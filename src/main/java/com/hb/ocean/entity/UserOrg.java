package com.hb.ocean.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserOrg implements Serializable {
    /**
     * 编号
     */
    private java.lang.String id;
    /**
     * 用户编号
     */
    private java.lang.String userId;
    /**
     * 机构编号
     */
    private java.lang.String orgId;
    /**
     * 是否主管(0会员 10 员工 11主管 12代理主管 13虚拟主管)
     */
    private java.lang.Integer managerType;
    /**
     * 是否包含子部门(0不包含1包含)
     */
    private java.lang.Integer hasleaf;
    /**
     * bak1
     */
    private java.lang.String bak1;
    /**
     * bak2
     */
    private java.lang.String bak2;
    /**
     * bak3
     */
    private java.lang.String bak3;
    /**
     * bak4
     */
    private java.lang.String bak4;
    /**
     * bak5
     */
    private java.lang.String bak5;
    // columns END 数据库字段结束

    private String orgName;//部门名字

    //专兼职 1专职2兼职
    private Integer specificDuty;

    private String ab;
}
