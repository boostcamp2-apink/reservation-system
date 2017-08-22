package org.apink.domain;

import java.sql.Date;

@SuppressWarnings("unused")
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


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", representFileId=" + representFileId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", salesStart=" + salesStart +
                ", salesEnd=" + salesEnd +
                ", salesFlag=" + salesFlag +
                ", event='" + event + '\'' +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                ", commentCount=" + commentCount +
                ", totalScore=" + totalScore +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getRepresentFileId() {
        return representFileId;
    }

    public void setRepresentFileId(int representFileId) {
        this.representFileId = representFileId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getSalesStart() {
        return salesStart;
    }

    public void setSalesStart(Date salesStart) {
        this.salesStart = salesStart;
    }

    public Date getSalesEnd() {
        return salesEnd;
    }

    public void setSalesEnd(Date salesEnd) {
        this.salesEnd = salesEnd;
    }

    public int getSalesFlag() {
        return salesFlag;
    }

    public void setSalesFlag(int salesFlag) {
        this.salesFlag = salesFlag;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
}