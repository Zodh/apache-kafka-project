package io.github.zodh.ZodhProducer.service;

import io.github.zodh.model.ProducerResponse;
import org.springframework.http.ResponseEntity;

public interface MessageProducerService {

  ResponseEntity<ProducerResponse> publish(String message);
}
