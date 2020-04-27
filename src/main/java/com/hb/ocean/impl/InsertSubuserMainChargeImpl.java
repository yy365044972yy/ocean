package com.hb.ocean.impl;

import com.hb.ocean.base.BaseApiService;
import com.hb.ocean.base.BaseResponse;
import com.hb.ocean.entity.ZhianUser;
import com.hb.ocean.service.InsertEssentialInformation;
import org.springframework.stereotype.Component;

/**
 * 主管机管
 */
@Component
public class InsertSubuserMainChargeImpl extends BaseApiService<String> implements InsertEssentialInformation {

    @Override
    public BaseResponse toInsert(ZhianUser zhianUser) {

        return setResultSuccess();
    }
}
