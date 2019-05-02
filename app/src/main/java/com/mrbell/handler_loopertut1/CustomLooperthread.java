package com.mrbell.handler_loopertut1;


import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class CustomLooperthread extends Thread {
    public Handler handler;
    public Looper looper;
    private static final String TAG = "CustomLooperthread";
    @Override
    public void run() {
        Looper.prepare();
        looper=Looper.myLooper();
        handler=new Handler_message();
        Looper.loop();
        Log.d(TAG, "run: end of run method");
    }
}
