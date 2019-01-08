package com.example.yuan.baweishoppingmall.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yuan.baweishoppingmall.R;
import com.example.yuan.baweishoppingmall.bean.Shopping_Select_bean;
import com.example.yuan.baweishoppingmall.customview.CustomView;

import java.util.ArrayList;
import java.util.List;

public class Shopping_Select extends RecyclerView.Adapter<Shopping_Select.ViewHolderSelect>{
    List<Shopping_Select_bean.Result> mSelets;
    private Context mContext;

    public Shopping_Select(Context mContext) {
        this.mContext = mContext;
        mSelets=new ArrayList<>();
    }

    public void setmSelets(List<Shopping_Select_bean.Result> datas) {
        this.mSelets = datas;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolderSelect onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view=View.inflate(mContext,R.layout.shopping_fragment_adapter,null);
        return new ViewHolderSelect(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSelect viewHolderSelect, int i) {
            ViewHolderSelect holderSelect=viewHolderSelect;
        Glide.with(mContext).load(mSelets.get(i).getPic()).into(holderSelect.shopping_adapter_image);
        holderSelect.shopping_adapter_price.setText(mSelets.get(i).getPrice()+"");
        holderSelect.shopping_adapter_title.setText(mSelets.get(i).getCommodityName());

    }

    @Override
    public int getItemCount() {
        return mSelets.size();
    }

    static class ViewHolderSelect extends RecyclerView.ViewHolder {

        private final CheckBox shopping_adapter_checkbox;
        private final ImageView shopping_adapter_image;
        private final TextView shopping_adapter_title;
        private final TextView shopping_adapter_price;
        private final CustomView shopping_adapter_cstom;

        public ViewHolderSelect(@NonNull View itemView) {
            super(itemView);

            shopping_adapter_checkbox = itemView.findViewById(R.id.shopping_adapter_checkbox);
            shopping_adapter_image = itemView.findViewById(R.id.shopping_adapter_image);
            shopping_adapter_title = itemView.findViewById(R.id.shopping_adapter_title);
            shopping_adapter_price = itemView.findViewById(R.id.shopping_adapter_price);
            shopping_adapter_cstom = itemView.findViewById(R.id.shopping_adapter_cstom);
        }
    }
}
