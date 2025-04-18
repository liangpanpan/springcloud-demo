package com.guxingyuan.model;

import lombok.Data;

import java.util.Date;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2025/4/18       create this file
 * </pre>
 */
@Data
public class UserInfo {

    private Integer id;

    private String userName;

    private String password;

    private String realName;

    private String email;

    private String phone;

    private Integer state;

    private Integer userRole;

    private Date createTime;

    private Boolean isActive;

}
