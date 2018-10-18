package com.winklix.indu.gooni.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.winklix.indu.gooni.R;
import com.winklix.indu.gooni.adapter.ProductListAdapter;
import com.winklix.indu.gooni.modals.ProductListModel;

import java.util.ArrayList;

public class Product_ListActivity extends AppCompatActivity {

    LinearLayoutManager layoutManager;
    RecyclerView product_rv;
    ProductListAdapter productListAdapter;

    private final int product_img[] = {R.drawable.prod,R.drawable.prod,R.drawable.prod,R.drawable.prod,R.drawable.prod,
            R.drawable.prod,R.drawable.prod,R.drawable.prod};

    private final String product_name[] = {
            "Product Name", "Product Name", "Product Name", "Product Name", "Product Name", "Product Name", "Product Name", "Product Name"
    };

    private final String product_prise[] = {
            "20% off", "30% off", "40% off", "10% off","20% off.", "20% off", "20% off", "20% off"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product__list);

        productViews();
    }

    private void productViews() {
            product_rv = (RecyclerView)findViewById(R.id.product_rv);
            product_rv.setHasFixedSize(true);
            product_rv.setLayoutManager(new GridLayoutManager(this, 2));

            ArrayList androidVersion = offerData();
            productListAdapter = new ProductListAdapter(getApplicationContext(),androidVersion);
            product_rv.setAdapter(productListAdapter);
        }

    private ArrayList offerData() {

        ArrayList offer_data = new ArrayList<>();
        for (int i = 0; i < product_img.length; i++) {
            ProductListModel productListModel = new ProductListModel();
            productListModel.setProd_img(product_img[i]);
            productListModel.setProd_name(product_name[i]);
            productListModel.setProd_prise(product_prise[i]);
            offer_data.add(productListModel);
        }
        return offer_data;

    }

    public void onClick(View view) {

        finish();
    }
}

