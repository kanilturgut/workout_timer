package com.kanilturgut.workouttimer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;

import com.kanilturgut.workouttimer.model.Pattern;
import com.kanilturgut.workouttimer.model.Workout;

import java.util.List;


public class MainActivity extends BaseActivity {

    Context context = this;
    Toolbar toolbar;

    List<Pattern> patternList;
    int counter = 0;
    int countdown = 0;

    Handler handler;
    Runnable runnable;

    TextView tvSet, tvType, tvTimer;
    ToneGenerator toneG;

    boolean isPlayed = false;
    MenuItem actionItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeStatusBarColor(R.color.main_red_color);
        setToolbar();

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        patternList = Pattern.getPatternList();
        countdown = patternList.get(0).getTime();

        tvSet = (TextView) findViewById(R.id.tvSet);
        tvType = (TextView) findViewById(R.id.tvType);
        tvTimer = (TextView) findViewById(R.id.tvTimer);

        toneG = new ToneGenerator(AudioManager.STREAM_ALARM, 100);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {

                tvTimer.setText(String.valueOf(countdown) + " sn");
                tvSet.setText("SET " + String.valueOf(patternList.get(counter).getSet()));

                if (patternList.get(counter).getWorkoutType() == Pattern.WORKOUT_TYPE_HIT_INTERVAL) {
                    tvType.setText("HIIT INTERVAL");
                    tvType.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                    toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    changeStatusBarColor(R.color.colorPrimaryDark);
                } else if (patternList.get(counter).getWorkoutType() == Pattern.WORKOUT_TYPE_RECOVERY) {
                    tvType.setText("RECOVERY");
                    tvType.setTextColor(getResources().getColor(R.color.dark_blue));
                    toolbar.setBackgroundColor(getResources().getColor(R.color.dark_blue));
                    changeStatusBarColor(R.color.dark_blue);
                } else if (patternList.get(counter).getWorkoutType() == Pattern.WORKOUT_TYPE_COOL_DOWN) {
                    tvType.setText("COOL DOWN");
                    tvType.setTextColor(getResources().getColor(R.color.main_green_color));
                    toolbar.setBackgroundColor(getResources().getColor(R.color.main_green_color));
                    changeStatusBarColor(R.color.main_green_color);
                } else if (patternList.get(counter).getWorkoutType() == Pattern.WORKOUT_TYPE_WARM_UP) {
                    tvType.setText("WARM UP");
                    tvType.setTextColor(getResources().getColor(R.color.main_green_color));
                    toolbar.setBackgroundColor(getResources().getColor(R.color.main_green_color));
                    changeStatusBarColor(R.color.main_green_color);
                }

                if (countdown < 3)
                    toneG.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD, 200);

                if (countdown == 0) {
                    counter++;

                    if (counter < patternList.size()) {
                        countdown = patternList.get(counter).getTime();
                        handler.postDelayed(runnable, 1000);
                    } else {
                        handler.removeCallbacks(runnable);
                        counter = 0;
                        countdown = patternList.get(0).getTime();
                        onOptionsItemSelected(actionItem);
                        toolbar.setBackgroundColor(getResources().getColor(R.color.main_red_color));

                        startActivity(new Intent(context, WorkoutResults.class));
                    }

                } else {
                    countdown--;
                    handler.postDelayed(runnable, 1000);
                }

            }
        };
    }

    private void setToolbar() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        TextView tvHeader = (TextView) findViewById(R.id.tvActionBarHeader);
        tvHeader.setText("WORKOUT");
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (handler != null)
            handler.removeCallbacks(runnable);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        actionItem = menu.findItem(R.id.menu_item_action);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menu_item_action) {
            if (!isPlayed) {
                item.setIcon(getResources().getDrawable(android.R.drawable.ic_media_pause));
                handler.postDelayed(runnable, 0);
                isPlayed = !isPlayed;
            } else {
                item.setIcon(getResources().getDrawable(android.R.drawable.ic_media_play));
                handler.removeCallbacks(runnable);
                isPlayed = !isPlayed;
            }

        }

        return super.onOptionsItemSelected(item);
    }

}
