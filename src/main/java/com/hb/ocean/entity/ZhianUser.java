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
public class ZhianUser implements Serializable {

    /**
     * 编号
     */
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 支付密码
     */
    private String payPwd;
    /**
     * 性别
     */
    private String sex;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 生日
     */
    private java.util.Date birthday;
    /**
     * 头像
     */
    private String headImg;
    /**
     * 微信Id
     */
    private String unionId;
    /**
     * 认证类型： 1001交通运维主管部门； 1002行业管理机构； 2001交通运输企业； 3001从业人员； 3002评审员； 4001第三方机构
     */
    private String certificationType;
    /**
     * 1001交通运维主管部门；1002行业管理机构；2001交通运输企业；3001从业人员；3002评审员；4001第三方机构
     */
    private Integer userType;
    /**
     * 是否有效(0否,1是)
     */
    private Integer active;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 身份证号
     */
    private String iDcard;
    /**
     * 自定义编号
     */
    private String workno;
    /**
     * 站点ID
     */
    private String siteId;
    /**
     * 创建时间
     */
    private java.util.Date createTime;
    /**
     * 是否是商业用户10
     */
    private Integer cod;
    /**
     * recommendUserId
     */
    private String recommendUserId;
    /**
     * 禁用时间，单位：天
     */
    private java.util.Date disableTime;
    /**
     * 禁用原因
     */
    private String disableReason;
    /**
     * 岗位id
     */
    private String postId;
    /**
     * 注册时的设备类型
     */
    private String regDeviceType;
    /**
     * 商业端有效期
     */
    private java.util.Date expTime;
    /**
     * bak1
     */
    private String bak1;
    /**
     * bak2
     */
    private String bak2;
    /**
     * bak3
     */
    private String bak3;
    /**
     * bak4
     */
    private String bak4;
    /**
     * bak5
     */
    private String bak5;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 导入id
     */
    private String exid;
    /**
     * 密码盐值
     */
    private String saltVal;
    /**
     * 从业类型: 0.普通从业人员 1.特种从业人员 2.其他
     */
    private Integer practitionersType;

    /**
     * 是否是安标导入过来的
     */
    private String ab;

    /**
     * 用户备注(旧系统移植字段)
     */
    private String userRemark;


}
