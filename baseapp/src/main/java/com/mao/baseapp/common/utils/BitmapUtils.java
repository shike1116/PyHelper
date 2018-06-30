package com.mao.baseapp.common.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class BitmapUtils {

    public static void standarCompressToCache(String srcImg){
        try{
            BitmapFactory.Options newOpts = new BitmapFactory.Options();
            newOpts.inJustDecodeBounds = false;
            newOpts.inPreferredConfig = Bitmap.Config.RGB_565;
            newOpts.inPurgeable = true;
            newOpts.inJustDecodeBounds = false;
            newOpts.inInputShareable = true;
            newOpts.inSampleSize = 8;//设置缩放比例
            Bitmap bitmap =  BitmapFactory.decodeStream(new FileInputStream(srcImg), null, newOpts);
        }catch (Exception e){

        }

    }
    public static class Rules{
        public int maxWidth;
        public int maxHeight;
        public int minWidth;
        public int minHeight;
        public int maxSize;
    }

    /**
     * 计算图片的缩放值
     */
    public static int calculateInSampleSize(BitmapFactory.Options options,
                                            int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            final int heightRatio = Math.round((float) height
                    / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        return inSampleSize;
    }
    /**
     * 根据路径获得突破并压缩返回bitmap用于显示
     */
    public static Bitmap compressBigBitmap(String filePath) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);
        options.inSampleSize = calculateInSampleSize(options, 720, 1280);
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inPurgeable = true;
        options.inJustDecodeBounds = false;
        options.inInputShareable = true;
        return BitmapFactory.decodeFile(filePath, options);
    }

    public static String compressImage(String filePath) {
        Bitmap bitmap = compressBigBitmap(filePath);
        String filename = "image" + System.currentTimeMillis()+".png";
        String newImagePath = FileUtils.initPath() + FileUtils.separator + filename ;
        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(newImagePath));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 60, bos);
            bos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != bos) {
                try {
                    bos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(bitmap != null && !bitmap.isRecycled()){
                // 回收并且置为null
                bitmap.recycle();
                bitmap = null;
            }
        }
        return newImagePath;
    }

    public static String saveImage(Bitmap bitmap) {
        String filename = "image" + System.currentTimeMillis()+".png";
        String newImagePath = FileUtils.initPath() + FileUtils.separator + filename ;
        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(newImagePath));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != bos) {
                try {
                    bos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(bitmap != null && !bitmap.isRecycled()){
                // 回收并且置为null
                bitmap.recycle();
                bitmap = null;
            }
        }
        return newImagePath;
    }

}
