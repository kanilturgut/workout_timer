package com.kanilturgut.workouttimer.model;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

/**
 * Author   : kanilturgut
 * Date     : 12/01/15
 * Time     : 16:23
 */
public class Workout {

    static int STATUS_BAD = 0;
    static int STATUS_NORMAL = 1;
    static int STATUS_GOOD = 2;
    static int STATUS_PERFECT = 3;

    static int WORKOUT_TYPE_BEGINNER = 0;

    String id;
    Date date;
    double calorie;
    double distance;
    int status;
    int level;
    int type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getCalorie() {
        return calorie;
    }

    public void setCalorie(double calorie) {
        this.calorie = calorie;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getStatus() {
        return status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public static Workout fromJSON(JSONObject jsonObject) {

        Workout workout = new Workout();

        workout.setId(jsonObject.optString("_id"));
//        workout.setDate((Date) jsonObject.opt("date"));
        // TODO fix date
        workout.setCalorie(jsonObject.optDouble("calorie"));
        workout.setDistance(jsonObject.optDouble("distance"));
        workout.setStatus(jsonObject.optInt("status"));
        workout.setType(jsonObject.optInt("type"));
        workout.setLevel(jsonObject.optInt("level"));

        return workout;
    }

    public static JSONObject toJSON(Workout workout) {

        JSONObject params = new JSONObject();

        try {
            params.put("date", new Date());
            params.put("type", WORKOUT_TYPE_BEGINNER);
            params.put("calorie", workout.getCalorie());
            params.put("distance", workout.getDistance());
            params.put("status", workout.getStatus());
            params.put("level", workout.getLevel());

            return params;

        } catch (JSONException e) {
            Log.e("Workout", "JSONException", e);
            return null;
        }
    }
}
