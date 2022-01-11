package demo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransactionKafkaSender {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void send(String transactionJson) {
		kafkaTemplate.send("transaction.create", transactionJson);
	}

}