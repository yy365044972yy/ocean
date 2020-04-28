package com.hb.ocean.impl;

import com.hb.ocean.base.BaseApiService;
import com.hb.ocean.base.BaseResponse;
import com.hb.ocean.entity.SubuserMainCharge;
import com.hb.ocean.entity.ZhianUser;
import com.hb.ocean.mapper.iceberg.ItemOrderMapper;
import com.hb.ocean.mapper.ocean.TotalMapper;
import com.hb.ocean.service.InsertEssentialInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 主管机管
 */
@Component
public class InsertSubuserMainChargeImpl extends BaseApiService<String> implements InsertEssentialInformation {

    static final Integer NUMLIU = 6;

    @Autowired
    private ItemOrderMapper itemOrderMapper;
    @Autowired
    private TotalMapper totalMapper;
    @Override
    public BaseResponse toInsert(ZhianUser zhianUser) {
        SubuserMainCharge zhianSubuserMainChargeAll = totalMapper.getZhianSubuserMainChargeByLoginName(zhianUser.getAccount());

//        基础信息填写
        zhianSubuserMainChargeAll.setId(UUID.randomUUID().toString().replace("-",""));
        zhianSubuserMainChargeAll.setUserId(zhianUser.getId());
        zhianSubuserMainChargeAll.setAb("1");
//        判断类型是否是空的，不是空的将|替换成逗号
        if(zhianSubuserMainChargeAll.getManagerTrade()==null){
            zhianSubuserMainChargeAll.setManagerTrade("");
        }else{
            zhianSubuserMainChargeAll.setManagerTrade(zhianSubuserMainChargeAll.getManagerTrade().replace("|",","));
        }
//        判断类型是否是6个，如果是6个就是主管机关，否则就是行业主管部门
        String[] split = zhianSubuserMainChargeAll.getManagerTrade().split(",");
        if(split.length==NUMLIU){
            zhianSubuserMainChargeAll.setRegType("1");
        }else{
            zhianSubuserMainChargeAll.setRegType("2");
        }


        itemOrderMapper.insertSubuserMainCharge(zhianSubuserMainChargeAll);
        return setResultSuccess();
    }
}
