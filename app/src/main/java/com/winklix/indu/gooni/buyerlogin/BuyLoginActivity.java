package com.winklix.indu.gooni.buyerlogin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.winklix.indu.gooni.R;
import com.winklix.indu.gooni.activities.BuyerDashBoardActivity;

public class BuyLoginActivity extends AppCompatActivity implements View.OnClickListener {

    Context context;
    Button btn_buy_login;
    TextView txt_forget_buy_pass,txt_buy_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_login);

        context = BuyLoginActivity.this;

        btn_buy_login = findViewById(R.id.btn_buy_login);
        txt_forget_buy_pass = findViewById(R.id.txt_forget_buy_pass);
        txt_buy_signup = findViewById(R.id.txt_buy_signup);

        btn_buy_login.setOnClickListener(this);
        txt_forget_buy_pass.setOnClickListener(this);
        txt_buy_signup.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        if (id == R.id.btn_buy_login)
        {
            context.startActivity(new Intent(context, BuyerDashBoardActivity.class));
        }

        if (id == R.id.txt_forget_buy_pass)
        {
            context.startActivity(new Intent(context, BuyForgetPassActivity.class));
        }

        if (id == R.id.txt_buy_signup)
        {
            context.startActivity(new Intent(context, BuySignupActivity.class));
        }
    }
}
