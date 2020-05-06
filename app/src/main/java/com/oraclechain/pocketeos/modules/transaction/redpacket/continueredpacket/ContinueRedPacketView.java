package com.oraclechain.pocketrix.modules.transaction.redpacket.continueredpacket;

import com.oraclechain.pocketrix.base.BaseView;
import com.oraclechain.pocketrix.bean.CoinRateBean;
import com.oraclechain.pocketrix.bean.RedPacketDetailsBean;

/**
 * Created by pocketrix on 2017/12/26.
 */
public interface ContinueRedPacketView extends BaseView {
    void getCoinRateDataHttp(CoinRateBean.DataBean coinRateBean);

    void getRedPacketDetailsDataHttp(RedPacketDetailsBean.DataBean dataBean);

    void getDataHttpFail(String msg);
}
