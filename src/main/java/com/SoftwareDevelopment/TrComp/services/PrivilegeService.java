package com.SoftwareDevelopment.TrComp.services;

import com.SoftwareDevelopment.TrComp.models.Mark;
import com.SoftwareDevelopment.TrComp.models.Privilege;
import com.SoftwareDevelopment.TrComp.repositories.MarkRepository;
import com.SoftwareDevelopment.TrComp.repositories.PrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PrivilegeService {
    @Autowired
    PrivilegeRepository privilegeRepository;

    public Privilege findById(String id) {
        Optional<Privilege> result = privilegeRepository.findById(id);
        Privilege n = null;
        if (result.isPresent()) {
            n = result.get();
        } else {
            throw new RuntimeException("Didn't find");
        }
        return n;
    }

    public Iterable<Privilege> findAll() {
        return privilegeRepository.findAll();
    }

    public Iterable<Privilege> findAll(Pageable pageable) {
        return privilegeRepository.findAll(pageable);
    }

    public Iterable<Privilege> findAll(Sort sort) {
        return privilegeRepository.findAll(sort);

    }

    public void save(Privilege mark) {
        privilegeRepository.save(mark);
    }
}

