package com.winklix.indu.gooni.buyerlogin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.winklix.indu.gooni.R;

public class BuyForgetPassActivity extends AppCompatActivity implements View.OnClickListener {

    Button buyforget_pass_btn;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_forget_pass);

        context = BuyForgetPassActivity.this;
        buyforget_pass_btn = findViewById(R.id.buyforget_pass_btn);
        buyforget_pass_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.txt_buy_signup)
        {
            context.startActivity(new Intent(context, BuyLoginActivity.class));
        }
    }
}
