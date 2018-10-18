package com.winklix.indu.gooni.buyerlogin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.winklix.indu.gooni.R;

public class BuyOTPActivity extends AppCompatActivity implements View.OnClickListener {

    Context context;
    Button otp_buy_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_otp);

        context = BuyOTPActivity.this;

        otp_buy_btn = findViewById(R.id.otp_buy_btn);
        otp_buy_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.otp_buy_btn)
        {
            context.startActivity(new Intent(context, BuyerCongratsActivity.class));
        }
    }
    }

