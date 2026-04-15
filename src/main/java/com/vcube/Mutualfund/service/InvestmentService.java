package com.vcube.Mutualfund.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vcube.Mutualfund.entity.Investment;
import com.vcube.Mutualfund.entity.MutualFund;
import com.vcube.Mutualfund.entity.User;
import com.vcube.Mutualfund.exception.ResourceNotFoundException;
import com.vcube.Mutualfund.repo.InvestmentRepository;
import com.vcube.Mutualfund.repo.MutualFundRepository;
import com.vcube.Mutualfund.repo.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class InvestmentService {

    private final InvestmentRepository investmentRepo;
    private final UserRepository userRepo;
    private final MutualFundRepository fundRepo;

    public InvestmentService(InvestmentRepository investmentRepo,
                             UserRepository userRepo,
                             MutualFundRepository fundRepo) {
        this.investmentRepo = investmentRepo;
        this.userRepo = userRepo;
        this.fundRepo = fundRepo;
    }

    // Create Investment
    public Investment createInvestment(Long userId, Long fundId, Investment investment) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"+userId));

        MutualFund fund = fundRepo.findById(fundId)
                .orElseThrow(() -> new ResourceNotFoundException("Fund not found"+fundId));

        investment.setUser(user);
        investment.setFund(fund);
        investment.setInvestmentDate(LocalDate.now());

        return investmentRepo.save(investment);
    }

    // Get All Investments
    public List<Investment> getAllInvestments() {
        return investmentRepo.findAll();
    }

    // Get Investment By Id
    public Investment getInvestmentById(Long id) {
        return investmentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Investment not found"+id));
    }

    // Delete Investment
    public void deleteInvestment(Long id) {
        investmentRepo.delete(getInvestmentById(id));
    }
}