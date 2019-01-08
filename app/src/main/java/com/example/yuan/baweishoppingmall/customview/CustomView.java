package com.example.yuan.baweishoppingmall.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.example.yuan.baweishoppingmall.R;

public class CustomView extends LinearLayout {
    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        //布局
        View view=View.inflate(getContext(),R.layout.shopping_custom,null);
        addView(view);
    }
}
