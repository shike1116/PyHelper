package com.mao.baseapp.common.ui.listener;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import static android.support.v4.view.ViewCompat.animate;


/**
 * 一个简易的按钮或文本等view的点击效果器
 * 变得透明化，实现类似颜色的切换
 */
public class OnStateTouchListener implements OnTouchListener {

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                animate(v).alpha(1).setDuration(200);
                return false;
            case MotionEvent.ACTION_DOWN:
                animate(v).alpha(0.2f).setDuration(200);
                return false;
            case MotionEvent.ACTION_MOVE:
                return false;
        }
        return false;
    }

}

