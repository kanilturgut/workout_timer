package com.kanilturgut.workouttimer.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Author   : kanilturgut
 * Date     : 08/01/15
 * Time     : 21:11
 */
public class Pattern {

    public static int WORKOUT_TYPE_WARM_UP = 0;
    public static int WORKOUT_TYPE_HIT_INTERVAL = 1;
    public static int WORKOUT_TYPE_RECOVERY = 2;
    public static int WORKOUT_TYPE_COOL_DOWN = 3;

    int set;
    int workoutType;
    int time;

    public Pattern(int set, int workoutType, int time) {
        this.set = set;
        this.workoutType = workoutType;
        this.time = time;
    }

    public int getSet() {
        return set;
    }

    public void setSet(int set) {
        this.set = set;
    }

    public int getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(int workoutType) {
        this.workoutType = workoutType;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public static List<Pattern> getPatternList() {

        List<Pattern> patternList = new LinkedList<>();
        Pattern pattern;

        pattern = new Pattern(0, WORKOUT_TYPE_WARM_UP, 180);
        patternList.add(pattern);

        pattern = new Pattern(1, WORKOUT_TYPE_HIT_INTERVAL, 15);
        patternList.add(pattern);
        pattern = new Pattern(1, WORKOUT_TYPE_RECOVERY, 15);
        patternList.add(pattern);

        pattern = new Pattern(2, WORKOUT_TYPE_HIT_INTERVAL, 15);
        patternList.add(pattern);
        pattern = new Pattern(2, WORKOUT_TYPE_RECOVERY, 15);
        patternList.add(pattern);

        pattern = new Pattern(3, WORKOUT_TYPE_HIT_INTERVAL, 30);
        patternList.add(pattern);
        pattern = new Pattern(3, WORKOUT_TYPE_RECOVERY, 30);
        patternList.add(pattern);

        pattern = new Pattern(4, WORKOUT_TYPE_HIT_INTERVAL, 30);
        patternList.add(pattern);
        pattern = new Pattern(4, WORKOUT_TYPE_RECOVERY, 30);
        patternList.add(pattern);

        pattern = new Pattern(5, WORKOUT_TYPE_HIT_INTERVAL, 45);
        patternList.add(pattern);
        pattern = new Pattern(5, WORKOUT_TYPE_RECOVERY, 45);
        patternList.add(pattern);

        pattern = new Pattern(6, WORKOUT_TYPE_HIT_INTERVAL, 60);
        patternList.add(pattern);
        pattern = new Pattern(6, WORKOUT_TYPE_RECOVERY, 60);
        patternList.add(pattern);

        pattern = new Pattern(7, WORKOUT_TYPE_HIT_INTERVAL, 60);
        patternList.add(pattern);
        pattern = new Pattern(7, WORKOUT_TYPE_RECOVERY, 60);
        patternList.add(pattern);

        pattern = new Pattern(8, WORKOUT_TYPE_HIT_INTERVAL, 60);
        patternList.add(pattern);
        pattern = new Pattern(8, WORKOUT_TYPE_RECOVERY, 60);
        patternList.add(pattern);

        pattern = new Pattern(9, WORKOUT_TYPE_HIT_INTERVAL, 60);
        patternList.add(pattern);
        pattern = new Pattern(9, WORKOUT_TYPE_RECOVERY, 60);
        patternList.add(pattern);

        pattern = new Pattern(10, WORKOUT_TYPE_HIT_INTERVAL, 45);
        patternList.add(pattern);
        pattern = new Pattern(10, WORKOUT_TYPE_RECOVERY, 45);
        patternList.add(pattern);

        pattern = new Pattern(11, WORKOUT_TYPE_HIT_INTERVAL, 30);
        patternList.add(pattern);
        pattern = new Pattern(11, WORKOUT_TYPE_RECOVERY, 30);
        patternList.add(pattern);

        pattern = new Pattern(12, WORKOUT_TYPE_HIT_INTERVAL, 30);
        patternList.add(pattern);
        pattern = new Pattern(12, WORKOUT_TYPE_RECOVERY, 30);
        patternList.add(pattern);

        pattern = new Pattern(13, WORKOUT_TYPE_HIT_INTERVAL, 15);
        patternList.add(pattern);
        pattern = new Pattern(13, WORKOUT_TYPE_RECOVERY, 15);
        patternList.add(pattern);

        pattern = new Pattern(14, WORKOUT_TYPE_HIT_INTERVAL, 15);
        patternList.add(pattern);
        pattern = new Pattern(14, WORKOUT_TYPE_RECOVERY, 15);
        patternList.add(pattern);

        pattern = new Pattern(15, WORKOUT_TYPE_COOL_DOWN, 180);
        patternList.add(pattern);

        return patternList;
    }
}
