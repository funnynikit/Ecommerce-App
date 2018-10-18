package com.winklix.indu.gooni.buyerlogin;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.winklix.indu.gooni.R;
import com.winklix.indu.gooni.api_details.GooniURL;
import com.winklix.indu.gooni.helper.AppHelper;
import com.winklix.indu.gooni.helper.MySingleton;

import java.util.HashMap;
import java.util.Map;

public class BuySignupActivity extends AppCompatActivity implements View.OnClickListener {

    Context context;
    Button btn_buy_register;
    EditText mLastName_edt, mFirstName_etd, mPhone_et, mPassword_et,
            mEmail_et, mState_et, mCity_et, mPincode_et,mAddress_et;
    private String mFirstName_Str;
    private String mLastName_Str;
    private String mPhone_Str;
    private String mPassword_Str;
    private String mEmail_Str;
    private String mState_Str;
    private String mCity_Str;
    private String mPincode_Str,mAddress_Str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_signup);

        context = BuySignupActivity.this;

        btn_buy_register = findViewById(R.id.btn_buy_register);

        mFirstName_etd = findViewById(R.id.buy_fname_et);
        mLastName_edt = findViewById(R.id.buy_lname_et);
        mPhone_et = findViewById(R.id.buy_phone_et);
        mPassword_et = findViewById(R.id.buy_password_et);
        mEmail_et = findViewById(R.id.buy_email_et);
        mState_et = findViewById(R.id.buy_state_et);
        mCity_et = findViewById(R.id.buy_city_et);
//        mPincode_et = findViewById(R.id.buy_pincode_et);
        mAddress_et = findViewById(R.id.buy_address_et);


        btn_buy_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.btn_buy_register) {
            mFirstName_Str=mFirstName_etd.getText().toString();
            mLastName_Str=mLastName_edt.getText().toString();
            mPhone_Str=mPhone_et.getText().toString();
            mPassword_Str=mPassword_et.getText().toString();
            mEmail_Str=mEmail_et.getText().toString();
            mState_Str=mState_et.getText().toString();
            mCity_Str=mCity_et.getText().toString();
//            mPincode_Str=mPincode_et.getText().toString();
            mAddress_Str=mAddress_et.getText().toString();
            buyerSignupWs("http://103.27.233.206:8080/goonidemo/Auth/register");
//calltest();
        }

    }

    private void buyerSignupWs(String mUrlString) {
        // Initialize a new StringRequest
        AppHelper.showProgressDialog(BuySignupActivity.this,"Please Wait...");
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                mUrlString,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Do something with response string
                        Log.e("responseP buyer>> ", response);

                        AppHelper.hideProgressDialog();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Do something when get error
//                        Snackbar.make(mCLayout,"Error...", Snackbar.LENGTH_LONG).show();
                        AppHelper.hideProgressDialog();

                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

//                params.put("fname", mFirstName_Str);
//                params.put("lname",mLastName_Str);
//                params.put("phoneno", mPhone_Str);
//                params.put("email", mEmail_Str);
//                params.put("password",mPassword_Str);
//                params.put("type", "user");
//                params.put("address",mAddress_Str);
//                params.put("city", mCity_Str);
//                params.put("statename", mState_Str);
//                params.put("pro_img", "");
//                params.put("email_verify", "0");
//                params.put("phone_verify", "0");

                params.put("fname", "sagar");
                params.put("lname","saxena");
                params.put("phoneno", "8800970633");
                params.put("email", "sagar@winklix.in");
                params.put("password","sagar123");
                params.put("type", "user");
                params.put("address","delhi");
                params.put("city", "noida");
                params.put("statename", "india");
                params.put("pro_img", "");
                params.put("email_verify", "0");
                params.put("phone_verify", "0");
                return super.getParams();
            }
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");
                return params;
            }
        };

        // Add StringRequest to the RequestQueue
        MySingleton.getInstance(context).addToRequestQueue(stringRequest);
    }

    public void calltest(){
        StringRequest sr = new StringRequest( Request.Method.POST,
                GooniURL.MENUITEMS, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("responseP test>> ", response);

                // valid response
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // error
                VolleyLog.d("Buyer", "Error: " + error.getMessage());


            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                // Removed this line if you dont need it or Use application/json
//                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }
        };
        MySingleton.getInstance(context).addToRequestQueue(sr);

    }

}
