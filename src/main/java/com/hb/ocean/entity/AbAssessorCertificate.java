package com.hb.ocean.entity;


import java.io.Serializable;
import lombok.Data;
/**
 * TODO 评审员证书
 * @author springrain<Auto generate>
 * @version  2020-02-10 16:30:07
 */

@Data
public class AbAssessorCertificate  implements Serializable {

	/**
	 * id
	 */
	private String id;
	/**
	 * 证书编号/备案号
	 */
	private String certificate;
	/**
	 * 专业类型Id
	 */
	private String typeId;
	/**
	 * 创建时间
	 */
	private java.util.Date createTime;
	/**
	 * 有效期起始时间
	 */
	private java.util.Date startTime;
	/**
	 * 有效期结束时间
	 */
	private java.util.Date endTime;

	private java.util.Date publicityEndDate;
	/**
	 * 0等待开始1考试通过2考试不通过4公示通过3公示不通过
	 */
	private Integer state;
	/**
	 * userId
	 */
	private String userId;
	/**
	 * 考试得分
	 */
	private Integer fraction;
	/**
	 * 归属年份
	 */
	private Integer year;
	/**
	 * 备用字段
	 */
	private String mes;
	/**
	 * 备案id
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

	//TODO 新增的数据
	private String ab;
	private String abId;
	private String abUserId;
}

	
