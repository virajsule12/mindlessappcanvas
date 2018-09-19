package virajsule.com.arrowswiper;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private MyCanvas myCanvas;
    private Boolean created = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myCanvas = new MyCanvas(this);
//        myCanvas.setBackgroundColor(Color.BLUE);
        setContentView(myCanvas);


    }


}
