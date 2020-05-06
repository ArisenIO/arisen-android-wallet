package com.oraclechain.pocketrix.base;

/**
 * Created by pocketrix on 2017/11/23.
 */
public abstract class BasePresent<T>{
    public T view;

    public void attach(T view){
        this.view = view;
    }

    public void detach(){
        this.view = null;
    }
}