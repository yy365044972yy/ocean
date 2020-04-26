package com.hb.ocean.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class AbSubuserTraffic implements Serializable {
    /**
     * 企业名称
     */
    private String businessName;
    /**
     * 统一信用代码
     */
    private String roadTransportNO;
    /**
     * 有效期开始时间
     */
    private String licenseGoodBegain;
    /**
     * 有效期截止日期
     */
    private String licenseGoodEnd;
    /**
     * 公司地址
     */
    private String registeAddress;
    /**
     * 大类
     */
    private String businessTypeOne;

    /**
     * 小类
     */
    private String businessTypeTwo;
    /**
     * 组织代码
     */
    private String organizationCode;

}
