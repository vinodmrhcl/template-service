package demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.domain.Transaction;
import demo.kafka.TransactionKafkaSender;
import demo.repo.TransactionRepository;
import demo.util.JsonUtil;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private TransactionKafkaSender transactionKafkaSender;

	@Override
	@Transactional(readOnly = true)
	public List<Transaction> getAll(Integer page, Integer size, String orderBy) {
		if (size == null) {
			return (List<Transaction>) transactionRepository.findAll();
		} else {
			if (orderBy == null || orderBy.isEmpty()) {
				return transactionRepository.findAll(PageRequest.of(page, size)).getContent();
			} else {
				return transactionRepository.findAll(PageRequest.of(page, size, Sort.by(orderBy).descending())).getContent();
			}
		}
	}

	@Override
	@Transactional
	public void create(Transaction transaction) {
		this.transactionRepository.save(transaction);
	}

	@Override
	public void send(Transaction transaction) {
		String transactionJson = JsonUtil.convertObjectToJson(transaction);
		transactionKafkaSender.send(transactionJson);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Transaction> getById(Long id) {
		return this.transactionRepository.findById(id);
	}

	@Override
	@Transactional
	public void update(Transaction transaction) {
		this.transactionRepository.save(transaction);
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		this.transactionRepository.deleteById(id);
	}

}