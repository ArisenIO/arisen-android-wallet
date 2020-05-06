package com.oraclechain.pocketrix.modules.wallet.createwallet.bindphone;

import com.oraclechain.pocketrix.base.BaseView;
import com.oraclechain.pocketrix.bean.CodeAuthBean;

/**
 * Created by pocketrix on 2018/1/18.
 */

public interface BindPhoneView extends BaseView {

    void getCodeDataHttp(String msg);

    void getCodeAuthDataHttp(CodeAuthBean.DataBean codeAuthBean);

    void getDataHttpFail(String msg);
}
