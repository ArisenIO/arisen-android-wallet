package com.oraclechain.pocketrix.modules.account.backupaccount.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.oraclechain.pocketrix.R;
import com.oraclechain.pocketrix.app.ActivityUtils;
import com.oraclechain.pocketrix.app.AppManager;
import com.oraclechain.pocketrix.app.MyApplication;
import com.oraclechain.pocketrix.base.BaseFragment;
import com.oraclechain.pocketrix.bean.AccountInfoBean;
import com.oraclechain.pocketrix.modules.blackbox.BlackBoxMainActivity;
import com.oraclechain.pocketrix.modules.main.MainActivity;
import com.oraclechain.pocketrix.modules.normalvp.NormalPresenter;
import com.oraclechain.pocketrix.modules.normalvp.NormalView;
import com.oraclechain.pocketrix.utils.EncryptUtil;
import com.oraclechain.pocketrix.utils.PasswordToKeyUtils;
import com.oraclechain.pocketrix.utils.Utils;
import com.oraclechain.pocketrix.view.dialog.passworddialog.PasswordCallback;
import com.oraclechain.pocketrix.view.dialog.passworddialog.PasswordDialog;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * rix钱包备份fragment
 */
public class BackUpAccountFragment extends BaseFragment<NormalView, NormalPresenter> implements NormalView {


    @BindView(R.id.backup_title)
    TextView mBackupTitle;
    @BindView(R.id.backup_desc)
    TextView mBackupDesc;
    @BindView(R.id.switch_view)
    Switch mSwitchView;
    @BindView(R.id.details)
    TextView mDetails;
    @BindView(R.id.go_home)
    Button mGoHome;

    AccountInfoBean mAccountInfoBean = null;
    int position = 0;

    @Override
    public NormalPresenter initPresenter() {
        return new NormalPresenter();
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {
        position = getArguments().getInt("i");
        mAccountInfoBean = getArguments().getParcelable("account");
        if (position == 0) {
            mBackupTitle.setText(R.string.backup_title_pra_key);
        } else {
            mBackupTitle.setText(R.string.backup_title_word_key);
        }

    }

    @Override
    public void initEvent() {
        mSwitchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    PasswordDialog mPasswordDialog = new PasswordDialog(getActivity(), new PasswordCallback() {
                        @Override
                        public void sure(String password) {
                            if (MyApplication.getInstance().getUserBean().getWallet_shapwd().equals(PasswordToKeyUtils.shaCheck(password))) {
                                if (position == 0) {
                                    try {
                                        mDetails.setText("OWNKEY:\n" + EncryptUtil.getDecryptString(mAccountInfoBean.getAccount_owner_private_key(),password)
                                                + "\nACTIVEKEY：\n" + EncryptUtil.getDecryptString(mAccountInfoBean.getAccount_active_private_key(),password));
                                    } catch (NoSuchAlgorithmException e) {
                                        e.printStackTrace();
                                    } catch (InvalidKeySpecException e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    mDetails.setText("我是助记词");
                                }
                                mDetails.setVisibility(View.VISIBLE);
                                mSwitchView.setVisibility(View.GONE);
                                mBackupDesc.setVisibility(View.GONE);
                            }
                        }
                        @Override
                        public void cancle() {
                        }
                    });
                    mPasswordDialog.setCancelable(true);
                    mPasswordDialog.show();
                } else {
                    mDetails.setVisibility(View.GONE);
                    mSwitchView.setVisibility(View.VISIBLE);
                    mBackupDesc.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_back_up_account;
    }


    @OnClick(R.id.go_home)
    public void onViewClicked() {
          if (Utils.getSpUtils().getString("loginmode").equals("phone")) {
            ActivityUtils.next(getActivity(), MainActivity.class, true);
        } else {
            ActivityUtils.next(getActivity(), BlackBoxMainActivity.class, true);
        }
        AppManager.getAppManager().finishAllActivity();
    }
}
