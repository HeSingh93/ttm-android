package com.example.conf_booking.api.retrofitservices;

import com.example.conf_booking.api.entities.TokenEntity;
import com.example.conf_booking.api.entities.UserEntity;

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


}


