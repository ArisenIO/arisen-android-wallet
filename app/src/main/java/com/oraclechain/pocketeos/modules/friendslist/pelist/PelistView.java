package com.oraclechain.pocketrix.modules.friendslist.pelist;

import com.oraclechain.pocketrix.base.BaseView;
import com.oraclechain.pocketrix.bean.PelistBean;

import java.util.List;

/**
 * Created by pocketrix on 2017/12/26.
 * 获取friendslist
 */
public interface PelistView extends BaseView {

    void getListDataHttp(List<PelistBean.DataBean> pelistBean);

    void getDataHttpFail(String msg);
}
