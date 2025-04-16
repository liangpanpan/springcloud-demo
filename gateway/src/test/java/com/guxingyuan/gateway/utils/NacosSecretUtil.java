package com.guxingyuan.gateway.utils;

import org.springframework.util.Base64Utils;

import java.nio.charset.StandardCharsets;

/**
 * nacos中JWT令牌密钥生成器<br>
 * 生成 nacos.core.auth.plugin.nacos.token.secret.key 的值
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2025/4/9       create this file
 * </pre>
 */
public class NacosSecretUtil {

    public static void main(String[] args) {
        // 自定义生成JWT令牌的密钥
        String nacosSecret = "nacos_guxingyuan_panpanliang_token";
        // 输出密钥长度，要求不得低于32字符，否则无法启动节点。
        System.out.println("密钥长度》》》" + nacosSecret.length());
        // 密钥进行Base64编码
        byte[] data = nacosSecret.getBytes(StandardCharsets.UTF_8);
        System.out.println("密钥Base64编码》》》" + Base64Utils.encodeToString(data));
    }

}
