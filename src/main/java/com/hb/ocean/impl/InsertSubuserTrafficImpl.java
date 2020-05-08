package com.hb.ocean.impl;

import com.hb.ocean.base.BaseApiService;
import com.hb.ocean.base.BaseResponse;
import com.hb.ocean.constants.Constants;
import com.hb.ocean.entity.*;
import com.hb.ocean.mapper.iceberg.ItemOrderMapper;
import com.hb.ocean.mapper.ocean.TotalMapper;
import com.hb.ocean.service.AbZhianService;
import com.hb.ocean.service.InsertEssentialInformation;
import com.hb.ocean.utils.pca.PCAUtils;
import org.apache.commons.lang3.StringUtils;
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

    @Autowired
    private AbZhianService abZhianService;

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

        //将类型转换规范形式
        String s = "";
        String s2 = "";
        String big = abSubuserTraffic.getBusinessTypeOne().replace("|", ",").replace("，", ",");
        String[] split = big.split(",");

        for(String e:split){
            //类型转换成id
            s+=bigType.get(e)+",";
        }
        s=s.substring(0,s.length()-1);
        String sm = abSubuserTraffic.getBusinessTypeTwo().replace("|", ",").replace("，", ",");
        String[] split1 = sm.split(",");
        for(String e:split1){
            //小类转换id
            s2+=smallType.get(e)+",";
        }
        s2=s2.substring(0,s2.length()-1);

        subuserTraffic.setCompanyType(s==null||Constants.ISNULL.equals(s)?"":s);
        subuserTraffic.setCompanySubType(s2==null||Constants.ISNULL.equals(s2)?"":s2);
        subuserTraffic.setAb("1");


        subuserTraffic.setCity(abSubuserTraffic.getCity());
        //判断地区是否正确

        String city = subuserTraffic.getCity();
        String getname = PCAUtils.getname(city);
        String getdq = PCAUtils.getdq(getname);
        subuserTraffic.setProvince("410000");
        if("省级".equals(getdq)){
            subuserTraffic.setProvince(city);
            subuserTraffic.setCity(null);
            subuserTraffic.setArea(null);
        }
        if("市级".equals(getdq)){
            subuserTraffic.setArea(null);
        }
        if("区级".equals(getdq)){
            subuserTraffic.setCity(PCAUtils.getPid(city));
            subuserTraffic.setArea(city);
        }


        itemOrderMapper.insertSubuserTraffic(subuserTraffic);

        //将类型从企业表放置到子表中
        abZhianService.insertSubuserCategory(subuserTraffic.getId(),subuserTraffic.getCompanyType(),subuserTraffic.getCompanySubType(),subuserTraffic.getUserId());

        //将企业添加默认的部门
        abZhianService.insertUserOrg(subuserTraffic.getCompanyName(), subuserTraffic.getUserId(), subuserTraffic.getProvince(), subuserTraffic.getCity(),
                subuserTraffic.getArea(), Integer.valueOf(subuserTraffic.getSubserTrafficType()));

        return setResultSuccess();
    }
}