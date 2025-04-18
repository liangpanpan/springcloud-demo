package com.guxingyuan.mapper;

import com.guxingyuan.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2025/4/18       create this file
 * </pre>
 */
@Mapper
public interface UserInfoMapper {

    List<UserInfo> findAll();

    UserInfo findById(Integer id);

    Integer insert(UserInfo userInfo);

    Integer update(UserInfo userInfo);

    Integer updatePassword(@Param("id") Integer id, @Param("password") String password);

    Integer delete(Integer id);

}
