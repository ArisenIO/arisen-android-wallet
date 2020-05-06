package com.oraclechain.pocketrix.modules.leftdrawer.usercenter.changename;

import com.oraclechain.pocketrix.base.BaseView;

/**
 * Created by pocketrix on 2018/1/18.
 */

public interface ChangeNameView extends BaseView {

    void updateNameDataHttp();


    void getDataHttpFail(String msg);
}
