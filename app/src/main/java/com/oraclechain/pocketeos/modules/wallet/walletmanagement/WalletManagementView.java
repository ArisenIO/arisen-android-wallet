package com.oraclechain.pocketrix.modules.wallet.walletmanagement;

import com.oraclechain.pocketrix.base.BaseView;
import com.oraclechain.pocketrix.bean.BaseBean;

/**
 * Created by pocketrix on 2018/1/18.
 */

public interface WalletManagementView extends BaseView {

    void setPolicyAccountHttp(BaseBean baseBean, int position);


    void getDataHttpFail(String msg);
}
