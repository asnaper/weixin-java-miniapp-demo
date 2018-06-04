package com.github.binarywang.demo.wechat.dao;

public interface BaseEnum<E extends Enum<?>, T> {
    public T getValue();
    public String getName();
}
