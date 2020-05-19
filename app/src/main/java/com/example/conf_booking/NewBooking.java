package com.example.conf_booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class NewBooking extends AppCompatActivity {

    ViewFlipper v_flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_booking);

        int[] images = new int[]{R.drawable.gothenburg, R.drawable.stockholm, R.drawable.malmo, R.drawable.uppsala};
        v_flipper = findViewById(R.id.v_flipper);

        for (int image: images){ flipCity(image);}
    }

        public void flipCity(int image) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(image);

            v_flipper.addView(imageView);
            v_flipper.setFlipInterval(4000);
            v_flipper.setAutoStart(true);

            v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
            v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
        }
}
