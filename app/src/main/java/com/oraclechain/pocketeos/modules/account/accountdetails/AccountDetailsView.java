package com.oraclechain.pocketrix.modules.account.accountdetails;

import com.oraclechain.pocketrix.base.BaseView;

/**
 * Created by pocketrix on 2018/1/18.
 */

public interface AccountDetailsView extends BaseView {

    void setMainAccountHttp(int type);


    void getDataHttpFail(String msg);


}
