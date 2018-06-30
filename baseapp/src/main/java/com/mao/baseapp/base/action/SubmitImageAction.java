package com.mao.baseapp.base.action;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;

import com.pizidea.imagepicker.AndroidImagePicker;
import com.pizidea.imagepicker.bean.ImageItem;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * Created by wjf on 16/10/9.
 */
public class SubmitImageAction {

    private static final int REQUEST_GET_IMAGE = 2;
    private static final int REQUEST_SHOW_IMAGE = 3;
    private static final int REQUEST_CLIP_IMAGE = 4;

    public static int USER_PHOTO_SIZE = 400;


    private boolean mIsClip = false;
    private int mMaxSize = USER_PHOTO_SIZE;
    private String mResultUrl = null;



    private Callback mCallbak;

    public SubmitImageAction(Callback callbak){
        this.mCallbak = callbak;
    }

    public void getSquarePhoto(int maxSize,Activity activity){
        mIsClip = true;
        mMaxSize = maxSize;
        getPhoto(1, null, activity);
    }
    public void getNormalPhoto(int maxCount,ArrayList<String> selectedUrl,Activity activity){
        mIsClip = false;
        getPhoto(maxCount, selectedUrl, activity);
    }

    private void getPhoto(int maxCount,ArrayList<String> selectedUrl,Activity activity){
        AndroidImagePicker.getInstance().pickMulti(activity, true, new AndroidImagePicker.OnImagePickCompleteListener() {
            @Override
            public void onImagePickComplete(List<ImageItem> items) {
                if(items != null && items.size() > 0){
                    List<String> imageList = new ArrayList<>();
                    for (ImageItem item : items) {
                        if(item != null && !TextUtils.isEmpty(item.path)){
                            imageList.add(item.path);
                        }
                    }
                    mCallbak.handlerGetImage(imageList);
                }
            }
        });
    }

    public void showPhoto(ArrayList<String> selectedUrl, int currentItem,boolean delectable, Activity activity){
//        PhotoPreview.builder()
//                .setPhotos(selectedUrl)
//                .setCurrentItem(currentItem)
//                .setShowDeleteButton(delectable)
//                .start(activity ,REQUEST_SHOW_IMAGE);
    }

    private void clipImage(ArrayList<String> urlList,Activity activity){
//        if(urlList == null || urlList.isEmpty()){
//            return;
//        }
//        mResultUrl = "";
//        File saveFile =  new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "aaaa");
//        Uri source = Uri.fromFile(new File(urlList.get(0)));
//        Crop.of(source, Uri.fromFile(saveFile)).withMaxSize(mMaxSize, mMaxSize).start(activity,REQUEST_CLIP_IMAGE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data,Activity activity) {
        if (resultCode != Activity.RESULT_OK || data == null){
            return;
        }
        switch (requestCode){
//            case REQUEST_GET_IMAGE:
//                if(mIsClip){
//                    clipImage(data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS),activity);
//                }else {
//                    mCallbak.handlerGetImage(data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS));
//                }
//                break;
//            case REQUEST_SHOW_IMAGE:
//                mCallbak.handlerShowImage(data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS));
//                break;
//            case REQUEST_CLIP_IMAGE:
//                //mCallbak.hadnlerClipImage(Crop.getOutput(data));
//                break;
//            default:
//                break;
        }
    }


    public interface Callback{
        void handlerGetImage(List<String> resultList);
        void handlerShowImage(List<String> resultList);
        void hadnlerClipImage(String resultUrl);
    }
}
