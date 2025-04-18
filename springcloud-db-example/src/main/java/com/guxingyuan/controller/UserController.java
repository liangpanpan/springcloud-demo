package com.guxingyuan.controller;

import com.guxingyuan.constant.RedisKeyConstant;
import com.guxingyuan.model.UserInfo;
import com.guxingyuan.service.UserService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
@RequestMapping("/userInfo")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate redisTemplate;

    @RequestMapping("/findAll")
    public List<UserInfo> findAll() {
        return userService.findAll();
    }

    @RequestMapping("/findById")
    public UserInfo findById(Integer id) {
        return userService.findById(id);
    }

    @RequestMapping("/insert")
    public Integer insert(UserInfo userInfo) {
        return userService.insert(userInfo);
    }


    @RequestMapping("/update")
    public Integer update(UserInfo userInfo) {
        return userService.update(userInfo);
    }

    @RequestMapping("/updatePassword")
    public Integer updatePassword(Integer id, String oldPassword, String password) {
        if (ObjectUtils.isEmpty(id) || StringUtils.isEmpty(oldPassword) || StringUtils.isEmpty(password)) {
            throw new RuntimeException("输入参数为空，并正确输入参数");
        }
        return userService.updatePassword(id, oldPassword, password);
    }

    @RequestMapping("/delete")
    public Integer deleteById(Integer id) {
        return userService.delete(id);
    }

    @RequestMapping("/unlock")
    public Long unlock(Integer id) {
        Boolean exist = redisTemplate.opsForHash().hasKey(RedisKeyConstant.USER_ERROR_UPDATE_PASSWORD_ERROR_KEY, id);
        if (!exist) {
            throw new RuntimeException("输入参数错误");
        }
        return redisTemplate.opsForHash().delete(RedisKeyConstant.USER_ERROR_UPDATE_PASSWORD_ERROR_KEY, id);
    }


}
