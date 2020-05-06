package com.oraclechain.pocketrix.modules.account.accountdetails;

import android.content.Context;

import com.lzy.okgo.model.Response;
import com.oraclechain.pocketrix.app.MyApplication;
import com.oraclechain.pocketrix.base.BasePresent;
import com.oraclechain.pocketrix.base.BaseUrl;
import com.oraclechain.pocketrix.bean.ResponseBean;
import com.oraclechain.pocketrix.net.HttpUtils;
import com.oraclechain.pocketrix.net.callbck.JsonCallback;

import java.util.HashMap;

/**
 * Created by pocketrix on 2018/1/18.
 */

public class AccountDetailsPresenter extends BasePresent<AccountDetailsView> {
    private Context mContext;

    public AccountDetailsPresenter(Context context) {
        this.mContext = context;
    }

    public void setMianAccountData(String rixAccountName, final int type) {//0代表直接执行设置主账号操作，1代表先删除后设置主账号
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("uid", MyApplication.getInstance().getUserBean().getWallet_uid());
        hashMap.put("rixAccountName", rixAccountName);
        HttpUtils.postRequest(BaseUrl.HTTP_set_mian_account, mContext, hashMap, new JsonCallback<ResponseBean<String>>() {
            @Override
            public void onSuccess(Response<ResponseBean<String>> response) {
                if (response.body().code == 0) {
                    view.setMainAccountHttp(type);
                } else {
                    view.getDataHttpFail(response.body().message);
                }
            }
        });
    }
}

