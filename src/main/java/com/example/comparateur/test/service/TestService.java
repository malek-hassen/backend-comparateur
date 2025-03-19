package com.example.comparateur.test.service;


import com.example.comparateur.test.entity.Test;
import com.example.comparateur.test.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;

    public Test saveTest(Test  test) {
        return testRepository.save(test);
    }
}
