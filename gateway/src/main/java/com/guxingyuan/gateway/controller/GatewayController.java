package com.guxingyuan.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2025/4/18       create this file
 * </pre>
 */
@RestController
public class GatewayController {

    @RequestMapping("/test")
    public String test(String message) {
        return "返回消息：" + message;
    }


}
