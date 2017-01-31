package com.example.chenyu.myapplication;

import android.os.Message;
import android.util.Log;

import com.sm.State;
import com.sm.StateMachine;

/**
 * Created by chenyu on 2017/1/21.
 */

public class TestSm extends StateMachine {

    private static final String TAG = "TestSm";

    public static final int MSG_TO_FIRST = 1;
    public static final int MSG_FIRST_START = 2;
    private State mInitialState =  new InitialState();
    private State mFirstState = new FirstState();

    protected TestSm(String name) {
        super(name);
        addState(mInitialState);
        addState(mFirstState);
        setInitialState(mInitialState);
    }

    class InitialState extends BaseState {

        @Override
        public boolean processMessage(Message msg) {
            switch (msg.what){
                case MSG_TO_FIRST:
                    transitionTo(mFirstState);
                    return true;
            }
            return super.processMessage(msg);
        }
    }

    class FirstState extends BaseState {
        @Override
        public void enter() {
            super.enter();
            sendMessage(MSG_FIRST_START);
        }

        @Override
        public boolean processMessage(Message msg) {
            switch (msg.what) {
                case MSG_FIRST_START:
                    Log.i(TAG, "into MSG_FIRST_START");
                    return true;
            }
            return super.processMessage(msg);
        }
    }

    class BaseState extends State {
        @Override
        public void enter() {
            super.enter();
            Log.i(TAG, "enter: " + getClass().getSimpleName());
        }

        @Override
        public void exit() {
            super.exit();
            Log.i(TAG, "exit: " + getClass().getSimpleName());
        }
    }

}
