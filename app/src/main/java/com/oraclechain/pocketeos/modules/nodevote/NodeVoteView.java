package com.oraclechain.pocketrix.modules.nodevote;

import com.oraclechain.pocketrix.base.BaseView;
import com.oraclechain.pocketrix.bean.AccountDetailsBean;
import com.oraclechain.pocketrix.bean.ResultTableRowBean;

/**
 * Created by pocketrix on 2017/12/26.
 */
public interface NodeVoteView extends BaseView {

    void getAccountVoteDataHttp(ResultTableRowBean resultTableRowBean);

    void getAccountDetailsDataHttp(AccountDetailsBean accountDetailsBean);

    void getDataHttpFail(String msg);
}
