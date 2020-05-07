package com.hb.ocean.controller;

import com.hb.ocean.base.BaseApiService;
import com.hb.ocean.base.BaseResponse;
import com.hb.ocean.impl.InsertSubuserTrafficImpl;
import com.hb.ocean.service.AbZhianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
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
     * 迁移考试记录表
     * @return
     * @throws Exception
     */
    @GetMapping("/startMission")
    @ResponseBody
    public BaseResponse startMission() throws Exception {
        //user表处理
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
//        //user表处理
        BaseResponse baseResponse = abZhianService.delMissionAll();
        return baseResponse;
    }



}