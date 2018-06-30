package com.mao.baseapp.common.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.mao.baseapp.R;

import java.util.Timer;
import java.util.TimerTask;


public class LoadingDialog extends Dialog {

    private TextView mTxtTip ;
    private ProgressBar mProgressBar ;
    private Resources mRes ;
    private boolean isActionShow = false ;
    private boolean isKeybackEnable = false ;

    public LoadingDialog(Context context) {
        super(context, R.style.popupDialog_Loading);
        mRes = context.getResources() ;
        init(false);
    }

    public LoadingDialog(Context context, boolean withAction) {
        super(context,R.style.popupDialog_Loading);
        mRes = context.getResources() ;
        isActionShow = withAction ;
        init(withAction);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void init(boolean withAction) {

        if(withAction) {
            setContentView(R.layout.layout_dialog_loading_data_action_1);
            mTxtTip = (TextView) findViewById(R.id.txt_tip);
            mProgressBar = (ProgressBar) findViewById(R.id.progressBar) ;
            mProgressBar.setIndeterminateDrawable(mRes.getDrawable(R.drawable.daisy_loading_rotate)) ;
        } else {
            setContentView(R.layout.layout_dialog_loading_data);
            mTxtTip = (TextView) findViewById(R.id.txt_tip);
            mProgressBar = (ProgressBar) findViewById(R.id.progressBar) ;
            mProgressBar.setIndeterminateDrawable(mRes.getDrawable(R.drawable.original_loading_rotate)) ;
        }
        setCanceledOnTouchOutside(false);
    }

    public void setPrompt(String prompt) {
        mTxtTip.setText(prompt);
        if(TextUtils.isEmpty(prompt)){
            mTxtTip.setVisibility(View.GONE);
        }else{
            mTxtTip.setVisibility(View.VISIBLE);
        }
    }

    public void setIndeterminateDrawable(int resId){
        mProgressBar.setIndeterminateDrawable(mRes.getDrawable(resId)) ;
    }

    /**
     * 显示错误信息, 
     * 3秒后消失
     * @param error String
     */
    public void setErrorInfo(String error) {
        mProgressBar.setIndeterminateDrawable(null) ;
        mProgressBar.setBackgroundResource(R.drawable.tips_negative) ;
        mTxtTip.setText(error) ;
        startTimer() ;
    }

    /**
     * 空白刷新调用
     * @param context Context
     * @param prompt String
     * @return LoadingDialog
     */
    public static LoadingDialog show(Context context, String prompt) {
        final LoadingDialog dialog = new LoadingDialog(context);
        dialog.setPrompt(prompt);
        dialog.show();
        return dialog ;
    }

    /**
     * 空白刷新调用
     * @param context
     * @param res
     * @return
     */
    public static LoadingDialog show(Context context, int res) {
        final LoadingDialog dialog = new LoadingDialog(context);
        dialog.setPrompt(context.getResources().getString(res));
        dialog.show();
        return dialog ;
    }

    /**
     * 动作提示的显示
     * @param context
     * @param prompt
     * @return
     */
    public static LoadingDialog actionShow(Context context, String prompt) {
        final LoadingDialog dialog = new LoadingDialog(context, true);
        dialog.setPrompt(prompt);
        dialog.show();
        return dialog ;
    }

    /**
     * 动作提示的显示
     * @param context
     * @param res
     * @return
     */
    public static LoadingDialog actionShow(Context context, int res) {
        final LoadingDialog dialog = new LoadingDialog(context, true);
        dialog.setPrompt(context.getResources().getString(res));
        dialog.show();
        return dialog ;
    }

    private void startTimer() {
        final Timer mTimer = new Timer();
        mTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                if (isShowing()) {
                    dismiss();
                    mTimer.cancel();
                }
            }
        }, 3000);
    }

    public void setKeybackEnable(boolean enable) {
        this.isKeybackEnable = enable ;
    }

    @Override
    public void dismiss() {
        if(isActionShow) {
            isActionShow = false ;
        }
        super.dismiss();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && isActionShow && ! isKeybackEnable) {

            return false ;
        }

        return super.onKeyDown(keyCode, event);

    }

}
