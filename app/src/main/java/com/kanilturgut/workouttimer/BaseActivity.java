package com.kanilturgut.workouttimer;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Author   : kanilturgut
 * Date     : 19/04/15
 * Time     : 20:21
 */
public class BaseActivity extends ActionBarActivity{


    /**
     * To clear all activity on activity stack
     *
     * @param context source
     * @param clazz destination
     */
    public void cleanIntent(Context context, Class clazz) {
        Intent intent = new Intent(context, clazz);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    /**
     * For the api above LOLLIPOP, this code will change status bar color
     *
     * @param color id of color parameter (e.g R.color.woto_blue)
     */
    public void changeStatusBarColor(int color) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(color));
        }
    }
}
