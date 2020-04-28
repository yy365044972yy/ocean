package com.hb.ocean.impl;

import com.hb.ocean.base.BaseApiService;
import com.hb.ocean.base.BaseResponse;
import com.hb.ocean.constants.Constants;
import com.hb.ocean.entity.*;
import com.hb.ocean.mapper.iceberg.ItemOrderMapper;
import com.hb.ocean.mapper.ocean.TotalMapper;
import com.hb.ocean.service.InsertEssentialInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 企业
 */
@Component
public class InsertSubuserTrafficImpl extends BaseApiService<String> implements InsertEssentialInformation {

    @Autowired
    private TotalMapper totalMapper;
    @Autowired
    private ItemOrderMapper itemOrderMapper;


    private Map<String,String> bigType=new HashMap<>();
    private Map<String,String> smallType=new HashMap<>();



    @Override
    public BaseResponse toInsert(ZhianUser zhianUser) throws ParseException {

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
        SubuserTraffic subuserTraffic = new SubuserTraffic();
        subuserTraffic.setId(UUID.randomUUID().toString().replace("-", ""));
        subuserTraffic.setUserId(zhianUser.getId());
//        AbUser abUser = totalMapper.selectUserFindId(zhianUser.getAbId());
//        subuserTraffic.setCompanyName();
        AbSubuserTraffic abSubuserTraffic = totalMapper.selectAbSubuserTrafficFindLoginName(zhianUser.getAccount());
        if(abSubuserTraffic==null||abSubuserTraffic.getRoadTransportNO()==null||Constants.ISNULL.equals(abSubuserTraffic.getRoadTransportNO())){
            return setResultError("企业:统一信用代码为空,"+zhianUser.getId());
        }
        int zhianSubuserTrafficByRoadTransportNO = itemOrderMapper.getZhianSubuserTrafficByRoadTransportNO(abSubuserTraffic.getRoadTransportNO());
        if(zhianSubuserTrafficByRoadTransportNO>0){
            return setResultError("企业:统一信用代码已被占用,"+zhianUser.getId());
        }
        subuserTraffic.setCompanyName(abSubuserTraffic.getBusinessName());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String licenseGoodBegain = abSubuserTraffic.getLicenseGoodBegain();
        String licenseGoodEnd = abSubuserTraffic.getLicenseGoodEnd();
        Date startDate=null;
        if(licenseGoodBegain!=null&&Constants.ISNULL.equals(licenseGoodBegain)){
            startDate=simpleDateFormat.parse(licenseGoodBegain);
        }
        subuserTraffic.setComTime(startDate);
        Date endDate=null;
        if(licenseGoodEnd!=null&&Constants.ISNULL.equals(licenseGoodEnd)){
            endDate=simpleDateFormat.parse(licenseGoodEnd);
        }
        subuserTraffic.setComfailureTime(endDate);
        subuserTraffic.setRoadTransportNO(abSubuserTraffic.getRoadTransportNO());
        subuserTraffic.setRegAddress(abSubuserTraffic.getRegisteAddress());
        subuserTraffic.setCompanyNo(abSubuserTraffic.getOrganizationCode());
        String s = bigType.get(abSubuserTraffic.getBusinessTypeOne());
        String s2 = smallType.get(abSubuserTraffic.getBusinessTypeTwo());
        subuserTraffic.setCompanyType(s==null||Constants.ISNULL.equals(s)?"":s);
        subuserTraffic.setCompanySubType(s2==null||Constants.ISNULL.equals(s2)?"":s2);
        subuserTraffic.setAb("1");
        itemOrderMapper.insertSubuserTraffic(subuserTraffic);
        return setResultSuccess();
    }
}