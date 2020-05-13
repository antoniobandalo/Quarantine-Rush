package com.example.quarantinerush;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Runnable {

    private Thread thread;
    private boolean isPlaying;
    private int screenX, screenY;
    public static float screenRatioX, screenRatioY;
    private Paint paint;
    private MainCharacter mainChar;
    private Background background1, background2;
    private int curYspeed;

    public GameView(Context context, int screenX, int screenY) {
        super(context);

        this.screenX = screenX;
        this.screenY = screenY;
        screenRatioX = 1080f / screenX;
        screenRatioY = 1920f / screenY;

        background1 = new Background(screenX, screenY, getResources());
        background2 = new Background(screenX, screenY, getResources());

        mainChar = new MainCharacter(screenY, getResources());

        background2.x = screenX;

        paint = new Paint();

    }

    @Override
    public void run() {

        while(isPlaying) {

            update();
            draw();
            sleep();


        }
    }

    private void update(){

        background1.x -= 12 * screenRatioX;
        background2.x -= 12 * screenRatioX;

        if (background1.x + background1.background.getWidth() < 0) {
            background1.x = screenX;
        }

        if (background2.x + background2.background.getWidth() < 0) {
            background2.x = screenX;
        }

        if (mainChar.jump) {
            curYspeed = -34;
            mainChar.jump = false;
        }
        else {
            mainChar.y += curYspeed;
            curYspeed++;
        }

        if (mainChar.y < 0)
            mainChar.y = 0;

        if (mainChar.y > screenY - mainChar.height)
            mainChar.y = screenY - mainChar.height;
    }

    private void draw(){

        if (getHolder().getSurface().isValid()) {

            Canvas canvas = getHolder().lockCanvas();
            canvas.drawBitmap(background1.background, background1.x, background1.y, paint);
            canvas.drawBitmap(background2.background, background2.x, background2.y, paint);

            canvas.drawBitmap(mainChar.getMainChar(), mainChar.x, mainChar.y, paint);



            getHolder().unlockCanvasAndPost(canvas);
        }
    }

    private void sleep(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void resume(){

        isPlaying = true;
        thread = new Thread(this);
        thread.start();

    }

    public void pause(){

        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (event.getX() < screenX / 2){
                    mainChar.jump = true;
                }
                break;
            case MotionEvent.ACTION_UP:
                mainChar.jump = false;
                break;
        }
        return true;
    }
}
