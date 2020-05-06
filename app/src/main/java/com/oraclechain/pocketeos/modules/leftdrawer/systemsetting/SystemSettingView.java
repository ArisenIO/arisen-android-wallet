package com.oraclechain.pocketrix.modules.leftdrawer.systemsetting;

import com.oraclechain.pocketrix.base.BaseView;
import com.oraclechain.pocketrix.bean.SystemInfoBean;

/**
 * Created by pocketrix on 2018/1/18.
 */

public interface SystemSettingView extends BaseView {

    void getSystemInfoHttp(SystemInfoBean.DataBean systemInfoBean, String id);


    void getDataHttpFail(String msg);
}
