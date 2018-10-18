package com.winklix.indu.gooni.seller_login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.winklix.indu.gooni.R;

public class TermsAcceptActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_seller_term;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_accept);

        context = TermsAcceptActivity.this;

        btn_seller_term = findViewById(R.id.btn_seller_term);
        btn_seller_term.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.btn_seller_term)
        {
            context.startActivity(new Intent(context, BusinessDetailActivity.class));
        }
    }


}
