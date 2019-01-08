package com.example.yuan.baweishoppingmall.utils;



import java.util.Map;

public interface IModel {
    void requestData(String url, Map<String, String> params, Class clazz, MyCallBack callBack);
    void getRequest(String url,Class clazz,MyCallBack callBack);
    void requestputData(String url, Map<String, String> params, Class clazz, MyCallBack callBack);
}
