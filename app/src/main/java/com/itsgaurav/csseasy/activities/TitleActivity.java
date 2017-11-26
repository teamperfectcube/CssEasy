package com.itsgaurav.csseasy.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.itsgaurav.csseasy.R;

public class TitleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(2000); //To pause the screen for 2 Seconds

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // To launch the index activity
                    Intent intent = new Intent(TitleActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();//to finish this activity
    }
}
