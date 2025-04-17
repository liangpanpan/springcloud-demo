package com.guxingyuan.nacos.example.spring.cloud.controller;

import com.guxingyuan.nacos.example.spring.cloud.api.EchoApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.DateTimeException;
import java.util.Date;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2025/4/16       create this file
 * </pre>
 */
@Slf4j
@RestController
public class TestController {

    @Resource
    private EchoApi echoApi;


    @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
    public String echo(@PathVariable String str) {

        Date start = new Date();

        String result = "";
        try {
            result = echoApi.echo(str);
        } catch (Exception e) {
            log.error("error:", e);
            return e.getMessage();
        } finally {
            log.info("cost time:{}", (new Date().getTime() - start.getTime()));
        }
        return result;
    }


}
