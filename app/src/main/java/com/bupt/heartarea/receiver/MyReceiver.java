package com.bupt.heartarea.receiver;

import android.content.Context;
import android.content.Intent;

import com.bupt.heartarea.activity.MainQSActivity;
import com.today.step.lib.BaseClickBroadcast;

public class MyReceiver extends BaseClickBroadcast {

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent mainIntent = new Intent(context, MainQSActivity.class);
        mainIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(mainIntent);
    }
}
