package com.hb.ocean.entity;


import lombok.Data;

import java.io.Serializable;
/**
* TODO 老系统的考试记录表
* @Author lyz
* @Date 2020/5/7 18:00
* @return 
*/
@Data
public class AbExamPoints implements Serializable {

    private String id;

    private String assessorId;

    private String businessType;

    private String points;

    private String examDate;

    private String dateBegin;

    private String dateEnd;

    private String status;

}