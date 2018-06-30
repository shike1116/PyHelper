package com.mao.baseapp.common.log;

import android.util.Log;

import java.io.File;

import com.mao.baseapp.common.thread.TreadCore;
import com.mao.baseapp.common.utils.*;

public class LogFileHandler {
    private static long lastClearLogTime;
    private static final String TAG = "LogFileHandler";
    private static final long CLEAR_SPACE = 7*24 * 60*60*1000;
    //定时清理
    public static void clearInvalid(){

        if(System.currentTimeMillis() - lastClearLogTime > 24 * 60*60*1000){
            lastClearLogTime = System.currentTimeMillis();
            TreadCore.start(TreadCore.MODLE_CLEAR_LOG, new Runnable(){

                @Override
                public void run() {
                    try {
                        Log.i(TAG, "start clearInvalid");
                        File logFile = FileUtils.getLogPath();
                        if(logFile == null){
                            return;
                        }
                        File[] files = logFile.listFiles();
                        if(files == null){
                            return;
                        }
                        long currTime = System.currentTimeMillis();
                        for (File file : files) {
                            try {
                                if(file != null && currTime - file.lastModified() > CLEAR_SPACE){
                                    file.delete();

                                    Log.i(TAG, file.getAbsolutePath() + "has delete");
                                }
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });
        }
    }

}
