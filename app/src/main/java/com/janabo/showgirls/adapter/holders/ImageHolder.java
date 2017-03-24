package com.janabo.showgirls.adapter.holders;

import android.net.Uri;
import android.text.TextUtils;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.janabo.showgirls.R;
import com.janabo.showgirls.bean.Image;
import com.janabo.showgirls.util.DeviceUtil;

/**
 * 作者：janabo on 2017/3/15 12:00
 */
public class ImageHolder extends BaseViewHolder<Image> {
    SimpleDraweeView item_img;
    private float width;
    private float height;
    private float screenWidth;
    private ViewGroup.LayoutParams layoutParams;

    public ImageHolder(ViewGroup parent) {
        super(parent, R.layout.image_item);
        item_img = (SimpleDraweeView) itemView.findViewById(R.id.item_img);
    }

    @Override
    public void setData(Image data) {
        screenWidth = DeviceUtil.getScreenWidth()/2;
        height =data.getHeight();
        width = data.getWidth();
        if(!TextUtils.isEmpty(data.getThumbImg())){
            layoutParams= item_img.getLayoutParams();
            layoutParams.height= (int)((height/width)*screenWidth);
            item_img.setLayoutParams(layoutParams);
        }
        item_img.setImageURI(Uri.parse(data.getThumbImg()));
    }
}
