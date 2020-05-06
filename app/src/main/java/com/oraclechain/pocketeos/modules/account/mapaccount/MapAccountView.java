package com.oraclechain.pocketrix.modules.account.mapaccount;

import com.oraclechain.pocketrix.base.BaseView;
import com.oraclechain.pocketrix.bean.GetAccountsBean;

/**
 * Created by pocketrix on 2017/12/26.
 */
public interface MapAccountView extends BaseView {

    void getBlackAccountDataHttp(GetAccountsBean getAccountsBean);

    void setMainAccountHttp();

    void getDataHttpFail(String msg);

    void postrixAccountDataHttp();
}
