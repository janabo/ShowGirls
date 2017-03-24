package com.janabo.showgirls.http;

import com.janabo.showgirls.bean.Image;
import com.janabo.showgirls.bean.ImageResult;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 作者：janabo on 2017/3/15 14:11
 */
public class HttpRetrofit {

    /**
     * 获取图片
     *
     * @param word
     * @param page
     * @param subscriber
     */
    public static void getImageList(String word, int page, Subscriber<List<Image>> subscriber) {
        HttpClient.getApiService().getImageList("ajax", "result", word, page * 24).map(new Func1<ImageResult, List<Image>>() {
            @Override
            public List<Image> call(ImageResult sosoImgResult) {
                return sosoImgResult.getItems();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }



}
