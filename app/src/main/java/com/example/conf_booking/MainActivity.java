package com.example.conf_booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        background.start();
    }

    /**
     * This method creates a Thread that has a delay of two seconds.
     * This helps us to create a splashscreen when the app is launched.
     */

    Thread background = new Thread() {
        public void run() {
            try {
                sleep(2000);

                Intent i = new Intent(getBaseContext(), MainMenu.class);
                startActivity(i);

                finish();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    };
}
