package com.hb.ocean.mapper.iceberg;

import com.hb.ocean.entity.*;
import com.hb.ocean.entity.ZhianUser;

import java.util.List;

/**
 * @author QuCheng on 2019-09-17.
 */

public interface ItemOrderMapper {

/*
<!--写新系统的SQL语句-->
    Integer selectCountSuccessOrder(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
    */

    List<ZhianUser> getZhianUserAll();

    int insertAll(ZhianUser zhianUser);

    int delZhianUserAll();

    int selectZhianUserFindAccount(String account);

    List<ZhianUser> getZhianUserAllFindByAb();

//    int insertUserRole(UserRole userRole);

    int insertSubuserTraffic(SubuserTraffic subuserTraffic);

    List<DicData> getDicData();

    int getZhianSubuserTrafficByRoadTransportNO(String roadTransportNO);

    int insertInsertSubuserpersonal(Subuserpersonal subuserpersonal);

    int delZhianUserFindErr(String err);


    int insertSubuserMainCharge(SubuserMainCharge subuserMainCharge);

    String getZhianUserIdByAbId(String abid);

    int insertZhianUkey(Ukey ukey);

    int delUserBySubuserpersonal();

    int delUserBySubuserTraffic();

    int delUserBySubuserMainCharge();

    String getDicDataPid(String typeId);
    String getDicDataByName(String name);

    int insertSubuserCategory(SubuserCategory subuserCategory);

    int delSubuserCateGory();

    int insertOrg(Org org);

    int insertUserOrg(UserOrg userOrg);

    //TODO 加考试
    int insertMission(Mission mission);
    //TODO 删除所有有关的旧系统数据
    int delMissionAll();
    //TODO 根据旧系统id 获取数据 用于判断是否已同步
    Mission selectMissionById(String adExamPointId);

    //TODO 增加评审员证书
    int insertAbAssessorCertificate(AbAssessorCertificate abAssessorCertificate);
    //TODO 删除所有有关的旧系统评审员证书数据
    int delAbAssessorCertificateAll();
    //TODO 根据旧系统id 获取评审员证书数据 用于判断是否已同步
    AbAssessorCertificate selectAbAssessorCertificateById(String adId);

    //TODO 增加企业证书
    int insertCertificates(AbCertificate abCertificate);
    //TODO 删除所有有关的旧系统企业证书数据
    int delCertificatesAll();
    //TODO 根据旧系统id 获取企业证书数据 用于判断是否已同步
    AbCertificate selectCertificatesById(String adId);

}
