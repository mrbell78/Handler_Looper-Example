package com.mrbell.handler_loopertut1;

import android.os.Message;
import android.util.Log;

import java.util.logging.Handler;

public class Handler_message extends android.os.Handler {
    public static final int taskC=1;
    public static final int taskD=2;
    private static final String TAG = "Handler_message";

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what){
            case taskC:
                for(int i=0;i<10;i++){
                    /*new MainActivity().tv.setText("Task C is excecution now==msgC"+i);*/
                    Log.d(TAG, "handleMessage: task c exceution now"+i);
                }
                break;
            case taskD:
                for(int i=0;i<10;i++){
                    /*new MainActivity().tv.setText("Task D is excecution now==msgD"+i);*/
                    Log.d(TAG, "handleMessage: task D exceution now"+i);
                }
                break;
        }
    }
}
