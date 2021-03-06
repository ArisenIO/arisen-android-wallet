package com.oraclechain.pocketrix.modules.blackbox.blackhome;

import android.content.Context;

import com.lzy.okgo.model.Response;
import com.oraclechain.pocketrix.base.BasePresent;
import com.oraclechain.pocketrix.base.BaseUrl;
import com.oraclechain.pocketrix.bean.AccountDetailsBean;
import com.oraclechain.pocketrix.bean.AccountWithCoinBean;
import com.oraclechain.pocketrix.bean.ResponseBean;
import com.oraclechain.pocketrix.net.HttpUtils;
import com.oraclechain.pocketrix.net.callbck.JsonCallback;
import com.oraclechain.pocketrix.utils.RegexUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by pocketrix on 2018/1/18.
 */

public class BlackBoxHomePresenter extends BasePresent<BlackBoxHomeView> {
    private Context mContext;

    public BlackBoxHomePresenter(Context context) {
        this.mContext = context;
    }
    public void getAccountDetailsData(final String name ) {

        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("name", name);
        HttpUtils.postRequest(BaseUrl.HTTP_rix_get_account, mContext, hashMap, new JsonCallback<ResponseBean<AccountDetailsBean>>() {
            @Override
            public void onSuccess(Response<ResponseBean<AccountDetailsBean>> response) {
                if (response.body().code == 0) {
                    if (response.body().data.getAccount_name().equals(name)) {
                        List<AccountWithCoinBean> accountWithCoinBeens = new ArrayList<>();
                        AccountWithCoinBean  rix = new AccountWithCoinBean();
                        rix.setCoinName("rix");
                        rix.setCoinForCny(RegexUtil.subZeroAndDot(response.body().data.getrix_balance_cny()));
                        rix.setCoinNumber(RegexUtil.subZeroAndDot(response.body().data.getrix_balance()));
                        rix.setCoinImg(response.body().data.getAccount_icon());
                        rix.setrix_market_cap_usd(response.body().data.getrix_market_cap_usd());
                        rix.setrix_market_cap_cny(response.body().data.getrix_market_cap_cny());
                        rix.setrix_price_cny(response.body().data.getrix_price_cny());
                        if (response.body().data.getrix_price_change_in_24h().contains("-")) {
                            rix.setCoinUpsAndDowns(response.body().data.getrix_price_change_in_24h() + "%");
                        } else {
                            rix.setCoinUpsAndDowns("+" + response.body().data.getrix_price_change_in_24h() + "%");
                        }
                        accountWithCoinBeens.add(rix);
                        AccountWithCoinBean oct = new AccountWithCoinBean();
                        oct.setCoinName("OCT");
                        oct.setCoinForCny(RegexUtil.subZeroAndDot(response.body().data.getOct_balance_cny()));
                        oct.setCoinNumber(RegexUtil.subZeroAndDot(response.body().data.getOct_balance()));
                        oct.setCoinImg(response.body().data.getAccount_icon());
                        oct.setOct_market_cap_cny(response.body().data.getOct_market_cap_cny());
                        oct.setOct_market_cap_usd(response.body().data.getOct_market_cap_usd());
                        oct.setOct_price_cny(response.body().data.getOct_price_cny());
                        if (response.body().data.getOct_price_change_in_24h().contains("-")) {
                            oct.setCoinUpsAndDowns(response.body().data.getOct_price_change_in_24h() + "%");
                        } else {
                            oct.setCoinUpsAndDowns("+" +response.body().data.getOct_price_change_in_24h() + "%");
                        }
                        accountWithCoinBeens.add(oct);
                        view.getAccountDetailsDataHttp(accountWithCoinBeens);
                    }
                } else {
                    view.getDataHttpFail(response.body().message);
                }
            }
        });
    }
}

