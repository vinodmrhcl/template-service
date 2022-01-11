package demo.service;

import java.util.List;
import java.util.Optional;

import demo.domain.Transaction;

public interface TransactionService {

	List<Transaction> getAll(Integer page, Integer size, String orderBy);

	void create(Transaction transaction);

	void send(Transaction transaction);

	Optional<Transaction> getById(Long id);

	void update(Transaction transaction);

	void deleteById(Long id);


}
