package com.example.yuan.baweishoppingmall.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.example.yuan.baweishoppingmall.R;
import com.example.yuan.baweishoppingmall.fragment.Bill_Fragment;
import com.example.yuan.baweishoppingmall.fragment.Circle_Fragment;
import com.example.yuan.baweishoppingmall.fragment.Home_Fragment;
import com.example.yuan.baweishoppingmall.fragment.My_Fragment;
import com.example.yuan.baweishoppingmall.fragment.Shopping_Fragemnt;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {
    @BindView(R.id.homeactirity_viewpager)
    ViewPager homeactivity_viewpager;
    @BindView(R.id.homeactirity_radiogroup)
    RadioGroup homeactivity_rediogroup;
    private List<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        list = new ArrayList<>();
        list.add(new Home_Fragment());
        list.add(new Circle_Fragment());
        list.add(new Shopping_Fragemnt());
        list.add(new Bill_Fragment());
        list.add(new My_Fragment());

        homeactivity_viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        homeactivity_rediogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.homeactirity_home:
                        homeactivity_viewpager.setCurrentItem(0);
                        break;
                    case R.id.homeactirity_circle:
                        homeactivity_viewpager.setCurrentItem(1);
                        break;
                    case R.id.homeactirity_shopping:
                        homeactivity_viewpager.setCurrentItem(2);
                        break;
                    case R.id.homeactirity_bill:
                        homeactivity_viewpager.setCurrentItem(3);
                        break;
                    case R.id.homeactirity_my:
                        homeactivity_viewpager.setCurrentItem(4);
                        break;
                        default:
                            break;
                }
            }
        });


    }
    @OnClick({R.id.homeactirity_viewpager,R.id.homeactirity_radiogroup})
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.homeactirity_viewpager:

                break;
            case R.id.homeactirity_radiogroup:

                break;
                default:
                    break;
        }
    }
}
