package com.janabo.showgirls.presenter;

/**
 * 作者：janabo on 2017/3/15 11:12
 */
public interface IPresenter<T> {
    void onCreate(T iView);
    void onViewCreated();
}
