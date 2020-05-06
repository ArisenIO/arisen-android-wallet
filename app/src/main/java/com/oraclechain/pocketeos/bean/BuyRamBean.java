package com.oraclechain.pocketrix.bean;

/**
 * Created by pocketrix on 2018/6/22.
 */

public class BuyRamBean {

    /**
     * payer : aaa
     * receiver : aaa
     * quant : 2.0000 RIX
     */

    private String payer;
    private String receiver;
    private String quant;

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getQuant() {
        return quant;
    }

    public void setQuant(String quant) {
        this.quant = quant;
    }
}
