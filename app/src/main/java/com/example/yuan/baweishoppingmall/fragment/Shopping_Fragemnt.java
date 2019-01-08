package com.example.yuan.baweishoppingmall.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yuan.baweishoppingmall.R;
import com.example.yuan.baweishoppingmall.adapter.Shopping_Select;
import com.example.yuan.baweishoppingmall.bean.Shopping_Select_bean;
import com.example.yuan.baweishoppingmall.utils.IPresenterImple;
import com.example.yuan.baweishoppingmall.utils.IView;

public class Shopping_Fragemnt extends Fragment implements IView {
    private Shopping_Select shopping_select;
    private IPresenterImple presenterImple;
    private RecyclerView shopping_recyclerview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.shopping_fragment_item,container,false);

        presenterImple = new IPresenterImple(this);

        shopping_recyclerview = view.findViewById(R.id.shopping_recyclerview);

        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        shopping_recyclerview.setLayoutManager(layoutManager);

        shopping_select = new Shopping_Select(getActivity());
        shopping_recyclerview.setAdapter(shopping_select);

        getShowData();
        return view;
    }
        //展示
    private void getShowData() {
        presenterImple.getRequest("http://172.17.8.100/small/order/verify/v1/findShoppingCart",Shopping_Select_bean.class);
    }

    @Override
    public void getDataSuccess(Object data) {
        if (data instanceof Shopping_Select_bean)
        {
            Shopping_Select_bean shopping_select_bean= (Shopping_Select_bean) data;
            shopping_select.setmSelets(shopping_select_bean.getResult());
        }
    }

    @Override
    public void getDataFail(String error) {

    }
}
