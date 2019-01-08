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

public class Home_Two_Adapter extends RecyclerView.Adapter<Home_Two_Adapter.ViewHolder>{
    private List<Home_RecyclerView_One_bean.ResultBean.RxxpBean.CommodityListBean> mDatas=new ArrayList<>();
    private Context mContext;

    public Home_Two_Adapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setTwo(List<Home_RecyclerView_One_bean.ResultBean.RxxpBean.CommodityListBean> datas) {
        this.mDatas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view=View.inflate(mContext,R.layout.home_fragment_two,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
          ViewHolder holder=viewHolder;

        Glide.with(mContext).load(mDatas.get(i).getMasterPic()).into(holder.home_fragment_one_images);
        holder.home_fragment_one_names.setText(mDatas.get(i).getCommodityName());
        holder.home_fragment_one_prices.setText("$  "+mDatas.get(i).getPrice()+"");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick!=null)
                {
                    onClick.getOnClick(mDatas.get(i).getCommodityId());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {


        private final ImageView home_fragment_one_images;
        private final TextView home_fragment_one_names;
        private final TextView home_fragment_one_prices;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            home_fragment_one_images = itemView.findViewById(R.id.home_fragment_one_images);
            home_fragment_one_names = itemView.findViewById(R.id.home_fragment_one_names);
            home_fragment_one_prices = itemView.findViewById(R.id.home_fragment_one_prices);

        }
    }
    OnClick onClick;

    public void setOnClick(OnClick mClick) {
        this.onClick = mClick;
    }

    public interface OnClick{
        void getOnClick(int position);
    }
}
