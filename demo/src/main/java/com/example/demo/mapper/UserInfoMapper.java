package com.example.demo.mapper;

import com.example.demo.model.UserInfo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserInfoMapper {

    @Insert("insert into user_info ( name ,password ) values ( #{name},#{password} ) ")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int insert(UserInfo userInfo);

    @Select("select * from user_info where id =#{id}")
    UserInfo findUserInfoById(Integer id);

    @Update("update user_info set name=#{name} ,password = #{password} where id =#{id}")
    int update(UserInfo userInfo);

    @Delete("delete from user_info where id =#{id} ")
    int delete(Integer id);

}
