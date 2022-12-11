package com.ppg.tekarch.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ppg.tekarch.Entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository <UserEntity, Integer>{
	
	UserEntity findByUsername (String username);
	
}