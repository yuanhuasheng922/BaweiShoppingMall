package com.example.yuan.baweishoppingmall.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yuan.baweishoppingmall.R;
import com.example.yuan.baweishoppingmall.bean.Home_poptwo_bean;

import java.util.ArrayList;
import java.util.List;

public class Home_poptwo_Adapter extends RecyclerView.Adapter<Home_poptwo_Adapter.ViewHolderPop> {

    private List<Home_poptwo_bean.ResultBean> mPopTwo;
    private Context context;

    public Home_poptwo_Adapter(Context context) {
        this.context = context;
        mPopTwo = new ArrayList<>();
    }


    public void setmPopTwo(List<Home_poptwo_bean.ResultBean> datas) {
        mPopTwo.clear();
        if (datas!=null)
        {
            mPopTwo.addAll(datas);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolderPop onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.home_poptwo_adapter, null);
        return new ViewHolderPop(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPop viewHolderPop, final int i) {
        ViewHolderPop holder = viewHolderPop;
        holder.homepop_names.setText(mPopTwo.get(i).getName());

    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (onShow!=null)
            {
                onShow.mClick(i);
            }
        }
    });

    }

    @Override
    public int getItemCount() {
        return mPopTwo.size();
    }

    static class ViewHolderPop extends RecyclerView.ViewHolder {
        private final TextView homepop_names;

        public ViewHolderPop(@NonNull View itemView) {
            super(itemView);
            homepop_names = itemView.findViewById(R.id.homepop_names);
        }
    }

    onShow onShow;

    public void setOnShow(Home_poptwo_Adapter.onShow onShow) {
        this.onShow = onShow;
    }

    public interface onShow
    {
        void mClick(int position);
    }
}






