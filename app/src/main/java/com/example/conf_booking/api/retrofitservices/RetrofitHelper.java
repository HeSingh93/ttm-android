package com.example.conf_booking.api.retrofitservices;

import retrofit2.Retrofit;

/**
 * Class for creating Retrofit objects used to make API calls
 */
public class RetrofitHelper {

    private static final String BASE_URL = "http://dev-be.timetomeet.se/service/rest/";

    private static Retrofit getRetrofitBuild() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .build();
    }

    public static APIService getAPIService() {return getRetrofitBuild().create(APIService.class);}


}
