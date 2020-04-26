package com.hb.ocean.impl;

import com.hb.ocean.base.BaseApiService;
import com.hb.ocean.base.BaseResponse;
import com.hb.ocean.entity.ZhianUser;
import com.hb.ocean.service.InsertEssentialInformation;

/**
 * 人员
 */

public class InsertSubuserpersonalImpl extends BaseApiService<String> implements InsertEssentialInformation {

    @Override
    public BaseResponse toInsert(ZhianUser zhianUser) {
        return null;
    }
}
