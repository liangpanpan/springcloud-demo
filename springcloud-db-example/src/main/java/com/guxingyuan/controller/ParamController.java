package com.guxingyuan.controller;

import com.alibaba.fastjson.JSONObject;
import com.guxingyuan.config.CustomConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2025/4/18       create this file
 * </pre>
 */
@RestController
@RequestMapping("/param")
public class ParamController {

    @Resource
    private CustomConfig config;

    @RequestMapping("/get")
    public String getParameter() {
        JSONObject result = new JSONObject();
        result.put("id", config.getId());
        result.put("name", config.getName());
        return result.toJSONString();
    }

}
