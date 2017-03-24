package com.janabo.showgirls.bean;

import java.io.Serializable;

/**
 * 图片实体
 * 作者：janabo on 2017/3/15 11:48
 */
public class Image implements Serializable {
    private String thumbUrl;
    private String pic_url_noredirect;
    private int thumb_width;
    private int thumb_height;

    public Image() {
    }

    public Image(String pic_url_noredirect, int thumb_height, int thumb_width, String thumbUrl) {
        this.pic_url_noredirect = pic_url_noredirect;
        this.thumb_height = thumb_height;
        this.thumb_width = thumb_width;
        this.thumbUrl = thumbUrl;
    }

    public String getThumbImg() {
        return thumbUrl;
    }

    public String getLargeImg() {
        return pic_url_noredirect;
    }

    public int getWidth() {
        return thumb_width;
    }

    public int getHeight() {
        return thumb_height;
    }
}
