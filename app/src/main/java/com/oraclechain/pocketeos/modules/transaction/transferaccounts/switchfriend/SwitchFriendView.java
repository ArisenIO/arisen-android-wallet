package com.oraclechain.pocketrix.modules.transaction.transferaccounts.switchfriend;

import com.oraclechain.pocketrix.base.BaseView;
import com.oraclechain.pocketrix.bean.FriendsListInfoBean;

import java.util.List;

/**
 * Created by pocketrix on 2017/12/26.
 * 获取friendslist
 */

public interface SwitchFriendView extends BaseView {

    void getDataHttp(List<FriendsListInfoBean> dataBeanList);


    void getDataHttpFail(String msg);
}
