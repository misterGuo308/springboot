package com.example.springbootrao;

import com.example.springbootrao.common.model.UserInfo;
import com.example.springbootrao.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRaoApplicationTests {

    @Resource
    private RedisTemplate redisTemplate;
    
    @Resource
    private UserInfoService userInfoService;

    @Test
    public void contextLoads() {
        Set<String> keys = redisTemplate.keys("*" + "2f2112cb-7948-49e1-8ad8-6f7a31b7a314" + "*");
        System.out.println(keys);
        redisTemplate.delete("mySession2:sessions:2f2112cb-7948-49e1-8ad8-6f7a31b7a314");

    }
    
    
    @Test
    public void  testUser() throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.setPassword("12345");
        userInfo.setAccount("12345");
        userInfo.setName("测试");
        userInfoService.insertregister(userInfo);
        
    }

    @Test
    public void  testMybatisPulsUser() throws Exception {
        List<UserInfo> list = new ArrayList<>();
        UserInfo userInfo = new UserInfo();
        userInfo.setPassword("12345");
        userInfo.setAccount("12345");
        userInfo.setName("测试");
        list.add(userInfo);

        UserInfo userInfo2 = new UserInfo();
        userInfo2.setPassword("12345");
     //   userInfo2.setAccount("12345");
        userInfo2.setName("测试");
        list.add(userInfo2);

        userInfoService.saveBatch(list);

    }

}
