package com.mao.baseapp.update.service;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.app.NotificationCompat;

import com.mao.baseapp.R;
import com.mao.baseapp.common.utils.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 *
 * Created by wjf on 16/5/28.
 */

public class UpdateService extends Service {

    private String mStUpdateTitle = "更新版本";
    private String mStUpdateText = "正在下载更新包";
    private String mStUpdateTextComple = "下载完成";
    private File mApkFile;
    private String mFileName = "new.apk";
    private String mDownLoadUrl;
    private NotificationManager mNotificationManager;
    private int NOTIFY_ID = 1;
    private final static int UPDATE_ERR = 0x0002;
    private final static int LOAD_COM = 0x0003;// 下载完成
    private Handler updateHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case LOAD_COM:
                    sendInfo(100, 2);
                    installAPK(Uri.fromFile(mApkFile));
                    stop();
                    break;
                case UPDATE_ERR:
                    sendInfo(0, 1);
                    stop();
                    break;
                default:
                    break;
            }

        }

    };

    public void downloadPackage(final String loadurl) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mBuilder.setProgress(100, 0, false);
                    mBuilder.build();
                    mNotificationManager.notify(NOTIFY_ID, mBuilder.build());

                    URL url = new URL(loadurl);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.connect();
                    int notifylength = conn.getContentLength() / 10;
                    int notifyCount = 1;
                    InputStream is = conn.getInputStream();
                    if (mApkFile.exists()) {
                        mApkFile.delete();
                    }
                    FileOutputStream fos = new FileOutputStream(mApkFile);
                    int count = 0;
                    byte buf[] = new byte[50 * 1024];
                    do {
                        int numread = is.read(buf);
                        count += numread;
                        if (count > notifylength) {
                            count = count % notifylength;
                            sendInfo(10 * notifyCount, 0);
                            notifyCount++;

                        }

                        if (numread <= 0) {
                            updateHandler.sendEmptyMessage(LOAD_COM);
                            break;
                        }
                        fos.write(buf, 0, numread);
                    } while (true);
                    fos.close();
                    is.close();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    updateHandler.sendEmptyMessage(UPDATE_ERR);
                } catch (IOException e) {
                    e.printStackTrace();
                    updateHandler.sendEmptyMessage(UPDATE_ERR);
                }

            }
        }).start();
    }

    private void sendInfo(int downloadPgd, int downloadState) {
        switch (downloadState) {
            case 0:
                mBuilder.setProgress(100, downloadPgd, false);
                mBuilder.build();
                mNotificationManager.notify(NOTIFY_ID, mBuilder.build());
                break;
            case 1:
                mNotificationManager.cancel(NOTIFY_ID);
                break;
            case 2:
                mBuilder.setContentText(mStUpdateTextComple).setProgress(0, 0, false);
                mNotificationManager.notify(NOTIFY_ID, mBuilder.build());
                break;
            default:
                break;
        }

    }

    private void sendDownloadBroadcast(int downloadPgd, int downloadState) {
        Intent intent = new Intent();
        intent.setAction("com.heju.mibo.download");
        intent.putExtra("download_state", downloadState);
        intent.putExtra("download_pgd", downloadPgd);
        this.sendBroadcast(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle bundle = intent.getExtras();
        mDownLoadUrl = bundle.getString("url");
        downloadPackage(mDownLoadUrl);
        return START_NOT_STICKY;
    }

    private void installAPK(Uri apk) {

        // 通过Intent安装APK文件
        Intent intents = new Intent();
        intents.setAction("android.intent.action.VIEW");
        intents.addCategory("android.intent.category.DEFAULT");
        intents.setType("application/vnd.android.package-archive");
        intents.setData(apk);
        intents.setDataAndType(apk, "application/vnd.android.package-archive");
        intents.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intents);
        stop();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mNotificationManager = (NotificationManager) getSystemService(android.content.Context.NOTIFICATION_SERVICE);
        mApkFile = new File(FileUtils.initPath() +File.separator+ mFileName );
        setNewNotification();
    }

    private android.support.v4.app.NotificationCompat.Builder mBuilder;

    private void setNewNotification() {
        mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setContentTitle(mStUpdateTitle).setContentText(mStUpdateText)
                .setSmallIcon(R.drawable.img_load_empty);
        mNotificationManager.notify(NOTIFY_ID, mBuilder.build());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void stop() {
        stopSelf();
    }

}

