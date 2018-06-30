package com.mao.baseapp.common.log;

import android.util.Log;

import com.google.gson.Gson;
import com.mao.baseapp.MaoConfig;
import com.mao.baseapp.common.thread.TreadCore;


public class LogCore {

    static final String LOG_CORE_FILE_NAME = LogCore.class.getName();

    static final String TAG = "LogCore";

    private static Gson gson = new Gson();
    public static void i(String tag, Object object){
        if(object == null){
            return;
        }
        i(null,tag,gson.toJson(object));
    }

    public static void i(String tag, String message){
        i(null,tag,message);
    }

    public static void i(String tag, Exception e){
        i(null, tag, Log.getStackTraceString(e));
    }
    public static void i(String tag, String message,Exception e){
        i(null, tag, message + " error = " + Log.getStackTraceString(e));
    }

    private static void i(final String module, String tag, String message) {
        if (message == null) {
            return;
        }
        if (MaoConfig.DEBUG) {
            Log.i(tag, message);
        }
        // 配置：是否显示文件名和行号
        boolean mShowLine = true;
        // 配置：是否显示线程号
        boolean mShowTid = true;

        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("->");
        String threadName = null;
        if (mShowTid) {
            try{
                Thread thread = Thread.currentThread();
                stringBuilder.append("[tid=").append(thread.getId()).append("] ");
                threadName = thread.getName();
            }catch (Exception e) {
                Log.i(TAG, Log.getStackTraceString(e)) ;
            }
        }
        stringBuilder.append(message);
        stringBuilder.append("\t").append("\t").append("[name=").append(threadName).append("]");

        if (mShowLine) {
            Throwable s = new Throwable();
            try {
                StackTraceElement[] stackTraceElements = s.getStackTrace();
                if(stackTraceElements != null && stackTraceElements.length > 0){
                    for(StackTraceElement ste : stackTraceElements){
                        if(ste == null){
                            continue;
                        }
                        String fileName = ste.getFileName();
                        String declaringClass = ste.getClassName();
                        if(fileName == null || declaringClass == null){
                            continue;
                        }
                        if(!LOG_CORE_FILE_NAME.equals(declaringClass)){
                            stringBuilder.append("{").append(fileName).append(":").append(ste.getMethodName()).append(":").append(ste.getLineNumber()).append("}");
                        }
                    }
                }
            }catch (Exception e) {
                Log.i(TAG, Log.getStackTraceString(e)) ;
            }
        }
        TreadCore.start(TreadCore.MODLE_LOG, new Runnable() {
            @Override
            public void run() {
                WriteLogInFile.writeLog(module,stringBuilder.toString());
            }
        });
    }

}
