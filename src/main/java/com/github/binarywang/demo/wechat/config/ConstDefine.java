package com.github.binarywang.demo.wechat.config;

public class ConstDefine {
    public static final String JSON_RESULT_MSG = "result";
    public static final String JSON_SUCCESS ="success";
    public static final String JSON_FAIL ="failed";

    public static final String JSON_DATA = "data";
    public static final String JSON_RET_CODE ="rescode";

    //错误代码

    public static final int JSON_RET_CODE_OK =1000; //处理成功
    public static final int JSON_RET_CODE_NEED_REGISTER =1001;    //登录接口，需要注册
    public static final int JSON_RET_CODE_WECHAT_ERROR  =1002;     //登录接口，微信返回错误
}
