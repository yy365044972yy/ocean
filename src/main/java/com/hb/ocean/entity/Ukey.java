package com.hb.ocean.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Ukey implements Serializable {


    private String id;

    private String abid;

    private String ptid;
    /**
     * 'ukey号'
     */
    private String only;
    /**
     * '密钥'
     */
    private String secretKey;

    /**
     * '用户id
     */
    private String userId;
    /**
     * '是否加密
     */
    private String password;


    private String ab;


}
