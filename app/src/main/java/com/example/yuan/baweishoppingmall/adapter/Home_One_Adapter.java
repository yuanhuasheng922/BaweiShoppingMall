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

public class Home_One_Adapter extends RecyclerView.Adapter<Home_One_Adapter.ViewHolder>{
    private List<Home_RecyclerView_One_bean.ResultBean.MlssBean.CommodityListBeanXX> mDatas=new ArrayList<>();
    private Context mContext;

    public Home_One_Adapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setmDatas(List<Home_RecyclerView_One_bean.ResultBean.MlssBean.CommodityListBeanXX> datas) {
        this.mDatas = datas;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view=View.inflate(mContext,R.layout.home_fragment_one,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
          ViewHolder holder=viewHolder;

        Glide.with(mContext).load(mDatas.get(i).getMasterPic()).into(holder.home_fragment_one_image);
        holder.home_fragment_one_name.setText(mDatas.get(i).getCommodityName());
        holder.home_fragment_one_price.setText("$  "+mDatas.get(i).getPrice()+"");
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView home_fragment_one_title;
        private final ImageView home_fragment_one_more;
        private final ImageView home_fragment_one_image;
        private final TextView home_fragment_one_name;
        private final TextView home_fragment_one_price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            home_fragment_one_title = itemView.findViewById(R.id.home_fragment_one_title);
            home_fragment_one_more = itemView.findViewById(R.id.home_fragment_one_more);
            home_fragment_one_image = itemView.findViewById(R.id.home_fragment_one_image);
            home_fragment_one_name = itemView.findViewById(R.id.home_fragment_one_name);
            home_fragment_one_price = itemView.findViewById(R.id.home_fragment_one_price);

        }
    }
}
