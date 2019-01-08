package com.example.yuan.baweishoppingmall.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;

import com.example.yuan.baweishoppingmall.App.BacaApplication;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static android.content.Context.MODE_PRIVATE;

public class RetrofitManager<T> {
    private final String BASE_URL = "http://172.17.8.100/small/";

    private static RetrofitManager mRetrofitManager;
            //单例
    public static synchronized RetrofitManager getInstance() {
        if (mRetrofitManager == null) {
            mRetrofitManager = new RetrofitManager();
        }
        return mRetrofitManager;
    }

    private BaceApis mBaseApis;
    //读写,拦截器,retrofit
    public RetrofitManager() {
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(15, TimeUnit.SECONDS);
        builder.readTimeout(15, TimeUnit.SECONDS);
        builder.writeTimeout(15, TimeUnit.SECONDS);
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                //拿到请求
                Request original = chain.request();
                //取出保存的两个id
                SharedPreferences sharedPreferences = BacaApplication.getApplication().getSharedPreferences("User",MODE_PRIVATE);
                String sessionId = sharedPreferences.getString("sessionId", "");
                String userId = sharedPreferences.getString("userId", "");

                //重新构造请求
                Request.Builder requestBuilder=original.newBuilder();
                //把原来请求的参数原样放进去
                requestBuilder.method(original.method(),original.body());
                //添加特殊的两个id
                if (!TextUtils.isEmpty(sessionId)&&!TextUtils.isEmpty(userId))
                {
                    requestBuilder.addHeader("userId",userId);
                    requestBuilder.addHeader("sessionId",sessionId);
                }
                //打包
                Request request=requestBuilder.build();
                //返回response
                return chain.proceed(request);
            }
        });






        builder.retryOnConnectionFailure(true);
        OkHttpClient client = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .client(client)
                .build();
        mBaseApis = retrofit.create(BaceApis.class);
    }



    /**
     * get请求
     */
    public void get(String url,HttpListener listener) {

        mBaseApis.get(url)
                //后台执行在哪个线程中
                .subscribeOn(Schedulers.io())
                //最终完成后执行在哪个线程
                .observeOn(AndroidSchedulers.mainThread())
                //设置我们的rxJava
                .subscribe(getObserver(listener));


    }




    /**
     * 普通post请求
     */
    public void post(String url, Map<String, String> map,HttpListener listener) {
        if (map == null) {
            map = new HashMap<>();
        }
        mBaseApis.post(url, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getObserver(listener));

    }
            //put 请求

    public void put(String url, Map<String, String> params,HttpListener listener) {
        if (params == null) {
            params = new HashMap<>();
        }
        mBaseApis.put(url, params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getObserver(listener));

    }


    private Observer getObserver(final HttpListener listener){
        Observer observer = new Observer<ResponseBody>() {

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                if(listener != null){
                    listener.onFail(e.getMessage());
                }
            }

            @Override
            public void onNext(ResponseBody responseBody) {
                try {
                    String string = responseBody.string();
                    if(listener != null){
                        listener.onSuccess(string);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    if(listener != null){
                        listener.onFail(e.getMessage());
                    }
                }
            }
        };
        return observer;
    }

    private HttpListener listener;

    public void result(HttpListener listener) {
        this.listener = listener;
    }

    public interface HttpListener {
        void onSuccess(String data);

        void onFail(String error);
    }
}
