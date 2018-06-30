package com.mao.baseapp.common.thread;


public class TreadCore {

    public static final int MODLE_LOG = 1;
    public static final int MODLE_CLEAR_LOG = 2;
    public static void start(int model,Runnable runnable){
        //TODO
        new Thread(runnable).start();
    }
}
