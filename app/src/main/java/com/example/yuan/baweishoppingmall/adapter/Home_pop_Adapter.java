package com.example.yuan.baweishoppingmall.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yuan.baweishoppingmall.R;
import com.example.yuan.baweishoppingmall.bean.Home_pop_bean;

import java.util.ArrayList;
import java.util.List;

public class Home_pop_Adapter extends RecyclerView.Adapter<Home_pop_Adapter.ViewHolderPop> {

    private List<Home_pop_bean.ResultBean> mPop;
    private Context context;

    public Home_pop_Adapter(Context context) {
        this.context = context;
        mPop = new ArrayList<>();
    }


    public void setmPop(List<Home_pop_bean.ResultBean> datas) {
        mPop.clear();
        if (datas!=null)
        {
            mPop.addAll(datas);
        }
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolderPop onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.home_pop_adapter, null);
        return new ViewHolderPop(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPop viewHolderPop, final int i) {
        ViewHolderPop holder = viewHolderPop;
        holder.homepop_name.setText(mPop.get(i).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onclick!=null)
                {
                    onclick.onSuccess(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPop.size();
    }

    static class ViewHolderPop extends RecyclerView.ViewHolder {
        private final TextView homepop_name;

        public ViewHolderPop(@NonNull View itemView) {
            super(itemView);
            homepop_name = itemView.findViewById(R.id.homepop_name);
        }
    }
    onClick onclick;

    public void setOnclick(onClick onclick) {
        this.onclick = onclick;
    }

    public interface onClick{
        void onSuccess(int index);
    }

}






