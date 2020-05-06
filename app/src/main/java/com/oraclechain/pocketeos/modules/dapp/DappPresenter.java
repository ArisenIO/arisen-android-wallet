package com.oraclechain.pocketrix.modules.dapp;

import android.content.Context;

import com.lzy.okgo.model.Response;
import com.oraclechain.pocketrix.base.BasePresent;
import com.oraclechain.pocketrix.base.BaseUrl;
import com.oraclechain.pocketrix.bean.DappBean;
import com.oraclechain.pocketrix.bean.DappCommpanyBean;
import com.oraclechain.pocketrix.net.HttpUtils;
import com.oraclechain.pocketrix.bean.ResponseBean;
import com.oraclechain.pocketrix.net.callbck.JsonCallback;

import java.util.HashMap;
import java.util.List;

/**
 * Created by pocketrix on 2017/12/26.
 */

public class DappPresenter extends BasePresent<DappView> {
    private Context mContext;

    public DappPresenter(Context context) {
        this.mContext = context;
    }

    public void getData() {

        HttpUtils.getRequets(BaseUrl.HTTP_dapp_commpany_list, mContext, new HashMap<String, String>(), new JsonCallback<ResponseBean<List<DappCommpanyBean.DataBean>>>() {
            @Override
            public void onSuccess(Response<ResponseBean<List<DappCommpanyBean.DataBean>>> response) {
                if (response.body().code == 0) {
                    view.getDappCommpanyDataHttp(response.body().data);
                } else {
                    view.getDataHttpFail(response.body().message);
                }
            }
        });
        HttpUtils.getRequets(BaseUrl.HTTP_dapp_list, mContext, new HashMap<String, String>(), new JsonCallback<ResponseBean<List<DappBean.DataBean>>>() {
            @Override
            public void onSuccess(Response<ResponseBean<List<DappBean.DataBean>>> response) {
                if (response.body().code == 0) {
                    view.getDappDataHttp(response.body().data);
                } else {
                    view.getDataHttpFail(response.body().message);
                }
            }
        });
    }
}
