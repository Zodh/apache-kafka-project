package io.github.zodh.ZodhProducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class ZodhProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZodhProducerApplication.class, args);
	}

}
