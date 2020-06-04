package com.mob.demo.mobpush;

import android.app.Application;

import com.mob.MobSDK;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        MobSDK.init(this,"moba6b6c6d6","b89d2427a3bc7ad1aea1e1e8c1d36bf3");


        MobSDK.submitPolicyGrantResult(true,null);

    }
}
