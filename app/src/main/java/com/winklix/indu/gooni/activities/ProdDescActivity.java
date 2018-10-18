package com.winklix.indu.gooni.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.winklix.indu.gooni.R;
import com.winklix.indu.gooni.imageslider.ChildAnimationExample;
import com.winklix.indu.gooni.imageslider.SliderLayout;

import java.util.HashMap;

public class ProdDescActivity extends AppCompatActivity implements View.OnClickListener , BaseSliderView.OnSliderClickListener {

    Context context;
    ImageView yellow1,yellow2,red2,red1,blue2,blue1,green2,green1,ic_back_img;

    ImageView plus,minus;
    TextView sizeno;
    RatingBar ratingbar;

    SliderLayout mDemoSlider;
    LinearLayout linear1,linear2, linear3, linear4, linear5, linear6;
    TextView  discription3, discription2, discription1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prod_desc);

        context = ProdDescActivity.this;

        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        sizeno =  findViewById(R.id.sizeno);


        //                ***********discription**********

        linear1 = (LinearLayout)findViewById(R.id.linear1);
        linear2 = (LinearLayout)findViewById(R.id.linear2);
        discription1 = (TextView)findViewById(R.id.discription1);
        ic_back_img = findViewById(R.id.ic_back_img);


        ic_back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                context.startActivity(new Intent(context,BuyerDashBoardActivity.class));

            }
        });

        linear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                linear2.setVisibility(View.VISIBLE);
                linear1.setVisibility(View.GONE);
                discription1.setVisibility(View.VISIBLE);

            }
        });

        linear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                linear2.setVisibility(View.GONE);
                linear1.setVisibility(View.VISIBLE);
                discription1.setVisibility(View.GONE);


            }
        });



//                ***********use and care**********

        linear3 = (LinearLayout)findViewById(R.id.linear3);
        linear4 = (LinearLayout)findViewById(R.id.linear4);
        discription2 = (TextView)findViewById(R.id.discription2);


        linear3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                linear4.setVisibility(View.VISIBLE);
                linear3.setVisibility(View.GONE);
                discription2.setVisibility(View.VISIBLE);

            }
        });

        linear4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                linear4.setVisibility(View.GONE);
                linear3.setVisibility(View.VISIBLE);
                discription2.setVisibility(View.GONE);


            }
        });



//                ***********design**********

        linear5 = (LinearLayout)findViewById(R.id.linear5);
        linear6 = (LinearLayout)findViewById(R.id.linear6);
        discription3 = (TextView)findViewById(R.id.discription3);


        linear5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                linear6.setVisibility(View.VISIBLE);
                linear5.setVisibility(View.GONE);
                discription3.setVisibility(View.VISIBLE);

            }
        });

        linear6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                linear6.setVisibility(View.GONE);
                linear5.setVisibility(View.VISIBLE);
                discription3.setVisibility(View.GONE);


            }
        });



//        fonts1 =  Typeface.createFromAsset(MainActivity.this.getAssets(),
//                "fonts/Lato-Light.ttf");
//
//
//
//        fonts2 =  Typeface.createFromAsset(MainActivity.this.getAssets(),
//                "fonts/Lato-Regular.ttf");
//
//
//        TextView t5 =(TextView)findViewById(R.id.title);
//        t5.setTypeface(fonts1);



//         ********Slider*********

        mDemoSlider = (SliderLayout)findViewById(R.id.slider);

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("1", R.drawable.prod);
        file_maps.put("2",R.drawable.prod);
        file_maps.put("3",R.drawable.prod);


        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    //  .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                    .setOnSliderClickListener(this);


            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new ChildAnimationExample());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);


    final int[] number = {0};
        sizeno.setText(""+ number[0]);

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (number[0] == 0){
                    sizeno.setText("" + number[0]);
                }

                if (number[0] > 0){

                    number[0] = number[0] -1;
                    sizeno.setText(""+ number[0]);
                }
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (number[0] == 9) {
                    sizeno.setText("" + number[0]);
                }

                if (number[0] < 9) {

                    number[0] = number[0] + 1;
                    sizeno.setText("" + number[0]);

                }
            }
        });

        ratingbar = (RatingBar) findViewById(R.id.ratingbar);
        LayerDrawable stars = (LayerDrawable) ratingbar.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);

        yellow1 = (ImageView)findViewById(R.id.yellow1);
        yellow2 = (ImageView)findViewById(R.id.yellow2);


        yellow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clickOfColor("1");


            }
        });

        red1 = (ImageView)findViewById(R.id.red1);
        red2 = (ImageView)findViewById(R.id.red2);


        red1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                clickOfColor("3");

            }
        });

        blue1 = (ImageView)findViewById(R.id.blue1);
        blue2 = (ImageView)findViewById(R.id.blue2);


        blue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                clickOfColor("4");

            }
        });


        //        ***********green color**********

        green1 = (ImageView)findViewById(R.id.green1);
        green2 = (ImageView)findViewById(R.id.green2);


        green1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                clickOfColor("2");

            }
        });


    }

    private void clickOfColor(String s) {

        yellow2.setVisibility(View.GONE);
        green2.setVisibility(View.GONE);
        blue2.setVisibility(View.GONE);
        red2.setVisibility(View.GONE);


        if(s.equalsIgnoreCase("1")){
            yellow2.setVisibility(View.VISIBLE);
        }

        if(s.equalsIgnoreCase("2")){
            green2.setVisibility(View.VISIBLE);
        }

        if(s.equalsIgnoreCase("3")){
            red2.setVisibility(View.VISIBLE);
        }
        if(s.equalsIgnoreCase("4")){
            blue2.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onClick(View v) {

        int id = v.getId();


    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }
}

