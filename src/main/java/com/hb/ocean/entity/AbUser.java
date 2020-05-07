package com.hb.ocean.entity;


import lombok.Data;


import java.io.Serializable;

@Data
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

    private String userID;


}