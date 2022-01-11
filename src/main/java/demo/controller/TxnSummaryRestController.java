package demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.domain.TxnSummary;
import demo.service.TxnSummaryService;

@RestController
@RequestMapping("/txnSummary")
public class TxnSummaryRestController {

	@Autowired
	private TxnSummaryService txnSummaryService;

	@GetMapping
	public Collection<TxnSummary> getAll() {
		return this.txnSummaryService.getAll();
	}

	@PostMapping
	public void create(@RequestBody TxnSummary txnSummary) {
		this.txnSummaryService.create(txnSummary);
	}

	@GetMapping("/{id}")
	public TxnSummary getById(@PathVariable(value = "id") Long id) {
		return this.txnSummaryService.getById(id).get();
	}

	@PutMapping
	public void update(@RequestBody TxnSummary txnSummary) {
		this.txnSummaryService.update(txnSummary);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		this.txnSummaryService.deleteById(id);
	}

}
