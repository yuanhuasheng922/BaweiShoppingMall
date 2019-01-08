package com.example.yuan.baweishoppingmall.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.yuan.baweishoppingmall.R;
import com.example.yuan.baweishoppingmall.bean.Details_bean;
import com.example.yuan.baweishoppingmall.utils.IView;

public class Details_Details_Fragment extends Fragment {

    private WebView details_webview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.details_fragment,container,false);
//        details_webview = view.findViewById(R.id.details_webview);
//        Details_bean details_bean=new Details_bean();
//        details_webview.loadDataWithBaseURL(null,details_bean.getResult().getDetails(),"text/html","utf-8",null);
        return view;
    }


//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        if (details_webview!=null)
//        {
//            details_webview.setVisibility(View.GONE);
//            details_webview.removeAllViews();
//            details_webview.destroy();
//        }
//    }
}
