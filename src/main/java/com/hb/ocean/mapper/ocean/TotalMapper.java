package com.hb.ocean.mapper.ocean;

import com.hb.ocean.entity.AbSubuserTraffic;
import com.hb.ocean.entity.AbUser;
import com.hb.ocean.entity.Subuserpersonal;
import com.hb.ocean.entity.ZhianUser;

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


}
