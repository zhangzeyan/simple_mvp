package com.simple.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * MVP模式
 * Created by zhangzeyan on 16/9/28.
 */

public class MVPActivity extends Activity implements MVPViewInter, AdapterView.OnItemClickListener {

    ListView mvpListView;
    MVPPresenter mvpPresenter;
    ProgressBar pb;
    UserDataAdapter adapter;
    private List<UserBean> userBeanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mvp);

        //初始化控件
        mvpListView = (ListView)findViewById(R.id.mListView);
        mvpListView.setOnItemClickListener(this);
        pb = (ProgressBar) findViewById(R.id.mLoading);

        userBeanList = new ArrayList<>();
        adapter = new UserDataAdapter(this, userBeanList);
        mvpListView.setAdapter(adapter);

        //实例化Presenter
        mvpPresenter = new MVPPresenter(this);
        //调用Presenter层请求数据
        mvpPresenter.requestForData();

    }

    @Override
    public void showLoading() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pb.setVisibility(View.GONE);
    }

    @Override
    public void setListItem(List<UserBean> data) {
        userBeanList.clear();
        userBeanList.addAll(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mvpPresenter.onItemClick(position);
    }

    @Override
    protected void onDestroy() {
        mvpPresenter.onDestroy();
        super.onDestroy();
    }
}