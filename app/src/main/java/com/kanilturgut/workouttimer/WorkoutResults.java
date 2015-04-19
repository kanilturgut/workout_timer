package com.kanilturgut.workouttimer;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.kanilturgut.workouttimer.backend.HttpURL;
import com.kanilturgut.workouttimer.backend.Requests;
import com.kanilturgut.workouttimer.model.Workout;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;


public class WorkoutResults extends BaseActivity {

    private final String TAG = WorkoutResults.class.getSimpleName();
    private Context mContext = this;

    private EditText etCalorie, etDistance, etStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_results);
        changeStatusBarColor(R.color.approved_color);

        etCalorie = (EditText) findViewById(R.id.etCalorie);
        etDistance = (EditText) findViewById(R.id.etDistance);
        etStatus = (EditText) findViewById(R.id.etStatus);

        findViewById(R.id.bSend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String calorie = etCalorie.getText().toString().trim();
                String distance = etDistance.getText().toString().trim();
                String status = etStatus.getText().toString().trim();

                final Workout workout = new Workout();

                if (!calorie.equals(""))
                    workout.setCalorie(Double.parseDouble(calorie));

                if (!distance.equals(""))
                    workout.setDistance(Double.parseDouble(distance));

                if (!status.equals(""))
                    workout.setStatus(Integer.parseInt(status));

                if (calorie.equals("") || distance.equals("") || status.equals("")) {
                    Toast.makeText(mContext, "Empty field(s)", Toast.LENGTH_SHORT).show();

                    return;
                }

                new AsyncTask<Void, Void, String>() {

                    ProgressDialog mProgressDialog;

                    @Override
                    protected void onPreExecute() {
                        super.onPreExecute();

                        mProgressDialog = ProgressDialog.show(mContext,
                                "Please Wait",
                                "Your data is sending to server",
                                true,
                                false);
                    }

                    @Override
                    protected String doInBackground(Void... params) {

                        try {
                            HttpResponse httpResponse = Requests.post(HttpURL.ADD_NEW_WORKOUT, Workout.toJSON(workout).toString());

                            if (Requests.checkStatusCode(httpResponse, HttpStatus.SC_OK))
                                return Requests.readResponse(httpResponse);
                        } catch (IOException e) {
                            e.printStackTrace();
                            cancel(true);
                        }

                        return null;
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        super.onPostExecute(s);

                        mProgressDialog.dismiss();

                        if (s != null) {
                            try {
                                Workout workout = Workout.fromJSON(new JSONObject(s));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        Toast.makeText(mContext,
                                "Bitti", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    protected void onCancelled() {
                        super.onCancelled();

                        mProgressDialog.dismiss();
                    }
                }.execute();

            }
        });
    }
}
