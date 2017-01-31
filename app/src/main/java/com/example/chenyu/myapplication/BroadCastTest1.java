package com.example.chenyu.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by chenyu on 2017/1/31.
 */

public class BroadCastTest1 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String nameMsg = intent.getStringExtra("name");
        Log.i(getClass().getSimpleName(), "name: " + nameMsg);
    }
}
