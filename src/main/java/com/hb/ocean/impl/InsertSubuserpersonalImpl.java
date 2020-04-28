package com.hb.ocean.impl;

import com.hb.ocean.base.BaseApiService;
import com.hb.ocean.base.BaseResponse;
import com.hb.ocean.entity.Subuserpersonal;
import com.hb.ocean.entity.ZhianUser;
import com.hb.ocean.mapper.iceberg.ItemOrderMapper;
import com.hb.ocean.mapper.ocean.TotalMapper;
import com.hb.ocean.service.InsertEssentialInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 人员/评审员 该功能只有评审员
 */
@Component
public class InsertSubuserpersonalImpl extends BaseApiService<String> implements InsertEssentialInformation {

    @Autowired
    private TotalMapper totalMapper;
    @Autowired
    private ItemOrderMapper itemOrderMapper;

    @Override
    public BaseResponse toInsert(ZhianUser zhianUser) {

//        首先查询老系统的人员表
        Subuserpersonal subuserpersonal = totalMapper.selectAbSubuserpersonalByLoginName(zhianUser.getAccount());
//        拿到老系统的人员表信息，赋值到咱们现在的系统里,给身份改成评审员
        subuserpersonal.setUserId(zhianUser.getId());
        subuserpersonal.setAb("1");
        itemOrderMapper.insertInsertSubuserpersonal(subuserpersonal);

        return setResultSuccess();
    }
}
