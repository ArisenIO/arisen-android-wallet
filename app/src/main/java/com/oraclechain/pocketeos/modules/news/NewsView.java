package com.oraclechain.pocketrix.modules.news;

import com.oraclechain.pocketrix.base.BaseView;
import com.oraclechain.pocketrix.bean.CoinBean;
import com.oraclechain.pocketrix.bean.NewsBean;

import java.util.List;

/**
 * Created by pocketrix on 2017/12/26.
 * 获取friendslist
 */

public interface NewsView extends BaseView {

    void getNewsDataHttp(List<NewsBean.DataBean> newsBean);

    void getBannerDataHttp(List<NewsBean.DataBean> newsBean);

    void getCoinTypeDataHttp(List<CoinBean.DataBean> coinBeen);

    void getDataHttpFail(String msg);
}
