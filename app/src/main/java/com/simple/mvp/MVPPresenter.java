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
    private RequestData requestData;
    private Handler mHandler;

    public MVPPresenter(MVPViewInter mvpView) {
        this.mvpView = mvpView;
        requestData = new RequestDataImp();
        mHandler = new Handler(Looper.getMainLooper());
    }

    public void requestForData(){
        mvpView.showLoading();
        requestData.requestForData(new RequestData.OnRequestListener() {
            @Override
            public void onSuccess(final List<UserBean> data) {
                mHandler.post(new Runnable() { //需要使用handler去更新界面
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

    public void onDestroy(){
        mvpView = null;
    }
}
