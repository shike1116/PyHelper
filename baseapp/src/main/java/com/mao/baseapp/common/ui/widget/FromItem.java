package com.mao.baseapp.common.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.LayoutDirection;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mao.baseapp.R;

/**
 * Created by wjf on 18/6/30.
 */

public class FromItem  extends LinearLayout {
    private boolean initCalled;
    public FromItem(Context context) {
        super(context);
        if(!initCalled){
            initCalled = true;
            init(context, null);
        }
    }

    public FromItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        if(!initCalled){
            initCalled = true;
            init(context, attrs);
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public FromItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if(!initCalled){
            initCalled = true;
            init(context, attrs);
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public FromItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        if(!initCalled){
            initCalled = true;
            init(context, attrs);
        }
    }


    private View mViewRoot,mViewTopLine,mViewBottomLine,mViewArrow;
    private TextView mTvRight,mTvLeft;
    private ImageView mIvIcon;
    public void init(Context context, AttributeSet attrs){
        mViewRoot = LayoutInflater.from(context).inflate(R.layout.view_fromitem, this);
        mViewTopLine = mViewRoot.findViewById(R.id.top_link);
        mViewBottomLine = mViewRoot.findViewById(R.id.bottom_link);
        mViewArrow = mViewRoot.findViewById(R.id.arrow);


        mTvLeft = (TextView)mViewRoot.findViewById(R.id.tv_left);
        mTvRight = (TextView)mViewRoot.findViewById(R.id.tv_right);
        mIvIcon = (ImageView)mViewRoot.findViewById(R.id.iv_icon);
        initParam(context,attrs);
    }

    private void initParam(Context context, AttributeSet attrs) {
        if(attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.FromItem);

            String leftText = typedArray.getString(R.styleable.FromItem_fi_left_text);
            if(!TextUtils.isEmpty(leftText)){
                mTvLeft.setText(leftText);
            }

            String rightText = typedArray.getString(R.styleable.FromItem_fi_right_text);
            if(!TextUtils.isEmpty(rightText)){
                mTvRight.setText(rightText);
            }

            boolean showArrow = typedArray.getBoolean(R.styleable.FromItem_fi_show_arrow,true);
            mViewArrow.setVisibility(showArrow? View.VISIBLE: View.GONE);


            boolean showTop = typedArray.getBoolean(R.styleable.FromItem_fi_show_top_line,true);
            mViewTopLine.setVisibility(showTop? View.VISIBLE: View.GONE);

            boolean showBottom = typedArray.getBoolean(R.styleable.FromItem_fi_show_bottom_line,true);
            mViewBottomLine.setVisibility(showBottom? View.VISIBLE: View.GONE);

            float topLineSpace = typedArray.getDimension(R.styleable.FromItem_fi_top_line_space,0);
            if(topLineSpace > 0){
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams )mViewTopLine.getLayoutParams();
                layoutParams.setMargins((int)topLineSpace,0,0,0);
                mViewTopLine.setLayoutParams(layoutParams);
            }

            float topBottomSpace = typedArray.getDimension(R.styleable.FromItem_fi_bottom_line_space,0);
            if(topBottomSpace > 0){
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams )mViewBottomLine.getLayoutParams();
                layoutParams.setMargins((int)topBottomSpace,0,0,0);
                mViewBottomLine.setLayoutParams(layoutParams);
            }
            int leftResound = typedArray.getResourceId(R.styleable.FromItem_fi_left_icon,-1);
            if(leftResound >0){
                mIvIcon.setVisibility(VISIBLE);
                mIvIcon.setBackgroundResource(leftResound);
            }
            float leftIconSize = typedArray.getDimension(R.styleable.FromItem_fi_left_icon_size, -1);
            if(leftIconSize > 0){
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams )mIvIcon.getLayoutParams();
                layoutParams.width = (int) leftIconSize;
                layoutParams.height =(int) leftIconSize;
                mIvIcon.setLayoutParams(layoutParams);
            }



            typedArray.recycle();
        }
    }

}
