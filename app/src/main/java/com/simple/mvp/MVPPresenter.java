package com.simple.mvp;

import android.os.Handler;
import android.os.Looper;

import java.util.List;

/**
 * Prensenter层
 * Created by zhangzeyan on 16/10/21.
 */
public class MVPPresenter {

    private MVPViewInter mvpView;
    RequestData requestBiz;
    private Handler mHandler;

    public MVPPresenter(MVPViewInter mvpView) {
        this.mvpView = mvpView;
        requestBiz = new RequestDataImp();
        mHandler = new Handler(Looper.getMainLooper());
    }

    public void requestForData(){
        mvpView.showLoading();
        requestBiz.requestForData(new RequestData.OnRequestListener() {
            @Override
            public void onSuccess(final List<UserBean> data) {
                //由于请求开启了新线程，所以用handler去更新界面
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mvpView.hideLoading();
                        mvpView.setListItem(data);
                    }
                });

            }

            @Override
            public void onFailed() {
                mvpView.showMessage("请求失败");
            }
        });
    }

    public void onItemClick(int position){
        mvpView.showMessage("点击了item"+position);
    }

    //presenter中添加mvpView 置为null的方法
    public void onDestroy(){
        mvpView = null;
    }
}
