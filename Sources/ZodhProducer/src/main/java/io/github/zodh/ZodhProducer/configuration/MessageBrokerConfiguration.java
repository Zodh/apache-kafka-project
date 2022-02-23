package io.github.zodh.ZodhProducer.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

@Getter
@Configuration
public class MessageBrokerConfiguration {

  @Value("${topic.name.producer}")
  private String topicName;

  @Autowired
  private KafkaTemplate<String, String> producer;
}
