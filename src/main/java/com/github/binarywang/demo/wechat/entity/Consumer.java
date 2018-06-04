package com.github.binarywang.demo.wechat.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.binarywang.demo.wechat.enums.Gender;

public class Consumer {

    private Long id;
    private String username;
    private String wechatOpenid;
    private Long phone;

    private String nickname;
    private String avatarUrl;

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    //private Gender gender;
    private int    gender;
    private String email;
    private Long lastLoginTime;
    private Boolean deleted;
    private Long createdBy;
    private Long createdAt;
    private Long updatedBy;
    private Long updatedAt;

    private String city;
    private String province;
    private String country;
    private String language;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWechatOpenid() {
        return wechatOpenid;
    }

    public void setWechatOpenid(String wechatOpenid) {
        this.wechatOpenid = wechatOpenid;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {

        this.avatarUrl = avatarUrl;
    }

   /* public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }*/

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("nickName")
    public String getNickname() {
        return nickname;
    }

    @JsonProperty("nickName")
    public void setNickname(String nickName) {
        this.nickname = nickName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", wechatOpenid='" + wechatOpenid + '\'' +
                ", phone=" + phone +
                ", nickName='" + nickname + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", deleted=" + deleted +
                ", createdBy=" + createdBy +
                ", createdAt=" + createdAt +
                ", updatedBy=" + updatedBy +
                ", updatedAt=" + updatedAt +
                '}';
    }

}
