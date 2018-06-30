package com.mao.baseapp.update.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mao.baseapp.common.ui.dialog.MaterialDialog;
import com.mao.baseapp.update.entity.UpdatePo;
import com.mao.baseapp.update.service.UpdateService;


/**
 *
 * Created by wjf on 16/3/17.
 */
public class UpdateDialog {
    private MaterialDialog mDialog;
    private Context mContext;
    private UpdatePo mUpdatePo;
    //private TextView mTvMessage;

    public UpdateDialog(Context context, UpdatePo updatePo) {
        this.mContext = context;
        this.mUpdatePo = updatePo;
        initDialog();
    }

    private void initDialog() {
        mDialog = new MaterialDialog(mContext);
        mDialog.setTitle("更新");
        //View contentView = initContentView();
        mDialog.setMessage(mUpdatePo.desrc);
        mDialog.setPositiveButton("马上更新", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog.dismiss();
                openUpdateService();
            }
        });
        mDialog.setNegativeButton("残忍拒绝", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog.dismiss();
            }
        });

    }

    public void show() {
        mDialog.show();
    }



    private void openUpdateService() {
        Intent downloadIt = new Intent(mContext, UpdateService.class);
        Bundle bundle = new Bundle();
        bundle.putString("url", mUpdatePo.url);
        bundle.putBoolean("isSendBroadcast", false);
        downloadIt.putExtras(bundle);
        mContext.startService(downloadIt);
    }



}








//package com.anwansport.bbb.common.widget;
//
//import android.app.Dialog;
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//import com.demo.workapp.DownloadService;
//import com.demo.workapp.R;
//import com.demo.workapp.log.LogCore;
//import com.nostra13.universalimageloader.core.DisplayImageOptions;
//
///**
// * Created by sf on 2016/5/16.
// */
//public class UpdateDailog extends Dialog implements View.OnClickListener{
//    String url,info;
//    private Context context;
//    public UpdateDailog(Context context, String url, String info) {
//        super(context,R.style.AppDialogGray);
//        this.context = context;
//        this.url = url;
//        this.info = info;
//    }
//
//    private DisplayImageOptions options;
//    private void initImageLoader(){
//        options = new DisplayImageOptions.Builder()
//                .showImageForEmptyUri(R.drawable.default_image)
//                .showImageOnFail(R.drawable.default_image).build();
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.dialog_update);
//        Button btnSave = (Button)findViewById(R.id.btn_update);
//        Button btnCanel = (Button)findViewById(R.id.btn_cancel);
//        btnSave.setOnClickListener(this);
//        btnCanel.setOnClickListener(this);
//
//        TextView tvInfo = (TextView)findViewById(R.id.tv_info);
//        if(info!=null){
//            tvInfo.setText(info);
//        }
//    }
//
//
//
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.btn_update:
//                update();
//                dismiss();
//                break;
//            case R.id.btn_cancel:
//                dismiss();
//                break;
//        }
//    }
//
//    public void update(){
//        Intent downloadIt = new Intent(context, UpdateDailog.class);
//        Bundle bundle = new Bundle();
//        bundle.putString("url", url);
//        bundle.putBoolean("isSendBroadcast", false);
//        downloadIt.putExtras(bundle);
//        context.startService(downloadIt);
//    }
//}
