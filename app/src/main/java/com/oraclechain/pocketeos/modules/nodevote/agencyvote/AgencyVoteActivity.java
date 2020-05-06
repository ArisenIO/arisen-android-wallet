package com.oraclechain.pocketrix.modules.nodevote.agencyvote;

import android.os.Bundle;

import com.oraclechain.pocketrix.R;
import com.oraclechain.pocketrix.base.BaseAcitvity;
import com.oraclechain.pocketrix.modules.normalvp.NormalPresenter;
import com.oraclechain.pocketrix.modules.normalvp.NormalView;

/**
 * 代理投票
 */
public class AgencyVoteActivity extends BaseAcitvity<NormalView, NormalPresenter> implements NormalView {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_agency_vote;
    }

    @Override
    public NormalPresenter initPresenter() {
        return new NormalPresenter();
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setCenterTitle(getString(R.string.go_entrust));
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initEvent() {

    }
}
