package com.oraclechain.pocketrix.modules.nodevote.gonodevote;

import com.oraclechain.pocketrix.base.BaseView;
import com.oraclechain.pocketrix.bean.ResultNodeListBean;

/**
 * Created by pocketrix on 2017/12/26.
 */
public interface GoNodeVoteView extends BaseView {

    void getNodeListDataHttp(ResultNodeListBean resultNodeListBean);

    void getDataHttpFail(String msg);
}
