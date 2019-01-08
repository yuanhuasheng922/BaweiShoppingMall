package com.example.yuan.baweishoppingmall.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuan.baweishoppingmall.R;
import com.example.yuan.baweishoppingmall.bean.RegistenBean;
import com.example.yuan.baweishoppingmall.utils.Apis;
import com.example.yuan.baweishoppingmall.utils.Constants;
import com.example.yuan.baweishoppingmall.utils.IPresenterImple;
import com.example.yuan.baweishoppingmall.utils.IView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity implements IView {
    @BindView(R.id.registeractivity_phonenum)
    EditText registeractivity_phonenum;
    @BindView(R.id.registeractivity_loginpassword)
    EditText registeractivity_loginpassword;
    @BindView(R.id.registeractivity_immediatelylogin)
    TextView registeractivity_immediatelylogin;
    @BindView(R.id.registeractivity_register)
    Button registeractivity_register;
    private IPresenterImple presenterImple;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        presenterImple = new IPresenterImple(this);


    }

    @OnClick({R.id.registeractivity_immediatelylogin,R.id.registeractivity_register})
    public void Onclick(View view) {
    switch (view.getId())
    {
        case R.id.registeractivity_immediatelylogin:
            Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
            startActivity(intent);
            break;
        case R.id.registeractivity_register:
                getShow();
            break;
    }
    }

    private void getShow() {
        Map<String,String> map=new HashMap<>();
        map.put(Constants.TYPE_PHONE,registeractivity_phonenum.getText().toString());
        map.put(Constants.TYPE_PASSWORD,registeractivity_loginpassword.getText().toString());
        presenterImple.startRequest(Apis.URL_REGISTER_POST,map,RegistenBean.class);

    }

    @Override
    public void getDataSuccess(Object data) {
            if (data instanceof RegistenBean)
            {
                RegistenBean registenBean= (RegistenBean) data;
                if (registenBean.getMessage().equals("注册成功"))
                {
                    Toast.makeText(RegisterActivity.this,registenBean.getMessage(),Toast.LENGTH_SHORT).show();
//                    Intent intent=new Intent(RegisterActivity.this,HomeActivity.class);
//                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(RegisterActivity.this,registenBean.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
    }

    @Override
    public void getDataFail(String error) {
        Toast.makeText(RegisterActivity.this,error,Toast.LENGTH_SHORT).show();
    }


}