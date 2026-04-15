package com.vcube.Mutualfund.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.Mutualfund.entity.Investment;
import com.vcube.Mutualfund.service.InvestmentService;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/investments")
public class InvestmentController {

	@Autowired
	private InvestmentService service;

	public InvestmentController(InvestmentService service) {
		this.service = service;
	}

	
	@PostMapping("/user/{userId}/fund/{fundId}")
	public Investment createInvestment(@PathVariable Long userId, @PathVariable Long fundId,
			@RequestBody Investment investment) {
		return service.createInvestment(userId, fundId, investment);
	}
	// Get All
	@GetMapping
	public List<Investment> getAllInvestments() {
		return service.getAllInvestments();
	}

	// Get By Id
	@GetMapping("/{id}")
	public Investment getInvestmentById(@PathVariable Long id) {
		return service.getInvestmentById(id);
	}

	// Delete
	@DeleteMapping("/{id}")
	public String deleteInvestment(@PathVariable Long id) {
		service.deleteInvestment(id);
		return "Investment deleted successfully";
	}
}