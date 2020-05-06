package com.hb.ocean.service;


import com.hb.ocean.base.BaseResponse;

import java.text.ParseException;

public interface AbZhianService {


    BaseResponse getAllUser() throws Exception;

//     Integer setZhianUser(ZhianUser zhianUser);
    BaseResponse delAllUser();

    BaseResponse insertEss() throws ParseException;

    BaseResponse inserUkey();

    BaseResponse delAllUserByType();

    /**
     * 处理认证子表
     * @param mid 表mid字段
     * @param bigType 表categoryId
     * @param smallType
     * @param userId
     * @return
     */
    BaseResponse insertSubuserCategory(String mid,String bigType,String smallType,String userId);


    BaseResponse insertUserOrg(String orgName, String userId, String provice, String city, String area, Integer orgType);


}
