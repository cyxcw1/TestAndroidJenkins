package com.example.chenyu.myapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import com.IServiceInterface;

public class MainActivity extends AppCompatActivity {
    TestSm msm;

    BroadCastTest1 bCastTest1 = new BroadCastTest1();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msm = new TestSm("yunusTest");
        msm.start();
        findViewById(R.id.pop_btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent in = new Intent(MainActivity.this, SecActivity.class);
//                startActivity(in);
//                msm.sendMessage(MSG_TO_FIRST);
                Intent intent = new Intent();
                intent.setAction("com.example.chenyu.test.br");
                intent.putExtra("name", "static");
                sendBroadcast(intent);
            }
        });

        findViewById(R.id.dynamic_brcast_sent_btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.example.chenyu.test.br02");

                registerReceiver(bCastTest1, intentFilter);

                Intent intent = new Intent();
                intent.setAction("com.example.chenyu.test.br02");
                intent.putExtra("name", "dynamic");

                sendBroadcast(intent);

            }
        });

        findViewById(R.id.bind_service_btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bindIntent = new Intent("com.IServiceInterface");
                bindService(bindIntent, mConnection, BIND_AUTO_CREATE);
            }
        });
    }

    private IServiceInterface myAIDLService;
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myAIDLService = IServiceInterface.Stub.asInterface(service);

            int result = 0;
            try {
                result = myAIDLService.plus(3, 5);
                String upperStr = myAIDLService.toUpperCase("hello world");
                Log.d("TAG", "result is " + result);
                Log.d("TAG", "upperStr is " + upperStr);

            } catch (RemoteException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
}
