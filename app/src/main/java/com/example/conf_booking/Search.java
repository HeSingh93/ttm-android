package com.example.conf_booking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.SearchManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Intent;

import com.example.conf_booking.api.entities.SearchEntity;
import com.example.conf_booking.api.retrofitservices.RetrofitHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.POST;
import retrofit2.internal.EverythingIsNonNull;

public class Search extends AppCompatActivity {

    Button search;

    TextView resultsTextView;
    ListView resultsListView;

    EditText objectIdTextEdit,
            objectTypeTextEdit,
            fromDateTextEdit,
            toDateTextEdit;

   ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        objectIdTextEdit = findViewById(R.id.objectId);
        objectTypeTextEdit = findViewById(R.id.objectType);
        fromDateTextEdit = findViewById(R.id.fromDate);
        toDateTextEdit = findViewById(R.id.toDate);
        resultsListView = findViewById(R.id.resultsLV);

        search = findViewById(R.id.searchBtn);
        search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) { searchPressed(view);}
        });

    }

    public void searchPressed(final View view) {

        String objectId = objectIdTextEdit.getText().toString().trim();
        String objectType = objectTypeTextEdit.getText().toString().trim();
        String fromDate = fromDateTextEdit.getText().toString().trim();
        String toDate = toDateTextEdit.getText().toString().trim();

        SearchEntity newSearch = new SearchEntity(objectId,objectType,fromDate,toDate);

        Call<SearchEntity> call = RetrofitHelper.getAPIService().createSearch(newSearch);
        call.enqueue(new Callback<SearchEntity>() {

            @Override
            @EverythingIsNonNull
            public void onResponse(Call<SearchEntity> call, Response<SearchEntity> response) {
               SearchEntity body = response.body();
                System.out.println(response.toString());

              if(body != null){
                  Intent intent = new Intent(view.getContext(), Search.class);
                  intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                  intent.putExtra("Search", body);
                  List<String> list = new ArrayList<>();

                  list.add(body.toString());

                  adapter = new ArrayAdapter<String>(
                          getBaseContext(),
                          android.R.layout.simple_list_item_1,
                          list);

                  resultsListView.setAdapter(adapter);

                  System.out.println(body.toString());


              }else {
                  System.out.println("lol");
              }
            }


            @Override
            public void onFailure(Call<SearchEntity> call, Throwable t) {
                System.out.println("ERROR! WRONG! U SUCK!");
                t.printStackTrace();

            }
        });
    }
}
