package demo.repo;

import org.springframework.data.keyvalue.repository.KeyValueRepository;

import demo.domain.Transaction;

public interface TransactionRepository extends KeyValueRepository<Transaction, Long> {
}