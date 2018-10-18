package com.winklix.indu.gooni.seller_login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.winklix.indu.gooni.R;

public class SellerOTPActivity extends AppCompatActivity implements View.OnClickListener {

    Button otp_sel_btn;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_otp);

        context = SellerOTPActivity.this;

        otp_sel_btn = findViewById(R.id.otp_sel_btn);
        otp_sel_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.otp_sel_btn)
        {
            context.startActivity(new Intent(context, CongratsActivity.class));
        }}}

