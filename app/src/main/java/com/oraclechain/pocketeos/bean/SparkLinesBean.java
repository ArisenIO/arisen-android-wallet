package com.oraclechain.pocketrix.bean;

/**
 * Created by pocketrix on 2018/4/8.
 */

public class SparkLinesBean {

    /**
     * code : 0
     * message : ok
     * data : {"sparkline_rix_png":"https://s2.coinmarketcap.com/generated/sparklines/web/7d/usd/1765.png","sparkline_oct_png":"https://s2.coinmarketcap.com/generated/sparklines/web/7d/usd/1838.png"}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message == null ? "" : message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * sparkline_rix_png : https://s2.coinmarketcap.com/generated/sparklines/web/7d/usd/1765.png
         * sparkline_oct_png : https://s2.coinmarketcap.com/generated/sparklines/web/7d/usd/1838.png
         */

        private String sparkline_rix_png;
        private String sparkline_oct_png;

        public String getSparkline_rix_png() {
            return sparkline_rix_png == null ? "" : sparkline_rix_png;
        }

        public void setSparkline_rix_png(String sparkline_rix_png) {
            this.sparkline_rix_png = sparkline_rix_png;
        }

        public String getSparkline_oct_png() {
            return sparkline_oct_png == null ? "" : sparkline_oct_png;
        }

        public void setSparkline_oct_png(String sparkline_oct_png) {
            this.sparkline_oct_png = sparkline_oct_png;
        }
    }
}
