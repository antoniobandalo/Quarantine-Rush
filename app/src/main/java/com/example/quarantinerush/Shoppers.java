package com.example.quarantinerush;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Shoppers {

    int x = 0, y, width, height, shopCounter = 1;
    Bitmap shopper1, shopper2, shopper3;

    Shoppers (int screenY, Resources res) {

        shopper1 = BitmapFactory.decodeResource(res, R.drawable.shopper1);
        shopper2 = BitmapFactory.decodeResource(res, R.drawable.shopper2);
        shopper3 = BitmapFactory.decodeResource(res, R.drawable.shopper3);

        width = shopper1.getWidth();
        height = shopper1.getHeight();

        Bitmap.createScaledBitmap(shopper1, width, height, false);
        Bitmap.createScaledBitmap(shopper2, width, height, false);
        Bitmap.createScaledBitmap(shopper3, width, height, false);

        y = screenY / 2;
        x = 200;

    }

    Bitmap getShopper(){

        if (shopCounter == 1){
            shopCounter++;
            return shopper1;
        }

        if (shopCounter == 2){
            shopCounter++;
            return shopper2;
        }

        shopCounter = 1;

        return shopper3;


    }
}
