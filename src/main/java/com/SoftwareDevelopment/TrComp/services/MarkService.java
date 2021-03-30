package com.SoftwareDevelopment.TrComp.services;

import com.SoftwareDevelopment.TrComp.models.Mark;
import com.SoftwareDevelopment.TrComp.repositories.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MarkService {
    @Autowired
    MarkRepository markRepository;

    public Mark findById(String id) {
        Optional<Mark> result = markRepository.findById(id);
        Mark n = null;
        if (result.isPresent()) {
            n = result.get();
        } else {
            throw new RuntimeException("Didn't find");
        }
        return n;
    }

    public Iterable<Mark> findAll() {
        return markRepository.findAll();
    }

    public Iterable<Mark> findAll(Pageable pageable) {
        return markRepository.findAll(pageable);
    }

    public Iterable<Mark> findAll(Sort sort) {
        return markRepository.findAll(sort);

    }

    public void save(Mark mark) {
        markRepository.save(mark);
    }
}

