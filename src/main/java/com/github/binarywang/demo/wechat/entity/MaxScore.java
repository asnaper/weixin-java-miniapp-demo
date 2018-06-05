package com.github.binarywang.demo.wechat.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class MaxScore {

    /*`seq_id` int(11) NOT NULL,
        `user_id` int(11) NOT NULL,
        `wechat_openid` varchar(64) NOT NULL COMMENT '用户openid',
        `difficult_class` int NOT NULL COMMENT '表示 游戏难度的阶段，class 1表示一阶，class 2表示二阶 class3 表示三阶',
        `max_score` decimal(65,0) DEFAULT NULL COMMENT '对应阶段的最高分',
        `max_score_time` datetime DEFAULT NULL COMMENT '最高分获取更新的时间',
        `update_time` datetime NOT NULL COMMENT '更新时间',*/
    @JsonIgnore
    private int seq_id;
    @JsonIgnore
    private int user_id;
    private String wechat_openid;
    private int difficult_class;
    private long  max_score;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
    private Date  max_score_time;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
    private Date  update_time;

    public int getSeq_id() {
        return seq_id;
    }

    public void setSeq_id(int seq_id) {
        this.seq_id = seq_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getWechat_openid() {
        return wechat_openid;
    }

    public void setWechat_openid(String wechat_openid) {
        this.wechat_openid = wechat_openid;
    }

    public int getDifficult_class() {
        return difficult_class;
    }

    public void setDifficult_class(int difficult_class) {
        this.difficult_class = difficult_class;
    }

    public long getMax_score() {
        return max_score;
    }

    public void setMax_score(long max_score) {
        this.max_score = max_score;
    }

    public Date getMax_score_time() {
        return max_score_time;
    }

    public void setMax_score_time(Date max_score_time) {
        this.max_score_time = max_score_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "MaxScore{" +
                "user_id=" + user_id +
                ", wechat_openid='" + wechat_openid + '\'' +
                ", difficult_class='" + difficult_class + '\'' +
                ", max_score=" + max_score +
                ", max_score_time=" + max_score_time +
                ", update_time=" + update_time +
                '}';
    }

}
