package com.ericcode.auxtools.sample;

import android.app.Activity;
import android.os.Bundle;

import com.ericcode.auxtools.Logger;

public class MainActivity extends Activity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testLogger();
        testTimeCute();
    }

    private void testTimeCute() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Logger.TimeCut timeCut = new Logger.TimeCut();
                    Thread.sleep(100);
                    Logger.i(TAG, "testTimeCute:" + timeCut.goOn());
                    Thread.sleep(100);
                    Logger.i(TAG, "testTimeCute:" + timeCut.end());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void testLogger() {
        Logger.v(TAG, "test Logger begin");
        Logger.v(TAG, "testLogger %d", 1);
        Logger.d(TAG, "testLogger %d", 2);
        Logger.i(TAG, "testLogger %d", 3);
        Logger.w(TAG, "testLogger %d", 4);
        Logger.e(TAG, "testLogger %d", 5);
        Logger.v(TAG, "test Logger level begin");
        Logger.setLogLevel(Logger.LogLevel.D);
        Logger.v(TAG, "testLogger %d", 1);
        Logger.d(TAG, "testLogger %d", 2);
        Logger.i(TAG, "testLogger %d", 3);
        Logger.w(TAG, "testLogger %d", 4);
        Logger.e(TAG, "testLogger %d", 5);
        Logger.setLogLevel(Logger.LogLevel.I);
        Logger.v(TAG, "testLogger %d", 1);
        Logger.d(TAG, "testLogger %d", 2);
        Logger.i(TAG, "testLogger %d", 3);
        Logger.w(TAG, "testLogger %d", 4);
        Logger.e(TAG, "testLogger %d", 5);
        Logger.setLogLevel(Logger.LogLevel.W);
        Logger.v(TAG, "testLogger %d", 1);
        Logger.d(TAG, "testLogger %d", 2);
        Logger.i(TAG, "testLogger %d", 3);
        Logger.w(TAG, "testLogger %d", 4);
        Logger.e(TAG, "testLogger %d", 5);
        Logger.setLogLevel(Logger.LogLevel.E);
        Logger.v(TAG, "testLogger %d", 1);
        Logger.d(TAG, "testLogger %d", 2);
        Logger.i(TAG, "testLogger %d", 3);
        Logger.w(TAG, "testLogger %d", 4);
        Logger.e(TAG, "testLogger %d", 5);
        Logger.e(TAG, "test Logger level end");
        Logger.setLogLevel(Logger.LogLevel.V);

        Logger.v(TAG, "testLogger %d", 1);
        Logger.d(TAG, "testLogger %d", 2);
        Logger.i(TAG, "testLogger %d", 3);
        Logger.w(TAG, "testLogger %d", 4);
        Logger.e(TAG, "testLogger %d", 5);

        Logger.setPreTag("#_#");
        Logger.i(TAG, "testLogger set pre tag is #_#");
        Logger.setPreTag("^_^");

        Logger.printCaller(TAG);

        Logger.setEnable(false);
        Logger.v(TAG, "testLogger this line should dismiss");
        Logger.setEnable(true);

        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            Logger.printException(e);
        }
    }
}
