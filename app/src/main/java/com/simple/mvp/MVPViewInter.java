package com.simple.mvp;

import java.util.List;

/**
 * View层需要实现的接口
 * Created by zhangzeyan on 16/10/21.
 */
public interface MVPViewInter {


    /**
     *  显示loading progress
     */
    void showLoading();

    /**
     * 隐藏loading progress
     */
    void hideLoading();

    /**
     * ListView的初始化
     * @param data
     */
    void setListItem(List<UserBean> data);


    /**
     * Toast 消息
     * @param message
     */
    void showMessage(String message);
}
