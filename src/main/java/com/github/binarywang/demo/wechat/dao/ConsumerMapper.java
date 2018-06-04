package com.github.binarywang.demo.wechat.dao;


import org.apache.ibatis.annotations.Mapper;
import com.github.binarywang.demo.wechat.entity.Consumer;

@Mapper
public interface ConsumerMapper {

    Consumer findConsumerById(Long id);

    Consumer findConsumerByWechatOpenid(String wechatOpenid);

    void insertConsumer(Consumer consumer);

    void updateConsumer(Consumer consumer);

}
