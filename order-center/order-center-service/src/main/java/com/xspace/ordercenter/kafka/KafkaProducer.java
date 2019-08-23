package com.xspace.ordercenter.kafka;

import com.alibaba.fastjson.JSON;
import com.xspace.ordercenter.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @author wmiao
 * @description
 * @date 2019/8/23
 */

@Component
public class KafkaProducer {
    @Autowired
    KafkaTemplate kafkaTemplate;

    public void kafkaSend(Employee employee) throws Exception {
        if (employee == null) {
            employee = new Employee();
            employee.setAge(12);
            employee.setUserName("李四");
            employee.setPhoneNum("15751003699");
        }

        ListenableFuture send = kafkaTemplate.send("mytopic", "key", JSON.toJSONString(employee));
    }
}
