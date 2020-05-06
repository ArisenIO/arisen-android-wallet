package com.oraclechain.pocketrix.modules.transaction.redpacket.getredpacketdetails;

import android.content.Context;

import com.lzy.okgo.model.Response;
import com.lzy.okgo.utils.OkLogger;
import com.oraclechain.pocketrix.base.BasePresent;
import com.oraclechain.pocketrix.base.BaseUrl;
import com.oraclechain.pocketrix.bean.RedPacketDetailsBean;
import com.oraclechain.pocketrix.bean.ResponseBean;
import com.oraclechain.pocketrix.net.HttpUtils;
import com.oraclechain.pocketrix.net.callbck.JsonCallback;

import java.util.HashMap;

/**
 * Created by pocketrix on 2017/12/26.
 */

public class GetRedPacketDetailsPresenter extends BasePresent<GetRedPacketDetailsView> {
    private Context mContext;

    public GetRedPacketDetailsPresenter(Context context) {
        this.mContext = context;
    }


    public void getRedPacketDetailsData(String redpacket_id) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("id", redpacket_id);
        HttpUtils.postRequest(BaseUrl.getHTTP_get_red_packet_details_history, mContext, hashMap, new JsonCallback<ResponseBean<RedPacketDetailsBean.DataBean>>() {
            @Override
            public void onSuccess(Response<ResponseBean<RedPacketDetailsBean.DataBean>> response) {

                if (response.body().code == 0) {
                    view.getRedPacketDetailsDataHttp(response.body().data);
                } else {
                    view.getDataHttpFail(response.body().message);
                }
            }
        });
    }
}
