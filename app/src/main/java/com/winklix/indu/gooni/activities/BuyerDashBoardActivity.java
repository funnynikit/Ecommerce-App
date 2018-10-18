package com.winklix.indu.gooni.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.winklix.indu.gooni.R;
import com.winklix.indu.gooni.adapter.Best_Sell_Adapter;
import com.winklix.indu.gooni.adapter.DealAdapter;
import com.winklix.indu.gooni.adapter.OfferAdapter;
import com.winklix.indu.gooni.imageslider.FlipperLayout;
import com.winklix.indu.gooni.imageslider.FlipperView;
import com.winklix.indu.gooni.modals.DealModel;
import com.winklix.indu.gooni.modals.OfferModel;
import com.winklix.indu.gooni.modals.SellingModel;
import com.winklix.indu.gooni.seller_login.SellerLoginActivity;

import java.util.ArrayList;

public class BuyerDashBoardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    FlipperLayout flipperLayout;
    LinearLayoutManager layoutManager;
    RecyclerView specialoffer_rv, deal_rv, bestselling_rv;
    OfferAdapter offerAdapter;
    DealAdapter dealAdapter;
    Best_Sell_Adapter best_sell_adapter;
    TextView sellon_tv;
    ImageView cat_list_img;
    Context context;
    Button dash_reg_btn, dash_login_btn, all_offer_btn, best_sell_btn;
    LinearLayout men_ll, women_ll, elec_ll, more_ll;

    private final int deal_img[] = {R.drawable.test_ic_dress, R.drawable.test_ic_dress, R.drawable.test_ic_dress, R.drawable.test_ic_dress, R.drawable.test_ic_dress,
            R.drawable.test_ic_dress, R.drawable.test_ic_dress, R.drawable.test_ic_dress, R.drawable.test_ic_dress, R.drawable.test_ic_dress, R.drawable.test_ic_dress, R.drawable.test_ic_dress,
    };

    private final String prod_name[] = {
            "Product Name", "Product Name", "Product Name", "Product Name", "Product Namexc", "Product Name", "Product Name",
            "Product Name", "Product Name", "Product Name", "Product Name", "Product Name"
    };

    /*private final String prod_prise[] = {
            "10% off", "10% off", "10% off", "10% off", "10% off", "10% off", "10% off", "10% off", "10% off", "10% off", "10% off", "10% off"
    };*/

    private final int best_sell_img[] = {
            R.drawable.test_ic_dress, R.drawable.test_ic_dress, R.drawable.test_ic_dress, R.drawable.test_ic_dress
    };

    private final String best_sell_name[] = {
            "Product Name", "Product Name", "Product Name", "Product Name"
    };
    private final String best_sell_prise[] = {
            "10%off", "20%off", "50%off", "55%off"
    };

    private final int offer_img[] = {
            R.drawable.test_ic_mendress, R.drawable.ic_women_fashion, R.drawable.test_ic_dress, R.drawable.ic_mobiles
    };

    private final String offer_name[] = {
            "Product Name", "Product Name", "Product Name", "Product Name"
    };
    private final String offer_prise[] = {
            "10%off", "20%off", "50%off", "55%off"
    };
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer_dash_board);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context = BuyerDashBoardActivity.this;

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);

        dash_reg_btn = header.findViewById(R.id.dash_reg_btn);
        dash_login_btn = header.findViewById(R.id.dash_login_btn);

        flipperLayout = (FlipperLayout) findViewById(R.id.flipper_layout);
        // sellon_tv = (TextView) findViewById(R.id.sellon_tv);
        cat_list_img = (ImageView) findViewById(R.id.cat_list_img);

        men_ll = findViewById(R.id.men_ll);
        women_ll = findViewById(R.id.women_ll);
        elec_ll = findViewById(R.id.elec_ll);
        more_ll = findViewById(R.id.more_ll);
        all_offer_btn = findViewById(R.id.all_offer_btn);
        best_sell_btn = findViewById(R.id.best_sell_btn);


        //sellon_tv.setOnClickListener(this);
        cat_list_img.setOnClickListener(this);
        dash_reg_btn.setOnClickListener(this);
        dash_login_btn.setOnClickListener(this);

        men_ll.setOnClickListener(this);
        women_ll.setOnClickListener(this);
        elec_ll.setOnClickListener(this);
        more_ll.setOnClickListener(this);
        all_offer_btn.setOnClickListener(this);
        best_sell_btn.setOnClickListener(this);


        setLayout();
        initViews();
        offerViews();
        BestSellingViews();

    }

    private void BestSellingViews() {

        bestselling_rv = findViewById(R.id.bestselling_rv);
        bestselling_rv.setHasFixedSize(true);
        bestselling_rv.setLayoutManager(new GridLayoutManager(this, 2));

        ArrayList sell_array = bestselData();
        Best_Sell_Adapter best_sell_adapter = new Best_Sell_Adapter(context, sell_array);
        bestselling_rv.setAdapter(best_sell_adapter);
    }

    private ArrayList bestselData() {

        ArrayList selling_data = new ArrayList<>();
        for (int i = 0; i < best_sell_img.length; i++) {
            SellingModel sellingModel = new SellingModel();
            sellingModel.setProd_img(best_sell_img[i]);
            sellingModel.setProd_name(best_sell_name[i]);
            sellingModel.setProd_prise(best_sell_prise[i]);
            selling_data.add(sellingModel);
        }
        return selling_data;

    }

    private void offerViews() {
        specialoffer_rv = (RecyclerView) findViewById(R.id.specialoffer_rv);
        specialoffer_rv.setHasFixedSize(true);
        specialoffer_rv.setLayoutManager(new GridLayoutManager(this, 2));

        ArrayList androidVersion = offerData();
        offerAdapter = new OfferAdapter(getApplicationContext(), androidVersion);
        specialoffer_rv.setAdapter(offerAdapter);
    }

    private ArrayList offerData() {

        ArrayList offer_data = new ArrayList<>();
        for (int i = 0; i < offer_img.length; i++) {
            OfferModel offerModel = new OfferModel();
            offerModel.setProd_img(offer_img[i]);
            offerModel.setProd_name(offer_name[i]);
            offerModel.setProd_prise(offer_prise[i]);
            offer_data.add(offerModel);
        }
        return offer_data;

    }


    private void initViews() {
        deal_rv = (RecyclerView) findViewById(R.id.deal_rv);
        deal_rv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(BuyerDashBoardActivity.this, LinearLayoutManager.HORIZONTAL, false);
        deal_rv.setLayoutManager(layoutManager);

        ArrayList androidVersions = prepareData();
        dealAdapter = new DealAdapter(getApplicationContext(), androidVersions);
        deal_rv.setAdapter(dealAdapter);

    }

    private ArrayList prepareData() {

        ArrayList deal_data = new ArrayList<>();
        for (int i = 0; i < deal_img.length; i++) {
            DealModel dealModel = new DealModel();
            dealModel.setProd_img(deal_img[i]);
            dealModel.setProd_name(prod_name[i]);
            // dealModel.setProd_prise(prod_prise[i]);
            deal_data.add(dealModel);
        }
        return deal_data;

    }

    private void setLayout() {
        String url[] = new String[]{

                "http://d23ul78pqg5rms.cloudfront.net/wp-content/uploads/2015/06/ezone-online-zero-margin-electronics-sale-6-11-2015.jpg",
                "https://marketplace.canva.com/MACb1T5UNSg/1/0/thumbnail_large/canva-black-white-sale-business-men%27s-fashion-facebook-cover-MACb1T5UNSg.jpg",
                "https://png.pngtree.com/thumb_back/fw800/back_pic/04/60/36/96586ca4c32a4b2.jpg",
                "https://cdn.pixabay.com/photo/2017/03/01/10/03/online-sales-2108028__340.jpg",
                "https://marketersmedia.com/wp-content/uploads/2014/11/coverpage-fb-500x190.png"};

        for (int i = 0; i < 5; i++) {
            FlipperView view = new FlipperView(this);
            view.setImageUrl(url[i]).setDescription("");
            flipperLayout.addFlipperView(view);
            view.setOnFlipperClickListener(new FlipperView.OnFlipperClickListener() {
                @Override
                public void onFlipperClick(FlipperView flipperView) {

                }
            });
        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_order) {
            // Handle the camera action
        } else if (id == R.id.nav_wishlist) {

        } else if (id == R.id.nav_notifi) {
            context.startActivity(new Intent(context, Notification_Activity.class));


        } else if (id == R.id.nav_catgry) {

            context.startActivity(new Intent(context, More_Prod_ListActivity.class));

        } else if (id == R.id.nav_profile) {
            context.startActivity(new Intent(context, Profile_Aciivity.class));

        } else if (id == R.id.nav_help) {

        } else if (id == R.id.nav_rate) {
            context.startActivity(new Intent(context, RateActivity.class));
        } else if (id == R.id.nav_sell) {
            context.startActivity(new Intent(context, SellerLoginActivity.class));

        }/*else if (id == R.id.nav_about) {

        }*/ else if (id == R.id.nav_contact) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

     /*   if (id == R.id.sellon_tv)
        {
            context.startActivity(new Intent(context, SellerLoginActivity.class));
        }
*/
        switch (view.getId()) {

            case R.id.cat_list_img:
                context.startActivity(new Intent(context, CategoryActivity.class));
                break;

            case R.id.dash_reg_btn:
                intent = new Intent(BuyerDashBoardActivity.this, BuyerSellerActivity.class);
                intent.putExtra("flag_buyer_seller", "signup");
                startActivity(intent);
                break;

            case R.id.dash_login_btn:
                intent = new Intent(BuyerDashBoardActivity.this, BuyerSellerActivity.class);
                intent.putExtra("flag_buyer_seller", "login");
                startActivity(intent);
                break;

            case R.id.men_ll:
                context.startActivity(new Intent(context, Product_ListActivity.class));
                break;
            case R.id.women_ll:
                context.startActivity(new Intent(context, Product_ListActivity.class));
                break;

            case R.id.elec_ll:
                context.startActivity(new Intent(context, Product_ListActivity.class));
                break;
            case R.id.more_ll:
                context.startActivity(new Intent(context, More_Prod_ListActivity.class));
                break;
            case R.id.all_offer_btn:
                context.startActivity(new Intent(context, Product_ListActivity.class));
                break;
            case R.id.best_sell_btn:
                context.startActivity(new Intent(context, Product_ListActivity.class));
                break;
        }
    }

}
