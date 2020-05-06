package com.hb.ocean.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Org implements Serializable {
    /**
     * 编号
     */
    private java.lang.String id;
    /**
     * 名称
     */
    private java.lang.String name;
    /**
     * 代码
     */
    private java.lang.String comcode;
    /**
     * 上级部门ID
     */
    private java.lang.String pid;
    /**
     * 0,组织机构 1.部门,2.虚拟部门
     */
    private java.lang.Integer orgType;
    /**
     * 叶子节点(0:树枝节点;1:叶子节点)
     */
    private java.lang.Integer leaf;
    /**
     * 排序号
     */
    private java.lang.Integer sortno;
    /**
     * 描述
     */
    private java.lang.String description;
    /**
     * 0.失效 1.有效
     */
    private java.lang.Integer active;

    /**
     * 负责人Id
     */
    private java.lang.String personId;


    /**
     * categoryA
     */
    private java.lang.String categoryA;

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
    private String categoryB;


    /**
     * 创建类型  1模板  2企业自建
     */
    private java.lang.Integer createType;
    /**
     * 1、是否强制使用 1强制 0非强制 ；默认为0
     */
    private java.lang.Integer mustIpt;
    /**
     * 模板id，也是本表数据
     */
    private java.lang.String tmpId;
    /**
     * 类别id
     */
    private java.lang.String catId;
    /**
     * 创建人id
     */
    private java.lang.String createUserId;
    /**
     * 部门职责
     */
    private java.lang.String orgTask;
    /**
     * 创建时间
     */
    private java.util.Date createTime;

    private String ab;

}
