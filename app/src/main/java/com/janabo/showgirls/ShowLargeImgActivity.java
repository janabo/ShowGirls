package com.janabo.showgirls;

import android.app.ProgressDialog;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.janabo.showgirls.adapter.LargeImgPagerAdapter;
import com.janabo.showgirls.bean.Image;
import com.janabo.showgirls.widget.ImageViewPager;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.utils.SocializeUtils;

import java.util.ArrayList;

/**
 * 作者：janabo on 2017/3/15 20:54
 */
public class ShowLargeImgActivity extends MyActivity implements ViewPager.OnPageChangeListener ,View.OnClickListener{
    ImageViewPager largeViewPager;
    TextView largePage;
    RelativeLayout largeRL;
    ImageView largeImgDownload;
    ImageView largeImgQqShare;
    ImageView largeImgWeixinShare;
    ImageView largeImgSinaShare;
    private ArrayList<Image> sosoImages;
    private int currentPosition;
    private ProgressDialog dialog;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_large_img;
    }

    @Override
    protected void initView() {
        super.initView();
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.background_dark));
        }
        dialog = new ProgressDialog(this);
        currentPosition = getIntent().getIntExtra("position", 0);
        sosoImages = (ArrayList<Image>) getIntent().getSerializableExtra("netImages");
        largeViewPager = (ImageViewPager) findViewById(R.id.large_viewPager);
        largePage = (TextView) findViewById(R.id.large_page);
        largeRL = (RelativeLayout) findViewById(R.id.large_RL);
        largeImgDownload = (ImageView) findViewById(R.id.large_img_download);
        largeImgQqShare = (ImageView) findViewById(R.id.large_img_qq_share);
        largeImgWeixinShare = (ImageView) findViewById(R.id.large_img_weixin_share);
        largeImgSinaShare = (ImageView) findViewById(R.id.large_img_sina_share);

        largeViewPager.setAdapter(new LargeImgPagerAdapter(sosoImages));
        largeViewPager.setCurrentItem(currentPosition);
        largeViewPager.addOnPageChangeListener(this);
        largeImgQqShare.setOnClickListener(this);
        largeImgDownload.setOnClickListener(this);
        largeImgWeixinShare.setOnClickListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        currentPosition = position;
        largePage.setText((position + 1) + "/" + sosoImages.size());
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.large_RL:
                onBackPressed();
            break;
            case R.id.large_img_qq_share://QQ分享
                UMImage imageurl = new UMImage(this,sosoImages.get(currentPosition).getThumbImg());
                new ShareAction(ShowLargeImgActivity.this).withMedia(imageurl)
                        .setPlatform(SHARE_MEDIA.QQ)
                        .setCallback(shareListener).share();
                break;
            case R.id.large_img_weixin_share:
                UMImage wx = new UMImage(this,sosoImages.get(currentPosition).getThumbImg());
                new ShareAction(ShowLargeImgActivity.this).withMedia(wx)
                        .setPlatform(SHARE_MEDIA.WEIXIN)
                        .setCallback(shareListener).share();
                break;
        }
    }

    @Override
    protected void initData() {
        largePage.setText((currentPosition + 1) + "/" + sosoImages.size());
    }

    @Override
    public void onBackPressed() {
        setResult(100, getIntent().putExtra("position", currentPosition));
        super.onBackPressed();
    }

    private UMShareListener shareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
//            SocializeUtils.safeShowDialog(dialog);
        }

        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(ShowLargeImgActivity.this,"成功了",Toast.LENGTH_LONG).show();
            SocializeUtils.safeCloseDialog(dialog);
        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            SocializeUtils.safeCloseDialog(dialog);
            Toast.makeText(ShowLargeImgActivity.this,"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            SocializeUtils.safeCloseDialog(dialog);
            Toast.makeText(ShowLargeImgActivity.this,"取消了",Toast.LENGTH_LONG).show();

        }
    };

}
