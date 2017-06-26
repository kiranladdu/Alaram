package com.kumar.user.alaramservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by User on 6/25/2017.
 */

public class AlaramReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context arg0, Intent intent) {

        Toast.makeText(arg0, "I'm running", Toast.LENGTH_LONG).show();
    }
}
