package com.example.quarantinerush;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import static com.example.quarantinerush.GameView.screenRatioX;
import static com.example.quarantinerush.GameView.screenRatioY;

public class MainCharacter {

    boolean jump = false;
    int x, y, width, height;
    Bitmap mainChar;

    MainCharacter(int screenY, Resources res) {

        mainChar = BitmapFactory.decodeResource(res, R.drawable.testchar);

        width = mainChar.getWidth();
        height = mainChar.getHeight();


        width *= (int) screenRatioX;
        height *= (int) screenRatioY;

        mainChar = Bitmap.createScaledBitmap(mainChar, width, height, false);

        y = screenY / 2;
        x = (int) (-300 * screenRatioX);

    }


    Bitmap getMainChar () {
        return mainChar;
    }
}
