package com.oraclechain.pocketrix.modules.leftdrawer.suggestionfeedback;

import com.oraclechain.pocketrix.base.BaseView;
import com.oraclechain.pocketrix.bean.SuggestionBean;

import java.util.List;

/**
 * Created by pocketrix on 2017/12/26.
 * 获取friendslist
 */
public interface SuggestionFeedbackView extends BaseView {

    void postSuggestionHttp();

    void getSuggestionListHttp(List<SuggestionBean.DataBean> suggestionBean);

    void getDataHttpFail(String msg);
}
