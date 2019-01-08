package com.example.yuan.baweishoppingmall.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yuan.baweishoppingmall.R;
import com.example.yuan.baweishoppingmall.bean.Home_RecyclerView_One_bean;

import java.util.ArrayList;
import java.util.List;

public class Home_Three_Adapter extends RecyclerView.Adapter<Home_Three_Adapter.ViewHolder>{
    private List<Home_RecyclerView_One_bean.ResultBean.PzshBean.CommodityListBeanX> mDatas=new ArrayList<>();
    private Context mContext;

    public Home_Three_Adapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setTwo(List<Home_RecyclerView_One_bean.ResultBean.PzshBean.CommodityListBeanX> datas) {
        this.mDatas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view=View.inflate(mContext,R.layout.home_fragment_three,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
          ViewHolder holder=viewHolder;

        Glide.with(mContext).load(mDatas.get(i).getMasterPic()).into(holder.home_fragment_one_imagess);
        holder.home_fragment_one_namess.setText(mDatas.get(i).getCommodityName());
        holder.home_fragment_one_pricess.setText("$"+mDatas.get(i).getPrice()+".00");
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {


        private final ImageView home_fragment_one_imagess;
        private final TextView home_fragment_one_namess;
        private final TextView home_fragment_one_pricess;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            home_fragment_one_imagess = itemView.findViewById(R.id.home_fragment_one_imagess);
            home_fragment_one_namess = itemView.findViewById(R.id.home_fragment_one_namess);
            home_fragment_one_pricess = itemView.findViewById(R.id.home_fragment_one_pricess);

        }
    }
}
