package com.hb.ocean.impl;

import com.hb.ocean.service.InsertEssentialInformation;

public class InsertSubuserTraffic implements InsertEssentialInformation {
    @Override
    public String toInsert() {
        return "企业";
    }
}
