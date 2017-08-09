package org.apink.domain;

import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class Product {

    //In Products Table
    private int id;
    private int categoryId;
    private int representFileId;
    private String name;
    private String description;
    private Date salesStart;
    private Date salesEnd;
    private int salesFlag;
    private String event;
    private Date createDate;
    private Date modifyDate;
    private int commentCount;
    private int totalScore;

    //In Products_Display Table
    private String placeName;

    //In Products_Image
    private List<Integer> imageIdList;



}
