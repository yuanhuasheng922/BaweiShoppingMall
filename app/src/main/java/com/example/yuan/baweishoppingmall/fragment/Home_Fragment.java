package com.example.yuan.baweishoppingmall.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yuan.baweishoppingmall.R;
import com.example.yuan.baweishoppingmall.activity.DetailsActivity;
import com.example.yuan.baweishoppingmall.adapter.Home_One_Adapter;
import com.example.yuan.baweishoppingmall.adapter.Home_SouSuo_Adapter;
import com.example.yuan.baweishoppingmall.adapter.Home_Three_Adapter;
import com.example.yuan.baweishoppingmall.adapter.Home_Two_Adapter;
import com.example.yuan.baweishoppingmall.adapter.Home_pop_Adapter;
import com.example.yuan.baweishoppingmall.adapter.Home_poptwo_Adapter;
import com.example.yuan.baweishoppingmall.adapter.Home_poptwoclick_Adapter;
import com.example.yuan.baweishoppingmall.bean.Home_RecyclerView_One_bean;
import com.example.yuan.baweishoppingmall.bean.Home_SouSuo_bean;
import com.example.yuan.baweishoppingmall.bean.Home_Xbanner_bean;
import com.example.yuan.baweishoppingmall.bean.Home_pop_bean;
import com.example.yuan.baweishoppingmall.bean.Home_poptwo_bean;
import com.example.yuan.baweishoppingmall.bean.Home_poptwoclick_bean;
import com.example.yuan.baweishoppingmall.utils.IPresenterImple;
import com.example.yuan.baweishoppingmall.utils.IView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.stx.xhb.xbanner.XBanner;


public class Home_Fragment extends Fragment  implements IView {

    private IPresenterImple presenterImple;
    private RecyclerView hone_fragment_recyclerview;
    private Home_One_Adapter home_one_adapter;
    private RecyclerView hone_fragment_recyclerviewtwo;
    private Home_Two_Adapter home_two_adapter;
    private RecyclerView hone_fragment_recyclerviewthree;
    private Home_Three_Adapter home_three_adapter;
    private XBanner hone_fragment_banner;
    private ImageView hone_fragment_serach;
    private LinearLayout linearLayoutone;
    private LinearLayout linearLayouttwo;
    private ImageView hone_fragment_change;
    private XRecyclerView twohomefragment_recyclerview;
    private int mage=1;
    private EditText homefragment_input;
    private Home_SouSuo_Adapter home_souSuo_adapter;
    private TextView homefragment_sousuo;
    private Home_pop_Adapter home_pop_adapter;
    private Home_poptwo_Adapter home_poptwo_adapter;
    private Home_pop_bean home_pop_bean;
    private Home_poptwo_bean home_poptwo_bean;
    private RecyclerView home_fragment_poptwoclick;
    private Home_poptwoclick_Adapter home_poptwoclick_adapter;
    private LinearLayout linearSecond;
    private ImageView homefragment_back;

//    @Override
//    public void onResume() {
//        super.onResume();
//        getView().setFocusableInTouchMode(true);
//        getView().requestFocus();
//        getView().setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//
//                if (keyCode==KeyEvent.KEYCODE_BACK&&event.getRepeatCount()==0)
//                {
//                    return true;
//                }
//
//
//
//        });
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.home_fragment_item,container,false);

        presenterImple = new IPresenterImple(this);
        hone_fragment_recyclerview = view.findViewById(R.id.hone_fragment_recyclerview);
        hone_fragment_recyclerviewtwo = view.findViewById(R.id.hone_fragment_recyclerviewtwo);
        hone_fragment_recyclerviewthree = view.findViewById(R.id.hone_fragment_recyclerviewthree);
        hone_fragment_banner = view.findViewById(R.id.hone_fragment_banner);
        hone_fragment_serach = view.findViewById(R.id.hone_fragment_serach);
        hone_fragment_change = view.findViewById(R.id.hone_fragment_change);
        linearLayoutone = view.findViewById(R.id.homrfragment_linear);
        linearLayouttwo = view.findViewById(R.id.homrfragment_linearTwo);
        homefragment_input = view.findViewById(R.id.homefragment_input);
        homefragment_sousuo = view.findViewById(R.id.homefragment_sousuo);
        home_fragment_poptwoclick = view.findViewById(R.id.home_fragment_poptwoclick);
        linearSecond = view.findViewById(R.id.linearSecond);
        homefragment_back = view.findViewById(R.id.homefragment_back);
        homefragment_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //二级列表
        hone_fragment_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View vv=View.inflate(getActivity(),R.layout.homefragment_pop,null);
               final PopupWindow popupWindow=new PopupWindow(vv,ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT,true);
              // popupWindow.showAtLocation(vv,1,0,0);
                popupWindow.showAtLocation(vv,Gravity.CENTER_VERTICAL,5,-380);
             RecyclerView home_pop_recyclerview= vv.findViewById(R.id.home_pop_recyclerview);
                popupWindow.setFocusable(true);
                popupWindow.setTouchable(true);
             //布局管理器
             LinearLayoutManager ll=new LinearLayoutManager(getActivity());
             ll.setOrientation(LinearLayoutManager.HORIZONTAL);
             home_pop_recyclerview.setLayoutManager(ll);
                //适配器
                 home_pop_adapter= new Home_pop_Adapter(getActivity());
                home_pop_recyclerview.setAdapter(home_pop_adapter);
                //AppinfoiItemDecoration decoration = new AppinfoiItemDecoration();
                //home_pop_recyclerview.addItemDecoration(decoration);

                //pop2
                RecyclerView home_pop_recyclerviewtwo= vv.findViewById(R.id.home_pop_recyclerviewtwo);
                LinearLayoutManager lll=new LinearLayoutManager(getActivity());
                lll.setOrientation(LinearLayoutManager.HORIZONTAL);
                home_pop_recyclerviewtwo.setLayoutManager(lll);
                //home_pop_recyclerviewtwo.addItemDecoration(decoration);
                home_poptwo_adapter = new Home_poptwo_Adapter(getActivity());
                home_pop_recyclerviewtwo.setAdapter(home_poptwo_adapter);

                home_pop_adapter.setOnclick(new Home_pop_Adapter.onClick() {
                    @Override
                    public void onSuccess(int index) {
                        String sid = home_pop_bean.getResult().get(index).getId();
                        presenterImple.getRequest(String.format("http://172.17.8.100/small/commodity/v1/findSecondCategory?firstCategoryId=%s",sid),Home_poptwo_bean.class);
                    }
                });
                    //点击二级类目出现商品
                //linearLayoutone.setVisibility(View.VISIBLE);
                home_poptwo_adapter.setOnShow(new Home_poptwo_Adapter.onShow() {
                    @Override
                    public void mClick(int position) {
                       linearLayoutone.setVisibility(View.GONE);
                       linearSecond.setVisibility(View.VISIBLE);
                        String cid = home_poptwo_bean.getResult().get(position).getId();

                        GridLayoutManager layoutm=new GridLayoutManager(getActivity(),2);
                        layoutm.setOrientation(LinearLayoutManager.VERTICAL);
                        home_fragment_poptwoclick.setLayoutManager(layoutm);
                        //适配器
                        home_poptwoclick_adapter = new Home_poptwoclick_Adapter(getActivity());
                        home_fragment_poptwoclick.setAdapter(home_poptwoclick_adapter);

                        presenterImple.getRequest("http://172.17.8.100/small/commodity/v1/findCommodityByCategory?categoryId="+cid+"&page=1&count=5",Home_poptwoclick_bean.class);
                            popupWindow.dismiss();
                    }
                });
                getShow();

            }
        });

        //搜索
        twohomefragment_recyclerview = view.findViewById(R.id.twohomefragment_recyclerview);
            GridLayoutManager grid1=new GridLayoutManager(getActivity(),2);
            twohomefragment_recyclerview.setLayoutManager(grid1);
        home_souSuo_adapter = new Home_SouSuo_Adapter(getActivity());
        twohomefragment_recyclerview.setAdapter(home_souSuo_adapter);

            twohomefragment_recyclerview.setLoadingMoreEnabled(true);
            twohomefragment_recyclerview.setPullRefreshEnabled(true);
            twohomefragment_recyclerview.setLoadingListener(new XRecyclerView.LoadingListener() {
                @Override
                public void onRefresh() {
                    mage=1;
                    getShow();
                }

                @Override
                public void onLoadMore() {
                    getShow();
                }

            });
            //点击搜索
            homefragment_sousuo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getShow();

                }
            });
        //点击隐藏显示
        linearLayouttwo.setVisibility(View.GONE);
        linearSecond.setVisibility(View.GONE);
        hone_fragment_serach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    linearLayoutone.setVisibility(View.GONE);
                    linearLayouttwo.setVisibility(View.VISIBLE);
                    hone_fragment_change.setVisibility(View.VISIBLE);
            }
        });
        //第一个
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
            hone_fragment_recyclerview.setLayoutManager(layoutManager);
        home_one_adapter = new Home_One_Adapter(getActivity());
        hone_fragment_recyclerview.setAdapter(home_one_adapter);



        //第二个
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),3);
        hone_fragment_recyclerviewtwo.setLayoutManager(gridLayoutManager);
        home_two_adapter = new Home_Two_Adapter(getActivity());
        hone_fragment_recyclerviewtwo.setAdapter(home_two_adapter);

        home_two_adapter.setOnClick(new Home_Two_Adapter.OnClick() {
            @Override
            public void getOnClick(int position) {
                Intent intent=new Intent(getActivity(),DetailsActivity.class);
                intent.putExtra("idd",position+"");
                startActivity(intent);
            }
        });
        //第三个
        GridLayoutManager grid=new GridLayoutManager(getActivity(),2);
        hone_fragment_recyclerviewthree.setLayoutManager(grid);
        home_three_adapter = new Home_Three_Adapter(getActivity());
        hone_fragment_recyclerviewthree.setAdapter(home_three_adapter);

        getShow();
        return view;
    }

    private void getShow() {
        presenterImple.getRequest("http://172.17.8.100/small/commodity/v1/commodityList",Home_RecyclerView_One_bean.class);
        presenterImple.getRequest("http://172.17.8.100/small/commodity/v1/bannerShow",Home_Xbanner_bean.class);
        String name = homefragment_input.getText().toString();
        presenterImple.getRequest("http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword="+name+"&page="+mage+""+"&count=5",Home_SouSuo_bean.class);
        presenterImple.getRequest("http://172.17.8.100/small/commodity/v1/findFirstCategory",Home_pop_bean.class);
    }


    @Override
    public void getDataSuccess(Object data) {
        if (data instanceof Home_RecyclerView_One_bean)
        {   //recyclerview
           Home_RecyclerView_One_bean bean= (Home_RecyclerView_One_bean) data;
            home_one_adapter.setmDatas(bean.getResult().getMlss().get(0).getCommodityList());
            home_two_adapter.setTwo(bean.getResult().getRxxp().get(0).getCommodityList());
            home_three_adapter.setTwo(bean.getResult().getPzsh().get(0).getCommodityList());
        }
        else if(data instanceof Home_Xbanner_bean)
        {
            //xbanner
            Home_Xbanner_bean homeXbannerBean= (Home_Xbanner_bean) data;
            hone_fragment_banner.setData(homeXbannerBean.getResult(),null);
            hone_fragment_banner.loadImage(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) { Home_Xbanner_bean.ResultBean resultBean= (Home_Xbanner_bean.ResultBean) model;Glide.with(getActivity()).load(resultBean.getImageUrl()).into((ImageView) view);hone_fragment_banner.setPageChangeDuration(1000);
                }
            });
        }
        else if (data instanceof Home_SouSuo_bean)
        {
            //搜索
            Home_SouSuo_bean home_souSuo_bean= (Home_SouSuo_bean) data;
            if (mage==1)
            {
                home_souSuo_adapter.setmSou(home_souSuo_bean.getResult());
            }
            else
            {
                home_souSuo_adapter.addSou(home_souSuo_bean.getResult());
            }
            mage++;
            twohomefragment_recyclerview.loadMoreComplete();
            twohomefragment_recyclerview.refreshComplete();
        }
        //一级类目
        else if (data instanceof Home_pop_bean)
        {
            home_pop_bean = (Home_pop_bean) data;
            home_pop_adapter.setmPop(home_pop_bean.getResult());
        }
        //二级类目
        else if (data instanceof Home_poptwo_bean)
        {
            home_poptwo_bean = (Home_poptwo_bean) data;
            home_poptwo_adapter.setmPopTwo(home_poptwo_bean.getResult());
        }
        else if (data instanceof Home_poptwoclick_bean)
        {
            Home_poptwoclick_bean homebeanclick= (Home_poptwoclick_bean) data;
            home_poptwoclick_adapter.setmTwoDatas(homebeanclick.getResult());
        }


    }

    @Override
    public void getDataFail(String error) {
        //Toast.makeText(getActivity(),error,Toast.LENGTH_SHORT).show();
    }



}
