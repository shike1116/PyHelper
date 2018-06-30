package com.mao.baseapp.common.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by wangjf on 2016/10/20.
 */
public class StepBar extends LinearLayout {

    private int mSelectColor = 0xFF21cf73;
    private int mUnSelectColor = 0xFF999999;
    private int mStepNumber = 2;
    private int mCurrentStep = 0;
    private Context mContext;
    public StepBar(Context context) {
        super(context);
        mContext = context;
    }

    public StepBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public StepBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public StepBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mContext = context;
    }

    public void init(int number){
        this.mStepNumber = number;
        initView();
    }

    public void init(int number,int selectColor ,int unSelectColor){
        this.mStepNumber = number;
        this.mSelectColor = selectColor;
        this.mUnSelectColor = unSelectColor;
        initView();
    }

    private void initView() {
        if(mStepNumber <2){
            return;
        }
        for (int i = 0; i < mStepNumber; i++) {
            if(i != 0){
                View view = new View(mContext);
                LayoutParams param = new LinearLayout.LayoutParams(
                        4, 0);
                this.addView(view, param);
            }

            View view = new View(mContext);
            view.setId(i);
            view.setBackgroundColor(i == mCurrentStep ? mSelectColor: mUnSelectColor);
            LayoutParams param = new LinearLayout.LayoutParams(
                    0, LayoutParams.MATCH_PARENT, 1.0f);
            this.addView(view, param);
        }
    }

    public void setStep(int newStep){
        View viewOldStep =  findViewById(mCurrentStep);
        View viewNewStep = findViewById(newStep);
        mCurrentStep = newStep;
        if(viewOldStep != null){
            viewOldStep.setBackgroundColor(mUnSelectColor);
        }
        if(viewNewStep != null){
            viewNewStep.setBackgroundColor(mSelectColor);
        }
    }
}