package com.oraclechain.pocketrix.modules.switchusernumber;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.oraclechain.pocketrix.R;
import com.oraclechain.pocketrix.adapter.AdapterManger;
import com.oraclechain.pocketrix.adapter.baseadapter.wrapper.EmptyWrapper;
import com.oraclechain.pocketrix.app.MyApplication;
import com.oraclechain.pocketrix.base.BaseAcitvity;
import com.oraclechain.pocketrix.bean.AccountInfoBean;
import com.oraclechain.pocketrix.modules.normalvp.NormalPresenter;
import com.oraclechain.pocketrix.modules.normalvp.NormalView;
import com.oraclechain.pocketrix.utils.JsonUtil;
import com.oraclechain.pocketrix.view.RecycleViewDivider;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.oraclechain.pocketrix.utils.Utils.getContext;

public class SwitchUserNumberActivity extends BaseAcitvity<NormalView, NormalPresenter> implements NormalView {


    @BindView(R.id.recycle_user_number)
    RecyclerView mRecycleUserNumber;

    private List<AccountInfoBean> mAccountInfoBeanList = new ArrayList<>();
    private EmptyWrapper mAccountAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_switch_user_number;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setCenterTitle(getString(R.string.switch_number));
    }

    @Override
    protected void initData() {
        if (getIntent().getStringExtra("from").equals("home")) {
            mAccountInfoBeanList = JsonUtil.parseJsonToArrayList(MyApplication.getInstance().getUserBean().getAccount_info(), AccountInfoBean.class);
        } else {
            mAccountInfoBeanList = getIntent().getParcelableArrayListExtra("allaccount");
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        layoutManager.setSmoothScrollbarEnabled(true);
        mRecycleUserNumber.setLayoutManager(layoutManager);
        mRecycleUserNumber.addItemDecoration(new RecycleViewDivider(getContext(), LinearLayoutManager.HORIZONTAL, 1, getResources().getColor(R.color.line)));
        mAccountAdapter = new EmptyWrapper(AdapterManger.getSwitchUserNumberAdapter(this,mAccountInfoBeanList,getIntent().getStringExtra("account")));
        mAccountAdapter.setEmptyView(R.layout.empty_project);
        mRecycleUserNumber.setAdapter(mAccountAdapter);
    }

    @Override
    public void initEvent() {

    }

    @Override
    public NormalPresenter initPresenter() {
        return new NormalPresenter();
    }

}
