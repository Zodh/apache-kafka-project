package io.github.zodh.ZodhProducer.controller;

import io.github.zodh.ZodhProducer.service.MessageProducerService;
import io.github.zodh.api.MessagesApi;
import io.github.zodh.model.ProducerResponse;
import io.github.zodh.model.ZodhMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class ZodhProducerController implements MessagesApi {

  @Autowired
  private MessageProducerService messageProducerService;

  @Override
  public ResponseEntity<ProducerResponse> messagesPublishPost(ZodhMessageRequest request) {
    return messageProducerService.publish(request.getMessage());
  }
}
