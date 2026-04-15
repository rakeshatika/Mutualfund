package com.vcube.Mutualfund.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vcube.Mutualfund.entity.Investment;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {

}