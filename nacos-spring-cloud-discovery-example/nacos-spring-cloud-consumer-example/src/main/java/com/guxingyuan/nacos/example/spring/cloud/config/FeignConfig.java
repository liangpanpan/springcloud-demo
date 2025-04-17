package com.guxingyuan.nacos.example.spring.cloud.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2025/4/16       create this file
 * </pre>
 */
@Configuration
public class FeignConfig {

    @Bean
    public Retryer retryer() {
        //return Retryer.NEVER_RETRY; //Feign默认配置是不走重试策略的
        //最大请求次数为3(1+2)，初始间隔时间为100ms，重试间最大间隔时间为1s
        /*
         * 初始间隔是100ms, 第二次重试是100*1.5，第三次重试是100 * 1.5*1.5
         * 最大重试时间是maxPeriod，如果重试间隔超过最大重试时间，则使用最大重试时间
         * maxAttempts是最大请求发送次数。
         */
        return new Retryer.Default(100, 1000, 3);
    }

    //配置日志
    @Bean
    Logger.Level feignLogLevel() {
        return Logger.Level.FULL;
    }

}
