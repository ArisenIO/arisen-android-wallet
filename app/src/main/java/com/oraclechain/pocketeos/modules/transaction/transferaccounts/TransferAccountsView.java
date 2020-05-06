package com.oraclechain.pocketrix.modules.transaction.transferaccounts;

import com.oraclechain.pocketrix.base.BaseView;
import com.oraclechain.pocketrix.bean.AccountDetailsBean;
import com.oraclechain.pocketrix.bean.CoinRateBean;
import com.oraclechain.pocketrix.bean.TransferHistoryBean;

/**
 * Created by pocketrix on 2017/12/26.
 */
public interface TransferAccountsView extends BaseView {
    void getCoinRateDataHttp(CoinRateBean.DataBean coinRateBean);

    void getAccountDetailsDataHttp(AccountDetailsBean accountDetailsBean);


    void getTransferHistoryDataHttp(TransferHistoryBean.DataBeanX transferHistoryBean);

    void getDataHttpFail(String msg);
}
