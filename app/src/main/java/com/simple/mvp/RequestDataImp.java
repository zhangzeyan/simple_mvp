package com.simple.mvp;

import java.util.ArrayList;
import java.util.List;

/**
 * 请求数据业务实现类
 * Created by zhangzeyan on 16/9/28.
 */

public class RequestDataImp implements RequestData {
    @Override
    public void requestForData(final OnRequestListener listener) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(2000); //模仿网络请求

                    List<UserBean> datas = new ArrayList<>();
                    for (int i = 1; i < 20; i++) {
                        UserBean user = new UserBean();
                        user.setName(i + "" + i + "" + i);
                        user.setImg("http://img2.cache.netease.com/auto/2016/7/28/201607282215432cd8a.jpg");
                        user.setAge(i + 20);
                        user.setSex(i % 2);
                        user.setStudent(i % 3 != 0);
                        datas.add(user);
                    }

                    if(null != listener){
                        listener.onSuccess(datas);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
