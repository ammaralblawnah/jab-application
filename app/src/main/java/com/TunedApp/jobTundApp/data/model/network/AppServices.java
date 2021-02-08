package com.TunedApp.jobTundApp.data.model.network;

import com.TunedApp.jobTundApp.data.model.Utilites.utils;
import com.TunedApp.jobTundApp.data.model.rout.Routs;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppServices {

    private static final String BASE_URL= utils.ServerIp;
    private static Retrofit instance;
    private static Routs routes;
    private static int REQUEST_TIMEOUT=60;

    public static Retrofit getInestance(){
        if (instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }

    public static Routs routs(){
        if (routes == null) {
            routes = getInestance().create(Routs.class);
        }
        return routes;
    }

}
