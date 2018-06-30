package com.mao.baseapp.common.ui.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mao.baseapp.R;
import com.mao.baseapp.common.ui.listener.OnStateTouchListener;


/**
 * Created by mao on 2016/10/20.
 */
public class TitleBar extends RelativeLayout {
    private boolean initCalled;
    public TitleBar(Context context) {
        super(context);
        if(!initCalled){
            initCalled = true;
            init(context, null);
        }
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        if(!initCalled){
            initCalled = true;
            init(context, attrs);
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if(!initCalled){
            initCalled = true;
            init(context, attrs);
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        if(!initCalled){
            initCalled = true;
            init(context, attrs);
        }
    }

    private View mRootView;
    private View mBack,mRitghtBtn;
    private TextView mTitle,mRightTv,mLeftTv;
    private ImageView mIvRightBtnIcon,mIvArrow;
    private View mBottomLink;

    public void init(Context context, AttributeSet attrs){
        mRootView = LayoutInflater.from(context).inflate(R.layout.view_titlebar, this);
        mBack = mRootView.findViewById(R.id.btn_back);
        mRitghtBtn = mRootView.findViewById(R.id.right_btn);
        mRightTv = (TextView)mRootView.findViewById(R.id.right_tv);
        mLeftTv = (TextView)mRootView.findViewById(R.id.left_tv);
        mTitle = (TextView)mRootView.findViewById(R.id.tv_title);
        mIvRightBtnIcon = (ImageView)mRootView.findViewById(R.id.right_btn_icon);
        mIvArrow = (ImageView)mRootView.findViewById(R.id.iv_back);
        mBottomLink = mRootView.findViewById(R.id.bottom_link);

        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD_MR1) {
            mBack.setOnTouchListener(new OnStateTouchListener());
            mRitghtBtn.setOnTouchListener(new OnStateTouchListener());
        }
        initParam(context, attrs);
    }
    private void initParam(Context context, AttributeSet attrs) {
        if(attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleBar);
            String title = typedArray.getString(R.styleable.TitleBar_tb_title);
            boolean showBack = typedArray.getBoolean(R.styleable.TitleBar_tb_show_back,true);
            boolean showBottomLine = typedArray.getBoolean(R.styleable.TitleBar_tb_show_bottom_line,true);

            if(!TextUtils.isEmpty(title)){
                setTitle(title);
            }

            if(mBottomLink != null){
                mBottomLink.setVisibility(showBottomLine ? VISIBLE : GONE);
            }
            if(mBack != null){
                mBack.setVisibility(showBack ? VISIBLE : GONE);
            }


            int bgColor = typedArray.getColor(R.styleable.TitleBar_tb_bg_color, Color.WHITE);
            mRootView.setBackgroundColor(bgColor);

            int textColor = typedArray.getColor(R.styleable.TitleBar_tb_title_color, Color.BLACK);
            mTitle.setTextColor(textColor);


            int iconResound = typedArray.getResourceId(R.styleable.TitleBar_tb_arrow_icon,-1);
            if(iconResound >0){
                mIvArrow.setBackgroundResource(iconResound);
            }

            typedArray.recycle();
        }
    }

    public TitleBar setBackListener(final Activity activity){
        mBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
            }
        });
        return this;
    }
    public TitleBar setClickListener(OnClickListener listener){
        mBack.setOnClickListener(listener);
        mRitghtBtn.setOnClickListener(listener);
        mRightTv.setOnClickListener(listener);
        mLeftTv.setOnClickListener(listener);
        return this;
    }

    public TitleBar setTitle(String title){
        mTitle.setText(title);
        return this;
    }

    public TitleBar setRightText(String text){
        mRightTv.setText(text);
        mRightTv.setVisibility(VISIBLE);
        return this;
    }

    public TitleBar setRightIcon(int resId){
        mIvRightBtnIcon.setImageResource(resId);
        mRitghtBtn.setVisibility(VISIBLE);
        return this;
    }

    public TitleBar setLeftText(String text){
        mLeftTv.setText(text);
        mLeftTv.setVisibility(VISIBLE);
        mBack.setVisibility(GONE);
        return this;
    }
    public TitleBar hideBottomLink(){
        mBottomLink.setVisibility(GONE);
        return this;
    }
}