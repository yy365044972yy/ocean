package com.hb.ocean.controller;

import com.hb.ocean.base.BaseApiService;
import com.hb.ocean.base.BaseResponse;
import com.hb.ocean.service.AbZhianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;


/**
 * @author QuCheng on 2019-09-17.
 */
@Controller
@RequestMapping("/abzhian")
public class TestView extends BaseApiService {

    @Autowired
    private AbZhianService abZhianService;

    /**
     * 迁移用户表
     * @return
     * @throws Exception
     */
    @GetMapping("/startUser")
    @ResponseBody
    public BaseResponse startUser() throws Exception {
        //user表处理
        BaseResponse allUser = abZhianService.getAllUser();

        return allUser;
    }

    /**
     * 删除用户表
     * @return
     */
    @GetMapping("/delUser")
    @ResponseBody
    public BaseResponse delUser(){
//        //user表处理
        BaseResponse baseResponse = abZhianService.delAllUser();
        return baseResponse;
    }

    /**
     * 删除角色表
     * @return
     */
    @GetMapping("/delUserByType")
    @ResponseBody
    public BaseResponse delUserByType(){
        return abZhianService.delAllUserByType();
    }




    /**
     * 处理基础信息表后续的企业/主管机关/人员等表
     * @return
     * @throws ParseException
     */


    @GetMapping("/startUserMiddleTab")
    @ResponseBody
    public BaseResponse startUserMiddleTab() throws ParseException {
            return abZhianService.insertEss();


    }


    /**
     * 处理UKey
     * @return
     * @throws ParseException
     */

    @GetMapping("/startUkey")
    @ResponseBody
    public BaseResponse startUkey() throws ParseException {
        return abZhianService.inserUkey();
    }


    /**
     * 手动将类型添加到子表中
     * @return
     */
    @GetMapping("/text")
    @ResponseBody
    public BaseResponse text(){
        //将类型从企业表放置到子表中
        String subuserTrafficId="21a7da98c9b549f78543aba5eabd9c47";
        String subuserTrafficBigType="ced8081240fe44c499edb8dadabf0c0b,5246ed26834546e5ad9d90ea5dedd83a,c4063a1c71a94ea496b83e9df45f529e,28239bfd284e4bc9b5c1b8cadf0181c7";
        String subuserTrafficSimallType="2ef784c06dd34efcac7fe96049f8f3ea,87f96fefc3ab4438ab3b9408b8bcc921,11e79d23776346ebbb16e4c52dca4040,5f1bc3b11f8649039b0188b41c7c8f5d,a69e97528cb94123acdfdf6e22bed8ed,d6c2f91e9b2c41d5b4cb63589aa3eb7b,220d416a96754673af96fda826b1f6db,3c483a162b4f43ab9994936039d9bf63,80530a459d384cbbabb18335e681e53d,86ccc8640452442881d6b767915d44fb,dccd3bc2ef634c5f888dba895239ccba";
        String subuserTrafficSimallUserId="ff61447e59f140fa97cb0eb1cc509dba";
        abZhianService.insertSubuserCategory(subuserTrafficId,subuserTrafficBigType,subuserTrafficSimallType,subuserTrafficSimallUserId);

        return setResultSuccess();
    }

    /**
     * 迁移考试记录表
     * @return
     * @throws Exception
     */
    @GetMapping("/startMission")
    @ResponseBody
    public BaseResponse startMission() throws Exception {
        BaseResponse baseResponse = abZhianService.insertMission();

        return baseResponse;
    }

    /**
     * 删除旧系统数据
     * @return
     */
    @GetMapping("/delAbMission")
    @ResponseBody
    public BaseResponse delAbMission(){
        BaseResponse baseResponse = abZhianService.delMissionAll();
        return baseResponse;
    }

    /**
     * 迁移证书数据
     * @return
     * @throws Exception
     */
    @GetMapping("/startZhengshu")
    @ResponseBody
    public BaseResponse startZhengshu() throws Exception {
        BaseResponse baseResponse = abZhianService.insertZheShu();
        return baseResponse;
    }

    /**
     * 删除旧系统证书数据
     * @return
     */
    @GetMapping("/delZheShuAll")
    @ResponseBody
    public BaseResponse delZheShuAll(){
        BaseResponse baseResponse = abZhianService.delZheShuAll();
        return baseResponse;
    }

}