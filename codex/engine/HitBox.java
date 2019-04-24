package codex.engine;
/**
 * Write a description of class HitBox here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.*;
import java.awt.geom.*;
import java.io.*;
public class HitBox implements Serializable
{
    private static final long serialVersionUID = 1L;
    private float x, y, width, height;
    private Rectangle2D.Float rect;
    private Engine eng;
    private GameObject currentCollidingObject;
    public HitBox(Engine eng, float x, float y, float width, float height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.eng = eng;
        currentCollidingObject = null;
        rect = new Rectangle2D.Float(x,y,width,height);
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
       
        return currentCollidingObject;
       
    }
    
    //Function that will loop through all the current gameObjects and will return
    //if the hitbox that called this function, is colliding with any gameobject 
    //with the specified id
    public boolean isColliding(String id){

        
        for(int i = 0; i < eng.getIDManager().getObjectsWithID(id).size(); i++){
            GameObject temp = eng.getIDManager().getObjectsWithID(id).get(i);
            if(temp.getHitBox().getBounds().intersects(rect.getBounds()) && temp.getHitBox() != this){
                currentCollidingObject = temp;
                return true;
            }
        }
        
        return false;
    }
    
    
    //Function used to update the position of the rectangle
    //that we use to check for collisions
    public void updatePosition(float x, float y){
        rect = new Rectangle2D.Float(x,y,width,height);
        this.x = x;
        this.y = y;
    }

    public void updatePosition(float x, float y, float width, float height){
        rect = new Rectangle2D.Float(x,y,width,height);
        this.x = x;
        this.y = y;
    }
    
    
    //Getters and Setters
    public float getX(){
        return x;
    }
    
    public float getY(){
        return y;
    }
    
    public void setX(float x){
        this.x = x;
    }
    
    public void setY(float y){
        this.y = y;
    }
    
    public String getPosition(){
        return "X: " + x + " Y: " + y;
    }
    
    public Rectangle2D.Float getBounds(){
        return rect;
    }
   
}
