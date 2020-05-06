package com.oraclechain.pocketrix.adapter.baseadapter.base;


/**
 * Created by pocketRix on 2017/11/23.
 */
public interface ItemViewDelegate<T>
{

    int getItemViewLayoutId();

    boolean isForViewType(T item, int position);

    void convert(ViewHolder holder, T t, int position);

}
