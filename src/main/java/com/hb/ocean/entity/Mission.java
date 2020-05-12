package com.hb.ocean.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO 考试任务
 * @author springrain<Auto generate>
 * @version  2019-12-06 18:23:19
 */
@Data
public class Mission implements Serializable {

	/**
	 * id
	 */
	private String id;
	/**
	 * 考试用户id
	 */
	private String userId;
	/**
	 * 系统id
	 */
	private String sysId;
	/**
	 * 考试时间
	 */
	private java.util.Date examTime;
	/**
	 * 考试科目id
	 */
	private String subId;
	/**
	 * 考试结果数据
	 */
	private String examResult;
	/**
	 * 考试的获得分数
	 */
	private String examScore;

	/**
	 * 考试状态
	 */
	private Integer status;

	/**
	 * 考试是否合格
	 */
	private Integer resultStatus;



	//TODO 新增的数据
    private String ab;
    private String abId;
	private String abUserId;
	private Date abBeginTime;
	private Date abEndTime;

}

	
