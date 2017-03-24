package com.janabo.showgirls.dialog;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Process;
import android.support.annotation.NonNull;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

/**
 * 弹出框
 * 作者：janabo on 2017/3/14 11:18
 */
public class AlertDialog {
    private Activity activity;
    public AlertDialog(Activity activity) {
        this.activity = activity;
    }

    /**
     * 退出应用
     */
    public void exitApp() {
        new MaterialDialog.Builder(activity)
                .negativeText("取消")
                .positiveText("确定")
                .content("确定退出？")
                .positiveColor(Color.RED)
                .onNegative(new MaterialDialog.SingleButtonCallback(){
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.dismiss();
                    }
                })
                .onPositive(new MaterialDialog.SingleButtonCallback(){
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        activity.startActivity(intent);
                        android.os.Process.killProcess(Process.myPid());
                    }
                })
                .show();
    }
}
