package virajsule.com.arrowswiper;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.CountDownTimer;
import android.provider.ContactsContract;
import android.support.constraint.solver.widgets.Rectangle;
import android.view.SurfaceView;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Timer;

public class MyCanvas extends View{

    Paint paint;
    Rect rect;
    private Canvas canvas;
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
        this.canvas = canvas;
        GameLoop l = new GameLoop(this, 1);
        l.start();


    }

    public void animateLoop(){
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

        System.out.println("hi");
    }


    public void paint(Canvas canvas, Rect rectangle) {
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(3);

        for(float i = 10; i<=500; i++){
            System.out.println(rectangle.top);
            float l = rectangle.left;
            float t = rectangle.top;
            float r = rectangle.width();
            float b = rectangle.height();
            rectangle.isEmpty();
            canvas.drawRect(l,t,r,b,paint);


        }
    }

    public void createArrows(final Canvas canvas){
        if (continueGame){
            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(3);
            int arrowNum = (int) Math.floor(Math.random()*4);
            Rect u = createRectangle(10, 10, 190, 190);
            canvas.drawRect(u,paint);
//
//            Rect r = new Rect(50,10, 240, 200);
//            canvas.drawRect(r,paint);



//            new CountDownTimer(2000, 100) {
//
//                public void onTick(long millisUntilFinished) {
//
//                }
//
//                public void onFinish() {
//                    System.out.println(lineBottom);
//
//                    while ((float)r.top<lineBottom){
//                        System.out.println(r.top);
//                        new CountDownTimer(500, 100) {
//
//                            public void onTick(long millisUntilFinished) {
//
//                            }
//
//                            public void onFinish() {
//                                r.top+=5;
//                                r.bottom+=5;
//                                canvas.drawRect(r,paint);
//
//                            }
//                        }.start();
//                    }
//
//                }
//            }.start();




//            System.out.println(r.left);
//            ArrowAnimator arrowAnimator = new ArrowAnimator(10f, r, this, 3000f);
//            arrowAnimator.start();
//            Path path = new Path();
//            path.lineTo(100,100);
//            ObjectAnimator.ofFloat(arrowsImg.get(0), 100f,100f, path).start();
//            ObjectAnimator.o

//            new CountDownTimer(3000, 100) {
//
//                public void onTick(long millisUntilFinished) {
//                    r.bottom+=100;
//                }
//
//                public void onFinish() {
//
//                }
//            }.start();
//            canvas.drawRect(arrowsx.get(arrowNum),10f,arrowsx.get(arrowNum)+190f,190f,paint);

//            canvas.drawBitmap(arrows.get(arrowNum), arrowsx.get(arrowNum), 0, null);
//            animate();


        }

    }

//    public void animateArrows(){
//
//
//    }

    private Rect createRectangle(int x, int y, int w, int h){
        return new Rect(x, y, x + w, y + h);
    }




}
