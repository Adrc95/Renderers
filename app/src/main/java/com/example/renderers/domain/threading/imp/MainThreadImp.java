
package com.example.renderers.domain.threading.imp;

import android.os.Handler;
import android.os.Looper;

import com.example.renderers.domain.threading.MainThread;


/**
 * This class makes sure that the runnable we provide will be run on the main UI thread.
 */
public class MainThreadImp implements MainThread {

    private static MainThread sMainThread;

    private Handler mHandler;

    private MainThreadImp() {
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void post(Runnable runnable) {
        mHandler.post(runnable);
    }

    public static MainThread getInstance() {
        if (sMainThread == null) {
            sMainThread = new MainThreadImp();
        }

        return sMainThread;
    }
}
