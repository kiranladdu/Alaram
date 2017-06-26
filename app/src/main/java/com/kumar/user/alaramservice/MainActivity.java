package com.kumar.user.alaramservice;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    PendingIntent pendingIntent;
    AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=new Intent(this,AlaramReciever.class);
        pendingIntent=PendingIntent.getBroadcast(this,0,intent,0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void startAlarm(View view) {

        alarmManager= (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        int interval=10000;
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), interval, pendingIntent);
        Toast.makeText(this, "Alarm SET", Toast.LENGTH_SHORT).show();

    }

    public void stopAlarm(View view) {
        if (alarmManager!=null){
            alarmManager.cancel(pendingIntent);
            Toast.makeText(this, "Alaram Canceled", Toast.LENGTH_SHORT).show();
        }
    }
}
