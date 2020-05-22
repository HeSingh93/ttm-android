package com.example.conf_booking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.conf_booking.api.entities.TokenEntity;
import com.example.conf_booking.api.entities.UserEntity;
import com.example.conf_booking.api.retrofitservices.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Login extends AppCompatActivity {

    Button signUpBtn,
            loginBtn;

    EditText usernameTextEdit, passwordTextEdit;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signUpBtn = findViewById(R.id.signUp);
        loginBtn = findViewById(R.id.login);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, SignUp.class));
            }

        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginButtonPressed(view);
            }
        });

        usernameTextEdit = findViewById(R.id.username);
        passwordTextEdit = findViewById(R.id.password);


    }

    public void loginButtonPressed(final View view) {

        String userName = usernameTextEdit.getText().toString().trim();
        String password = passwordTextEdit.getText().toString().trim();

        UserEntity newUser = new UserEntity(userName, password);
        Call<TokenEntity> call = RetrofitHelper.getAPIService().login(newUser);

        call.enqueue(new Callback<TokenEntity>() {

            @Override
            public void onResponse(Call<TokenEntity> call, Response<TokenEntity> response) {
                TokenEntity body = response.body();

                if (body != null) {

                    Intent intent = new Intent(view.getContext(), MainMenu.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("Token", body);
                    startActivity(intent);
                }
                else {
                System.out.println("No token entity received, try again!");
                }

            }

            @Override
            public void onFailure(Call<TokenEntity> call, Throwable t) {
                //TODO Add error handling here
            }
        });

    }
}

