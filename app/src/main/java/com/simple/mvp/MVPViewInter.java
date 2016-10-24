package com.simple.mvp;

import java.util.List;

/**
 *
 * Created by zhangzeyan on 16/10/21.
 */
public interface MVPViewInter {


    //显示loading progress
    void showLoading();
    //隐藏loading progress
    void hideLoading();
    //ListView的初始化
    void setListItem(List<UserBean> data);
    //Toast 消息
    void showMessage(String message);
}
