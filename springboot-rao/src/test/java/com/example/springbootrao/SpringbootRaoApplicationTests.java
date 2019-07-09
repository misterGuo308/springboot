package com.example.springbootrao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRaoApplicationTests {

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
        Set<String> keys = redisTemplate.keys("*" + "2f2112cb-7948-49e1-8ad8-6f7a31b7a314" + "*");
        System.out.println(keys);
        redisTemplate.delete("mySession2:sessions:2f2112cb-7948-49e1-8ad8-6f7a31b7a314");

    }

}
