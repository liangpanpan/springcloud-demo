package com.guxingyuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2025/4/17       create this file
 * </pre>
 */
@EnableDiscoveryClient
@SpringBootApplication
public class DBAllExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(DBAllExampleApplication.class, args);
    }
}
