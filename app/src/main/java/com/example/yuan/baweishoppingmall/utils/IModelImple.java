package com.example.yuan.baweishoppingmall.utils;


import com.google.gson.Gson;

import java.util.Map;

import retrofit2.Retrofit;


public class IModelImple implements IModel {
    @Override
    public void requestData(String url, Map<String, String> params, final Class clazz, final MyCallBack callBack) {

    RetrofitManager.getInstance().post(url, params, new RetrofitManager.HttpListener() {
        @Override
        public void onSuccess(String data) {
            Object o =new Gson().fromJson(data,clazz);

            if (callBack!=null)
            {
                callBack.onSuccess(o);
            }
        }

        @Override
        public void onFail(String error) {
            if (callBack!=null)
            {
                callBack.onFail(error);
            }
        }
    });





    }

    @Override
    public void getRequest(String url, final Class clazz, final MyCallBack callBack) {
        RetrofitManager.getInstance().get(url, new RetrofitManager.HttpListener() {
            @Override
            public void onSuccess(String data) {
                Object o =new Gson().fromJson(data,clazz);

                if (callBack!=null)
                {
                    callBack.onSuccess(o);
                }
            }

            @Override
            public void onFail(String error) {
                if (callBack!=null)
                {
                    callBack.onFail(error);
                }
            }
        });


    }

    @Override
    public void requestputData(String url, Map<String, String> params, final Class clazz, final MyCallBack callBack) {
        RetrofitManager.getInstance().put(url, params, new RetrofitManager.HttpListener() {
            @Override
            public void onSuccess(String data) {
                Object o=new Gson().fromJson(data,clazz);
                if (callBack!=null)
                {
                    callBack.onSuccess(o);
                }
            }

            @Override
            public void onFail(String error) {
                if (callBack!=null)
                {
                    callBack.onFail(error);
                }
            }
        });
    }


}
