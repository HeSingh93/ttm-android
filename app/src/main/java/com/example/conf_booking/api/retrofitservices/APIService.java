package com.example.conf_booking.api.retrofitservices;

import com.example.conf_booking.GetCity;
import com.example.conf_booking.api.entities.GetCityEntity;
import com.example.conf_booking.api.entities.GetListCityEntity;
import com.example.conf_booking.api.entities.SearchEntity;
import com.example.conf_booking.api.entities.SearchResponseEntity;
import com.example.conf_booking.api.entities.TokenEntity;
import com.example.conf_booking.api.entities.UserEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface APIService {

    @POST("user/add/")
    Call<UserEntity> createUser(
            @Body UserEntity user);

    @POST("api-token-auth/")
    Call<TokenEntity> login(
            @Body UserEntity user);


    @POST("logout/")
    Call<String> logout(
            @Header("Token") String token);

    @POST("search/availability/period/v3")
    Call<SearchResponseEntity> createSearch(
            @Body SearchEntity search);


    @GET("/service/rest/city/")
    Call<List<GetListCityEntity>> getCity();
}


