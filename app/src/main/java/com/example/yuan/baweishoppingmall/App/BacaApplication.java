package com.example.yuan.baweishoppingmall.App;

import android.app.Application;
import android.content.Context;

public class BacaApplication extends Application {
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();
    }
    public static Context getApplication()
    {
        return mContext;
    }
}
