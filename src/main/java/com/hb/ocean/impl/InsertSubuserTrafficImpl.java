package com.hb.ocean.impl;

import com.hb.ocean.service.InsertEssentialInformation;

/**
 * 企业
 */
public class InsertSubuserTrafficImpl implements InsertEssentialInformation {
    @Override
    public String toInsert() {
        return "企业";
    }
}
