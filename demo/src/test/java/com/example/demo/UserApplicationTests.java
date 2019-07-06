package com.example.demo;

import com.example.demo.model.UserInfo;
import com.example.demo.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApplicationTests {

    @Resource
    private UserInfoService userInfoService;


    @Test
    public void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("张小虎");
        userInfo.setPassword("123456");
        int i = userInfoService.insert(userInfo);
        System.out.println("新增成功" + i + "条");
    }

    @Test
    public  void findUserInfoById() {

        int id =1;
        UserInfo userInfo = userInfoService.findUserInfoById(id);
        System.out.println("用户信息为"+userInfo);
    }

    @Test
    public void update(){
        UserInfo userInfo = new UserInfo();

        userInfo.setId(1);
        userInfo.setName("张强");
        userInfo.setPassword("23455");
        int i = userInfoService.update(userInfo);
        System.out.println("修改行位"+i);
    }


    @Test
    public  void  delete(){
        int id =1;
        int i = userInfoService.delete(id);
        System.out.println("删除数据为"+i+"条");
    }
}
