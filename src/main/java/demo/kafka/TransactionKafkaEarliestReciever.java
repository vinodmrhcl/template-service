package demo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import demo.domain.Transaction;
import demo.util.JsonUtil;

@Service
public class TransactionKafkaEarliestReciever {

	@KafkaListener(groupId = "tollstart", topics = "transaction.create", containerFactory = "earliestContainerFactory")
	public void createTransaction(String transactionJson) {
		Transaction transaction = JsonUtil.convertJsonToObject(transactionJson, Transaction.class);
		System.out.println("Received earliest transaction.create" + transaction);
	}

}