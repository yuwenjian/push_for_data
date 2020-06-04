package com.mob.demo.mobpush;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.mob.pushsdk.MobPush;
import com.mob.pushsdk.MobPushCustomMessage;
import com.mob.pushsdk.MobPushNotifyMessage;
import com.mob.pushsdk.MobPushReceiver;

public class SplashActivity extends AppCompatActivity {
    private static final String TAG = "SplashActivity";
     private  Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        MobPush.addPushReceiver(new MobPushReceiver() {
            @Override
            public void onCustomMessageReceive(Context context, MobPushCustomMessage mobPushCustomMessage) {
                Log.e(TAG, "onCustomMessageReceive: "+ mobPushCustomMessage.toString() );
            }

            @Override
            public void onNotifyMessageReceive(Context context, MobPushNotifyMessage mobPushNotifyMessage) {
                Log.e(TAG, "onNotifyMessageReceive: "+ mobPushNotifyMessage.toString());
            }

            @Override
            public void onNotifyMessageOpenedReceive(Context context, MobPushNotifyMessage mobPushNotifyMessage) {
                Log.e(TAG, "onNotifyMessageOpenedReceive: "+ mobPushNotifyMessage.toString());

            }

            @Override
            public void onTagsCallback(Context context, String[] strings, int i, int i1) {
                Log.e(TAG, "onTagsCallback: "+ strings.toString());
            }

            @Override
            public void onAliasCallback(Context context, String s, int i, int i1) {
                Log.e(TAG, "onAliasCallback: "+s.toString());
            }

        });

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                jumpActivity();
            }
        },2000);

    }


   public void  jumpActivity(){
        startActivity(new Intent(this, MainActivity.class));
        finish();
   }

}
