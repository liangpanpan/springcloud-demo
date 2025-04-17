package com.guxingyuan.nacos.example.spring.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.loadbalancer.core.RoundRobinLoadBalancer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2025/4/16       create this file
 * </pre>
 */
// 可以支持配置多个，对不同的请求域名配置不同的访问策略
@LoadBalancerClients({
        @LoadBalancerClient(name = "service-provider", configuration = CustomLoadBalancerConfiguration.class)
})
@Configuration
public class RestConfiguration {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
