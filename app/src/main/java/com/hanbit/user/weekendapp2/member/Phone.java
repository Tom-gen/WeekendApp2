package com.hanbit.user.weekendapp2.member;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;

/**
 * Created by 1027 on 2016-07-30.
 */
public class Phone {
    private Context context;
    private Activity activity;

    public Phone(Context context, Activity activity) {

        this.context = context;
        this.activity = activity;

    }

    public void dial(String phoneNo) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNo));
        context.startActivity(intent);
    }

    public void directCall(String phoneNo) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNo));

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CALL_PHONE}, 2);

            return;
        }
        context.startActivity(intent);
    }
}