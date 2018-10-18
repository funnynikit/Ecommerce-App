package com.winklix.indu.gooni.seller_login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.winklix.indu.gooni.R;
import com.winklix.indu.gooni.activities.SellerDashBoardActivity;

public class CongratsActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_seller_continue;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrats);

        context = CongratsActivity.this;

        btn_seller_continue = findViewById(R.id.btn_seller_continue);
        btn_seller_continue.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.btn_seller_continue)
        {
            context.startActivity(new Intent(context, SellerDashBoardActivity.class));
           // Toast.makeText(context, " Coming Soon", Toast.LENGTH_SHORT).show();
        }
    }
}
