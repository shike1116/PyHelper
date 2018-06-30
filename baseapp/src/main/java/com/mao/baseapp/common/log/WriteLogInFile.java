package com.mao.baseapp.common.log;

import android.text.TextUtils;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import com.mao.baseapp.common.utils.*;


public class WriteLogInFile {

    public static final String ENTER = "\r\n";
    private static final String SPLITE_STR = "-";
    private static final String LOG_FILE_NAME = "log.txt";

    public static void writeLog(final String module, String msg){
        if (TextUtils.isEmpty(msg)) {
            return;
        }
        File logFile = getLogFile(module);
        try {
            writeLog(logFile, msg);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static File getLogFile(final String module){
        String ymd = TimeUtils.getCurrentFormatYMD();
        String fileName = TextUtils.isEmpty(module)? (ymd +LOG_FILE_NAME ): (module + "_" + ymd + LOG_FILE_NAME);
        File logFile = new File(FileUtils.getLogPath() , fileName);
        return logFile;
    }

    private static void writeLog(File logFile, String msg) throws Exception{
        StringBuilder log = new StringBuilder();
        log.append(TimeUtils.getCurrentFormatHMSS());
        log.append(SPLITE_STR);
        log.append(msg);
        log.append(ENTER);
        saveLog(logFile, log.toString());
    }

    protected static void saveLog(File logFile, String result) {
        try {
            FileOutputStream fos = new FileOutputStream(logFile, true);
            InputStream is = new ByteArrayInputStream(result.getBytes());
            LogFileHandler.clearInvalid();
            FileUtils.saveFile(is, fos);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

