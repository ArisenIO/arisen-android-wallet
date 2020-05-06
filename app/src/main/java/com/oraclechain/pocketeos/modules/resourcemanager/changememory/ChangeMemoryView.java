package com.oraclechain.pocketrix.modules.resourcemanager.changememory;

import com.oraclechain.pocketrix.base.BaseView;
import com.oraclechain.pocketrix.bean.AccountDetailsBean;
import com.oraclechain.pocketrix.bean.TableResultBean;

/**
 * Created by pocketrix on 2017/12/26.
 */
public interface ChangeMemoryView extends BaseView {


    void getAccountDetailsDataHttp(AccountDetailsBean accountDetailsBean);

    void getTableDataHttp(TableResultBean.DataBean dataBean);

    void getDataHttpFail(String msg);
}
