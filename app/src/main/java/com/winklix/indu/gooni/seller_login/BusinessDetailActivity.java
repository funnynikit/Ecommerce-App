package com.winklix.indu.gooni.seller_login;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.winklix.indu.gooni.R;

public class BusinessDetailActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_seller_busines_reg;
    Context context;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_detail);

        context = BusinessDetailActivity.this;
        btn_seller_busines_reg = findViewById(R.id.btn_seller_busines_reg);
        btn_seller_busines_reg.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.btn_seller_busines_reg)
        {
            showVerifyDialog();
        }

    }

    private void showVerifyDialog() {

        dialog = new Dialog(context);

        dialog.setContentView(R.layout.verify_no_layout);
        dialog.setTitle("Account Verification ...");
        TextView click_tv = dialog.findViewById(R.id.click_tv);
        dialog.setCanceledOnTouchOutside(false);
        click_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                context.startActivity(new Intent(context, SellerOTPActivity.class));
                dialog.dismiss();
            }

        });

        dialog.show();
    }

    private void showOtpDialog() {

       final Dialog otp_dialog = new Dialog(context);

        otp_dialog.setContentView(R.layout.otp_layout);
        otp_dialog.setTitle("Enter OTP...");
        EditText otp_et = otp_dialog.findViewById(R.id.otp_et);
        Button verify_otp_btn = otp_dialog.findViewById(R.id.verify_otp_btn);
        otp_dialog.setCanceledOnTouchOutside(false);
        verify_otp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, CongratsActivity.class));
              //  Toast.makeText(context, "verify" + "", Toast.LENGTH_SHORT).show();
               // otp_dialog.dismiss();
            }});

        otp_dialog.show();
    }
    }




