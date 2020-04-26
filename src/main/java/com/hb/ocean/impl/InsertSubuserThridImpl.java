package com.hb.ocean.impl;

import com.hb.ocean.base.BaseApiService;
import com.hb.ocean.base.BaseResponse;
import com.hb.ocean.entity.ZhianUser;
import com.hb.ocean.service.InsertEssentialInformation;

/**
 * 第三方机构
 */

public class InsertSubuserThridImpl extends BaseApiService<String> implements InsertEssentialInformation {

    @Override
    public BaseResponse toInsert(ZhianUser zhianUser) {
        return setResultSuccess();
    }
}
