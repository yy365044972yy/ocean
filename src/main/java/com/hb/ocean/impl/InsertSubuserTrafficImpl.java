package com.hb.ocean.impl;

import com.hb.ocean.base.BaseApiService;
import com.hb.ocean.entity.SubuserTraffic;
import com.hb.ocean.entity.ZhianUser;
import com.hb.ocean.service.InsertEssentialInformation;

import java.util.UUID;

/**
 * 企业
 */
public class InsertSubuserTrafficImpl extends BaseApiService<String> implements InsertEssentialInformation {


    @Override
    public BaseApiService toInsert(ZhianUser zhianUser) {
        SubuserTraffic subuserTraffic=new SubuserTraffic();
        subuserTraffic.setId(UUID.randomUUID().toString().replace("-",""));

        return null;
    }
}