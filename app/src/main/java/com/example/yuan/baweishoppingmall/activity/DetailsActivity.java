package com.example.yuan.baweishoppingmall.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yuan.baweishoppingmall.R;
import com.example.yuan.baweishoppingmall.adapter.Details_Tablayout_Adapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {
    @BindView(R.id.detailsactivity_tablayout)
    TabLayout detailsactivity_tablayout;
    @BindView(R.id.detailsactivity_viewpager)
    ViewPager detailsactivity_viewpager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ButterKnife.bind(this);
        detailsactivity_viewpager.setAdapter(new Details_Tablayout_Adapter(getSupportFragmentManager()));
        detailsactivity_tablayout.setupWithViewPager(detailsactivity_viewpager);


    }
}
