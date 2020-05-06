package com.oraclechain.pocketrix.modules.friendslist.friendsdetails;

import com.oraclechain.pocketrix.base.BaseView;
import com.oraclechain.pocketrix.bean.AccountWithCoinBean;
import com.oraclechain.pocketrix.bean.WalletDetailsBean;

import java.util.List;

/**
 * Created by pocketrix on 2018/1/18.
 */

public interface FriendsDetailsView extends BaseView {

    void getWalletDetailsDataHttp(List<WalletDetailsBean.DataBean> walletDetailsBean);

    void getAccountDetailsDataHttp(List<AccountWithCoinBean> mAccountWithCoinBeen);

    void getAddFollowsDataHttp();

    void getCancelFollow();

    void isfollow(Boolean isFollows);

    void getDataHttpFail(String msg);
}
