package com.winklix.indu.gooni.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.winklix.indu.gooni.R;
import com.winklix.indu.gooni.adapter.More_ProdAdapter;
import com.winklix.indu.gooni.api_details.GooniURL;
import com.winklix.indu.gooni.helper.AppHelper;
import com.winklix.indu.gooni.helper.MySingleton;
import com.winklix.indu.gooni.modals.Category;
import com.winklix.indu.gooni.modals.DataList;
import com.winklix.indu.gooni.modals.MoreProdModel;
import com.winklix.indu.gooni.modals.SubCategory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class More_Prod_ListActivity extends AppCompatActivity
{

    private final String TAG = "More_Prod_ListActivity";


//    private final Integer[] offer_img = {R.drawable.logocarrt, R.drawable.logocarrt, R.drawable.logocarrt, R.drawable.logocarrt, R.drawable.logocarrt, R.drawable.logocarrt,
//            R.drawable.logocarrt, R.drawable.logocarrt};
//
//    private final String offer_name[] = {
//            "Men", "Women", "Electronics", "Baby & Kids", "Appliance", "Gifts & More", "Mobile", "Mobile Accessories"
//    };

    RecyclerView more_prod_rv;
    More_ProdAdapter more_prodAdapter;
    LinearLayoutManager layoutManager;
    private ArrayList<Category> arralist_MenuItemsList=MySingleton.getArralist_MenuItemsList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more__prod__list);
        menuItems(GooniURL.MENUITEMS);
        if(MySingleton.getArralist_MenuItemsList().size()!=0)
        {
            MySingleton.getArralist_MenuItemsList().clear();
        }
//        offerViews();

        more_prod_rv = (RecyclerView) findViewById(R.id.more_prod_rv);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        more_prod_rv.setLayoutManager(layoutManager);
       // arralist_MenuItemsList = new ArrayList<Category>();

    }

    private void offerViews() {
        more_prod_rv.setHasFixedSize(true);

//        ArrayList androidVersion = offerData();
//        more_prod_rv.setAdapter(more_prodAdapter);
    }

//    private ArrayList offerData() {
//
//        ArrayList mpre_prod_data = new ArrayList<>();
//        for (int i = 0; i < offer_img.length; i++) {
//            MoreProdModel moreProdModel = new MoreProdModel();
//            moreProdModel.setCat_img(offer_img[i]);
//            moreProdModel.setCat_name(offer_name[i]);
//            mpre_prod_data.add(moreProdModel);
//        }
//        return mpre_prod_data;
//
//    }


    private void menuItems(String mUrlString) {
        // Initialize a new StringRequest
        AppHelper.showProgressDialog(More_Prod_ListActivity.this, "Please Wait...");
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                mUrlString,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        // Do something with response string
                        Log.e("responseP More>> ", response);
//

                        try
                        {
                            JSONObject object = new JSONObject(response);
                            String status = object.optString("status");
                            Log.e("HTR","RES:"+status);
                                JSONArray array = object.getJSONArray("result");
                                for (int i = 0; i < array.length(); i++)
                                {
                                    Category category=new Category();

                                    JSONObject object1 = array.getJSONObject(i);
                                    JSONObject categoryName = object1.getJSONObject("category");

                                    String cname = categoryName.optString("cname");
                                    String id=categoryName.optString("id");
                                    category.setCname(cname);
                                    Log.e("HTR","C Name::"+cname);
                                    category.setId(id);
                                    category.setcImage("https://media.glamour.com/photos/56958a29085ae0a85037423c/master/w_1600,c_limit/fashion-blogs-slaves-to-fashion-2009-05-08-0507shopping-habits_fa.jpg");
                                    JSONArray subcategoryArray=categoryName.getJSONArray("sub_category");
                                    final int len=subcategoryArray.length();
                                    ArrayList<SubCategory> subCategoriesList = null;
                                    subCategoriesList=new ArrayList<>();
                                    for(int j=0;j<len;j++)
                                    {

                                        JSONObject subcategoryJSONObject=(JSONObject) subcategoryArray.get(j);
                                        SubCategory subCategory=new SubCategory();
                                        String cat_id=subcategoryJSONObject.getString("cat_id");
                                        String s_name=subcategoryJSONObject.getString("s_name");
                                        String img=subcategoryJSONObject.getString("s_image");
                                        Log.e("HTR","cat id:"+cat_id);
                                        Log.e("HTR","s cat name:"+s_name);
                                       // Log.e("HTR","RES:"+img);


                                        subCategory.setCatId(cat_id);
                                        subCategory.setSName(s_name);
                                        subCategoriesList.add(subCategory);

                                    }
                                    category.setSubCategory(subCategoriesList);
                                   // moreProdModel.setCat_img("https://media.glamour.com/photos/56958a29085ae0a85037423c/master/w_1600,c_limit/fashion-blogs-slaves-to-fashion-2009-05-08-0507shopping-habits_fa.jpg");



                                    Log.e("categoryName: ", cname.toString());
                                    arralist_MenuItemsList.add(category);
                                    Log.e("HTR","size of list:"+arralist_MenuItemsList.size());



                                more_prodAdapter = new More_ProdAdapter(getApplicationContext(), arralist_MenuItemsList);
                                more_prod_rv.setAdapter(more_prodAdapter);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }




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
        MySingleton.getInstance(More_Prod_ListActivity.this).addToRequestQueue(stringRequest);
    }


    public void onClick(View view) {


        Intent intent = new Intent(More_Prod_ListActivity.this, BuyerDashBoardActivity.class);
        startActivity(intent);

    }
}
