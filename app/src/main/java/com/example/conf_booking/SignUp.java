package com.example.conf_booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.conf_booking.api.entities.UserEntity;
import com.example.conf_booking.api.retrofitservices.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class SignUp extends AppCompatActivity {

    Button signUp;

    EditText firstNameTextEdit,
            lastNameTextEdit,
            userNameTextEdit,
            passwordTextEdit,
            emailTextEdit,
            phoneNumberTextEdit,
            orgNameTextEdit,
            orgNumberTextEdit,
            streetTextEdit,
            cityTextEdit,
            zipCodeTextEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signUp = findViewById(R.id.signUpUser);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUpButtonPressed(view);
            }
        });

        firstNameTextEdit = findViewById(R.id.firstName);
        lastNameTextEdit = findViewById(R.id.lastName);
        userNameTextEdit = findViewById(R.id.username);
        passwordTextEdit = findViewById(R.id.password);
        emailTextEdit = findViewById(R.id.email);
        phoneNumberTextEdit = findViewById(R.id.phoneNumber);
        orgNameTextEdit = findViewById(R.id.orgName);
        orgNumberTextEdit = findViewById(R.id.orgNumber);
        streetTextEdit = findViewById(R.id.street);
        cityTextEdit = findViewById(R.id.cityName);
        zipCodeTextEdit = findViewById(R.id.zipCode);
    }


    public void signUpButtonPressed(final View view) {

        UserEntity newUser = new UserEntity();


        newUser.setFirstName(firstNameTextEdit.getText().toString().trim());
        newUser.setLastName(lastNameTextEdit.getText().toString().trim());
        newUser.setUserName(userNameTextEdit.getText().toString().trim());
        newUser.setPassword(passwordTextEdit.getText().toString().trim());
        newUser.setEmail(emailTextEdit.getText().toString().trim());
        newUser.setPhoneNumber(phoneNumberTextEdit.getText().toString().trim());
        newUser.setOrgName(orgNameTextEdit.getText().toString().trim());
        newUser.setOrgNumber(orgNumberTextEdit.getText().toString().trim());
        newUser.setStreet(streetTextEdit.getText().toString().trim());
        newUser.setCityName(cityTextEdit.getText().toString().trim());
        newUser.setZipCode(cityTextEdit.getText().toString().trim());

        System.out.println(newUser.getStreet());


        Call<UserEntity> call = RetrofitHelper.getAPIService().createUser(newUser);

        call.enqueue(new Callback<UserEntity>() {

            @Override
            @EverythingIsNonNull
            public void onResponse(Call<UserEntity> call, Response<UserEntity> response) {
                UserEntity body = response.body();

                System.out.println(response.toString());

                if (body != null) {
                    Intent intent = new Intent(view.getContext(), Login.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("User", body);
                    startActivity(intent);
                } else {
                    //TODO Add error message
                }

            }

            @Override
            public void onFailure(Call<UserEntity> call, Throwable t) {

                System.out.println("asdf");

                t.printStackTrace();

            }
        });


    }
}
