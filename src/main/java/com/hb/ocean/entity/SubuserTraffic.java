package com.hb.ocean.entity;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
public class SubuserTraffic{
	/**
	 * id
	 */
	private String id;
	/**
	 * 单位名称
	 */
	private String companyName;
	/**
	 * 道路运输号
	 */
	private String companyNo;
	/**
	 * 有效期
	 */
	private java.util.Date comTime;
	/**
	 * 失效期
	 */
	private java.util.Date comfailureTime;
	/**
	 * 统一社会信用代码
	 */
	private String roadTransportNO;
	/**
	 * 省
	 */
	private String province;
	/**
	 * 市
	 */
	private String city;
	/**
	 * 县
	 */
	private String area;
	/**
	 * 营业执照
	 */
	private String image;
	/**
	 * 证有效时间
	 */
	private java.util.Date imageTime;
	/**
	 * 失效时间
	 */
	private java.util.Date failureTime;
	/**
	 * 注册地址
	 */
	private String regAddress;
	/**
	 * 注册类型
	 */
	private String companyType;
	/**
	 * 注册类别
	 */
	private String companySubType;
	/**
	 * 法人
	 */
	private String cpnUser;
	/**
	 * 法人电话
	 */
	private String cpnTel;
	/**
	 * 联系人
	 */
	private String telName;
	/**
	 * 联系人电话
	 */
	private String telTel;
	/**
	 * 联系人身份证号
	 */
	private String iDcard;
	/**
	 * 经营范围
	 */
	private String scopeBusiness;
	/**
	 * 通讯地址
	 */
	private String telAddress;
	/**
	 * 邮箱
	 */
	private String subemail;
	/**
	 * 传真
	 */
	private String fax;
	/**
	 * 创建时间
	 */
	private java.util.Date createTime;
	/**
	 * 更新时间
	 */
	private java.util.Date updateTime;
	/**
	 * 父Id
	 */
	private String pid;
	/**
	 * 企业注册类型： 1、是企业； 2、是集团
	 */
	private String subserTrafficType;
	/**
	 * 用户外键id
	 */
	private String userId;
	/**
	 * 法人代表
	 */
	private String legalMan;
	/**
	 * 法人身份证正面
	 */
	private String legalIdcardz;
	/**
	 * 法人身份证反面
	 */
	private String legalIdcardf;
	/**
	 * 联系人身份证正面
	 */
	private String linkIdcardz;
	/**
	 * 联系人身份证反面
	 */
	private String linkIdcardf;
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
	 * 单位电话
	 */
	private String bak5;
	/**
	 * 是否申报
	 */
	private String isDeclare;
	/**
	 * 私钥
	 */
	private String rsaPrivateKey;
	/**
	 * 公钥
	 */
	private String rsaPublicKey;
	/**
	 * 校验状态(0成功,null为未比对)
	 */
	private String chekState;
	/**
	 * 秘钥
	 */
	private String aes;
	/**
	 * 私钥有效期
	 */
	private java.util.Date validTime;
	/**
	 * 企业对接申请id
	 */
	private String companyRequestId;
	/**
	 * 更新对接参数时间
	 */
	private java.util.Date updateApplayTime;

}

	
