package com.xspace.commoncenter.annotation;




import com.xspace.commoncenter.cache.CacheConstants;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author
 */
@Retention(RUNTIME)
@Target(METHOD)
@Documented
public @interface CacheAble {

    /**
     * Redis set key的前缀。
     *
     * @return
     */
    String prefixKey() default "";

    /**
     * <p>redis set key 的后缀组合。 比如：</p>
     * <p>
     * <pre>方法定义：public Object fun(String str1, int num){}</pre>
     *
     * <pre>
     * 示例1：prefixKey = "test", suffixIndex = {0, 1}
     * 方法入参为：("测试", 20)       则suffixIndex为：测试_20；完整的key为：test_测试_20
     * 方法入参为：("helloworld", 4)  则suffixIndex为：helloworld_4；完整的key为：test_helloworld_4
     * 方法入参为：(null, 4)          则suffixIndex为：n-u-l-l_4；完整的key为：test_n-u-l-l_4
     * </pre>
     * <p>
     * <pre>
     * 示例2：prefixKey = "test", suffixIndex = {0}
     * 方法入参为：("测试", 20)       则suffixIndex为：测试；完整的key为：test_测试
     * 方法入参为：("helloworld", 4)  则suffixIndex为：helloworld；完整的key为：test_helloworld
     * 方法入参为：(null, 4)          则suffixIndex为：n-u-l-l；完整的key为：test_n-u-l-l
     * </pre>
     * <p>
     * <p>注意：</p>
     * <pre>1、完整的key必须要确保全局唯一，否则redis缓存数据会相互覆盖，会出现意想不到的问题。</pre>
     * <pre>2、完整的key不宜过长。</pre>
     *
     * @return
     */
    int[] suffixIndex();

    /**
     * redis过期时间，默认一天。
     *
     * @return
     */
    int expire() default CacheConstants.ONE_DAY_S;

}
