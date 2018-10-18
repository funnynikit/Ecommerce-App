package com.winklix.indu.gooni.seller_login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.winklix.indu.gooni.R;

public class SellerRegisterActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_seller_register;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_register);

        this.context = SellerRegisterActivity.this;

        btn_seller_register = findViewById(R.id.btn_seller_register);
        btn_seller_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.btn_seller_register)
        {
            context.startActivity(new Intent(context, TermsAcceptActivity.class));
        }
    }



}
