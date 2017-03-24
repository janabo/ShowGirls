package com.janabo.showgirls.view;

/**
 *
 * @param <T>
 */
public interface IView<T> {
    void attachView(T data);
    void detachView();
}
