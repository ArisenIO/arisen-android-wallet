package com.oraclechain.pocketrix.modules.account.createaccount;

import com.oraclechain.pocketrix.base.BaseView;

/**
 * Created by pocketrix on 2018/1/18.
 */

public interface CreateAccountView extends BaseView {


    void postrixAccountDataHttp();
    void getDataHttpFail(String msg);
    void setMainAccountHttp();
}
