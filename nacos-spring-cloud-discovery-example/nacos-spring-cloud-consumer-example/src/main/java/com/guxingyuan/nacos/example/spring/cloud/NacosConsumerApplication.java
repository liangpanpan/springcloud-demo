package com.guxingyuan.nacos.example.spring.cloud;

import com.guxingyuan.nacos.example.spring.cloud.api.EchoApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 *
 */
// 通过@EnableFeignCilent的basePackages和clients两个参数来进行注册
@EnableFeignClients(basePackageClasses = {EchoApi.class})
@EnableDiscoveryClient
@SpringBootApplication
public class NacosConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerApplication.class, args);
    }

}

