package demo.service;

import java.util.Collection;
import java.util.Optional;

import demo.domain.TxnSummary;

public interface TxnSummaryService {

	Collection<TxnSummary> getAll();

	void create(TxnSummary txnSummary);

	Optional<TxnSummary> getById(Long txnSummaryId);

	void update(TxnSummary txnSummary);

	void deleteById(Long txnSummaryId);

}
