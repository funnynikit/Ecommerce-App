package com.winklix.indu.gooni.seller_login;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.winklix.indu.gooni.R;
import com.winklix.indu.gooni.activities.SellerDashBoardActivity;

public class SellerLoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txt_sel_signup,txt_forget_sel_pass;
    Context context;
    Dialog forget_pass_dialog;
    Button btn_seller_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_login);

        context = SellerLoginActivity.this;

        txt_sel_signup = findViewById(R.id.txt_sel_signup);
        txt_forget_sel_pass = findViewById(R.id.txt_forget_sel_pass);
        btn_seller_login = findViewById(R.id.btn_seller_login);

        txt_sel_signup.setOnClickListener(this);
        txt_forget_sel_pass.setOnClickListener(this);
        btn_seller_login.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.txt_sel_signup)
        {
            context.startActivity(new Intent(context, SellerRegisterActivity.class));
        }
        if (id == R.id.txt_forget_sel_pass)
        {
            context.startActivity(new Intent(context, ForgotPassActivity.class));
        }
        if (id == R.id.btn_seller_login)
        {
            //context.startActivity(new Intent(context, SellerRegisterActivity.class));

            context.startActivity(new Intent(context, SellerDashBoardActivity.class));
        }
    }

    private void showForgetPassDialog() {

        forget_pass_dialog = new Dialog(context);

        forget_pass_dialog.setContentView(R.layout.forgetpass_layout);
        forget_pass_dialog.setTitle("Forgot Password...");
        TextView forget_login_tv = forget_pass_dialog.findViewById(R.id.forget_login_tv);
        Button resend_pass_btn = forget_pass_dialog.findViewById(R.id.resend_pass_btn);
        forget_pass_dialog.setCanceledOnTouchOutside(false);
        resend_pass_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                context.startActivity(new Intent(context, SellerLoginActivity.class));

                forget_pass_dialog.dismiss();
            }

        });

        forget_login_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                context.startActivity(new Intent(context, SellerLoginActivity.class));

                forget_pass_dialog.dismiss();
            }

        });

        forget_pass_dialog.show();
    }}

