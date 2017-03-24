package com.janabo.showgirls.http;

import android.util.Log;

import com.janabo.showgirls.listener.RequestCancelListener;
import com.janabo.showgirls.listener.SubscriberDoOnNextListener;

import rx.Subscriber;

/**
 * 作者：janabo on 2017/3/15 14:56
 */
public class HttpSubscribe<T> extends Subscriber<T> implements RequestCancelListener {
    private SubscriberDoOnNextListener<T> nextListener;
    public HttpSubscribe(SubscriberDoOnNextListener<T> nextListener){
        this.nextListener = nextListener;
    }

    @Override
    public void cancel() {
        if(!isUnsubscribed()){
            unsubscribe();
        }
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        Log.e("onError", e.getMessage());
    }

    @Override
    public void onNext(T t) {
        if(nextListener!=null){
            nextListener.doOnNext(t);
        }
    }
}
