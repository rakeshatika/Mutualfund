package com.vcube.Mutualfund.entity;

import java.util.List;

import com.vcube.Mutualfund.enums.FundType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "mutual_fund")
public class MutualFund {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;

	private String fundName;
	@Enumerated(EnumType.STRING)
	private FundType fundType;
	private double nav;
	private double investedAmount;

	public MutualFund(Long id, String fundName, FundType fundType, double nav, double investedAmount,
			List<Investment> investments) {
		super();
		this.id = id;
		this.fundName = fundName;
		this.fundType = fundType;
		this.nav = nav;
		this.investedAmount = investedAmount;
		this.investments = investments;
	}

	public MutualFund() {
	}

	@OneToMany(mappedBy = "fund", cascade = CascadeType.ALL)
	private List<Investment> investments;

	public Long getId() {
		return id;
	}

	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public FundType getFundType() {
		return fundType;
	}

	public void setFundType(FundType fundType) {
		this.fundType = fundType;
	}

	public double getNav() {
		return nav;
	}

	public void setNav(double nav) {
		this.nav = nav;
	}

	public double getInvestedAmount() {
		return investedAmount;
	}

	public void setInvestedAmount(double investedAmount) {
		this.investedAmount = investedAmount;
	}
}