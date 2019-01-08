package com.example.yuan.baweishoppingmall.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.yuan.baweishoppingmall.fragment.Details_Comment_Fragment;
import com.example.yuan.baweishoppingmall.fragment.Details_Details_Fragment;
import com.example.yuan.baweishoppingmall.fragment.Details_Shop_Fragment;

public class Details_Tablayout_Adapter extends FragmentPagerAdapter {

    private String[] str=new String[]{"商品","详情","评论"};
    public Details_Tablayout_Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i)
        {
            case 0:
               return new Details_Shop_Fragment();
            case 1:
                return new Details_Details_Fragment();
            case 2:
                return new Details_Comment_Fragment();

        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return str[position];
    }

    @Override
    public int getCount() {
        return str.length;
    }
}
