package com.janabo.showgirls.presenter;

import com.janabo.showgirls.bean.Image;
import com.janabo.showgirls.fragments.CommonImgFragment;
import com.janabo.showgirls.http.HttpRetrofit;
import com.janabo.showgirls.http.HttpSubscribe;
import com.janabo.showgirls.listener.SubscriberDoOnNextListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：janabo on 2017/3/15 13:59
 */
public class CommonImgPresenter implements IPresenter<CommonImgFragment>{
    CommonImgFragment iView;
    private int page = 1;
    private String word;
    List<Image> images;
    //是否正在加载
    private boolean isLoading = false;

    public CommonImgPresenter(){
        images = new ArrayList<>();
    }

    @Override
    public void onCreate(CommonImgFragment iView) {
        this.iView = iView;
        word = iView.getArguments().getString("title");
        onViewCreated();
    }

    @Override
    public void onViewCreated() {
        isLoading = true;
        HttpRetrofit.getImageList(word, page, new HttpSubscribe<List<Image>>(new SubscriberDoOnNextListener<List<Image>>() {
            @Override
            public void doOnNext(List<Image> imgs) {
                images.addAll(imgs);
                iView.attachView(images);
                isLoading = false;
            }
        }));
    }

    public void loadMore(){
        if(!isLoading) {
            page++;
            onViewCreated();
        }
    }
}
