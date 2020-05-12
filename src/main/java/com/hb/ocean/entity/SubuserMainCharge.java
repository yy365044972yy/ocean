package com.hb.ocean.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SubuserMainCharge implements Serializable {

    /**
     * id
     */
    private String id;

    /**
     * userId
     */
    private String userId;

    /**
     * 省级还是市级
     */
    private String grateType;

    /**
     * 省
     */
    private String province;

    /**
     * 区
     */
    private String area;

    /**
     * 市
     */
    private String city;

    /**
     * 统一信用代码
     */
    private String companyNo;

    /**
     * 所在地
     */
    private String inAddress;

    /**
     * 管理行业
     */
    private String managerTrade;

    /**
     * 单位名称
     */
    private String companyName;

    /**
     * 联系人
     */
    private String telName;

    /**
     * 联系电话
     */
    private String telPhone;

    /**
     * 企业电话
     */
    private String cpnTel;

    /**
     * 通讯地址
     */
    private String telAddress;

    private String ab;

    private String regType;
}
