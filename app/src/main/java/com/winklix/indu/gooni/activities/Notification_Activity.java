package com.winklix.indu.gooni.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.winklix.indu.gooni.R;
import com.winklix.indu.gooni.adapter.RecyclerAdapter;

import java.util.ArrayList;


public class Notification_Activity extends FragmentActivity implements View.OnClickListener {
ImageButton back_BtnHeader;
Intent intent;
TextView mEmptyView_Tv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_notification);

        back_BtnHeader=findViewById(R.id.btn_back_header);
        back_BtnHeader.setOnClickListener(this);



        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Online Sale Shopping of up to 70% Off on Fashion");
        arrayList.add("Buy New Shirts Now !");
        arrayList.add("Upcoming Deal");
        arrayList.add("Every Hour UpTo 80% OFF");
        arrayList.add("30% Off on Fashion");
        arrayList.add("Buy One Get One Free !");
        arrayList.add("Deal Comming soon");
        arrayList.add("Every Hour UpTo 80% OFF");


        RecyclerView recyclerViewNotificationList = findViewById(R.id.recycler_notification);
        mEmptyView_Tv = (TextView)findViewById(R.id.empty_view);


        recyclerViewNotificationList.setLayoutManager(new LinearLayoutManager(this));




        RecyclerAdapter adapter = new RecyclerAdapter(this, arrayList);

        if (arrayList.isEmpty()) {
            recyclerViewNotificationList.setVisibility(View.GONE);
            mEmptyView_Tv.setVisibility(View.VISIBLE);
        }
        else {
            recyclerViewNotificationList.setVisibility(View.VISIBLE);
            mEmptyView_Tv.setVisibility(View.GONE);
            recyclerViewNotificationList.setAdapter(adapter);

        }

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back_header:
                 intent=new Intent(this,BuyerDashBoardActivity.class);
                 startActivity(intent);
                 finish();
                 break;



        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        intent=new Intent(this,BuyerDashBoardActivity.class);
        startActivity(intent);
        finish();
    }
}
