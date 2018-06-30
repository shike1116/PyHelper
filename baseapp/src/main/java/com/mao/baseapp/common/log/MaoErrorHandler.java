package com.mao.baseapp.common.log;

import android.util.Log;


import com.mao.baseapp.MaoConfig;
import com.mao.baseapp.common.utils.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class MaoErrorHandler implements Thread.UncaughtExceptionHandler{

    private static final String TAG = "MaoErrorHandler";

    public MaoErrorHandler(){
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {

        ByteArrayOutputStream baos = null;
        PrintStream printStream = null;
        String info = "";
        try {
            baos = new ByteArrayOutputStream();
            printStream = new PrintStream(baos);
            ex.printStackTrace(printStream);
            byte[] data = baos.toByteArray();
            info = new String(data);
        } catch (Exception e) {
            LogCore.i(TAG, Log.getStackTraceString(e));
        } finally {
            try {
                if (printStream != null) {
                    printStream.close();
                }
                if (baos != null) {
                    baos.close();
                }
            } catch (Exception e) {
                LogCore.i(TAG, Log.getStackTraceString(e));
            }
        }

        writeErrorLog(info);
        // 此处示例发生异常后，重新启动应用
        // 备注: 目前的情况是:不在MoaFragmentTabActivity界面崩溃会自动重启
        System.exit(0);
    }

    private void writeErrorLog(String errorMsg){
        StringBuilder log = new StringBuilder();
        log.append("============崩溃了============")
                .append(WriteLogInFile.ENTER);
        addLogAppInfo(log);
        log.append(errorMsg);
        log.append("==============================")
                .append(WriteLogInFile.ENTER);
        WriteLogInFile.saveLog(FileUtils.getUncaughtLogPath(),log.toString());
    }

    private void addLogAppInfo(StringBuilder strBuilder) {
        try{
            strBuilder.append("time:")
                    .append(TimeUtils.getCurrentFormatYMDHMSS())
                    .append(WriteLogInFile.ENTER);
            strBuilder.append("accout:")
                    .append(MaoConfig.getUserInfo())
                    .append(WriteLogInFile.ENTER);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
