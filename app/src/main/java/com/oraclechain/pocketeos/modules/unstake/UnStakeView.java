package com.oraclechain.pocketrix.modules.unstake;

import com.oraclechain.pocketrix.base.BaseView;
import com.oraclechain.pocketrix.bean.AccountDetailsBean;

/**
 * Created by pocketrix on 2017/12/26.
 */
public interface UnStakeView extends BaseView {

    void getAccountDetailsDataHttp(AccountDetailsBean accountDetailsBean);

    void getDataHttpFail(String msg);
}
