package demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.domain.TxnSummary;

public interface TxnSummaryRepository extends JpaRepository<TxnSummary, Long> {
}