package com.oraclechain.pocketrix.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pocketrix on 2018/1/25.
 */

public class WalletDetailsBean {

    /**
     * code : 0
     * message : ok
     * data : [{"rixAccountName":"1589","isMainAccount":1}]
     */

    private String code;
    private String message;
    private List<DataBean> data;

    public String getCode() {
        return code == null ? "" : code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message == null ? "" : message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        if (data == null) {
            return new ArrayList<>();
        }
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * rixAccountName : 1589
         * isMainAccount : 1
         */

        private String rixAccountName;
        private int isMainAccount;

        public String getrixAccountName() {
            return rixAccountName == null ? "" : rixAccountName;
        }

        public void setrixAccountName(String rixAccountName) {
            this.rixAccountName = rixAccountName;
        }

        public int getIsMainAccount() {
            return isMainAccount;
        }

        public void setIsMainAccount(int isMainAccount) {
            this.isMainAccount = isMainAccount;
        }
    }
}
