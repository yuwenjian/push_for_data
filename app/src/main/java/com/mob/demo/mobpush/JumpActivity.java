package com.mob.demo.mobpush;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.mob.pushsdk.MobPush;
import com.mob.pushsdk.MobPushCustomMessage;
import com.mob.pushsdk.MobPushNotifyMessage;
import com.mob.pushsdk.MobPushReceiver;

public class JumpActivity extends AppCompatActivity {
    private static final String TAG = "JumpActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump);

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
    }
}
