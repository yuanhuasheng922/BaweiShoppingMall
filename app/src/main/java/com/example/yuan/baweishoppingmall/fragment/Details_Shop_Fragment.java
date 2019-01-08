package com.example.yuan.baweishoppingmall.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuan.baweishoppingmall.R;
import com.example.yuan.baweishoppingmall.bean.Details_bean;
import com.example.yuan.baweishoppingmall.bean.Details_shopadd;
import com.example.yuan.baweishoppingmall.utils.Apis;
import com.example.yuan.baweishoppingmall.utils.IPresenterImple;
import com.example.yuan.baweishoppingmall.utils.IView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoaderInterface;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Details_Shop_Fragment extends Fragment implements IView {

    private Banner details_banner;
    private TextView details_title;
    private TextView details_price;
    private IPresenterImple presenterImple;
    private String idd;
   private WebView webView;
    private ImageView details_addshop;
    private Details_bean details_bean;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view=inflater.inflate(R.layout.details_shop,container,false);
        Fresco.initialize(getActivity());
         webView= view.findViewById(R.id.webview);
       webView.getSettings().setJavaScriptEnabled(true);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        details_banner = view.findViewById(R.id.details_banner);
        details_title = view.findViewById(R.id.details_title);
        details_price = view.findViewById(R.id.details_price);
        details_addshop = view.findViewById(R.id.details_addshop);
        presenterImple = new IPresenterImple(this);
        //点击购物车按钮 添加到购物车
        details_addshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int commodityId = details_bean.getResult().getCommodityId();
                Map<String,String> map=new HashMap<>();
                map.put("data","[{\"commodityId\":"+commodityId+",\"count\":1}]");
                presenterImple.startputRequest(Apis.URL_ADD_PUT,map,Details_shopadd.class);
            }
        });
        //拿到传过来的id
        Intent intent = getActivity().getIntent();
        idd = intent.getStringExtra("idd");


        details_banner.setBannerStyle(BannerConfig.NOT_INDICATOR);
        details_banner.setImageLoader(new ImageLoaderInterface<ImageView>() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Uri uri = Uri.parse((String) path);
                imageView.setImageURI(uri);

            }

            @Override
            public ImageView createImageView(Context context) {
                SimpleDraweeView simpleDraweeView=new SimpleDraweeView(context);
                return simpleDraweeView;
            }
        });

        getShow();
    }

    private void getShow() {
        presenterImple.getRequest("http://172.17.8.100/small/commodity/v1/findCommodityDetailsById?commodityId="+idd,Details_bean.class);
    }

    @Override
    public void getDataSuccess(Object data) {
        if (data instanceof Details_bean)
        {
            details_bean = (Details_bean) data;
            List<String> list=new ArrayList<>();
            String[] split = details_bean.getResult().getPicture().split("\\,");
            for (int i=0;i<split.length;i++)
            {
                list.add(split[i]);
            }
            details_banner.setImages(list);
            details_banner.start();
            //details_price.setText(details_bean.getResult().getStock());
            //details_title.setText(details_bean.getResult().getSaleNum());
           webView.loadDataWithBaseURL(null, details_bean.getResult().getDetails(),"text/html","utf-8",null);
        }
        //添加
        else  if(data instanceof  Details_shopadd)
        {
            Details_shopadd details_shopadd= (Details_shopadd) data;
            if (details_shopadd.getMessage().equals("同步成功"))
            {
                Toast.makeText(getActivity(),"添加购物车成功",Toast.LENGTH_LONG).show();
            }
        }



    }

    @Override
    public void getDataFail(String error) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (webView!=null)
        {
            webView.setVisibility(View.GONE);
            webView.removeAllViews();
            webView.destroy();
        }
    }
}
