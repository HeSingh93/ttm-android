package com.example.conf_booking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenu extends AppCompatActivity {

    ViewFlipper v_flipper;
    Button newBookingBtn, viewBookingBtn, myProfileBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        newBookingBtn = findViewById(R.id.newBooking);
        viewBookingBtn = findViewById(R.id.viewBooking);
        myProfileBtn = findViewById(R.id.myProfile);

        newBookingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, NewBooking.class));
            }
        });

        viewBookingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, ViewBooking.class));
            }
        });

        myProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( MainMenu.this, MyProfile.class));
            }
        });

        int[] images = new int[]{R.drawable.rum1, R.drawable.rum2, R.drawable.rum3, R.drawable.rum4};

        v_flipper = findViewById(R.id.v_flipper);

        for (int image : images) {
            flipImages(image);
        }


    }

    public void flipImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }

}
