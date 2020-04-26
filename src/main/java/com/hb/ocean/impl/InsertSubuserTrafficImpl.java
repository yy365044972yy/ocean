package com.hb.ocean.impl;

import com.hb.ocean.base.BaseApiService;
import com.hb.ocean.base.BaseResponse;
import com.hb.ocean.constants.Constants;
import com.hb.ocean.entity.*;
import com.hb.ocean.mapper.iceberg.ItemOrderMapper;
import com.hb.ocean.mapper.ocean.TotalMapper;
import com.hb.ocean.service.InsertEssentialInformation;
import com.hb.ocean.utils.LiUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 企业
 */
public class InsertSubuserTrafficImpl extends BaseApiService<String> implements InsertEssentialInformation {

    @Autowired
    private TotalMapper totalMapper;
    @Autowired
    private ItemOrderMapper itemOrderMapper;


    private Map<String,String> bigType=new HashMap<>();
    private Map<String,String> smallType=new HashMap<>();

    {
        List<DicData> dicData = itemOrderMapper.getDicData();
        for(DicData d:dicData){
            if(d.getPid()==null||Constants.ISNULL.equals(d.getPid())){
                bigType.put(d.getName(),d.getId());
            }else{
                smallType.put(d.getName(),d.getId());
            }
        }
    }

    @Override
    public BaseResponse toInsert(ZhianUser zhianUser) throws ParseException {
        SubuserTraffic subuserTraffic = new SubuserTraffic();
        subuserTraffic.setId(UUID.randomUUID().toString().replace("-", ""));
        subuserTraffic.setUserId(zhianUser.getId());
//        AbUser abUser = totalMapper.selectUserFindId(zhianUser.getAbId());
//        subuserTraffic.setCompanyName();
        AbSubuserTraffic abSubuserTraffic = totalMapper.selectAbSubuserTrafficFindLoginName(zhianUser.getAccount());
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
        itemOrderMapper.insertSubuserTraffic(subuserTraffic);
        return setResultSuccess();
    }
}