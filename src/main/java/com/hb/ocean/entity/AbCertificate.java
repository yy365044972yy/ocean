package com.hb.ocean.entity;


import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Id;
import java.io.Serializable;


/**
 * TODO 企业证书表
 * @copyright {@link
 * @author springrain<Auto generate>
 * @version  2019-09-25 10:17:03
 * @see
 */
@Data
public class AbCertificate implements Serializable {
	

	/**
	 * id
	 */
	private String id;
	/**
	 * 备案Id
	 */
	private String bodyId;
	private String userId;
	private String pidUserId;
	private String kinds;
	/**
	 * 证书编号
	 */
	private String number;
	/**
	 * 有效期前
	 */
	private java.util.Date oneDate;
	/**
	 * 有效期后
	 */
	private java.util.Date twoDate;
	/**
	 * 证书等级
	 */
	private String grade;
	/**
	 * 颁发日期
	 */
	private java.util.Date createDate;
	/**
	 * 文件地址
	 */
	private String file;
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

	private String active;

	private String type;

	private String status;

	//TODO 新增的数据
	private String ab;
	private String abId;
	private String abUserId;

}

	
