package com.oraclechain.pocketrix.modules.transaction.redpacket.makeredpacket;

import com.oraclechain.pocketrix.base.BaseView;
import com.oraclechain.pocketrix.bean.CoinRateBean;
import com.oraclechain.pocketrix.bean.RedPacketHistoryBean;
import com.oraclechain.pocketrix.bean.SendRedPacketBean;

import java.util.List;

/**
 * Created by pocketrix on 2017/12/26.
 */
public interface RedPacketView extends BaseView {
    void getCoinRateDataHttp(CoinRateBean.DataBean coinRateBean);

    void getRedPacketHistoryDataHttp(List<RedPacketHistoryBean.DataBean> dataBeanList);

    void sendRedPacketDataHttp(SendRedPacketBean.DataBean sendRedPacketBean);


    void getDataHttpFail(String msg);
}
