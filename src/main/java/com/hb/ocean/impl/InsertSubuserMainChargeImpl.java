package com.hb.ocean.impl;

import com.hb.ocean.base.BaseApiService;
import com.hb.ocean.base.BaseResponse;
import com.hb.ocean.entity.ZhianUser;
import com.hb.ocean.service.InsertEssentialInformation;

/**
 * 主管机管
 */
public class InsertSubuserMainChargeImpl extends BaseApiService<String> implements InsertEssentialInformation {

    @Override
    public BaseResponse toInsert(ZhianUser zhianUser) {

        return setResultSuccess("好的");
    }
}
