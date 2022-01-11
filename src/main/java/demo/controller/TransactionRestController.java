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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.domain.Transaction;
import demo.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionRestController {

	@Autowired
	private TransactionService transactionService;

	@GetMapping
	public Collection<Transaction> getAll(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "orderBy", required = false) String orderBy) {
		return this.transactionService.getAll(page, size, orderBy);
	}

	@PostMapping
	public void create(@RequestBody Transaction transaction) {
		this.transactionService.create(transaction);
	}

	@PostMapping("/send")
	public void sendCreate(@RequestBody Transaction transaction) {
		this.transactionService.send(transaction);
	}

	@GetMapping("/{id}")
	public Transaction getById(@PathVariable(value = "id") Long id) {
		return this.transactionService.getById(id).get();
	}

	@PutMapping
	public void update(@RequestBody Transaction transaction) {
		this.transactionService.update(transaction);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		this.transactionService.deleteById(id);
	}

}
