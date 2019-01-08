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
import com.example.yuan.baweishoppingmall.bean.Home_poptwoclick_bean;

import java.util.ArrayList;
import java.util.List;

public class Home_poptwoclick_Adapter extends RecyclerView.Adapter<Home_poptwoclick_Adapter.ViewHolderClick>{
    private List<Home_poptwoclick_bean.ResultBean> mTwoDatas;
    private Context mContext;

    public Home_poptwoclick_Adapter(Context mContext) {
        this.mContext = mContext;
        mTwoDatas=new ArrayList<>();
    }

    public void setmTwoDatas(List<Home_poptwoclick_bean.ResultBean> datas) {
        this.mTwoDatas = datas;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolderClick onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(mContext,R.layout.home_fragment_poptwoclick,null);
        return new ViewHolderClick(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClick viewHolderClick, int i) {
        ViewHolderClick holderClick=viewHolderClick;
        Glide.with(mContext).load(mTwoDatas.get(i).getMasterPic()).into(holderClick.home_fragment_poptwoclick_image);
        holderClick.home_fragment_poptwoclick_title.setText(mTwoDatas.get(i).getCommodityName());
        //holderClick.home_fragment_poptwoclick_price.setText(mTwoDatas.get(i).getPrice());
    }

    @Override
    public int getItemCount() {
        return mTwoDatas.size();
    }

    static class ViewHolderClick extends RecyclerView.ViewHolder {

        private final ImageView home_fragment_poptwoclick_image;
        private final TextView home_fragment_poptwoclick_title;
        private final TextView home_fragment_poptwoclick_price;

        public ViewHolderClick(@NonNull View itemView) {
            super(itemView);

            home_fragment_poptwoclick_image = itemView.findViewById(R.id.home_fragment_poptwoclick_image);
            home_fragment_poptwoclick_title = itemView.findViewById(R.id.home_fragment_poptwoclick_title);
            home_fragment_poptwoclick_price = itemView.findViewById(R.id.home_fragment_poptwoclick_price);
        }
    }
}
