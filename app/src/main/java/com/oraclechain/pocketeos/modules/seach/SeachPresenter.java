package com.oraclechain.pocketrix.modules.seach;

import android.content.Context;

import com.lzy.okgo.model.Response;
import com.oraclechain.pocketrix.base.BasePresent;
import com.oraclechain.pocketrix.base.BaseUrl;
import com.oraclechain.pocketrix.bean.BlockChainAccountInfoBean;
import com.oraclechain.pocketrix.net.HttpUtils;
import com.oraclechain.pocketrix.bean.ResponseBean;
import com.oraclechain.pocketrix.net.callbck.JsonCallback;

import java.util.HashMap;

/**
 * Created by pocketrix on 2017/12/26.
 */

public class SeachPresenter extends BasePresent<SeachView> {
    private Context mContext;

    public SeachPresenter(Context context) {
        this.mContext = context;
    }

    public void getAccountInfoData(String accountname) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("name", accountname);
        HttpUtils.postRequest(BaseUrl.HTTP_get_chain_account_info, mContext, hashMap, new JsonCallback<ResponseBean<BlockChainAccountInfoBean.DataBean>>() {
            @Override
            public void onSuccess(Response<ResponseBean<BlockChainAccountInfoBean.DataBean>> response) {
                if (response.body().code == 0) {
                    view.getBlockchainAccountInfoDataHttp(response.body().data);
                } else {
                    view.getDataHttpFail(response.body().message);
                }
            }
        });
    }
}
