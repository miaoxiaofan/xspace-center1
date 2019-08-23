package com.xspace.ordercenter.cache;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xspace.commoncenter.cache.CacheConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wmiao
 * @description
 * @date 2019/8/8
 */

@Configuration
public class RedisConfig extends CachingConfigurerSupport {
    @Value("${spring.cache.redis.time-to-live}")
    private String timeOut;

    @Bean(name = "redisTemplate")
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {

        RedisTemplate<String, String> template = new RedisTemplate<>();


        RedisSerializer<String> redisSerializer = new StringRedisSerializer();

        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        template.setConnectionFactory(factory);
        //key序列化方式
        template.setKeySerializer(redisSerializer);
        //value序列化
        template.setValueSerializer(jackson2JsonRedisSerializer);
        //value hashmap序列化
        template.setHashValueSerializer(jackson2JsonRedisSerializer);

        return template;
    }

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {


        return new RedisCacheManager(
                RedisCacheWriter.nonLockingRedisCacheWriter(factory),
                this.getRedisCacheConfigurationWithTtl(getTimeOut()), // 默认策略，未配置的 key 会使用这个默认时间 86400
                this.getRedisCacheConfigurationMap() // 指定 key 策略
        );
    }

    //定义缓存空间过期时间
    private Map<String, RedisCacheConfiguration> getRedisCacheConfigurationMap() {
        Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();
        redisCacheConfigurationMap.put("Ibo_parkIndustryList", this.getRedisCacheConfigurationWithTtl(43200));
        redisCacheConfigurationMap.put("Ibo_buildIndustryList", this.getRedisCacheConfigurationWithTtl(43200));
        redisCacheConfigurationMap.put("Ibo_IndustryType", this.getRedisCacheConfigurationWithTtl(86400));
        redisCacheConfigurationMap.put("Ibo_BusinessType", this.getRedisCacheConfigurationWithTtl(86400));
        return redisCacheConfigurationMap;
    }

    private RedisCacheConfiguration getRedisCacheConfigurationWithTtl(Integer seconds) {
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
     /*   ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
*/
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        redisCacheConfiguration = redisCacheConfiguration.serializeValuesWith(
                RedisSerializationContext
                        .SerializationPair
                        .fromSerializer(jackson2JsonRedisSerializer)
        ).entryTtl(Duration.ofSeconds(seconds)).disableCachingNullValues();

        return redisCacheConfiguration;
    }

    private Integer getTimeOut() {
        Integer timeOutSencond = 86400;
        if (null == timeOut) {
            return timeOutSencond;
        }
        if(timeOut.endsWith("d")){
            int cout=Integer.valueOf(timeOut.replace("s",""));
            timeOutSencond=cout*CacheConstants.ONE_DAY_S;
        }else  if(timeOut.endsWith("h")){
            int cout=Integer.valueOf(timeOut.replace("h",""));
            timeOutSencond=cout* CacheConstants.ONE_HOUR_S;
        }else  if(timeOut.endsWith("ms")){
            int cout=Integer.valueOf(timeOut.replace("ms",""));
            timeOutSencond=cout/1000;
        }else  if(timeOut.endsWith("s")){
            int cout=Integer.valueOf(timeOut.replace("s",""));
            timeOutSencond=cout;
        }
        return timeOutSencond;
    }
}
