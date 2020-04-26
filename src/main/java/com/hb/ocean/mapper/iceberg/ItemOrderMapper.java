package com.hb.ocean.mapper.iceberg;

import com.hb.ocean.entity.SubuserTraffic;
import com.hb.ocean.entity.UserRole;
import com.hb.ocean.entity.ZhianUser;
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

//    int insertUserRole(UserRole userRole);

    int insertSubuserTraffic(SubuserTraffic subuserTraffic);



}
