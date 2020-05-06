package com.oraclechain.pocket.bean;

import java.io.Serializable;

/**
 * Created by pocketrix on 2018/4/2.
 */


public class ResponseBean<T> implements Serializable {

    public int code;
    public String message;
    public T data = null;

}