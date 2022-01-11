package demo.kafka;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import demo.domain.Transaction;
import demo.service.TransactionService;
import demo.util.JsonUtil;

@Service
public class TransactionKafkaReciever {

	@Autowired
	private TransactionService transactionService;

	@KafkaListener(groupId = "tollend", topics = "transaction.create", containerFactory = "containerFactory")
	@Transactional
	public void createTransaction(String transactionJson) {
		Transaction transaction = JsonUtil.convertJsonToObject(transactionJson, Transaction.class);
		System.out.println("Received latest transaction.create" + transaction);
		transactionService.create(transaction);
	}

}