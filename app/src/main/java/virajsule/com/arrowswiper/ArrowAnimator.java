package virajsule.com.arrowswiper;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.Image;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class ArrowAnimator extends Thread {

    private float t;
    private Rect rect;
    private MyCanvas myCanvas;
    private long lastTime;
    private long endTime;


    public ArrowAnimator(float time, Rect r, MyCanvas mc, float duration){
        t = time;
        rect=r;
        myCanvas = mc;
        endTime = (long) duration;

    }


    private Runnable myRunnable = new Runnable() {
        @Override
        public void run() {
            rect.top+=5;
            rect.bottom+=5;
        }
    };

    private Runnable secondRunnable = new Runnable() {
        @Override
        public void run() {
            rect.setEmpty();
        }
    };


    public void run(){
        lastTime = System.currentTimeMillis();
        endTime += System.currentTimeMillis();
        while(true){
            if(System.currentTimeMillis() - lastTime >= t){
                lastTime = System.currentTimeMillis();
                myCanvas.postDelayed(myRunnable,500);

            }
            if (System.currentTimeMillis()>= endTime){
                myCanvas.postDelayed(secondRunnable,500);
//                activity.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        rect.setEmpty();
//                        image.setVisibility(View.INVISIBLE);
//                    }
//                });
                break;
            }

        }
    }
}
