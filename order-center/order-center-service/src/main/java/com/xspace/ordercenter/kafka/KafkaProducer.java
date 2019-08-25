package com.xspace.ordercenter.kafka;

import com.alibaba.fastjson.JSON;
import com.xspace.ordercenter.entity.Employee;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @author wmiao
 * @description
 * @date 2019/8/23
 */

@Component
public class KafkaProducer {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    KafkaTemplate kafkaTemplate;

    public void kafkaSend(Employee employee) throws Exception {
        if (employee == null) {
            employee = new Employee();
            employee.setAge(12);
            employee.setUserName("李四");
            employee.setPhoneNum("15751003699");
        }
        logger.info("向  topic:{} 推送数据，内容：{}", "atopic", JSON.toJSONString(employee));
        ListenableFuture<SendResult<String,String>> future = kafkaTemplate.send("atopic", "key", JSON.toJSONString(employee));

        try {
            RecordMetadata recordMetadata= future.get().getRecordMetadata();
            logger.info("result:{}",recordMetadata);
        } catch (Exception e) {
            logger.error("error"+e);
        }
    }
}
