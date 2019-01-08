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
import com.example.yuan.baweishoppingmall.bean.Home_SouSuo_bean;

import java.util.ArrayList;
import java.util.List;

public class Home_SouSuo_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<Home_SouSuo_bean.ResultBean> mDatas;
    private Context context;

    public Home_SouSuo_Adapter(Context context) {
        this.context = context;
        mDatas=new ArrayList<>();
    }

    public void setmSou(List<Home_SouSuo_bean.ResultBean> datas) {
       mDatas.clear();
       mDatas.addAll(datas);
       notifyDataSetChanged();
    }
    public void addSou(List<Home_SouSuo_bean.ResultBean> datas) {
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(context,R.layout.home_fragment_sousuo,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            ViewHolder holder= (ViewHolder) viewHolder;
        Glide.with(context).load(mDatas.get(i).getMasterPic()).into(holder.home_fragment_sousuo_image);
        holder.home_fragment_sousuo_title.setText(mDatas.get(i).getCommodityName());
//        holder.home_fragment_sousuo_num.setText(mDatas.get(i).getSaleNum());
//        holder.home_fragment_sousuo_price.setText(mDatas.get(i).getPrice());
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView home_fragment_sousuo_image;
        private final TextView home_fragment_sousuo_title;
//        private final TextView home_fragment_sousuo_price;
//        private final TextView home_fragment_sousuo_num;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            home_fragment_sousuo_image = itemView.findViewById(R.id.home_fragment_sousuo_image);
            home_fragment_sousuo_title = itemView.findViewById(R.id.home_fragment_sousuo_title);
//            home_fragment_sousuo_price = itemView.findViewById(R.id.home_fragment_sousuo_price);
//            home_fragment_sousuo_num = itemView.findViewById(R.id.home_fragment_sousuo_num);

        }
    }
}
