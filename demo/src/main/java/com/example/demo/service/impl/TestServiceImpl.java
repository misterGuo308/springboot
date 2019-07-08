package com.example.demo.service.impl;

import com.example.demo.mapper.TestMapper;
import com.example.demo.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestServiceImpl implements TestService {

    @Resource
    private TestMapper testMapper;

    @Override
    public String get() {
        return testMapper.get();
    }
}
