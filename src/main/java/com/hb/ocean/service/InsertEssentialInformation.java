package com.hb.ocean.service;

import com.hb.ocean.base.BaseApiService;
import com.hb.ocean.base.BaseResponse;
import com.hb.ocean.entity.ZhianUser;

public interface InsertEssentialInformation {

    BaseResponse toInsert(ZhianUser zhianUser);
}
