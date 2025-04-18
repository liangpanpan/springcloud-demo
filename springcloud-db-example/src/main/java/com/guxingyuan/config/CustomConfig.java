package com.guxingyuan.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 可以自动注入guxingyuan.custom下的参数配置信息
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2025/4/17       create this file
 * </pre>
 */
@Data
@Configuration
@ConfigurationProperties("guxingyuan.custom")
public class CustomConfig {

    private String id;

    private String name;

    /**
     * 输入的最大更新密码失败次数
     */
    private Integer max_update_password_num = 3;

}
