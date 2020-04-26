package com.hb.ocean.impl;

import com.hb.ocean.base.BaseApiService;
import com.hb.ocean.entity.ZhianUser;
import com.hb.ocean.service.InsertEssentialInformation;

/**
 * 第三方机构
 */

public class InsertSubuserThridImpl extends BaseApiService<String> implements InsertEssentialInformation {

    @Override
    public BaseApiService toInsert(ZhianUser zhianUser) {
        return null;
    }
}
