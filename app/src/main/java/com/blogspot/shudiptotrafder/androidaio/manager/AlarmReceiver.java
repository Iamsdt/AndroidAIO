package com.blogspot.shudiptotrafder.androidaio.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Shudipto on 6/23/2017.
 */

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //with action
        if (intent.getAction().equalsIgnoreCase("myAlarmAction")){
            Toast.makeText(context, "Alarm work with string", Toast.LENGTH_SHORT).show();
        }

//        //with request code
//        if (intent.getExtras().getInt("requestCode") == 109){
//            Toast.makeText(context, "Alarm work with request code", Toast.LENGTH_SHORT).show();
//        }

    }
}
