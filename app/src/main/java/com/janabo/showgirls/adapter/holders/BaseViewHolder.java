package com.janabo.showgirls.adapter.holders;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作者：janabo on 2017/3/15 11:51
 */
public abstract class BaseViewHolder<M> extends RecyclerView.ViewHolder{
    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public BaseViewHolder(ViewGroup parent, @LayoutRes int res){
        super(LayoutInflater.from(parent.getContext()).inflate(res,parent,false));
    }

    public void setData(M data){

    }

    protected <T extends View> T $(@IdRes int id){
        return (T) this.itemView.findViewById(id);
    }

    protected Context getContext(){
        return this.itemView.getContext();
    }
}
