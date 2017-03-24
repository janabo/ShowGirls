package com.janabo.showgirls.listener;

/**
 * 作者：janabo on 2017/3/15 14:07
 */
public interface SubscriberDoOnNextListener<T> {
    void doOnNext(T t);
}
