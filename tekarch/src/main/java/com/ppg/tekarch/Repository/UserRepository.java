package com.ppg.tekarch.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ppg.tekarch.Entity.*;

@Repository
public interface UserRepository extends JpaRepository <UserEntity, String>{
	
}