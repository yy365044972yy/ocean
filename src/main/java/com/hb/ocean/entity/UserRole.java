package com.hb.ocean.entity;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Data
@Component
public class UserRole implements Serializable {

	/**
	 * 编号
	 */
	private java.lang.String id;
	/**
	 * 用户编号
	 */
	private java.lang.String userId;
	/**
	 * 角色编号
	 */
	private java.lang.String roleId;
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

}