package com.SoftwareDevelopment.TrComp.repositories;

import com.SoftwareDevelopment.TrComp.models.Achievement;
import com.SoftwareDevelopment.TrComp.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AchievementRepository extends
        JpaRepository<Achievement, Integer> { };
