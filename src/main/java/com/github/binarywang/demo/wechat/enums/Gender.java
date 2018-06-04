package com.github.binarywang.demo.wechat.enums;

import com.github.binarywang.demo.wechat.dao.BaseEnum;
import java.util.HashMap;
import java.util.Map;

public enum Gender implements BaseEnum<Gender, Byte> {
    UNKNOW(0, "未知"),
    MAN(1, "先生"),
    WOMAN(2, "女士");

    private Byte value;
    private String name;

    static Map<Byte,Gender> enumMap=new HashMap<Byte, Gender>();
    static{
        for(Gender type:Gender.values()){
            enumMap.put(type.getValue(), type);
        }
    }

    Gender(int value, String name) {
        this.value = (byte)value;
        this.name = name;
    }

    public Byte getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }
}