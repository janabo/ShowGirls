package com.janabo.showgirls.http;

import com.janabo.showgirls.bean.ImageResult;
import com.janabo.showgirls.bean.RecommendList;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * 作者：janabo on 2017/3/15 14:20
 */
public interface HttpService {

    @GET("test1")
    Observable<RecommendList> getHeadList(@Query("start") int start, @Query("end") int end);

    @GET("http://pic.sogou.com/pics")
    Observable<ImageResult> getImageList(
            @Query("reqType") String ajax,
            @Query("reqFrom") String result,
            @Query("query") String word,
            @Query("start" ) int page);

//    @GET("http://api.laifudao.com/open/tupian.json")
//    Observable<ImageJoy[]> getImageJoy();
}
