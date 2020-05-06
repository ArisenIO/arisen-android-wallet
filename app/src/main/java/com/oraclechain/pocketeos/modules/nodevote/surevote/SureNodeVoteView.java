package com.oraclechain.pocketrix.modules.nodevote.surevote;

import com.oraclechain.pocketrix.base.BaseView;
import com.oraclechain.pocketrix.bean.ResponseBean;
import com.oraclechain.pocketrix.bean.ResultTableRowBean;
import com.oraclechain.pocketrix.bean.ResultVoteWeightBean;

/**
 * Created by pocketrix on 2017/12/26.
 */
public interface SureNodeVoteView extends BaseView {

    void getNowVoteWeightDataHttp(ResultVoteWeightBean resultVoteWeightBean);

    void getAccountVoteDataHttp(ResultTableRowBean resultTableRowBean);

    void postVoteTask(ResponseBean<String> data);

    void getDataHttpFail(String msg);
}
