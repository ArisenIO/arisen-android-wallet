package com.oraclechain.pocketrix.modules.leftdrawer.candyintegral;

import com.oraclechain.pocketrix.base.BaseView;
import com.oraclechain.pocketrix.bean.CandyScoreBean;
import com.oraclechain.pocketrix.bean.CandyUserTaskBean;
import com.oraclechain.pocketrix.bean.HotEquitiesBean;

import java.util.List;

/**
 * Created by pocketrix on 2017/12/26.
 * 获取friendslist
 */
public interface CandyIntegralView extends BaseView {

    void getCandyScoreDataHttp(CandyScoreBean.DataBean messageBean);

    void getHotEquitiesDataHttp(List<HotEquitiesBean.DataBean> mDataBeans);

    void getCandyTaskDataHttp(List<CandyUserTaskBean.DataBean> mDataBeans);

    void getDataHttpFail(String msg);
}
