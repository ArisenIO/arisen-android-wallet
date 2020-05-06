package com.oraclechain.pocketrix.bean;

import java.util.List;

/**
 * Created by pocketrix on 2018/6/12.
 */

public class VoteproducerMessageBean {

    /**
     * voter : aaaaaavotera
     * proxy :
     * producers : ["producerc","producera"]
     */

    private String voter;
    private String proxy;
    private List<String> producers;

    public String getVoter() {
        return voter;
    }

    public void setVoter(String voter) {
        this.voter = voter;
    }

    public String getProxy() {
        return proxy;
    }

    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

    public List<String> getProducers() {
        return producers;
    }

    public void setProducers(List<String> producers) {
        this.producers = producers;
    }
}
