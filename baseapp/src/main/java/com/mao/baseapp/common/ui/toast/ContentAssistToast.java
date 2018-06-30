package com.mao.baseapp.common.ui.toast;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mao.baseapp.R;


public class ContentAssistToast extends Toast {

    private static final int THREE_SECOND = 3 * 1000;
    public ImageView mImageLogo;
    private Context mContext;
    private TextView mTxtTip;

    public ContentAssistToast(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public static ContentAssistToast makeText(Context context, CharSequence text, int duration) {
        ContentAssistToast toast = new ContentAssistToast(context);
        toast.setTip(text);
        toast.setDuration(duration);
        return toast;
    }

    public static ContentAssistToast makeText(Context context, int resId, int duration) {
        ContentAssistToast toast = new ContentAssistToast(context);
        toast.setTip(context.getString(resId));
        toast.setDuration(duration);
        return toast;
    }

    public static ContentAssistToast makeText(Context context, int resId) {
        ContentAssistToast toast = new ContentAssistToast(context);
        toast.setTip(context.getString(resId));
        toast.setDuration(THREE_SECOND);
        return toast;
    }

    public static ContentAssistToast makeText(Context context, String content) {
        ContentAssistToast toast = new ContentAssistToast(context);
        toast.setTip(content);
        toast.setDuration(THREE_SECOND);
        return toast;
    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.layout_toast_verify, null);
        mTxtTip = (TextView) view.findViewById(R.id.txt_tip);
        mImageLogo = (ImageView) view.findViewById(R.id.img_logo);
        this.setView(view);
    }

    public void setTip(CharSequence text) {
        mTxtTip.setText(text);
    }

    public void setImageLogo(int resId) {
        mImageLogo.setImageResource(resId);
    }

    public void setPositiveImage() {
        setImageLogo(R.drawable.tips_possitive);
    }

    public void setNegativeImage() {
        setImageLogo(R.drawable.tips_negative);
    }

}
