package com.simple.mvp;

import java.util.List;

/**
 * 请求数据业务接口
 * Created by zhangzeyan on 16/10/21.
 */

public interface RequestData {

    void requestForData(OnRequestListener listener);

    /**
     * Created by zhangzeyan on 16/9/28.
     */

    interface OnRequestListener {

        void onSuccess(List<UserBean> data);
        void onFailed();
    }
}
