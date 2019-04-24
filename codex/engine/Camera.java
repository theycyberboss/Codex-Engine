package codex.engine;
import codex.drivers.*;
import java.io.*;

public class Camera implements Serializable{

    private int x,y,maxWidth,maxHeight,minWidth,minHeight, viewWidth, viewHeight;
    
    private int offSetX,offSetY;
    private static final long serialVersionUID = 1L;

    public Camera(int x, int y,int maxWidth,int maxHeight, int minWidth, int minHeight, int viewWidth,int viewHeight){
        this.x = x;
        this.y = y;
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.minWidth = minWidth;
        this.minHeight = minHeight;
        this.viewWidth = viewWidth;
        this.viewHeight = viewHeight;
    }

    public void updatePosition(int x, int y){
        this.x = x;
        this.y = y;
        //offSetX = x ;
        //offSetY = y ;
        //clamp();
    }
    public void updatePositionCenter(int x, int y){
        this.x = x - viewWidth /2;
        this.y = y - viewHeight /2;

        offSetX = x - viewWidth /2;
        offSetY = y - viewHeight /2;

        //clamp();
    }
    public void updatePositionCenterLerp(int x, int y){
        this.x = (int)Utils.lerp((float)this.x,(float)(x - viewWidth/2),.05f);
        this.y = (int)Utils.lerp((float)this.y,(float)(y - viewHeight/2),.05f);

        offSetX = x - viewWidth /2;
        offSetY = y - viewHeight /2;

        //clamp();
    }

    public int getOffSetX(){
        return offSetX;
    }

    public int getOffSetY(){
        return offSetY;
    }

    private void clamp(){
        if(x < minWidth){
            x = minWidth;
        }else if(x > maxWidth){
            x = maxWidth;
        }

        if(y > maxHeight){
            y = maxHeight;
        }else if(y < minHeight){
            y = minHeight;
        }
    }

    public void setViewWidth(int vw){
        viewWidth = vw;

    }

    public void setViewHeight(int vh){
        viewHeight = vh;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getMaxWidth(){
        return maxWidth;
    }

    public int getMaxHeight(){
        return maxHeight;
    }

    public int getMinWidth(){
        return minWidth;
    }

    public int getMinHeight(){
        return minHeight;
    }

    public int getViewWidth(){
        return viewWidth;
    }

    public int getViewHeight(){
        return viewHeight;
    }
}