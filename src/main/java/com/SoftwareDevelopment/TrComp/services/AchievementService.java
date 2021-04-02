package com.SoftwareDevelopment.TrComp.services;

import com.SoftwareDevelopment.TrComp.models.Achievement;
import com.SoftwareDevelopment.TrComp.models.Customer;
import com.SoftwareDevelopment.TrComp.repositories.AchievementRepository;
import com.SoftwareDevelopment.TrComp.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AchievementService {
    @Autowired
    AchievementRepository repository;
    public Achievement findById(Integer id) {
        Optional<Achievement> result = repository.findById(id);
        Achievement n = null;
        if (result.isPresent()) {
            n = result.get();
        } else {
            throw new RuntimeException("Didn't find");
        }
        return n;
    }

    public Iterable<Achievement> findAll() {
        return repository.findAll();
    }

    public Iterable<Achievement> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Iterable<Achievement> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    public void save(Achievement achievement) {
        repository.save(achievement);
    }

    public void deleteById(Integer id){
        repository.deleteById(id);
    }
}

