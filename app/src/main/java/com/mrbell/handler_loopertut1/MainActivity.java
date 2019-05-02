package com.mrbell.handler_loopertut1;

import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.mrbell.handler_loopertut1.Handler_message.taskC;
import static com.mrbell.handler_loopertut1.Handler_message.taskD;

public class MainActivity extends AppCompatActivity {

    Button btn_start,btn_stop,btn_taskA,btn_taskB,btn_taskC,btn_taskD;
    CustomLooperthread looperthread =new CustomLooperthread();
    private static final String TAG = "MainActivity";
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start=findViewById(R.id.start);
        btn_stop=findViewById(R.id.stop);
        btn_taskA=findViewById(R.id.taskA);
        btn_taskB=findViewById(R.id.taskB);
        tv=findViewById(R.id.tv);
        btn_taskC=findViewById(R.id.taskC);
        btn_taskD=findViewById(R.id.taskD);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: thread is started");
                tv.setText("Thread is started");
                looperthread.start();
            }
        });

        btn_taskB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                looperthread.handler.post(new Runnable() {
                    @Override
                    public void run() {
                        for(int i =0;i<10;i++){
                            Log.d(TAG, "Runable object sent to looper=="+i);
                            tv.setText("task B: Runable object sent to looper==msgB"+i);
                            SystemClock.sleep(1000);
                        }
                    }
                });
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("Thread and message que is stoped");
                looperthread.looper.quit();
            }
        });

        btn_taskA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                looperthread.handler.post(new Runnable() {
                    @Override
                    public void run() {
                        for(int i =0;i<10;i++){
                            Log.d(TAG, "Runable object sent to looper=="+i);
                            tv.setText("task A: Runable object sent to looper==msgA"+i);
                            SystemClock.sleep(1000);
                        }
                    }
                });
            }
        });

        btn_taskC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message = Message.obtain();
                message.what=taskC;
                looperthread.handler.sendMessage(message);
            }
        });
        btn_taskD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message msg = Message.obtain();
                msg.what=taskD;
                looperthread.handler.sendMessage(msg);
            }
        });
    }
}
