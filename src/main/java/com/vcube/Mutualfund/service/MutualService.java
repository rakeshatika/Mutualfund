package com.vcube.Mutualfund.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vcube.Mutualfund.entity.MutualFund;
import com.vcube.Mutualfund.exception.ResourceNotFoundException;
import com.vcube.Mutualfund.repo.MutualFundRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MutualService {

    private final MutualFundRepository repo;

    public MutualService(MutualFundRepository repo) {
        this.repo = repo;
    }

    public MutualFund saveFund(MutualFund fund) {
        return repo.save(fund);
    }

    public List<MutualFund> getAllFunds() {
        return repo.findAll();
    }

    public MutualFund getFundById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fund not found with id " + id));
    }

    public MutualFund updateFund(Long id, MutualFund fund) {
        MutualFund existing = getFundById(id);
        existing.setFundName(fund.getFundName());
        existing.setFundType(fund.getFundType());
        existing.setNav(fund.getNav());
        existing.setInvestedAmount(fund.getInvestedAmount());
        return repo.save(existing);
    }

    public void deleteFund(Long id) {
        repo.delete(getFundById(id));
    }
}