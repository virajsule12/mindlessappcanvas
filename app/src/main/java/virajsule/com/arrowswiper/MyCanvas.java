package virajsule.com.arrowswiper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.CountDownTimer;
import android.provider.ContactsContract;
import android.support.constraint.solver.widgets.Rectangle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import java.util.ArrayList;

public class MyCanvas extends View{

    Paint paint;
    Rect rect;
    private ArrayList<Bitmap> arrows = new ArrayList<>();
    private ArrayList<Bitmap> movingArrows= new ArrayList<>();
    private ArrayList<ImageView> arrowsImg = new ArrayList<>();
    private ArrayList<ImageView> movingArrowsImg = new ArrayList<>();
    private ArrayList<Float> arrowsx = new ArrayList<>();
    private ImageView left, right, down, up,temp;

    private Bitmap line;
    private boolean continueGame=true;
    private float lineTop,lineBottom;

    public MyCanvas(Context context){
        super(context);
        paint = new Paint();
        rect = new Rect();
        arrows.add(BitmapFactory.decodeResource(getResources(), R.drawable.left));
        arrows.add(BitmapFactory.decodeResource(getResources(), R.drawable.right));
        arrows.add(BitmapFactory.decodeResource(getResources(), R.drawable.down));
        arrows.add(BitmapFactory.decodeResource(getResources(), R.drawable.up));
        line = BitmapFactory.decodeResource(getResources(), R.drawable.line);



    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        arrowsx.add(50f);
        arrowsx.add(325f);
        arrowsx.add((float)canvas.getWidth()-300-arrows.get(3).getWidth());
        arrowsx.add((float)canvas.getWidth()-50-arrows.get(3).getWidth());
        lineTop = canvas.getHeight()/2-100;
        lineBottom = line.getHeight()+ lineTop;
        canvas.drawColor(Color.rgb(158,166,255));

//        paint.setColor(Color.BLACK);
//        paint.setStrokeWidth(3);

//        canvas.drawRect(10,10, canvas.getWidth()/4,canvas.getHeight()/4,paint);
        canvas.drawBitmap(arrows.get(0), arrowsx.get(0), canvas.getHeight()/2, null);
        canvas.drawBitmap(arrows.get(1), arrowsx.get(1), canvas.getHeight()/2, null);
        canvas.drawBitmap(arrows.get(2), arrowsx.get(2), canvas.getHeight()/2, null);
        canvas.drawBitmap(arrows.get(3), arrowsx.get(3), canvas.getHeight()/2, null);
        canvas.drawBitmap(line, 0, canvas.getHeight()/2-100, null);
        createArrows(canvas);


    }

    public void createArrows(Canvas canvas){
        if (continueGame){
            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(3);
            int arrowNum = (int) Math.floor(Math.random()*4);
            rect = new Rect();


            final Rect r = new Rect(50,10, 240, 200);
            canvas.drawRect(r,paint);

            new CountDownTimer(3000, 100) {

                public void onTick(long millisUntilFinished) {
                    r.bottom+=100;
                }

                public void onFinish() {

                }
            }.start();
//            canvas.drawRect(arrowsx.get(arrowNum),10f,arrowsx.get(arrowNum)+190f,190f,paint);

//            canvas.drawBitmap(arrows.get(arrowNum), arrowsx.get(arrowNum), 0, null);
//            animate();


        }

    }

    public void animateArrows(){


    }




}
