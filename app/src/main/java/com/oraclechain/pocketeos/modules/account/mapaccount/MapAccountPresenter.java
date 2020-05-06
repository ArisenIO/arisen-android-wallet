package com.oraclechain.pocketrix.modules.account.mapaccount;

import android.content.Context;

import com.lzy.okgo.model.Response;
import com.oraclechain.pocketrix.app.MyApplication;
import com.oraclechain.pocketrix.base.BasePresent;
import com.oraclechain.pocketrix.base.BaseUrl;
import com.oraclechain.pocketrix.bean.GetAccountsBean;
import com.oraclechain.pocketrix.bean.ResponseBean;
import com.oraclechain.pocketrix.net.HttpUtils;
import com.oraclechain.pocketrix.net.callbck.JsonCallback;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by pocketrix on 2017/12/26.
 */

public class MapAccountPresenter extends BasePresent<MapAccountView> {
    private Context mContext;

    public MapAccountPresenter(Context context) {
        this.mContext = context;
    }

    public void getAccountInfoData(String public_key) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("public_key", public_key);
        HttpUtils.postRequest(BaseUrl.getHTTP_GetAccounts, mContext, new JSONObject(hashMap).toString(), new JsonCallback<GetAccountsBean>() {
            @Override
            public void onSuccess(Response<GetAccountsBean> response) {
                    view.getBlackAccountDataHttp(response.body());
            }
        });


    }

    public void postrixAccountData(String rixAccountName, String uid) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("uid", uid);
        hashMap.put("rixAccountName", rixAccountName);
        HttpUtils.postRequest(BaseUrl.HTTP_add_new_rix, mContext, hashMap, new JsonCallback<ResponseBean<String>>() {
            @Override
            public void onSuccess(Response<ResponseBean<String>> response) {
                if (response.body().code == 0) {
                    view.postrixAccountDataHttp();
                } else {
                    view.getDataHttpFail(response.body().message);
                }
            }
        });
    }

    public void setMianAccountData(String rixAccountName) {

        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("uid", MyApplication.getInstance().getUserBean().getWallet_uid());
        hashMap.put("rixAccountName", rixAccountName);
        HttpUtils.postRequest(BaseUrl.HTTP_set_mian_account, mContext, hashMap, new JsonCallback<ResponseBean<String>>() {
            @Override
            public void onSuccess(Response<ResponseBean<String>> response) {
                if (response.body().code == 0) {
                    view.setMainAccountHttp();
                } else {
                    view.getDataHttpFail(response.body().message);
                }
            }
        });
    }
}
