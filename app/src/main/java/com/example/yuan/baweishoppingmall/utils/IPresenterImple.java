package com.example.yuan.baweishoppingmall.utils;



import java.util.Map;

public class IPresenterImple implements IPresenter {

    private IView mIView;
    private IModelImple mIModelImple;

    public IPresenterImple(IView mIView) {
        this.mIView = mIView;
        mIModelImple=new IModelImple();
    }

    @Override
    public void startRequest(String url, Map<String, String> params, Class clazz) {
        mIModelImple.requestData(url, params, clazz, new MyCallBack() {
            @Override
            public void onSuccess(Object data) {
                mIView.getDataSuccess(data);

            }

            @Override
            public void onFail(String error) {
                mIView.getDataFail(error);
            }
        });
    }

    @Override
    public void getRequest(String url, Class clazz) {
        mIModelImple.getRequest(url, clazz, new MyCallBack() {
            @Override
            public void onSuccess(Object data) {
                mIView.getDataSuccess(data);
            }

            @Override
            public void onFail(String error) {
                mIView.getDataFail(error);
            }
        });
    }
        //put
    @Override
    public void startputRequest(String url, Map<String, String> params, Class clazz) {
        mIModelImple.requestputData(url, params, clazz, new MyCallBack() {
            @Override
            public void onSuccess(Object data) {
                mIView.getDataSuccess(data);
            }

            @Override
            public void onFail(String error) {
                mIView.getDataFail(error);
            }
        });
    }


}
