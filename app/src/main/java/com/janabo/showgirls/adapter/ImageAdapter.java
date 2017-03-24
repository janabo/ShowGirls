package com.janabo.showgirls.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.janabo.showgirls.adapter.holders.BaseViewHolder;
import com.janabo.showgirls.adapter.holders.ImageHolder;
import com.janabo.showgirls.bean.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * 图片适配器
 * 作者：janabo on 2017/3/15 11:53
 */
public class ImageAdapter extends RecyclerView.Adapter<BaseViewHolder<Image>>{
    private ArrayList<Image> mData;
    private OnImageItemClickListener listener;

    public ImageAdapter() {
        mData = new ArrayList<>();
    }

    public void setListener(OnImageItemClickListener listener) {
        this.listener = listener;
    }

    public void setmData(List<Image> mData) {
        if(mData!=null) {
            this.mData.clear();
            this.mData.addAll(mData);
            notifyDataSetChanged();
        }
    }

    @Override
    public ImageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageHolder(parent);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<Image> holder, final int position) {
        holder.setData(mData.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                    listener.onImageItemClick(position,mData);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public interface OnImageItemClickListener{
        void onImageItemClick(int position,ArrayList<Image> list);
    }
}
