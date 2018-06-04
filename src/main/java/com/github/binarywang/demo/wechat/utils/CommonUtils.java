package com.github.binarywang.demo.wechat.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class CommonUtils {

    public static Map<String, Object> convertObj2Map(Object obj) {

        ObjectMapper oMapper = new ObjectMapper();

        // object -> Map
        Map<String, Object> map = oMapper.convertValue(obj, Map.class);
        System.out.println(map);
        return map;
    }
}
