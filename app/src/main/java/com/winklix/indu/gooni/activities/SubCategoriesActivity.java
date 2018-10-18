package com.winklix.indu.gooni.activities;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.winklix.indu.gooni.R;
import com.winklix.indu.gooni.adapter.SubCategoriesAdapter;
import com.winklix.indu.gooni.helper.MySingleton;

import org.json.JSONObject;

public class SubCategoriesActivity extends AppCompatActivity{

    ListView recyclerView;
    String mypos;

    SubCategoriesAdapter subCategoriesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_categories);


      Bundle bun=getIntent().getExtras();
        if(bun!=null)
        {
            mypos= bun.getString("mypos");
           Log.e("RRR","myppo:"+mypos);
        }

        Log.e("RTAZM","sub cat:"+ MySingleton.getArralist_MenuItemsList().get(Integer.valueOf(mypos)).getSubCategory());

        recyclerView = (ListView) findViewById(R.id.subcategory_rv);
        subCategoriesAdapter=new SubCategoriesAdapter(this, MySingleton.getArralist_MenuItemsList().get(Integer.valueOf(mypos)).getSubCategory());
        recyclerView.setAdapter(subCategoriesAdapter);
    }

    public void onClickMethod(View view) {


        Intent intent = new Intent(SubCategoriesActivity.this, More_Prod_ListActivity.class);
        startActivity(intent);

    }



   /* public void getSubCategoriesData()
    {
        Boolean status=isNetworkAvailable();
        if(status==true)
        {
            // call api
            getSubCategoryData();
        }
        else
        {
            ///
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    public void getSubCategoryData()
    {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, App_Api.LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //  progressBar.setVisibility(View.GONE);
                        Log.e("test","server Res"+response);

                        try {

                            //converting response to json object
                            JSONObject obj = new JSONObject(response);

                            //if no error in response
                            if (obj.getString("response").equals("success")) {
                               *//* Intent intent1 = new Intent(context,HomeActivity.class);
                                startActivity(intent1);*//*

                                JSONObject userJson = obj.getJSONObject("data");

                                String UserId = userJson.getString("id");
                                String UserEmail=userJson.getString("email");

                                // callFirebaseLoginMethod(final String user, final String pass)


                                Log.e("test","ID:"+UserId);
                                Log.e("test","Email:"+UserEmail);
                                m_shared_pref.setPrefranceValue(App_Api.Id, UserId);


                                m_shared_pref.setPrefranceValue(App_Api.Email, UserEmail);
                                m_shared_pref.setPrefranceValue(App_Api.IsLoggedIn, true);


                                // Toast.makeText(context, obj.getString("message"), Toast.LENGTH_SHORT).show();


                            } else {
                                // Toast.makeText(context, obj.getString("message"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("email", login_email_str);
                params.put("password", login_pass_str);
                params.put("lat",String.valueOf(lat));
                params.put("lng",String.valueOf(lng));
                Log.e("test","Login Params:"+params);

                return params;
            }
        };

        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }*/
}
