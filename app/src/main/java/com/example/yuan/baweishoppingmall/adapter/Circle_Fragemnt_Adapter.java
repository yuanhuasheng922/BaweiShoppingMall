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
import com.example.yuan.baweishoppingmall.bean.Circle_Home_bean;

import java.util.ArrayList;
import java.util.List;

public class Circle_Fragemnt_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<Circle_Home_bean.ResultBean> mDatas;
    private Context mContext;

    public Circle_Fragemnt_Adapter(Context Context) {
        this.mContext = Context;
        mDatas=new ArrayList<>();
    }

    public void setmDatas(List<Circle_Home_bean.ResultBean> datas) {
        mDatas.clear();
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }
    public void addmDatas(List<Circle_Home_bean.ResultBean> datas) {

        mDatas.addAll(datas);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(mContext,R.layout.circle_fragment_adapter_item,null);
        return new ViewHolderr(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            ViewHolderr holderr= (ViewHolderr) viewHolder;
            Circle_Home_bean.ResultBean resultBean=new Circle_Home_bean.ResultBean();
            Glide.with(mContext).load(mDatas.get(i).getHeadPic()).into(holderr.circle_fragment_headimage);
            holderr.circle_fragment_headimagename.setText(mDatas.get(i).getNickName());
            //时间holderr.circle_fragment_time.setText(resultBean.getCreateTime());
            holderr.circle_fragment_title.setText(mDatas.get(i).getContent());
            Glide.with(mContext).load(mDatas.get(i).getImage()).into(holderr.circle_fragment_image);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    static class ViewHolderr extends RecyclerView.ViewHolder{

        private final ImageView circle_fragment_headimage;
        private final TextView circle_fragment_headimagename;
        private final TextView circle_fragment_time;
        private final TextView circle_fragment_title;
        private final ImageView circle_fragment_image;

        public ViewHolderr(@NonNull View itemView) {
            super(itemView);

            circle_fragment_headimage = itemView.findViewById(R.id.circle_fragment_headimage);
            circle_fragment_headimagename = itemView.findViewById(R.id.circle_fragment_headimagename);
            circle_fragment_time = itemView.findViewById(R.id.circle_fragment_time);
            circle_fragment_title = itemView.findViewById(R.id.circle_fragment_title);
            circle_fragment_image = itemView.findViewById(R.id.circle_fragment_image);


        }
    }

}
