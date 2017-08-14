package org.apink.domain;

import java.sql.Date;

public class User {
    private int id;
    private String username;
    private String email;
    private String tel;
    private String nickname;
    private String snsId;
    private String snsType;
    private String snsProfile;
    private int adminFlag;
    private Date createDate;
    private Date modifyDate;

    public Boolean isValid(){
        if(username != null || email != null || tel != null){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", nickname='" + nickname + '\'' +
                ", snsId='" + snsId + '\'' +
                ", snsType='" + snsType + '\'' +
                ", snsProfile='" + snsProfile + '\'' +
                ", adminFlag=" + adminFlag +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String neickname) {
        this.nickname = neickname;
    }

    public String getSnsId() {
        return snsId;
    }

    public void setSnsId(String snsId) {
        this.snsId = snsId;
    }

    public String getSnsType() {
        return snsType;
    }

    public void setSnsType(String snsType) {
        this.snsType = snsType;
    }

    public String getSnsProfile() {
        return snsProfile;
    }

    public void setSnsProfile(String snsProfile) {
        this.snsProfile = snsProfile;
    }

    public int getAdminFlag() {
        return adminFlag;
    }

    public void setAdminFlag(int adminFlag) {
        this.adminFlag = adminFlag;
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
}