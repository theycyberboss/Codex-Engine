
/**
 * Write a description of class GameObject here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.awt.geom.*;
import java.awt.*;
public abstract class GameObject
{
    private int x, y,width,height;
    private double rotation;
    private String id;
    private HitBox hitBox;
    private Sprite sprite;
    
    public GameObject(Engine eng,int x, int y){
        this.x = x;
        this.y = y;
        this.width = 32;
        this.height = 32;
        rotation = 0;
        id = "GameObject";
        hitBox = new HitBox(eng,x,y,32,32);
        sprite = null;
        
    }
    
    public GameObject(Engine eng,int x, int y,int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        rotation = 0;
        id = "GameObject";
        hitBox = new HitBox(eng,x,y,width,height);
        sprite = null;
        
    }
    
    //A helper method that can draw the collision bounds of a gameObjects 
    public void drawHitBox(Engine eng){
        eng.getGraphics().setColor(Color.YELLOW);
        eng.getGraphics().drawRect(
        (int)hitBox.getBounds().getX(),
        (int)hitBox.getBounds().getY(),
        (int)hitBox.getBounds().getWidth(),
        (int)hitBox.getBounds().getHeight());
    }
    
    //Helper function used to return wether the mouse is over a gameObject
    public boolean mouseOver(){
        if(Mouse.getX() > x && Mouse.getX() < x + width){
            if(Mouse.getY() > y && Mouse.getY() < y + height){
                return true;
            }
        }
        
        return false;
    }
    
    
    //All gameobjects will have an update and a render method
    public abstract void update(Engine eng);
    public abstract void render(Engine eng);
    
    
    //Getters and setters
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public double getRotation(){
        return rotation;
    }
    
    public void setRotation(double angle){
        rotation = angle;
    }
    
    public HitBox getHitBox(){
        return hitBox;
    }
    
    public void setID(String id){
        this.id = id;
    }
    
    public String getID(){
        return id;
    }
    
    public void setSprite(Sprite sprite){
        this.sprite = sprite;
    }
    
    public Sprite getSprite(){
        return sprite;
    }
}
