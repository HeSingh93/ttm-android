package com.example.conf_booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.conf_booking.api.entities.GetCityEntity;
import com.example.conf_booking.api.entities.GetListCityEntity;
import com.example.conf_booking.api.retrofitservices.APIService;
import com.example.conf_booking.api.retrofitservices.RetrofitHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetCity extends AppCompatActivity {

    ListView resultListView;

    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_city);

        resultListView = findViewById(R.id.getresultLV);

        GetListCityEntity getListCityEntity = new GetListCityEntity();

        Call<List<GetListCityEntity>> call = RetrofitHelper.getAPIService().getCity();

        call.enqueue(new Callback<GetListCityEntity>() {

            @Override
            public void onResponse(Call<GetListCityEntity> call, Response<GetListCityEntity> response) {
                Intent intent = new Intent(resultListView.getContext(), GetCity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                adapter = new ArrayAdapter<GetListCityEntity>(
                        getBaseContext(),
                        android.R.layout.simple_list_item_1
                );

                resultListView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<GetListCityEntity> call, Throwable t) {

                System.out.println("ERRRRRROR, COME BACK WHEN YOU DOCTOR");

            }
        }
    }
}

