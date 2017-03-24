package com.janabo.showgirls.bean;


import com.janabo.showgirls.dao.Recommend;

import java.io.Serializable;
import java.util.List;

/**
 * Created by chao on 2016/3/29.
 */
public class RecommendList implements Serializable {
    private List<Recommend> recommends;

    public List<Recommend> getRecommends() {
        return recommends;
    }

    public void setRecommends(List<Recommend> recommends) {
        this.recommends = recommends;
    }
}
