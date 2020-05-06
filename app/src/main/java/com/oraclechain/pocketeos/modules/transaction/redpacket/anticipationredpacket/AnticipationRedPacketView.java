package com.oraclechain.pocketrix.modules.transaction.redpacket.anticipationredpacket;

import com.oraclechain.pocketrix.base.BaseView;
import com.oraclechain.pocketrix.bean.AuthRedPacketBean;

/**
 * Created by pocketrix on 2017/12/26.
 */
public interface AnticipationRedPacketView extends BaseView {
    void getAuthRedPacketDataHttp(AuthRedPacketBean.DataBean dataBean);

    void getDataHttpFail(String msg);
}
