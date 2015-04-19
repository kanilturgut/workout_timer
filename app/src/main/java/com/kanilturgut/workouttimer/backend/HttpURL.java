package com.kanilturgut.workouttimer.backend;

/**
 * Author   : kanilturgut
 * Date     : 20/06/14
 * Time     : 19:53
 */
public class HttpURL {

    public static final String domain = "http://workouttimer.herokuapp.com";

    public static final String ADD_NEW_WORKOUT = "/addWorkout";
    public static final String GET_ALL_WORKOUT = "/getAllWorkouts";
    public static final String DELETE_WORKOUT = "/deleteWorkout";

    public static String createURL(String url) {
        return domain + url;
    }
}
