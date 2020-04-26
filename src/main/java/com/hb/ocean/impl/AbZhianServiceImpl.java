package com.hb.ocean.impl;

import com.alibaba.fastjson.JSON;
import com.hb.ocean.entity.AbUser;
import com.hb.ocean.entity.SubuserTraffic;
import com.hb.ocean.entity.UserRole;
import com.hb.ocean.entity.ZhianUser;
import com.hb.ocean.mapper.iceberg.ItemOrderMapper;
import com.hb.ocean.mapper.ocean.TotalMapper;
import com.hb.ocean.service.AbZhianService;
import com.hb.ocean.service.InsertEssentialInformation;
import com.hb.ocean.utils.SpringContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AbZhianServiceImpl implements AbZhianService {

    @Autowired
    private ItemOrderMapper itemOrderMapper;

    @Autowired
    private TotalMapper totalMapper;

    static final String NUMONE = "1";
    static final String NUMTWO = "2";
    static final String NUMTHREE = "3";
    static final String NUMFOUR = "4";
    static final String NUMFIVE = "5";
    static final String SEXMAN = "男";
    static final String SEXWOMEN = "女";
    static final String ISNUMM = "";
    //1002行业管理机构
    static final String ZHUGUANBUMEN = "1001";
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
    public String getAllUser() throws Exception {

        List<AbUser> users = totalMapper.selectAll();
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
                    certificationType = ZHUGUANBUMEN;
                    break;
                case NUMTWO:
                    certificationType = JIAOTONGYUNSHUQIYE;
                    break;
                case NUMTHREE:
                    certificationType = DISANFANGJIGOU;
                    break;
                case NUMFOUR:
                    certificationType = PINGSHENYUAN;
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

            try {
                itemOrderMapper.insertAll(zhianUser);
            } catch (Exception e) {
                return "错误数据" + JSON.toJSONString(zhianUser) + "\n错误信息:" + JSON.toJSONString(e.getLocalizedMessage());
            }


            okNum++;


            list.add(zhianUser);
        }

        for(ZhianUser zhianUser:list){

            insertEss(zhianUser);
        }



//        String s = JSON.toJSONString(zhianUserAll);
//        String b = JSON.toJSONString(users);
//        System.out.println(s);
//        System.out.println(b);
        return "总数量:" + users.size() + "\n跳过数量:" + continueNum + "\n成功数量:" + okNum;

    }

    /**
     * 删除数据
     * @return
     */
    @Override
    public Integer delAllUser() {
        return itemOrderMapper.delZhianUserAll();
    }


    /**
     * 处理基本信息
     * @return
     */
    public String insertEss(ZhianUser zhianUser){
        Map<String,Object> map=new HashMap<>();
//        map.put(ZHUGUANBUMEN,"insertSubuserTraffic");
        map.put(JIAOTONGYUNSHUQIYE,"insertSubuserTraffic");

//        SpringContextUtils.getBean(payBeanId, InsertEssentialInformation.class);
        return null;
    }





}
