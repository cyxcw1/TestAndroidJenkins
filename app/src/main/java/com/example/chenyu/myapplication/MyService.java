package com.example.chenyu.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.IServiceInterface;
import com.IServiceInterface.Stub;

/**
 * Created by chenyu on 2017/1/31.
 */

public class MyService extends Service {

    IServiceInterface.Stub mBinder = new Stub() {
        @Override
        public int plus(int a, int b) throws RemoteException {
            return a + b;
        }

        @Override
        public String toUpperCase(String str) throws RemoteException {
            if(str != null) {
                return str.toUpperCase();
            }
            return null;
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
}
