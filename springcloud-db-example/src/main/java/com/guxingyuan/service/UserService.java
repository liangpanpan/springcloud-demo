package com.guxingyuan.service;

import com.guxingyuan.model.UserInfo;

import java.util.List;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2025/4/17       create this file
 * </pre>
 */
public interface UserService {

    List<UserInfo>  findAll();

    UserInfo findById(Integer id);

    Integer insert(UserInfo userInfo);

    Integer update(UserInfo userInfo);

    Integer delete(Integer id);

    Integer updatePassword(Integer id, String oldPassword, String newPassword);

}
