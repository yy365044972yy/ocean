package com.hb.ocean.service;


import com.hb.ocean.base.BaseResponse;

import java.text.ParseException;

public interface AbZhianService {


    BaseResponse getAllUser() throws Exception;

//     Integer setZhianUser(ZhianUser zhianUser);
    BaseResponse delAllUser();

    BaseResponse insertEss() throws ParseException;

    BaseResponse inserUkey();

}
