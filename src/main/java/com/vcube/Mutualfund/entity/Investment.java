package com.vcube.Mutualfund.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "investment")
public class Investment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private double investedAmount;
	private double units;
	private LocalDate investmentDate;
	
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getInvestedAmount() {
		return investedAmount;
	}

	public void setInvestedAmount(double investedAmount) {
		this.investedAmount = investedAmount;
	}

	public double getUnits() {
		return units;
	}

	public void setUnits(double units) {
		this.units = units;
	}

	public LocalDate getInvestmentDate() {
		return investmentDate;
	}

	public void setInvestmentDate(LocalDate investmentDate) {
		this.investmentDate = investmentDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public MutualFund getFund() {
		return fund;
	}

	public void setFund(MutualFund fund) {
		this.fund = fund;
	}
	public Long getUserId() {
	    return user != null ? user.getId() : null;
	}

	public Long getFundId() {
	    return fund != null ? fund.getId() : null;
	}

	@ManyToOne
	@JoinColumn(name = "UserId")
	@JsonIgnore
	private User user;

	@ManyToOne
	@JoinColumn(name = "FundId")
	@JsonIgnore
	private MutualFund fund;

}
