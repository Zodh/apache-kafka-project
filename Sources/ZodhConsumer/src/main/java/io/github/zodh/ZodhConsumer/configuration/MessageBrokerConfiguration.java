package io.github.zodh.ZodhConsumer.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class MessageBrokerConfiguration {

  @Value("${topic.name.consumer}")
  private String topicName;
}
