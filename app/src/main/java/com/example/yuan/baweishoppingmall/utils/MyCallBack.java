package com.example.yuan.baweishoppingmall.utils;

public interface MyCallBack<T> {
    void onSuccess(T data);
    void onFail(String error);
}
