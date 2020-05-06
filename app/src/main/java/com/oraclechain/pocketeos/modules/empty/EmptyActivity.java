package com.oraclechain.pocketrix.modules.empty;

import android.os.Bundle;

import com.oraclechain.pocketrix.R;
import com.oraclechain.pocketrix.base.BaseAcitvity;
import com.oraclechain.pocketrix.modules.normalvp.NormalPresenter;
import com.oraclechain.pocketrix.modules.normalvp.NormalView;

public class EmptyActivity extends BaseAcitvity<NormalView, NormalPresenter> implements NormalView {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_empty;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setCenterTitle("红包");
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initEvent() {

    }

    @Override
    public NormalPresenter initPresenter() {
        return new NormalPresenter();
    }
}
