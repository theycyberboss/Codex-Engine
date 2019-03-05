
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
    private GameObject currentCollidingObject;
    public HitBox(Engine eng, int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.eng = eng;
        currentCollidingObject = null;
        rect = new Rectangle(x,y,width,height);
    }
    
    //Function that will loop through all the game objects that are currently active
    //and return wether they are colliding with the hitbox that called the method
    //Since all gameObjects are by default labled "GameObject", we can use a default method to 
    //check for basic collisons
    public boolean isColliding(){
        for(int i = 0; i < eng.getIDManager().getObjectsWithID("GameObject").size(); i++){
            GameObject temp = eng.getIDManager().getObjectsWithID("GameObject").get(i);
            
            if(temp.getHitBox().getBounds().intersects(rect.getBounds()) &&
            temp.getHitBox() != this){
                currentCollidingObject = temp;
                return true;
            }
        }
        
        return false;
    }
    
    //Function that returns the last known object that the hitbox that 
    //called thus function, collided with
    public GameObject getOther(){
        Debugger.log(""+currentCollidingObject);
        return currentCollidingObject;
       
    }
    
    //Function that will loop through all the current gameObjects and will return
    //if the hitbox that called this function, is colliding with any gameobject 
    //with the specified id
    public boolean isColliding(String id){
        for(int i = 0; i < eng.getIDManager().getObjectsWithID(id).size(); i++){
            GameObject temp = eng.getIDManager().getObjectsWithID(id).get(i);
            if(temp.getHitBox().getBounds().intersects(rect.getBounds())){
                currentCollidingObject = temp;
                return true;
            }
        }
        
        return false;
    }
    
    
    //Function used to update the position of the rectangle
    //that we use to check for collisions
    public void updatePosition(int x, int y){
        rect = new Rectangle(x,y,width,height);
        this.x = x;
        this.y = y;
    }
    
    
    //Getters and Setters
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
