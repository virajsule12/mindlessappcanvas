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
    private Activity activity;
    private long lastTime;
    private long endTime;


    public ArrowAnimator(float time, Rect r, Activity a, float duration){
        t = time;
        rect=r;
        activity = a;
        endTime = (long) duration;

    }

    public void run(){
        lastTime = System.currentTimeMillis();
        endTime += System.currentTimeMillis();
        while(true){
            if(System.currentTimeMillis() - lastTime >= t){
                lastTime = System.currentTimeMillis();
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        image.setY(image.getY()+5);
                        System.out.println(image.getY());
                    }
                });

            }
            if (System.currentTimeMillis()>= endTime){
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        image.setVisibility(View.INVISIBLE);
                    }
                });
                break;
            }

        }
    }
}
