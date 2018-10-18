package com.winklix.indu.gooni.seller_login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.winklix.indu.gooni.R;

public class LoginRegisterActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_seller_reg,btn_seller_login;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);

        context =LoginRegisterActivity.this;

        btn_seller_reg = findViewById(R.id.btn_seller_reg);
        btn_seller_login = findViewById(R.id.btn_seller_login);

        btn_seller_reg.setOnClickListener(this);
        btn_seller_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.btn_seller_reg)
        {
            context.startActivity(new Intent(context, SellerRegisterActivity.class));
        }
        else
        if (id == R.id.btn_seller_login)
        {
            context.startActivity(new Intent(context, SellerLoginActivity.class));
        }
    }
}
