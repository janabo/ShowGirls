package com.janabo.showgirls.adapter;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.janabo.showgirls.R;
import com.janabo.showgirls.bean.Image;
import com.janabo.showgirls.bean.ImageJoy;
import com.janabo.showgirls.util.DeviceUtil;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by chao on 2016/4/12.
 */
public class LargeImgPagerAdapter extends PagerAdapter {
    private ArrayList<Image> sosoImages;
    private PhotoView photoView;
    private int screenHeight;
    private int screenWidth;
    ViewGroup.LayoutParams mLayoutParams;
    private View view;
    public LargeImgPagerAdapter(ArrayList<Image> sosoImages) {
        this.sosoImages = sosoImages;
        screenHeight = DeviceUtil.getScreenHeight();
        screenWidth = DeviceUtil.getScreenWidth();
    }

    @Override
    public int getCount() {
        return sosoImages.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, int position) {
        view =  LayoutInflater.from(container.getContext()).inflate(R.layout.item_large_img, null);
        photoView = (PhotoView) view.findViewById(R.id.photoView);
        photoView.setOnViewTapListener(new PhotoViewAttacher.OnViewTapListener() {
            @Override
            public void onViewTap(View view, float v, float v1) {
                if(container.getContext() instanceof Activity){
                    Activity activity = (Activity) container.getContext();
                    activity.onBackPressed();
                }
            }
        });
        //glide配合photoview使用更容易适配图片的大小
        if(sosoImages.get(position) instanceof ImageJoy){
           ImageJoy joy = (ImageJoy) sosoImages.get(position);
            Glide.with(container.getContext())
                    .load(joy.getSourceurl())
                    .crossFade()
                    .placeholder(R.mipmap.ic_loading)
                    .into(photoView);
        }else {
            Glide.with(container.getContext())
                    .load(sosoImages.get(position).getLargeImg())
                    .crossFade()
                    .placeholder(R.mipmap.ic_loading)
                    .into(photoView);
        }
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
}
