package com.hb.ocean.mapper.ocean;

import com.hb.ocean.entity.*;

import java.util.List;

/**
 * @author QuCheng on 2019-09-17.
 */
public interface TotalMapper  {

//<!--写老系统的SQL语句-->
    /*@Param("id") String id*/
    List<AbUser> selectUserAll();

    AbUser selectUserFindId(String id);

    AbSubuserTraffic selectAbSubuserTrafficFindLoginName(String LoginName);

    Subuserpersonal selectAbSubuserpersonalByLoginName( String loginName);


    SubuserMainCharge getZhianSubuserMainChargeByLoginName(String loginName);

//    String getZhianSubuserMainChargeByLoginNameOne(String loginName);
    List<Ukey> selAllOldUkey();

     //TODO 获取所有老系统的用户考试记录
     List<AbExamPoints> selectAbExamPointsAll();

    //TODO 获取所有老系统的证书记录
    List<CertificateInfos> selectCertificateInfosAll();

}
