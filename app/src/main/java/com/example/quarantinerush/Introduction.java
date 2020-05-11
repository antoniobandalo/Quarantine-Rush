package com.example.quarantinerush;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;

import static android.view.View.TEXT_ALIGNMENT_CENTER;

public class Introduction extends AppCompatActivity {

    private static int SPLASH_SCREEN_INT = 19000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Typewriter writer = new Typewriter(this);
        setContentView(writer);

        writer.setBackgroundColor(Color.parseColor("#000000"));
        writer.setAllCaps(true);
        writer.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        writer.setGravity(20);
        writer.setTextSize(40);
        writer.setTextColor(Color.parseColor("#FFFFFF"));
        writer.setCharacterDelay(150);
        writer.animateText("The year is 2020...\n A virus has broken out and put the world under quarantine. \n Will you be able to survive?");

        new Handler().postDelayed(new Runnable(){

            public void run(){
                Intent homeIntent = new Intent(Introduction.this, MainMenu.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_SCREEN_INT);
    }
}
