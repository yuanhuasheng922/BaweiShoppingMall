package com.example.yuan.baweishoppingmall.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuan.baweishoppingmall.R;
import com.example.yuan.baweishoppingmall.bean.LoginBean;
import com.example.yuan.baweishoppingmall.utils.Apis;
import com.example.yuan.baweishoppingmall.utils.Constants;
import com.example.yuan.baweishoppingmall.utils.IPresenterImple;
import com.example.yuan.baweishoppingmall.utils.IView;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IView {
    //绑定
    @BindView(R.id.mainactivity_phonenum)
    TextView mainactivity_phonenum;
    @BindView(R.id.mainactivity_password)
    TextView mainactivity_password;
    @BindView(R.id.mainactivity_eye)
    ImageView mainactivity_eye;
    @BindView(R.id.mainactivity_rememberpassword)
    CheckBox mainactivity_rememberpassword;
    @BindView(R.id.mainactivity_register)
    TextView mainactivity_register;
    @BindView(R.id.mainactivity_register_login)
    Button mainactivity_register_login;
    private IPresenterImple presenterImple;
    private SharedPreferences sp;
    private SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenterImple = new IPresenterImple(this);
        ButterKnife.bind(this);

        //点击小眼睛显示密码
        mainactivity_eye.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN)
                {
                    mainactivity_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else if (event.getAction()==MotionEvent.ACTION_UP)
                {
                    mainactivity_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                return false;
            }
        });

        sp = getSharedPreferences("User", MODE_PRIVATE);
        edit = sp.edit();

        boolean jz = sp.getBoolean("jz", false);
        if (jz)
        {
            String phone = sp.getString("phone", null);
            String pwd = sp.getString("pwd", null);
            mainactivity_phonenum.setText(phone);
            mainactivity_password.setText(pwd);
            mainactivity_rememberpassword.setChecked(true);
        }


    }
    @OnClick({R.id.mainactivity_phonenum,R.id.mainactivity_password ,R.id.mainactivity_eye,R.id.mainactivity_rememberpassword,R.id.mainactivity_register,R.id.mainactivity_register_login})
    public void OnClick(View view)
    {
        switch (view.getId())
        {
            case R.id.mainactivity_eye:

                break;
            case R.id.mainactivity_rememberpassword:

                break;
            case R.id.mainactivity_register:
                //跳转注册
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.mainactivity_register_login:
                getShow();

                String phone = mainactivity_phonenum.getText().toString();
                String pwd = mainactivity_password.getText().toString();

                if (mainactivity_rememberpassword.isChecked())
                {
                    edit.putString("phone",phone);
                    edit.putString("pwd",pwd);

                    edit.putBoolean("jz",true);
                    edit.commit();
                }
                else
                {
                    edit.clear();
                    edit.commit();

                }

                break;
        }
    }


    private void getShow() {

        Map<String,String> params=new HashMap<>();
        params.put(Constants.TYPE_PHONE,mainactivity_phonenum.getText().toString());
        params.put(Constants.TYPE_PASSWORD,mainactivity_password.getText().toString());
        presenterImple.startRequest(Apis.URI_LOGIN_POST,params,LoginBean.class);
    }

    @Override
    public void getDataSuccess(Object data) {
        if (data instanceof LoginBean)
        {
            LoginBean loginBean= (LoginBean) data;

            if (loginBean.getMessage().equals("登录成功"))
            {
                edit.putString("userId",loginBean.getResult().getUserId());
                edit.putString("sessionId",loginBean.getResult().getSessionId());
                edit.commit();

                Toast.makeText(MainActivity.this,loginBean.getMessage(),Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
            }
            else
            {
               Toast.makeText(MainActivity.this,loginBean.getMessage(),Toast.LENGTH_SHORT).show();
            }

        }


    }

    @Override
    public void getDataFail(String error) {

        Toast.makeText(MainActivity.this,error,Toast.LENGTH_SHORT).show();
    }
}
