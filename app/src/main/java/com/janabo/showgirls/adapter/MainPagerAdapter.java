package com.janabo.showgirls.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.janabo.showgirls.R;
import com.janabo.showgirls.fragments.CommonImgFragment;

import java.util.HashMap;
import java.util.Map;

public class MainPagerAdapter extends FragmentStatePagerAdapter {
    private String[] titles ;
    private Map<Integer,Fragment> fragments;
    public MainPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        fragments = new HashMap<>();
        titles = context.getResources().getStringArray(R.array.tab);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new CommonImgFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title",titles[position]);
        fragment.setArguments(bundle);
        fragments.put(position,fragment);
        return fragment;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    public Fragment getFragment(int position){
        return fragments.get(position);
    }
}
