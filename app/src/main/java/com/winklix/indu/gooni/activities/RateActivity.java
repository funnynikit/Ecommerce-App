package com.winklix.indu.gooni.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.winklix.indu.gooni.R;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;

public class RateActivity extends AppCompatActivity {
    MaterialRatingBar simpleRatingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        // ratingbar
        simpleRatingBar = (MaterialRatingBar) findViewById(R.id.ratingbar); // initiate a rating bar


    }

    public void onClick(View view) {
        Float ratingNumber = simpleRatingBar.getRating(); // get rating number from a rating bar

        Toast.makeText(getApplicationContext(), "You rated " + ratingNumber, Toast.LENGTH_LONG).show();


        finish();
    }
}
