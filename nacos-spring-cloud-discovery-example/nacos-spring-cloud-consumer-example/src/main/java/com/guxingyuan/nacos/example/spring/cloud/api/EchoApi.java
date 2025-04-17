package com.guxingyuan.nacos.example.spring.cloud.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2025/4/16       create this file
 * </pre>
 */
@FeignClient(value = "${spring.application.serverName}")
public interface EchoApi {

    @GetMapping("/echo/{str}")
    String echo(@PathVariable("str") String message);

}
