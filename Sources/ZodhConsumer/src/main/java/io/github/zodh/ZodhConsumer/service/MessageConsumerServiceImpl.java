package io.github.zodh.ZodhConsumer.service;

import io.github.zodh.ZodhConsumer.configuration.MessageBrokerConfiguration;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class MessageConsumerServiceImpl {

  @Autowired
  private MessageBrokerConfiguration messageBrokerConfiguration;

  @KafkaListener(topics = "${topic.name.consumer}", groupId = "io.github.zodh")
  public void consumeTopic(ConsumerRecord<String, String> payload){
    System.out.println("\n\n");
    log.info("Topic: {}", messageBrokerConfiguration.getTopicName());
    log.info("Key: {}", payload.key());
    log.info("Headers: {}", payload.headers());
    log.info("Partition: {}", payload.partition());
    log.info("Order: {}", payload.value());
    System.out.println("\n\n");
  }

}
