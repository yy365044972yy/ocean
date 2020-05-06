package com.hb.ocean.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SubuserCategory implements Serializable {

    private String id;

    private String mainId;

    private String categoryId;

    private String pid;

    private String userId;

    private Date okDate;

    private String active;

    private String ab;
}
