package com.example.springbootrao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootrao.common.model.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author guoyou
 * @since 2019-07-08
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    @Insert("insert into user_info (id ,name ,password ,account )values (#{id} ,#{name} ,#{password} ,#{account} ) ")
    int transationTest(UserInfo userInfo);
}
