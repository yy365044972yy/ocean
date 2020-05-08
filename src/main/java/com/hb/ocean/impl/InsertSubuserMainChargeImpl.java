package com.hb.ocean.impl;

import com.hb.ocean.base.BaseApiService;
import com.hb.ocean.base.BaseResponse;
import com.hb.ocean.constants.Constants;
import com.hb.ocean.entity.DicData;
import com.hb.ocean.entity.SubuserMainCharge;
import com.hb.ocean.entity.ZhianUser;
import com.hb.ocean.mapper.iceberg.ItemOrderMapper;
import com.hb.ocean.mapper.ocean.TotalMapper;
import com.hb.ocean.service.AbZhianService;
import com.hb.ocean.service.InsertEssentialInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 主管机管
 */
@Component
public class InsertSubuserMainChargeImpl extends BaseApiService<String> implements InsertEssentialInformation {

    private Map<String,String> bigType=new HashMap<>();
    private Map<String,String> smallType=new HashMap<>();

    @Autowired
    private ItemOrderMapper itemOrderMapper;
    @Autowired
    private TotalMapper totalMapper;
    @Override
    public BaseResponse toInsert(ZhianUser zhianUser) {

        if(bigType.size()==0||smallType.size()==0){
            bigType=new HashMap<>();
            smallType=new HashMap<>();
            List<DicData> dicData = itemOrderMapper.getDicData();
            for(DicData d:dicData){
                if(d.getPid()==null||Constants.ISNULL.equals(d.getPid())){
                    bigType.put(d.getName(),d.getId());
                }else{
                    smallType.put(d.getName(),d.getId());
                }
            }
        }

        SubuserMainCharge zhianSubuserMainChargeAll = totalMapper.getZhianSubuserMainChargeByLoginName(zhianUser.getAccount());

        if(ObjectUtils.isEmpty(zhianSubuserMainChargeAll)){
            return setResultError("帐号未找到,"+zhianUser.getAccount());
        }
//        基础信息填写
        zhianSubuserMainChargeAll.setId(UUID.randomUUID().toString().replace("-",""));
        zhianSubuserMainChargeAll.setUserId(zhianUser.getId());
        zhianSubuserMainChargeAll.setAb("1");

//        判断类型是否是空的，不是空的将|替换成逗号
        if(zhianSubuserMainChargeAll.getManagerTrade()==null){
            zhianSubuserMainChargeAll.setManagerTrade("");
        }else{
            String replace = zhianSubuserMainChargeAll.getManagerTrade().replace("|", ",");
            String[] split = replace.split(",");
            String bigtypes="";
            for(String e:split){
                bigtypes+=bigType.get(e)+",";
            }
            bigtypes=bigtypes.substring(0,bigtypes.length()-1);
            zhianSubuserMainChargeAll.setManagerTrade(bigtypes);
        }
//        判断类型是否是6个，如果是6个就是主管机关，否则就是行业主管部门
        String[] split = zhianSubuserMainChargeAll.getManagerTrade().split(",");
        if(split.length== Constants.NUMLIU){
            zhianSubuserMainChargeAll.setRegType("1");
        }else{
            zhianSubuserMainChargeAll.setRegType("2");
        }

        String grateType = zhianSubuserMainChargeAll.getGrateType();

        switch (grateType==null?"":grateType){
            case "省":
                grateType="省级";
                break;
            case "市":
                grateType="市级";
                 break;
            case "县":
                grateType="区级";
                break;
                default:
                    grateType="省级";
                    break;
        }
        zhianSubuserMainChargeAll.setGrateType(grateType);

        itemOrderMapper.insertSubuserMainCharge(zhianSubuserMainChargeAll);

        abZhianService.insertSubuserCategory(zhianSubuserMainChargeAll.getId(),zhianSubuserMainChargeAll.getManagerTrade(),"",zhianSubuserMainChargeAll.getUserId());
        return setResultSuccess();
    }

    @Autowired
    private AbZhianService abZhianService;
}
