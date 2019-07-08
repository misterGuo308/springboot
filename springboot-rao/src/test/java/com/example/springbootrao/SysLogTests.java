package com.example.springbootrao;

import com.example.springbootrao.model.SysLog;
import com.example.springbootrao.service.SysLogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysLogTests {

    @Resource
    private SysLogService sysLogService;

    @Test
    public void contextLoads() {

        SysLog sysLog = sysLogService.selectById(1);
        System.out.println(sysLog);
    }

}
