package com.oraclechain.pocketrix.modules.account.importaccount;

import com.oraclechain.pocketrix.base.BaseView;
import com.oraclechain.pocketrix.bean.BlockChainAccountInfoBean;

/**
 * Created by pocketrix on 2017/12/26.
 */
public interface ImportAccountView extends BaseView {

    void getBlockchainAccountInfoDataHttp(BlockChainAccountInfoBean.DataBean blockChainAccountInfoBean);

    void setMainAccountHttp();

    void getDataHttpFail(String msg);

    void postrixAccountDataHttp();
}
