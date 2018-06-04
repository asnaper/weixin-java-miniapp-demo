package com.github.binarywang.demo.wechat.controller;


import com.alibaba.fastjson.JSONObject;
import com.github.binarywang.demo.wechat.config.ConstDefine;
import com.github.binarywang.demo.wechat.dao.ConsumerMapper;
import com.github.binarywang.demo.wechat.dao.MaxScoreMapper;
import com.github.binarywang.demo.wechat.entity.Consumer;
import com.github.binarywang.demo.wechat.entity.MaxScore;
import com.github.binarywang.demo.wechat.utils.CommonUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.github.binarywang.demo.wechat.utils.JsonUtils;
import me.chanjar.weixin.common.exception.WxErrorException;

import java.util.Map;

/**
 * 微信小程序用户接口
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@RestController
@RequestMapping("/wechat/user")
public class WxMaUserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WxMaService wxService;

    @Autowired
    private ConsumerMapper consumerMapper;

    @Autowired
    private MaxScoreMapper maxScoreMapper;
    /**
     * 登陆接口
     */
    @GetMapping("/login")
    public String login(String code) {
        if (StringUtils.isBlank(code)) {
            return "empty jscode";
        }

        try {
            WxMaJscode2SessionResult session = this.wxService.getUserService().getSessionInfo(code);
            this.logger.info(session.getSessionKey());
            this.logger.info(session.getOpenid());
            //TODO 可以增加自己的逻辑，关联业务相关数据
            String wxOpenId = session.getOpenid();
            Consumer consumer = new Consumer();
            consumer.setWechatOpenid(wxOpenId);
            loginOrRegisterConsumer(consumer);
            String bUpdate = "true";
            //业务处理逻辑结束
            //创建JSON对象
            JSONObject jsonObject = new JSONObject();
            String retMsg = "success";
            Map<String,Object> map = CommonUtils.convertObj2Map(session);
            map.put("bNeedUpdate",bUpdate);
            try {
                jsonObject.put(ConstDefine.JSON_DATA,map);
            }catch (Exception e)
            {
                retMsg = "failed";
            }
            jsonObject.put(ConstDefine.JSON_RESULT_MSG,retMsg);

            //以下为获取得分的逻辑
            MaxScore maxScore1 = maxScoreMapper.findClassScoreByWechatOpenid(wxOpenId,"1");
            MaxScore maxScore2 = maxScoreMapper.findClassScoreByWechatOpenid(wxOpenId,"2");
            MaxScore maxScore3 = maxScoreMapper.findClassScoreByWechatOpenid(wxOpenId,"3");

            //以上为获取得分的逻辑
            return jsonObject.toJSONString();
            //return JsonUtils.toJson(session);
        } catch (WxErrorException e) {
            this.logger.error(e.getMessage(), e);
            return e.toString();
        }
    }

    /**
     * <pre>
     * 获取用户信息接口
     * </pre>
     */
    @GetMapping("/info")
    public String info(String sessionKey, String signature, String rawData, String encryptedData, String iv) {
        // 用户信息校验
        if (!this.wxService.getUserService().checkUserInfo(sessionKey, rawData, signature)) {
            return "user check failed";
        }

        // 解密用户信息
        WxMaUserInfo userInfo = this.wxService.getUserService().getUserInfo(sessionKey, encryptedData, iv);

        return JsonUtils.toJson(userInfo);
    }

    @PostMapping(path = "/updateMembers", consumes = "application/json", produces = "application/json")
    public  String updateMembers(@RequestBody Consumer consumer) {
        this.logger.info(">>>>> /updateMembers:"+consumer.toString());
        consumer.setWechatOpenid("otgmA4r9IDbTpfOwctS3yp26Ml1Y");
        JSONObject jsonObject = new JSONObject();
        String retMsg = "success";
        try{
            updateConsumerInfo(consumer);
            Map<String,Object> map = CommonUtils.convertObj2Map(consumer);
            jsonObject.put(ConstDefine.JSON_DATA,map);

        }
        catch (Exception e)
        {
            retMsg = "falied";
        }
        jsonObject.put(ConstDefine.JSON_RESULT_MSG,retMsg);
        this.logger.info("<<<<< /updateMembers:"+jsonObject.toJSONString());
        return jsonObject.toJSONString();
    }
    /**
     * <pre>
     * 获取用户绑定手机号信息
     * </pre>
     */
    @GetMapping("/phone")
    public String phone(String sessionKey, String signature, String rawData, String encryptedData, String iv) {
        // 用户信息校验
        if (!this.wxService.getUserService().checkUserInfo(sessionKey, rawData, signature)) {
            return "user check failed";
        }

        // 解密
        WxMaPhoneNumberInfo phoneNoInfo = this.wxService.getUserService().getPhoneNoInfo(sessionKey, encryptedData, iv);

        return JsonUtils.toJson(phoneNoInfo);
    }


    private void loginOrRegisterConsumer(Consumer consumer) {
        Consumer consumer1 = consumerMapper.findConsumerByWechatOpenid(consumer.getWechatOpenid());
        if (null == consumer1) {
            long lTimeStamp = System.currentTimeMillis();
            consumer.setCreatedBy(1L);
            consumer.setCreatedAt(lTimeStamp);
            consumer.setDeleted(false);
            consumer.setCreatedAt(lTimeStamp);
            consumer.setUpdatedAt(lTimeStamp);
            consumerMapper.insertConsumer(consumer);
        }
    }

    public void updateConsumerInfo(Consumer consumer) {
        Consumer consumerExist = consumerMapper.findConsumerByWechatOpenid(consumer.getWechatOpenid());
        if( null != consumerExist ){
            consumerExist.setUpdatedBy(1L);
            consumerExist.setUpdatedAt(System.currentTimeMillis());
            consumerExist.setGender(consumer.getGender());
            consumerExist.setAvatarUrl(consumer.getAvatarUrl());
            consumerExist.setWechatOpenid(consumer.getWechatOpenid());
            consumerExist.setEmail(consumer.getEmail());
            consumerExist.setNickname(consumer.getNickname());
            consumerExist.setPhone(consumer.getPhone());
            consumerExist.setUsername(consumer.getUsername());
            consumerExist.setCity(consumer.getCity());
            consumerExist.setProvince(consumer.getProvince());
            consumerExist.setCountry(consumer.getCountry());
            consumerExist.setLanguage(consumer.getLanguage());
            consumerMapper.updateConsumer(consumerExist);
        }
        else {
            this.logger.error("updateConsumerInfo FAILED");
        }

    }

    private MaxScore getMaxScoreByWechatOpenID(String wechat_openid,String difficult_class){
        return maxScoreMapper.findClassScoreByWechatOpenid(wechat_openid,difficult_class);
    }
}
