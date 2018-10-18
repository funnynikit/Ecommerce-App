package com.winklix.indu.gooni.buyerlogin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.winklix.indu.gooni.R;
import com.winklix.indu.gooni.activities.BuyerDashBoardActivity;

public class BuyerCongratsActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_buyer_continue;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer_congrats);

        context = BuyerCongratsActivity.this;

        btn_buyer_continue = findViewById(R.id.btn_buyer_continue);
        btn_buyer_continue.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.btn_buyer_continue)
        {
            context.startActivity(new Intent(context, BuyerDashBoardActivity.class));

        }
    }
}
