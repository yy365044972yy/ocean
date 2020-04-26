package com.hb.ocean.impl;

import com.hb.ocean.base.BaseApiService;
import com.hb.ocean.base.BaseResponse;
import com.hb.ocean.entity.SubuserTraffic;
import com.hb.ocean.entity.ZhianUser;
import com.hb.ocean.mapper.iceberg.ItemOrderMapper;
import com.hb.ocean.mapper.ocean.TotalMapper;
import com.hb.ocean.service.InsertEssentialInformation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * 企业
 */
public class InsertSubuserTrafficImpl extends BaseApiService<String> implements InsertEssentialInformation {

    @Autowired
    private TotalMapper totalMapper;


    @Override
    public BaseResponse toInsert(ZhianUser zhianUser) {
        SubuserTraffic subuserTraffic = new SubuserTraffic();
        subuserTraffic.setId(UUID.randomUUID().toString().replace("-", ""));
        subuserTraffic.setUserId(zhianUser.getId());
//        subuserTraffic.setCompanyName();

//        totalMapper.sel
        return setResultSuccess();
    }
}