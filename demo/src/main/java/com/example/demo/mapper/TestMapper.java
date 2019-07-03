package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
public interface TestMapper {
    
    @Select(" select name from test limit 1 ")
    String get();
}
