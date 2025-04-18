package com.guxingyuan.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2025/4/17       create this file
 * </pre>
 */
@Slf4j
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Resource
    private RedisTemplate redisTemplate;

    @PostMapping("getValue")
    public String getKey(String key) {
        Object o = redisTemplate.opsForValue().get(key);
        if (o == null) {
            return "当前Key:" + key + "对应Value不存在";
        }
        return "当前Key:" + key + "对应Value is:" + o;
    }

    @PostMapping("setValue")
    public String setValue(String key, String value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return "修改成功";
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            return "修改失败";
        }
    }




}
