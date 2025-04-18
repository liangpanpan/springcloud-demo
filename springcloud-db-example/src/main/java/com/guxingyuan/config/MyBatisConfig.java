package com.guxingyuan.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2025/4/17       create this file
 * </pre>
 */
@EnableTransactionManagement
@Configuration
@MapperScan({"com.guxingyuan.mapper"})
@RefreshScope
public class MyBatisConfig {
}
