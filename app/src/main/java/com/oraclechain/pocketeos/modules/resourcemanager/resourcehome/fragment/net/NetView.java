package com.oraclechain.pocketrix.modules.resourcemanager.resourcehome.fragment.net;

import com.oraclechain.pocketrix.base.BaseView;
import com.oraclechain.pocketrix.bean.BlockChainAccountInfoBean;

/**
 * Created by pocketrix on 2017/12/26.
 */
public interface NetView extends BaseView {

    void getBlockchainAccountInfoDataHttp(BlockChainAccountInfoBean.DataBean blockChainAccountInfoBean);

    void getDataHttpFail(String msg);

}
