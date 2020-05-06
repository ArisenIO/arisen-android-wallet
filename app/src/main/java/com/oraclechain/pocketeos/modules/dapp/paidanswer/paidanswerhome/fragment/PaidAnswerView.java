package com.oraclechain.pocketrix.modules.dapp.paidanswer.paidanswerhome.fragment;

import com.oraclechain.pocketrix.base.BaseView;
import com.oraclechain.pocketrix.bean.PaidAnswerBean;

/**
 * Created by pocketrix on 2017/12/26.
 * 获取有问必答问题列表
 */
public interface PaidAnswerView extends BaseView {

    void getQuestionListDataHttp(PaidAnswerBean.DataBeanX paidAnswerBean);

    void getDataHttpFail(String msg);
}
