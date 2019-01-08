package com.example.yuan.baweishoppingmall.utils;

import java.util.Map;

public interface IPresenter {
    void startRequest(String url, Map<String, String> params, Class clazz);
    void getRequest(String url,Class clazz);
    void startputRequest(String url, Map<String, String> params, Class clazz);
}
