package com.example.conf_booking.api.retrofitservices;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Class for creating Retrofit objects used to make API calls
 */
public class RetrofitHelper {

    private static final String BASE_URL = "https://dev-be.timetomeet.se/service/rest/";

    private static Retrofit getRetrofitBuild() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static APIService getAPIService() {return getRetrofitBuild().create(APIService.class);}


}
