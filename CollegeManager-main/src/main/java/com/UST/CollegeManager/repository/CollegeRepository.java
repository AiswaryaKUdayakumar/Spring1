package com.UST.CollegeManager.repository;

import com.UST.CollegeManager.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {

    College findByName(String name);
}

