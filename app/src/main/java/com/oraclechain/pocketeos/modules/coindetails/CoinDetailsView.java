package com.oraclechain.pocketrix.modules.coindetails;

import com.oraclechain.pocketrix.base.BaseView;
import com.oraclechain.pocketrix.bean.SparkLinesBean;
import com.oraclechain.pocketrix.bean.TransferHistoryBean;

/**
 * Created by pocketrix on 2017/12/26.
 */
public interface CoinDetailsView extends BaseView {


    void getTransferHistoryDataHttp(TransferHistoryBean.DataBeanX transferHistoryBean);

    void getSparklinesData(SparkLinesBean.DataBean dataBean);


    void getDataHttpFail(String msg);
}
