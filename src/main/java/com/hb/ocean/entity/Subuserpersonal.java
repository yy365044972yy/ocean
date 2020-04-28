package com.hb.ocean.entity;

import lombok.Data;

@Data
public class Subuserpersonal {

    /**
     * 姓名
     */
    private String name;

    /**
     * 身份证号码
     */
    private String cardno;

    /**
     * 区
     */
    private String area;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 技术职称
     */
    private String skillName;

    /**
     * 最高学历
     */
    private String lastStudy;

    /**
     * 所学专业
     */
    private String studyName;

    /**
     * 现从事专业
     */
    private String nowWork;

    /**
     * 专业年限
     */
    private String workYears;

    /**
     * 学习经历
     */
    private String studyDes;

    /**
     * 工作经历
     */
    private String workDes;

    /**
     * 主要工作业绩
     */
    private String majorDes;

    /**
     * 证明单位
     */
    private String proveCpn;

    /**
     * 证明人
     */
    private String proveName;

    /**
     * 证明人手机号码
     */
    private String proveTel;

    /**
     * userId
     */
    private String userId;

    /**
     * 是否是安标来的
     */
    private String ab;

}
