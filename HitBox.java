
/**
 * Write a description of class HitBox here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.*;
public class HitBox
{
    private int x, y,width,height;
    private Rectangle rect;
    private Engine eng;
    public HitBox(Engine eng, int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.eng = eng;
        
        rect = new Rectangle(x,y,width,height);
    }
    
    public boolean isColliding(){
        for(int i = 0; i < eng.getIDManager().getObjectsWithID("GameObject").size(); i++){
            GameObject temp = eng.getIDManager().getObjectsWithID("GameObject").get(i);
            
            if(temp.getHitBox().getBounds().intersects(rect.getBounds()) &&
            temp.getHitBox() != this){
      
                return true;
            }
        }
        
        return false;
    }
    
    public boolean isColliding(String id){
        for(int i = 0; i < IDManager.getObjectsWithID(id).size(); i++){
            GameObject temp = IDManager.getObjectsWithID(id).get(i);
            if(temp.getHitBox().getBounds().intersects(rect.getBounds())){
                return true;
            }
        }
        
        return false;
    }
    
    public void updatePosition(int x, int y){
        rect = new Rectangle(x,y,width,height);
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public String getPosition(){
        return "X: " + x + " Y: " + y;
    }
    
    public Rectangle getBounds(){
        return rect;
    }
   
}
