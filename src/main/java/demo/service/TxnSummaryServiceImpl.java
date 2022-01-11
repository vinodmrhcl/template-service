package demo.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.domain.TxnSummary;
import demo.repo.TxnSummaryRepository;

@Service
public class TxnSummaryServiceImpl implements TxnSummaryService {

	@Autowired
	private TxnSummaryRepository txnSummaryRepository;

	@Override
	@Transactional(readOnly = true)
	public Collection<TxnSummary> getAll() {
		return this.txnSummaryRepository.findAll();
	}

	@Override
	@Transactional
	public void create(TxnSummary txnSummary) {
		this.txnSummaryRepository.save(txnSummary);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<TxnSummary> getById(Long id) {
		return this.txnSummaryRepository.findById(id);
	}

	@Override
	@Transactional
	public void update(TxnSummary txnSummary) {
		this.txnSummaryRepository.save(txnSummary);
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		this.txnSummaryRepository.deleteById(id);
	}

}
