package com.guxingyuan.config;

import com.guxingyuan.druid.DruidDataSourceWrapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2025/4/14       create this file
 * </pre>
 */
@Configuration
public class NacosConfigConfiguration {

    @Bean
    @ConditionalOnMissingBean
    @RefreshScope
    public DruidDataSourceWrapper dataSource() {
        return new DruidDataSourceWrapper();
    }

}
