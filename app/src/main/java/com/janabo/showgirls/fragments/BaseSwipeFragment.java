package com.janabo.showgirls.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.janabo.showgirls.R;
import com.janabo.showgirls.presenter.IPresenter;
import com.janabo.showgirls.view.ISwipeView;

/**
 * 作者：janabo on 2017/3/14 15:30
 */
public abstract class BaseSwipeFragment<T>  extends Fragment implements ISwipeView<T> {

    SwipeRefreshLayout mainSwipe;
    RecyclerView mainRV;

    protected LayoutInflater inflater;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutID(), container, false);
        this.inflater = inflater;
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mainSwipe = (SwipeRefreshLayout) view.findViewById(R.id.main_swipe);
        mainRV = (RecyclerView) view.findViewById(R.id.main_RV);
        mainSwipe.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimary, R.color.colorAccent);
        mainSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPresenter().onViewCreated();
            }
        });
        initParams();
    }


    //滑到顶部
    public void goToTop(int position) {
        mainRV.scrollToPosition(position);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public abstract int getLayoutID();

    public  void initParams(){
        getPresenter().onCreate(this);
    }

    public abstract IPresenter<ISwipeView<T>> getPresenter();

    @Override
    public void hideRefresh() {
        if(mainSwipe!=null) {
            mainSwipe.setRefreshing(false);
        }
    }
    @Override
    public void attachView(T data) {
    }
    @Override
    public void detachView() {

    }
}
