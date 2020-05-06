package com.oraclechain.pocketrix.modules.leftdrawer.messagecenter;

import com.oraclechain.pocketrix.base.BaseView;
import com.oraclechain.pocketrix.bean.MessageCenterBean;

import java.util.List;

/**
 * Created by pocketrix on 2017/12/26.
 * 获取friendslist
 */
public interface MessageCenterView extends BaseView {

    void getListDataHttp(List<MessageCenterBean.DataBean> messageBean);

    void getDataHttpFail(String msg);
}
