package com.blogspot.shudiptotrafder.androidaio.manager;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.blogspot.shudiptotrafder.androidaio.R;

import java.util.Calendar;

public class AlarmManagerActivity extends AppCompatActivity {

    //todo post alarm manager

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_manager);

        alarmManager();
    }


    @SuppressLint("ObsoleteSdkInt")
    private void alarmManager(){

        Calendar calendar = Calendar.getInstance();
        int requestCode = 109;

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        Intent intent  = new Intent(this, AlarmReceiver.class);
        intent.setAction("myAlarmAction");

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, requestCode, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,
                    calendar.getTimeInMillis()+5000,
                    pendingIntent);

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            alarmManager.setExact(AlarmManager.RTC_WAKEUP,
                    calendar.getTimeInMillis()+2000,
                    pendingIntent);

        } else {
            alarmManager.set(AlarmManager.RTC_WAKEUP,
                    calendar.getTimeInMillis()+2000,
                    pendingIntent);

        }

        //if we are in android m then
        //we have to check

        //Use of REQUEST_IGNORE_BATTERY_OPTIMIZATIONS violates the Play Store

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//
//            PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
//
//            if (pm.isIgnoringBatteryOptimizations(getPackageName())){
//                Toast.makeText(this, "Ignored true", Toast.LENGTH_SHORT).show();
//
//            } else {
//                Intent intentsettings = new Intent();
//                String packageName = getPackageName();
//                PowerManager pm2 = (PowerManager) getSystemService(Context.POWER_SERVICE);
//                intent.setAction(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
//                intent.setData(Uri.parse("package:" + packageName));
//                startActivity(intentsettings);
//
//            }
//        }

    }

}
