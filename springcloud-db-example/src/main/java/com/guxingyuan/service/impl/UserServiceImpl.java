package com.guxingyuan.service.impl;

import com.guxingyuan.config.CustomConfig;
import com.guxingyuan.constant.RedisKeyConstant;
import com.guxingyuan.mapper.UserInfoMapper;
import com.guxingyuan.model.UserInfo;
import com.guxingyuan.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2025/4/17       create this file
 * </pre>
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private CustomConfig customConfig;

    @Override
    public List<UserInfo> findAll() {
        return userInfoMapper.findAll();
    }

    @Override
    public UserInfo findById(Integer id) {
        return userInfoMapper.findById(id);
    }

    @Override
    public Integer insert(UserInfo userInfo) {
        return userInfoMapper.insert(userInfo);
    }

    @Override
    public Integer update(UserInfo userInfo) {
        return userInfoMapper.update(userInfo);
    }

    @Override
    public Integer delete(Integer id) {
        return userInfoMapper.delete(id);
    }

    @Override
    public Integer updatePassword(Integer id, String oldPassword, String newPassword) {
        UserInfo userInfo = userInfoMapper.findById(id);
        if (userInfo == null) {
            throw new RuntimeException("当前用户信息不正确");
        }

        // 校验输入密码次数
        Object errorNum = redisTemplate.opsForHash().get(RedisKeyConstant.USER_ERROR_UPDATE_PASSWORD_ERROR_KEY, id);
        if (errorNum != null && Integer.valueOf(errorNum.toString()) > customConfig.getMax_update_password_num()) {
            throw new RuntimeException("更新密码错误次数超限，请找管理员处理操作！");
        }

        if (!userInfo.getPassword().equals(oldPassword)) {
            redisTemplate.opsForHash().increment(RedisKeyConstant.USER_ERROR_UPDATE_PASSWORD_ERROR_KEY, id, 1);
            throw new RuntimeException("输入的旧密码不正确");
        }

        Integer i = userInfoMapper.updatePassword(id, newPassword);
        log.info("update id:{} password result:{}", id, i);
        redisTemplate.opsForHash().delete(RedisKeyConstant.USER_ERROR_UPDATE_PASSWORD_ERROR_KEY, id);
        return i;
    }
}
