package com.xspace.ordercenter.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author wmiao
 * @description
 * @date 2019/8/23
 */

@Component
public class KafkaConsumer {
    public static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(topics = {"mytopic"})
    public void jktopic(ConsumerRecord consumerRecord) throws InterruptedException {
        System.out.println(consumerRecord.offset());
        System.out.println(consumerRecord.value().toString());
        Thread.sleep(3000);
    }
}