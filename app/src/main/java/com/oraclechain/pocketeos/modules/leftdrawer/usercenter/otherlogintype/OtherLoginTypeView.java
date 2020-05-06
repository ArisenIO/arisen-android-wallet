package com.oraclechain.pocketrix.modules.leftdrawer.usercenter.otherlogintype;

import com.oraclechain.pocketrix.base.BaseView;

/**
 * Created by pocketrix on 2018/1/18.
 */

public interface OtherLoginTypeView extends BaseView {

    void unBindOtherLoginDataHttp();

    void bindOtherLoginDataHttp();

    void getDataHttpFail(String msg);
}
