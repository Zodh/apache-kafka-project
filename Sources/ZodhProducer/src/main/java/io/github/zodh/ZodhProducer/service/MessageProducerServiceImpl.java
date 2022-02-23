package io.github.zodh.ZodhProducer.service;

import io.github.zodh.ZodhProducer.configuration.MessageBrokerConfiguration;
import io.github.zodh.model.ProducerResponse;
import io.github.zodh.model.ProducerResponse.MessageEnum;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class MessageProducerServiceImpl implements MessageProducerService{

  private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

  @Autowired
  private MessageBrokerConfiguration messageBrokerConfiguration;

  @Override
  public ResponseEntity<ProducerResponse> publish(String message) {
    try {
      createAndPostMessage(message);
      var response = new ProducerResponse().message(MessageEnum.SENT);
      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (Exception exception) {
      log.error("Error trying to publish message: " + message + " Error: " + exception.getMessage());
      var response = new ProducerResponse().message(MessageEnum.NOT_SENT);
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  private void createAndPostMessage(String message){
    generateLog("Starting Zodh Producer flow");

    generateLog("Generating Message Key");
    var key = UUID.randomUUID().toString();

    generateLog("Building Message");
    var publishedMessage = simpleDateFormat.format(new Date()) + " | Key: " + key + " | Message: " + message;

    generateLog("Building Kafka Record");
    var topicMessage = new ProducerRecord<>(messageBrokerConfiguration.getTopicName(), key, publishedMessage);

    var producer = messageBrokerConfiguration.getProducer();
    generateLog("Sending Kafka Record");
    producer.send(topicMessage);

    generateLog("Message Sent: " + publishedMessage);
  }

  private void generateLog(String message){
    log.info(String.format("Step [%s]", message));
  }


}
