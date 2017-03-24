package com.janabo.showgirls.http;

import com.squareup.okhttp.OkHttpClient;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * 作者：janabo on 2017/3/15 14:20
 */
public class HttpClient {
    private static HttpService apiService;
    private static Retrofit.Builder builder = new Retrofit.Builder();
    private static OkHttpClient client = new OkHttpClient();

    public static HttpService getApiService() {
        builder.client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());
        builder.baseUrl("http://42.96.184.107:4000/");
        Retrofit retrofit = builder.build();
        apiService = retrofit.create(HttpService.class);
        return apiService;
    }
}
