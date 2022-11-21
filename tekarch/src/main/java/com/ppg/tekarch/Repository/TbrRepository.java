package com.ppg.tekarch.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ppg.tekarch.Entity.TbrEntity;

@Repository
public interface TbrRepository extends JpaRepository<TbrEntity, Integer>{
	TbrEntity findByTitle(String title);
}

