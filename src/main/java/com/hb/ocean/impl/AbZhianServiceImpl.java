package com.hb.ocean.impl;

import com.alibaba.fastjson.JSON;
import com.hb.ocean.base.BaseApiService;
import com.hb.ocean.base.BaseResponse;
import com.hb.ocean.constants.Constants;
import com.hb.ocean.entity.*;
import com.hb.ocean.mapper.iceberg.ItemOrderMapper;
import com.hb.ocean.mapper.ocean.TotalMapper;
import com.hb.ocean.service.AbZhianService;
import com.hb.ocean.service.InsertEssentialInformation;
import com.hb.ocean.utils.DateUtilsLyz;
import com.hb.ocean.utils.SpringContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AbZhianServiceImpl extends BaseApiService implements AbZhianService {

    public Map<String, Object> map;

    {
        map = new HashMap<>();
        //1001主管机关
        map.put(ZHUGUANJIGUAN, "insertSubuserMainChargeImpl");
        //1002行业管理机构
        map.put(ZHUGUANBUMEN, "insertSubuserMainChargeImpl");
        //2001交通运输企业
        map.put(JIAOTONGYUNSHUQIYE, "insertSubuserTrafficImpl");
        //3001从业人员
        map.put(CONGYERENYUAN, "insertSubuserpersonalImpl");
        //3002评审员
        map.put(PINGSHENYUAN, "insertSubuserpersonalImpl");
        //4001第三方机构
        map.put(DISANFANGJIGOU, "insertSubuserThridImpl");

    }

    public Map<String, String> mapSubject;
    {
        mapSubject = new HashMap<>();
        //1001主管机关
        mapSubject.put("评审员-收费公路运营", "07d9a28b364448c38b86df7728682728");
        //1002行业管理机构
        mapSubject.put("评审员-交通运输工程建设", "6bf06fd9c44d446b86bcc6c9fc1ed6c6");
        //2001交通运输企业
        mapSubject.put("评审员-城市客运", "9dc393360fab46debbb90b01638db725");
        //3001从业人员
        mapSubject.put("评审员-港口营运", "9de3a0ec6a334a7dbe2adc2cec93694f");
        //3002评审员
        mapSubject.put("评审员-道路运输", "bcf536ff10c346368a8ed5876ad88751");
        //4001第三方机构
        mapSubject.put("评审员-水路运输", "fd7d2262b1264018891cd43ec44b0d36");
    }

    static final String ab_sysId = "3ed22058ac364d26a36568f281152ac7";

    @Autowired
    private ItemOrderMapper itemOrderMapper;

    @Autowired
    private TotalMapper totalMapper;

    static final String NUMONE = "1";
    static final String NUMTWO = "2";
    static final String NUMTHREE = "3";
    static final String NUMFOUR = "4";
    static final String NUMFIVE = "5";

    static final String NUMJIU = "9";
    static final String SEXMAN = "男";
    static final String SEXWOMEN = "女";
    static final String ISNUMM = "";

    //1001主管机关
    static final String ZHUGUANJIGUAN = "1001";
    //1002行业管理机构
    static final String ZHUGUANBUMEN = "1002";
    //2001交通运输企业
    static final String JIAOTONGYUNSHUQIYE = "2001";
    //3001从业人员
    static final String CONGYERENYUAN = "3001";
    //3002评审员
    static final String PINGSHENYUAN = "3002";
    //4001第三方机构
    static final String DISANFANGJIGOU = "4001";


    /**
     * (新) 代表现在开发的系统
     * (旧) 代表之前.NET开发的系统
     *
     * @return
     * @throws Exception
     */
    @Override
    public BaseResponse getAllUser() throws Exception {

        List<AbUser> users = totalMapper.selectUserAll();
//        List<ZhianUser> zhianUserAll = itemOrderMapper.getZhianUserAll();
        int continueNum = 0;
        int okNum = 0;
        List<ZhianUser> list = new ArrayList<>();
        for (AbUser abUser : users) {
//            先判断下现系统是否有该账号
            if (abUser.getLoginName() == null || ISNUMM.equals(abUser.getLoginName())) {
                continueNum++;
                continue;
            }

            int i = itemOrderMapper.selectZhianUserFindAccount(abUser.getLoginName());
            if (i > 0) {
                continueNum++;
                continue;
            }

            ZhianUser zhianUser = new ZhianUser();
            zhianUser.setId(UUID.randomUUID().toString().replace("-", ""));
            //(新)name姓名 (旧)userName 姓名 (注)姓名
            zhianUser.setName(abUser.getUserName());
            //(新)account帐号 (旧)loginName 用户名 (注)帐号
            zhianUser.setAccount(abUser.getLoginName());
            //(新)password密码 (旧)password 密码 (注) 老系统的密码不知道怎么加密的，此处以后可以写老系统加密方式
            zhianUser.setPassword(abUser.getPassword());
            //(新)sex性别  (旧)sex性别 (注)因新系统性别没有注释，也全是空，所以直接拿老系统的中文
            zhianUser.setSex(abUser.getSex());
            //(新)mobile手机号码  (旧)loginName登录名称 (注)老系统手机号码全是空，所以新系统手机号字段用帐号代替
            zhianUser.setMobile(abUser.getLoginName());
            //判断老系统用户身份
            String certificationType = "";
            switch (abUser.getRoleID()) {
                case NUMONE:
                    certificationType = JIAOTONGYUNSHUQIYE;
                    break;
                case NUMTWO:
                    certificationType = ZHUGUANJIGUAN;
                    break;
                case NUMTHREE:
                    certificationType = DISANFANGJIGOU;
                    break;
                case NUMFOUR:
                    certificationType = PINGSHENYUAN;
                    break;
                case NUMJIU:
                    certificationType = ZHUGUANJIGUAN;
                    break;
                //其他状态不知道是啥
                /*case NUMFIVE:
                    certificationType = DISANFANGJIGOU;
                    break;*/
                default:
                    //不确定的类型暂时跳过，后期需要再处理
                    continueNum++;
                    continue;
//                    certificationType = "";
//                    break;

            }
            //(新)certificationType
            // '认证类型：\r\n1001交通运维主管部门；\r\n1002行业管理机构；\r\n2001交通运输企业；\r\n3001从业人员；\r\n3002评审员；\r\n4001第三方机构'
            // (旧)state
            //角色编号
            //因为没有注释，直接赋值进去了
            zhianUser.setCertificationType(certificationType);
            zhianUser.setUserType(Integer.parseInt(certificationType));
            //(新)active是否有效(0否,1是)  (旧)state资料审查状态1可用0不可用
            zhianUser.setActive(abUser.getState() == null ? 0 : Integer.parseInt(abUser.getState()));
            //(新)email邮箱  (旧)email邮箱 (注)旧系统email字段全是空的
            zhianUser.setEmail(abUser.getEmail());
            //(新)新增字段userRemark用户备注  (旧)userRemark邮箱
            // (注)旧系统全表就仨值，待注销、待注销、已注销 没啥用不要了
            //zhianUser.setUserRemark(abUser.getUserRemark());
            String createTime = abUser.getCreateTime();
            //定义时间格式
            SimpleDateFormat df_time_s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //(新)createTime创建时间 (旧)createTime创建时间 (注)如果老系统是NULL或者是""就获取当前时间，否则就用旧系统数据
            zhianUser.setCreateTime(createTime == null || ISNUMM.equals(createTime) ? new Date() : df_time_s.parse(createTime));
            //标识该数据为旧系统转移数据
            zhianUser.setAb(NUMONE);
            zhianUser.setAbId(abUser.getUserID());

            try {
                itemOrderMapper.insertAll(zhianUser);
            } catch (Exception e) {
                return setResultError("错误数据" + JSON.toJSONString(zhianUser) + "\n错误信息:" + JSON.toJSONString(e.getLocalizedMessage()));
            }
            okNum++;
            list.add(zhianUser);
        }

       /* for (ZhianUser zhianUser : list) {

            BaseResponse baseResponse = insertEss(zhianUser);
        }*/


//        String s = JSON.toJSONString(zhianUserAll);
//        String b = JSON.toJSONString(users);
//        System.out.println(s);
//        System.out.println(b);
        return setResultSuccess("总数量:" + users.size() + "\n跳过数量:" + continueNum + "\n成功数量:" + okNum);
    }

    /**
     * 删除数据
     *
     * @return
     */
    @Override
    public BaseResponse delAllUser() {
        int i = itemOrderMapper.delZhianUserAll();
        return setResultSuccess("删除了" + i + "条");
    }

    /**
     * 处理基本信息
     *
     * @return
     */
    @Override
    public BaseResponse insertEss() throws ParseException {
        List<Map<String, String>> list = new ArrayList<>();
        List<ZhianUser> zhianUserAllFindByAb = itemOrderMapper.getZhianUserAllFindByAb();
        String ids = "";
        for (ZhianUser zhianUser : zhianUserAllFindByAb) {
            //根据用户类型获取bean
            Object o = map.get(zhianUser.getCertificationType());
            if (o == null) {
                continue;
            }

            InsertEssentialInformation bean = SpringContextUtils.getBean(o.toString(), InsertEssentialInformation.class);
            BaseResponse baseResponse = bean.toInsert(zhianUser);
            //判断状态码
            if (!Constants.HTTP_RES_CODE_200.equals(baseResponse.getCode())) {
                Map<String, String> map = new HashMap<>();
                map.put("msg", baseResponse.getMsg().split(",")[0]);
                list.add(map);
                ids += baseResponse.getMsg().split(",")[1] + ",";
                //删除错误信息的user数据
                itemOrderMapper.delZhianUserFindErr(baseResponse.getMsg().split(",")[1]);
            }


        }
        int length = ids.split(",").length;



        return setResultSuccess("添加完成!删除错误user表数据" + length + "条");

    }


    @Override
    public BaseResponse inserUkey() {
//1.    获取老ukey数据

        int tiaoguoNum = 0;
        int okNum = 0;
        List<Ukey> ukeys = totalMapper.selAllOldUkey();
//2.    循环获取老ukey的id去对应新表t_user表查询abid
        for (Ukey ukey : ukeys) {
            String abId = ukey.getAbid();
            String userId = itemOrderMapper.getZhianUserIdByAbId(abId);
            if (userId == null || Constants.ISNULL.equals(userId)) {
                tiaoguoNum++;
                continue;
            }
            ukey.setUserId(userId);
            ukey.setId(UUID.randomUUID().toString().replace("-", ""));
            ukey.setPassword("0");
            ukey.setAb("1");

            itemOrderMapper.insertZhianUkey(ukey);
            okNum++;
        }
//3.    获取到现有的t_user的id
//4.    循环插入t_ukey表

        return setResultSuccess("成功数:" + okNum + ",跳过数:" + tiaoguoNum);
    }

    @Override
    public BaseResponse delAllUserByType() {
        int i = itemOrderMapper.delUserBySubuserpersonal();
        int i1 = itemOrderMapper.delUserBySubuserMainCharge();
        int i2 = itemOrderMapper.delUserBySubuserTraffic();
        int i3 = itemOrderMapper.delSubuserCateGory();
        return setResultSuccess("删除企业表数据" + i2 + "条,主管机关/行业主管部门" + i1 + "条,人员表" + i + "条,类型子表条数:"+i3+"条");
    }

    /**
     * //将类型从企业表放置到子表中
     * @param mid 表mid字段
     * @param bigType 表categoryId
     * @param smallType
     * @param userId
     * @return
     */
    @Override
    public BaseResponse insertSubuserCategory(String mid, String bigType, String smallType,String userId) {

        if (StringUtils.isEmpty(bigType)) {
            return setResultError("大类型为空");
        }
        String[] bigTypeSplit = bigType.split(",");


        for(String e:bigTypeSplit){
            SubuserCategory subuserCategory=new SubuserCategory();
            subuserCategory.setId(UUID.randomUUID().toString().replace("-",""));
            subuserCategory.setMainId(mid);
            subuserCategory.setPid(null);
            subuserCategory.setCategoryId(e);
            subuserCategory.setActive("1");
            subuserCategory.setAb("1");
            subuserCategory.setOkDate(new Date());
            subuserCategory.setUserId(userId);
            itemOrderMapper.insertSubuserCategory(subuserCategory);
        }


        String[] smallTypeSplit = smallType.split(",");
        if(!StringUtils.isEmpty(smallType)){
            for(String e:smallTypeSplit){
                String dicDataPid = itemOrderMapper.getDicDataPid(e);
                SubuserCategory subuserCategory=new SubuserCategory();
                subuserCategory.setId(UUID.randomUUID().toString().replace("-",""));
                subuserCategory.setMainId(mid);
                subuserCategory.setPid(StringUtils.isEmpty(dicDataPid)?"???":dicDataPid);
                subuserCategory.setCategoryId(e);
                subuserCategory.setActive("1");
                subuserCategory.setAb("1");
                subuserCategory.setOkDate(new Date());
                subuserCategory.setUserId(userId);
                itemOrderMapper.insertSubuserCategory(subuserCategory);
            }
        }


        return setResultSuccess();
    }

    /**
     * 将企业添加默认的部门
     * @param orgName
     * @param userId
     * @param provice
     * @param city
     * @param area
     * @param orgType
     * @return
     */
    @Override
    public BaseResponse insertUserOrg(String orgName, String userId, String provice, String city, String area, Integer orgType) {
        // 先删除

        Org org = new Org();
        org.setId(UUID.randomUUID().toString().replace("-",""));
        org.setName(orgName);
        org.setComcode("," + org.getId() + ",");
        org.setPersonId(userId);
        org.setOrgType(orgType);
        org.setBak1(provice);
        org.setBak2(city);
        org.setBak3(area);
        org.setActive(1);
        org.setAb("1");
        itemOrderMapper.insertOrg(org);

        UserOrg userOrg = new UserOrg();
        userOrg.setId(UUID.randomUUID().toString().replace("-",""));
        userOrg.setManagerType(11);
        userOrg.setUserId(userId);
        userOrg.setOrgId(org.getId());
        userOrg.setHasleaf(1);
        userOrg.setAb("1");
        itemOrderMapper.insertUserOrg(userOrg);
        return setResultSuccess();
    }

    @Override
    public BaseResponse delMissionAll() {
        int i = itemOrderMapper.delMissionAll();
        return setResultSuccess("删除了" + i + "条");
    }

    @Override
    public BaseResponse insertMission() throws ParseException {

        List<AbExamPoints> listAb=totalMapper.selectAbExamPointsAll();
        int continueNoBaeNum = 0;
        int continueHaveNum = 0;
        int okNum = 0;
        for(AbExamPoints abPoint:listAb){

            //TODO 首先判断 当前 人员数据是否同步过来
            String zhianUser=itemOrderMapper.getZhianUserIdByAbId(abPoint.getAssessorId());
            if(StringUtils.isEmpty(zhianUser)){
                continueNoBaeNum++;
                continue;
            }

            Mission misOne=itemOrderMapper.selectMissionById(abPoint.getId());
            if(!ObjectUtils.isEmpty(misOne)){
                continueHaveNum++;
                continue;
            }

            Mission mission=new Mission();
            mission.setId(UUID.randomUUID().toString().replace("-", ""));
            mission.setUserId(zhianUser);
            mission.setSubId(mapSubject.get("评审员-"+abPoint.getBusinessType()));
            mission.setSysId(ab_sysId);
            mission.setExamTime(getHaveDate(abPoint.getExamDate()));
            mission.setExamResult("未提供");
            mission.setExamScore(abPoint.getPoints());
            //todo 是否考试
            mission.setStatus(StringUtils.isEmpty(abPoint.getPoints())?1:2);
            //TODO 考试的结果
            mission.setResultStatus(StringUtils.isEmpty(abPoint.getPoints())?1:Integer.parseInt(abPoint.getPoints())>90?2:1);
            mission.setAb(NUMONE);
            mission.setAbId(abPoint.getId());
            mission.setAbUserId(abPoint.getAssessorId());
            mission.setAbBeginTime(getHaveDate(abPoint.getDateBegin()));
            mission.setAbEndTime(getHaveDate(abPoint.getDateEnd()));
            try {
                itemOrderMapper.insertMission(mission);
            } catch (Exception e) {
                return setResultError("错误数据" + JSON.toJSONString(mission) + "\n错误信息:" + JSON.toJSONString(e.getLocalizedMessage()));
            }
            okNum++;
        }
       return setResultSuccess("总数量:" + (ObjectUtils.isEmpty(listAb)?0:listAb.size()) + "\n因基础用户数据未同步跳过数量:" + continueNoBaeNum + "\n因当前数据已同步跳过数量:" + continueHaveNum +"\n成功数量:" + okNum);
    }

    @Override
    public BaseResponse delZheShuAll() {
        int i = itemOrderMapper.delAbAssessorCertificateAll();
        int m = itemOrderMapper.delCertificatesAll();
        return setResultSuccess("删除了" +( i+m)+ "条");
    }

    @Override
    public BaseResponse insertZheShu() throws ParseException {


        List<CertificateInfos> listAb=totalMapper.selectCertificateInfosAll();
        int continueNoBaeNum = 0;
        int continueHaveNum = 0;
        int okNum = 0;
        for(CertificateInfos certificateInfos:listAb) {

          //TODO 首先判断 当前 人员数据是否同步过来
            String zhianUser = itemOrderMapper.getZhianUserIdByAbId(certificateInfos.getUserId());
            if (StringUtils.isEmpty(zhianUser)) {
                continueNoBaeNum++;
                continue;
            }
            //TODO 判断数据是否已同步
            AbCertificate certificates = itemOrderMapper.selectCertificatesById(certificateInfos.getId());
            if (!ObjectUtils.isEmpty(certificates)) {
                continueHaveNum++;
                continue;
            }
            String roleName = certificateInfos.getRoleName();
            String typeid=itemOrderMapper.getDicDataByName(certificateInfos.getBusinessType());
            if ("评审员".equals(roleName)) {

                AbAssessorCertificate obj = new AbAssessorCertificate();
                obj.setId(UUID.randomUUID().toString().replace("-", ""));
                obj.setCertificate(certificateInfos.getCertificateId());
                obj.setTypeId(typeid);
                obj.setCreateTime(null);
                obj.setStartTime(DateUtilsLyz.parseDate(certificateInfos.getExpiryBegin()));
                obj.setEndTime(DateUtilsLyz.parseDate(certificateInfos.getExpiryEnd()));
                //公示结束时间
                //obj.setPublicityEndDate();
                obj.setState(getSatuteDate(certificateInfos.getStatus()));
                obj.setUserId(zhianUser);
                //TODO 考试得分
                //obj.setFraction();

                obj.setYear(StringUtils.isEmpty(certificateInfos.getExpiryEnd())?DateUtilsLyz.getDataYear(new Date()):DateUtilsLyz.getDataYear(obj.getEndTime()));
                obj.setMes(certificateInfos.getMemo());
                obj.setAb(NUMONE);
                obj.setAbId(certificateInfos.getId());
                obj.setAbUserId(certificateInfos.getUserId());
                try {
                    itemOrderMapper.insertAbAssessorCertificate(obj);
                } catch (Exception e) {
                    return setResultError("评审员证书错误数据" + JSON.toJSONString(obj) + "\n错误信息:" + JSON.toJSONString(e.getLocalizedMessage()));
                }
                okNum++;

            } else if ("企业".equals(roleName) || "评价机构".equals(roleName)) {

                AbCertificate qyObj = new AbCertificate();
                qyObj.setId(UUID.randomUUID().toString().replace("-", ""));
                //qyObj.setBodyId();
                qyObj.setUserId(zhianUser);
                qyObj.setPidUserId(certificateInfos.getOperator());
                qyObj.setNumber(certificateInfos.getCertificateId());
                qyObj.setOneDate(DateUtilsLyz.parseDate(certificateInfos.getExpiryBegin()));
                qyObj.setTwoDate(DateUtilsLyz.parseDate(certificateInfos.getExpiryEnd()));
                qyObj.setGrade(certificateInfos.getCertificateDegree());
                //qyObj.setCreateDate();
                qyObj.setKinds(typeid);
                qyObj.setFile(certificateInfos.getCertificatePath());
                qyObj.setActive(((new Date()).getTime()>(qyObj.getTwoDate()).getTime())?"1":"0");
                qyObj.setType(("评价机构".equals(roleName))?"0":"1");
                qyObj.setStatus(StringUtils.isEmpty(certificateInfos.getStatus())?"4":certificateInfos.getStatus());
                qyObj.setAb(NUMONE);
                qyObj.setAbId(certificateInfos.getId());
                qyObj.setAbUserId(certificateInfos.getUserId());
                try {
                    itemOrderMapper.insertCertificates(qyObj);
                } catch (Exception e) {
                    return setResultError("企业证书错误数据" + JSON.toJSONString(qyObj) + "\n错误信息:" + JSON.toJSONString(e.getLocalizedMessage()));
                }
                okNum++;
            }

        }
        return setResultSuccess("总数量:" + (ObjectUtils.isEmpty(listAb)?0:listAb.size()) + "\n因基础用户数据未同步跳过数量:" + continueNoBaeNum + "\n因当前数据已同步跳过数量:" + continueHaveNum +"\n成功数量:" + okNum);
    }


    public Date getHaveDate(String dat) throws ParseException {
        Date datD=null;
        if(!StringUtils.isEmpty(dat)){
           String str1[]=dat.split(" ");
           if(str1.length>1){
               String str[]=str1[0].split("/");
               String newDa=str[2]+"/"+str[1]+"/"+str[0]+" "+str1[1];
               datD=DateUtilsLyz.parseDate(newDa);
           }else{
               String str[]=dat.split("/");
               String newDa=str[2]+"/"+str[1]+"/"+str[0];
               datD=DateUtilsLyz.parseDate(newDa);
           }
        }
       return datD;
    }

    public Integer getSatuteDate(String dat) throws ParseException {
        Integer datD=null;
        if(StringUtils.isEmpty(dat)) {
            datD=4;
        }else{
           // 0等待开始1考试通过2考试不通过4公示通过3公示不通过5正在公式 10冻结   11 其他
            if(dat.equals("等待开始")){
                datD=0;
            }else if(dat.equals("考试通过")){
                datD=1;
            }else if(dat.equals("考试不通过")){
                datD=2;
            }else if(dat.equals("公示通过")){
                datD=4;
            }else if(dat.equals("公示不通过")){
                datD=3;
            }else if(dat.equals("正在公示")){
                datD=5;
            }else if(dat.equals("冻结")){
                datD=10;
            }else{
                datD=11;
            }
        }
        return datD;
    }

}
