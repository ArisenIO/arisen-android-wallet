package com.oraclechain.pocketrix.modules.leftdrawer.messagecenter;

import android.content.Context;

import com.lzy.okgo.model.Response;
import com.oraclechain.pocketrix.base.BasePresent;
import com.oraclechain.pocketrix.base.BaseUrl;
import com.oraclechain.pocketrix.bean.MessageCenterBean;
import com.oraclechain.pocketrix.net.HttpUtils;
import com.oraclechain.pocketrix.bean.ResponseBean;
import com.oraclechain.pocketrix.net.callbck.JsonCallback;

import java.util.HashMap;
import java.util.List;

/**
 * Created by pocketrix on 2017/12/26.
 */

public class MessageCenterPresenter extends BasePresent<MessageCenterView> {
    private Context mContext;

    public MessageCenterPresenter(Context context) {
        this.mContext = context;
    }

    public void getData(int offset) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("offset", offset + "");
        hashMap.put("size", "10");
        HttpUtils.postRequest(BaseUrl.HTTP_getMagList, mContext, hashMap, new JsonCallback<ResponseBean<List<MessageCenterBean.DataBean>>>() {
            @Override
            public void onSuccess(Response<ResponseBean<List<MessageCenterBean.DataBean>>> response) {
                if (response.body().code == 0) {
                    view.getListDataHttp(response.body().data);
                } else {
                    view.getDataHttpFail(response.body().message);
                }
            }
        });
    }

}
