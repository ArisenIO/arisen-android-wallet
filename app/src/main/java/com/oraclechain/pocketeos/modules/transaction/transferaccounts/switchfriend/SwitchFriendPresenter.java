package com.oraclechain.pocketrix.modules.transaction.transferaccounts.switchfriend;

import android.content.Context;

import com.lzy.okgo.model.Response;
import com.oraclechain.pocketrix.app.MyApplication;
import com.oraclechain.pocketrix.base.BasePresent;
import com.oraclechain.pocketrix.base.BaseUrl;
import com.oraclechain.pocketrix.bean.FriendsListInfoBean;
import com.oraclechain.pocketrix.net.HttpUtils;
import com.oraclechain.pocketrix.bean.ResponseBean;
import com.oraclechain.pocketrix.net.callbck.JsonCallback;

import java.util.HashMap;
import java.util.List;

/**
 * Created by pocketrix on 2017/12/26.
 */

public class SwitchFriendPresenter extends BasePresent<SwitchFriendView> {
    private Context mContext;

    public SwitchFriendPresenter(Context context) {
        this.mContext = context;
    }
    public void getData() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("uid", MyApplication.getInstance().getUserBean().getWallet_uid());
        HttpUtils.postRequest(BaseUrl.HTTP_Getfollow_list, mContext, hashMap, new JsonCallback<ResponseBean<List<FriendsListInfoBean>>>() {
            @Override
            public void onSuccess(Response<ResponseBean<List<FriendsListInfoBean>>> response) {
                if (response.body().code == 0) {
                    view.getDataHttp(response.body().data);
                } else {
                    view.getDataHttpFail(response.body().message);
                }
            }
        });
    }
}
