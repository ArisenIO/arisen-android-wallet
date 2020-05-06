package com.oraclechain.pocketrix.modules.transaction.redpacket.getredpacketdetails;

import com.oraclechain.pocketrix.base.BaseView;
import com.oraclechain.pocketrix.bean.RedPacketDetailsBean;

/**
 * Created by pocketrix on 2017/12/26.
 */
public interface GetRedPacketDetailsView extends BaseView {
    void getRedPacketDetailsDataHttp(RedPacketDetailsBean.DataBean dataBean);

    void getDataHttpFail(String msg);
}
