package com.example.yuan.baweishoppingmall.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.yuan.baweishoppingmall.R;
import com.example.yuan.baweishoppingmall.adapter.Circle_Fragemnt_Adapter;
import com.example.yuan.baweishoppingmall.bean.Circle_Home_bean;
import com.example.yuan.baweishoppingmall.utils.IPresenterImple;
import com.example.yuan.baweishoppingmall.utils.IView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

//import butterknife.ButterKnife;

public class Circle_Fragment extends Fragment implements IView {
//   @BindView(R.id.circle_fragment_xrecyclerview)
//    XRecyclerView circle_fragment_xrecyclerview;
    private IPresenterImple presenterImple;
    private int mPage;
    private Circle_Fragemnt_Adapter circle_fragemnt_adapter;
    private XRecyclerView circle_fragment_xrecyclerview;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.circle_fragment,container,false);
        //绑定
        //ButterKnife.bind(getActivity());
        presenterImple = new IPresenterImple(this);

         circle_fragment_xrecyclerview= view.findViewById(R.id.circle_fragment_xrecyclerview);

        circle_fragment_xrecyclerview.setLoadingMoreEnabled(true);
        circle_fragment_xrecyclerview.setPullRefreshEnabled(true);

        circle_fragment_xrecyclerview.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mPage=1;
                getShow();
            }

            @Override
            public void onLoadMore() {
                getShow();
            }
        });
        //适配器
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        circle_fragment_xrecyclerview.setLayoutManager(layoutManager);

        circle_fragemnt_adapter = new Circle_Fragemnt_Adapter(getActivity());
        circle_fragment_xrecyclerview.setAdapter(circle_fragemnt_adapter);


        getShow();

        return view;
    }

    private void getShow() {
        presenterImple.getRequest("http://172.17.8.100/small/circle/v1/findCircleList?userId=1010&sessionId=17600822995&page=1&count=5",Circle_Home_bean.class);
    }

    @Override
    public void getDataSuccess(Object data) {

        if (data instanceof Circle_Home_bean)
        {
            Circle_Home_bean circle_home_bean= (Circle_Home_bean) data;
           if (mPage==1)
           {
               circle_fragemnt_adapter.setmDatas(circle_home_bean.getResult());
           }
           else
           {
               circle_fragemnt_adapter.addmDatas(circle_home_bean.getResult());
           }
           mPage++;
           circle_fragment_xrecyclerview.refreshComplete();
           circle_fragment_xrecyclerview.loadMoreComplete();

        }

    }

    @Override
    public void getDataFail(String error) {
        Toast.makeText(getActivity(),error,Toast.LENGTH_SHORT).show();
    }
}
