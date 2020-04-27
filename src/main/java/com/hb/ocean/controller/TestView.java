package com.hb.ocean.controller;

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
public class TestView {

    @Autowired
    private AbZhianService abZhianService;

    @GetMapping("/startUser")
    @ResponseBody
    public BaseResponse startUser() throws Exception {
        //user表处理
        BaseResponse allUser = abZhianService.getAllUser();

        return allUser;
    }

    @GetMapping("/delUser")
    @ResponseBody
    public BaseResponse delUser() throws Exception {
        //user表处理
        BaseResponse baseResponse = abZhianService.delAllUser();
        return baseResponse;
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


}
