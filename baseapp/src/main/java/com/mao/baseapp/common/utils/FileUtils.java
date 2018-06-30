package com.mao.baseapp.common.utils;

import android.os.Environment;

import com.mao.baseapp.MaoConfig;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class FileUtils {
    private static final int IO_BUFFER_SIZE = 8 * 1024;

    public static File getLogPath(){
        File file = new File(initPath() +separator+LOG_FOLDER_NAME);
        if (file != null && !file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static boolean saveFile(InputStream is, OutputStream os) {
        BufferedOutputStream out = null;
        BufferedInputStream in = null;

        try {
            in = new BufferedInputStream(is, IO_BUFFER_SIZE);
            out = new BufferedOutputStream(os, IO_BUFFER_SIZE);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            out.flush();
            return true;
        } catch (IOException ignore) {
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ignore) {
            }
        }
        return false;
    }


    public static final File parentPath = Environment.getExternalStorageDirectory();
    public static final String separator = File.separator;
    private static final String DST_FOLDER_NAME = MaoConfig.APP_NAME;

    private static final String LOG_FOLDER_NAME = "log";
    static String storagePath = "";
    public static String initPath() {
        if (storagePath.equals("")) {
            storagePath = parentPath.getAbsolutePath() + separator + DST_FOLDER_NAME;
            File f = new File(storagePath);
            if (f != null && !f.exists()) {
                f.mkdirs();
            }
        }
        return storagePath;
    }

    public static File getApkFiel(String fileName) {
        String path = initPath();
        return new File(path + separator +fileName);
    }

    public static File uplogPath = null;

    public static File getUncaughtLogPath(){
        if (uplogPath == null) {
            String uplogPathUrl = initPath() + separator +"UncaughtException.txt";
            uplogPath = new File(uplogPathUrl);
            if (!uplogPath.exists()) {
                try {
                    uplogPath.createNewFile();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return uplogPath;
    }
    /**
     * 将一个InputStream流转换成字符串
     *
     * @param is
     * @return
     */
    public static String toConvertString(InputStream is) {
        StringBuffer res = new StringBuffer();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader read = new BufferedReader(isr);
        try {
            String line;
            line = read.readLine();
            while (line != null) {
                res.append(line + "<br>");
                line = read.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != isr) {
                    isr.close();
                    isr = null;
                }
                if (null != read) {
                    read.close();
                    read = null;
                }
                if (null != is) {
                    is.close();
                    is = null;
                }
            } catch (Exception e) {
            }
        }
        return res.toString();
    }

}

