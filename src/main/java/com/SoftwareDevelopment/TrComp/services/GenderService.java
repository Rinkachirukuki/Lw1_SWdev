package com.SoftwareDevelopment.TrComp.services;

import com.SoftwareDevelopment.TrComp.models.Gender;
import com.SoftwareDevelopment.TrComp.models.Mark;
import com.SoftwareDevelopment.TrComp.repositories.GenderRepository;
import com.SoftwareDevelopment.TrComp.repositories.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GenderService {
    @Autowired
    GenderRepository genderRepository;

    public Gender findById(String id) {
        Optional<Gender> result = genderRepository.findById(id);
        Gender n = null;
        if (result.isPresent()) {
            n = result.get();
        } else {
            throw new RuntimeException("Didn't find");
        }
        return n;
    }

    public Iterable<Gender> findAll() {
        return genderRepository.findAll();
    }

    public Iterable<Gender> findAll(Pageable pageable) {
        return genderRepository.findAll(pageable);
    }

    public Iterable<Gender> findAll(Sort sort) {
        return genderRepository.findAll(sort);

    }

    public void save(Gender mark) {
        genderRepository.save(mark);
    }
}

