package com.janabo.showgirls.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.janabo.showgirls.R;
import com.janabo.showgirls.ShowLargeImgActivity;
import com.janabo.showgirls.adapter.ImageAdapter;
import com.janabo.showgirls.bean.Image;
import com.janabo.showgirls.presenter.CommonImgPresenter;
import com.janabo.showgirls.presenter.IPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：janabo on 2017/3/15 11:31
 */
public class CommonImgFragment extends BaseSwipeFragment<List<Image>> implements ImageAdapter.OnImageItemClickListener{

    ImageAdapter iAdapter;
    CommonImgPresenter commonImgPresenter;

    @Override
    public int getLayoutID() {
        return R.layout.fragment_main;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iAdapter = new ImageAdapter();
        commonImgPresenter = new CommonImgPresenter();
    }

    @Override
    public void initParams() {
        super.initParams();
        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mainRV.setLayoutManager(layoutManager);
        iAdapter.setListener(this);
        mainRV.setAdapter(iAdapter);
        mainRV.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int totalCount = layoutManager.getItemCount();
                int[] visibleItems = layoutManager.findLastVisibleItemPositions(null);
                int lastItem = Math.max(visibleItems[0], visibleItems[1]);
                if (dy > 0 && lastItem > totalCount - 2) {
                    commonImgPresenter.loadMore();
                }
            }
        });
    }

    @Override
    public void onImageItemClick(int position, ArrayList<Image> list) {
        Intent intent = new Intent();
        intent.putExtra("position", position);
        intent.putExtra("netImages", list);
        intent.setClass(getView().getContext(), ShowLargeImgActivity.class);
        startActivityForResult(intent,100);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100){
            mainRV.scrollToPosition(data.getIntExtra("position", 0));
        }
    }

    @Override
    public IPresenter getPresenter() {
        return commonImgPresenter;
    }

    @Override
    public void attachView(List<Image> data) {
        iAdapter.setmData(data);
    }
}
