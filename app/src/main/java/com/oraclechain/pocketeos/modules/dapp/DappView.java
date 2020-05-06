package com.oraclechain.pocketrix.modules.dapp;

import com.oraclechain.pocketrix.base.BaseView;
import com.oraclechain.pocketrix.bean.DappBean;
import com.oraclechain.pocketrix.bean.DappCommpanyBean;

import java.util.List;

/**
 * Created by pocketrix on 2017/12/26.
 * 获取friendslist
 */

public interface DappView extends BaseView {
    void getDappCommpanyDataHttp(List<DappCommpanyBean.DataBean> dappCommpanyBean);

    void getDappDataHttp(List<DappBean.DataBean> dappBean);

    void getDataHttpFail(String msg);
}
