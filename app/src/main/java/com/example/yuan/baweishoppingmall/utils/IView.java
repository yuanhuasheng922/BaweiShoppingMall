package com.example.yuan.baweishoppingmall.utils;

public interface IView<T> {
    void getDataSuccess(T data);
    void getDataFail(String error);
}
