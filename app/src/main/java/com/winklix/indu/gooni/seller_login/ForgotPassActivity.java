package com.winklix.indu.gooni.seller_login;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.winklix.indu.gooni.R;

public class ForgotPassActivity extends AppCompatActivity implements View.OnClickListener {

    Context context;
    Button sel_fordet_pass_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);

        context = ForgotPassActivity.this;

        sel_fordet_pass_btn = findViewById(R.id.sel_fordet_pass_btn);
        sel_fordet_pass_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}
