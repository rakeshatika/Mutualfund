package com.vcube.Mutualfund.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vcube.Mutualfund.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
  
}
