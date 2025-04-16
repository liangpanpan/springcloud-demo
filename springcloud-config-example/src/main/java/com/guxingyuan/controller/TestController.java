package com.guxingyuan.controller;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.guxingyuan.druid.DruidDataSourceWrapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2025/4/14       create this file
 * </pre>
 */
@RestController
@RequestMapping("/api")
@RefreshScope
public class TestController {

    @Value("${test}")
    private String testValue;

    @Value("${aaa}")
    private String aaaValue;

    @Resource
    private DruidDataSourceWrapper dataSourceWrapper;

    @RequestMapping("/testValue")
    public String getTestValue() {
        return testValue;
    }


    @RequestMapping("/aaa")
    public String getAAAValue() {
        return aaaValue;
    }

    @RequestMapping("/druid")
    public String getDruidWrapper() {
        return dataSourceWrapper.toString();
    }

    @GetMapping("/query")
    public String testDruid() throws SQLException {
        DruidPooledConnection connection = dataSourceWrapper.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from user_info where user_id = 1;");
        String result = "没有此用户！！！";
        if (resultSet.next()) {
            result = resultSet.getString("user_id") + " : " + resultSet.getString("user_name");
            System.out.println(result);
            return result;
        }
        return result;
    }


}
