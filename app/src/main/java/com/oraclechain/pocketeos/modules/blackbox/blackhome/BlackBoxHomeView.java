package com.oraclechain.pocketrix.modules.blackbox.blackhome;

import com.oraclechain.pocketrix.base.BaseView;
import com.oraclechain.pocketrix.bean.AccountWithCoinBean;

import java.util.List;

/**
 * Created by pocketrix on 2018/1/18.
 */

public interface BlackBoxHomeView extends BaseView {

    void getAccountDetailsDataHttp(List<AccountWithCoinBean> mAccountWithCoinBeen);

    void getDataHttpFail(String msg);
}
