package com.oraclechain.pocketrix.modules.leftdrawer.transactionhistory;

import com.oraclechain.pocketrix.base.BaseView;
import com.oraclechain.pocketrix.bean.TransferHistoryBean;

/**
 * Created by pocketrix on 2017/12/26.
 */
public interface TransactionHistoryView extends BaseView {


    void getTransferHistoryDataHttp(TransferHistoryBean.DataBeanX transferHistoryBean);


    void getDataHttpFail(String msg);
}
