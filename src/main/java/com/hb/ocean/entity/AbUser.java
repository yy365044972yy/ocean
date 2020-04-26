package com.hb.ocean.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Getter
@Setter
@ConfigurationProperties(prefix = "druid")
@Component
public class AbUser implements Serializable {


    private String loginName;

    private String userName;

    private String sex;

    private String password;

    private String telephone;

    private String roleID;

    private String state;

    private String email;

    private String userRemark;

    private String createTime;


}