package com.example.chenyu.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;

/**
 * Created by chenyu on 16/6/25.
 */
public class SecActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);
        //注意这里要有这句话，不然弹出的布局不是理想中的。
        getWindow().setLayout(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        findViewById(R.id.quit_btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.x = 0;
        params.height = 200;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.y = 0;

        this.getWindow().setAttributes(params);
    }
}
