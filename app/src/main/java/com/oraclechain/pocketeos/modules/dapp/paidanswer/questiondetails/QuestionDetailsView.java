package com.oraclechain.pocketrix.modules.dapp.paidanswer.questiondetails;

import com.oraclechain.pocketrix.base.BaseView;
import com.oraclechain.pocketrix.bean.ChainInfoBean;
import com.oraclechain.pocketrix.bean.GetChainJsonBean;
import com.oraclechain.pocketrix.bean.GetRequiredKeysBean;

/**
 * Created by pocketrix on 2017/12/26.
 */
public interface QuestionDetailsView extends BaseView {


    void getChainInfoHttp(ChainInfoBean.DataBean chainInfoBean);

    void getChainJsonHttp(GetChainJsonBean.DataBean getChainJsonBean);

    void getRequiredKeysHttp(GetRequiredKeysBean.DataBean getRequiredKeysBean);

    void pushtransactionHttp();

    void getDataHttpFail(String msg);
}
