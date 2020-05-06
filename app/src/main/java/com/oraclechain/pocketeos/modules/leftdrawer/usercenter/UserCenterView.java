package com.oraclechain.pocketrix.modules.leftdrawer.usercenter;

import com.oraclechain.pocketrix.base.BaseView;
import com.oraclechain.pocketrix.bean.UpdataPhotoBean;

/**
 * Created by pocketrix on 2018/1/18.
 */

public interface UserCenterView extends BaseView {

    void headImgUploadaDataHttp(UpdataPhotoBean updataPhotoBean);


    void getDataHttpFail(String msg);
}
