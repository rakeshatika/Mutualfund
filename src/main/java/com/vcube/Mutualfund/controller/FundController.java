package com.vcube.Mutualfund.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.Mutualfund.entity.MutualFund;
import com.vcube.Mutualfund.service.MutualService;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/funds")
public class FundController {

	
	@Autowired
	private MutualService service;
	

	@PostMapping
	public MutualFund addFund(@RequestBody MutualFund fund) {
		return service.saveFund(fund);
	}

	@GetMapping
	public List<MutualFund> getAllFunds() {
		return service.getAllFunds();
	}

	@GetMapping("/{id}")
	public MutualFund getFund(@PathVariable Long id) {
		return service.getFundById(id);
	}

	@PutMapping("/{id}")
	public MutualFund updateFund(@PathVariable Long id, @RequestBody MutualFund fund) {
		return service.updateFund(id, fund);
	}

	@DeleteMapping("/{id}")
	public String deleteFund(@PathVariable Long id) {
		service.deleteFund(id);
		return "Fund deleted successfully";
	}
}
