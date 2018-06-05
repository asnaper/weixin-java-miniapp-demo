package com.github.binarywang.demo.wechat.dao;

import com.github.binarywang.demo.wechat.entity.MaxScore;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaxScoreMapper {
    MaxScore findScoreByWechatOpenid(String wechatOpenid);
    MaxScore findClassScoreByWechatOpenid(@Param("wechat_openid")String wechat_openid, @Param("difficult_class") String difficult_class);
    void insertScore(MaxScore consumerScore);

    void updateScore(MaxScore consumerScore);

    List<MaxScore> getTop10ScoreByClass(@Param("difficult_class") int difficult_class);
}
