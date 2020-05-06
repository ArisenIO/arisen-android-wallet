package com.oraclechain.pocketrix.modules.dapp.dappcommpany;

import com.oraclechain.pocketrix.base.BaseView;
import com.oraclechain.pocketrix.bean.DappBean;

import java.util.List;

/**
 * Created by pocketrix on 2017/12/26.
 * 获取friendslist
 */
public interface DappCommpanyDetailsView extends BaseView {

    void getDappCommpanyDataHttp(List<DappBean.DataBean> dappBean);


    void getDataHttpFail(String msg);
}
