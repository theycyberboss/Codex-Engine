package codex.engine;
import codex.drivers.*;

public class Camera{

    private int x,y,maxWidth,maxHeight;
    public Camera(int x, int y,int maxWidth,int maxHeight){
        this.x = x;
        this.y = y;
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
    }

    public void updatePosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    private void clamp(){

    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}