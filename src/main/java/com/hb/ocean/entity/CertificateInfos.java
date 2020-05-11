package com.hb.ocean.entity;

import lombok.Data;

import java.io.Serializable;

/**
* TODO 老系统中的证书表
* @Author lyz
* @Date 2020/5/11 0:32
* @return 
*/
@Data
public class CertificateInfos  implements Serializable {
    private String  id;
    private String  userId;
    private String  businessType;
    private String  certificateId;
    private String  expiryBegin;
    private String  expiryEnd;
    private String  certificateTCB;
    private String  certificatePath;
    private String  certificateDegree;
    private String  roleName;
    private String  memo;
    private String  selfAssessPath;
    private String  assessReportPath;
    private String  operatetime;
    private String  status;
    private String  operator;
}
