package virajsule.com.arrowswiper;

public class GameLoop extends Thread {
    MyCanvas canvas;
    public GameLoop(MyCanvas canvas, int fps){
        this.canvas = canvas;
    }
    public void run(){
        while(true){
            canvas.animateLoop();
        }

    }
}
