package com.janabo.showgirls.application;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.janabo.showgirls.util.DeviceUtil;
import com.janabo.showgirls.util.ImagePipelineConfigUtils;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * 作者：janabo on 2017/3/14 09:41
 */
public class MyApplication extends Application{

    private static MyApplication instance;

    public static MyApplication getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Fresco.initialize(this, ImagePipelineConfigUtils.getDefaultImagePipelineConfig(this));
        DeviceUtil.initialize(this);
        UMShareAPI.get(this);

    }

    //各个平台的配置，建议放在全局Application或者程序入口
    {
        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        PlatformConfig.setQQZone("1105987743", "c7394704798a158208a74ab60104f0ba");

    }
}
