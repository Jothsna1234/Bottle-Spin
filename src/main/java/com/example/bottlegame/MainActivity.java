package com.example.bottlegame;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView bot;
    private Random rand = new Random();
    private int lstDr;
    private boolean spn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bot = findViewById(R.id.bottle);
    }

    // onClick function
    public void spinBottle(View v) {
        // check if the bottled has stopped spinning
        if (!spn) {

            // generate a random number from 1-1800
            int num = rand.nextInt(1800);

            // set the pivot to the centre of the image
            float pX = bot.getWidth() / 2;
            float pY = bot.getHeight() / 2;

            // pass parameters in RoatateAnimation function
            Animation rot = new RotateAnimation(lstDr, num, pX, pY);

            // set rotate duration 2500 millisecs
            rot.setDuration(2500);

            // rotation will persist after finishing
            rot.setFillAfter(true);
            rot.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spn = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spn = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });

            // change the last direction
            lstDr = num;

            // start the animation
            bot.startAnimation(rot);
        }
    }
}