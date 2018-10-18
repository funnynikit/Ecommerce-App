package com.winklix.indu.gooni;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.winklix.indu.gooni.activities.BuyerDashBoardActivity;

public class SplashScreen_Activity extends AppCompatActivity implements Animation.AnimationListener {

    Animation animFadeIn;
    LinearLayout linearLayout;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        context = SplashScreen_Activity.this;

        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);

        } else {
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }

        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.animation_fade_in);
        animFadeIn.setAnimationListener(this);
        linearLayout = (LinearLayout) findViewById(R.id.layout_linear);
        linearLayout.setVisibility(View.VISIBLE);
        linearLayout.startAnimation(animFadeIn);

    }

    @Override
    public void onBackPressed() {
        this.finish();
        super.onBackPressed();
    }

    @Override
    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        Intent intent = new Intent(context, BuyerDashBoardActivity.class);
//        Intent intent = new Intent(context, HomeDeshBoard.class);
        startActivity(intent);
        this.finish();
    }


    @Override
    public void onAnimationRepeat(Animation animation) {
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
    }

}
