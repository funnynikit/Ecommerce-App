package com.winklix.indu.gooni.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.winklix.indu.gooni.R;
import com.winklix.indu.gooni.buyerlogin.BuyLoginActivity;
import com.winklix.indu.gooni.buyerlogin.BuySignupActivity;
import com.winklix.indu.gooni.seller_login.SellerLoginActivity;
import com.winklix.indu.gooni.seller_login.SellerRegisterActivity;

public class BuyerSellerActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_seller_login, btn_buyer_login;
    Context context;
    private String mFlag_Seller_Buyer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer_seller);

        context = BuyerSellerActivity.this;

        btn_seller_login = findViewById(R.id.btn_seller_login);
        btn_buyer_login = findViewById(R.id.btn_buyer_login);
        btn_seller_login.setOnClickListener(this);
        btn_buyer_login.setOnClickListener(this);

        mFlag_Seller_Buyer = getIntent().getStringExtra("flag_buyer_seller");


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btn_seller_login:
                if (mFlag_Seller_Buyer.equals("signup")) {
                    context.startActivity(new Intent(context, SellerRegisterActivity.class));
                } else {
                    context.startActivity(new Intent(context, SellerLoginActivity.class));
                }
                break;

            case R.id.btn_buyer_login:
                if (mFlag_Seller_Buyer.equals("signup")) {
                    context.startActivity(new Intent(context, BuySignupActivity.class));
                } else {
                    context.startActivity(new Intent(context, BuyLoginActivity.class));
                }
                break;
        }


    }
}
