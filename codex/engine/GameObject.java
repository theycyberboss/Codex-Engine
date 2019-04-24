package codex.engine;
import codex.drivers.*;
import java.io.*;
/**
 * Write a description of class GameObject here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.awt.geom.*;
import java.awt.*;
import java.util.*;
public abstract class GameObject implements Serializable
{
    private float x, y,width,height;
    private double rotation;
    private String id;
    private HitBox hitBox;
    private Sprite sprite;
    private Behavior behavior;
    private LinkedList<Behavior> behaviors;
    private static final long serialVersionUID = 1L;
    private String confPath;
    
    public GameObject(Engine eng,float x, float y){
        this.x = x;
        this.y = y;
        this.width = 32;
        this.height = 32;
        rotation = 0;
        id = "GameObject";
        hitBox = new HitBox(eng,x,y,32,32);
        sprite = null;
        behavior = null;
        behaviors = new LinkedList<Behavior> ();
        
    }
    
    public GameObject(Engine eng,float x, float y,float width, float height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        rotation = 0;
        id = "GameObject";
        hitBox = new HitBox(eng,x,y,width,height);
        sprite = null;
        behavior = null;
        behaviors = new LinkedList<Behavior> ();
        
    }

    //This constructer allows you to create a file from what i am calling
    //a .cof file which stands for Codex Object File
    public GameObject(Engine eng, float x, float y,String data, String path){

        behaviors = new LinkedList<Behavior> ();
        
        confPath = path;
        this.x = x;
        this.y = y;

        String[] parts = splitData(data);

        for(int i = 0; i < parts.length; i++){
            parseData(eng,parts[i]);

            //System.out.println(parts[i]);
        }

        initBehaviors(eng,this);

        rotation = 0;
        id = "GameObject";
        hitBox = new HitBox(eng,x,y,width,height);
        sprite = null;
        behavior = null;
        
    }

    public String getConfPath(){
        return confPath;
    }

    private void initBehaviors(Engine eng,GameObject o){
        for(int i = 0; i < behaviors.size(); i++){
            behaviors.get(i).init(eng,o);
        }
    }

    //Function used to update all the behaviors that are "attached" to this gameObject 
    public void updateBehaviors(Engine eng,GameObject temp){

        for(int i = 0; i < behaviors.size(); i++){
            behaviors.get(i).run(eng,temp);
        }

    }
	
	public void renderGUI(Engine eng){
		
	}


    //Function used to parse the String data that is being read
    //from a text file and turn it into an object
    private void parseData(Engine eng, String data){

        String spritePath = "";
        //data = data.trim();
        int length = data.length();
        //System.out.println(data);
        
        

        if(data.startsWith("sprite: ")){
            Sprite temp = new Sprite(data.substring(length));

            if(temp != null){
                sprite = temp;
            }

        }else  if(data.startsWith("x:")){
           // System.out.println(data.substring(2).trim());
            this.x = Float.parseFloat(data.substring( ("x: ").length() ));
        
        }else  if(data.startsWith("y: ")){
            this.y = Float.parseFloat(data.substring( ("y: ").length()));
        
        }else  if(data.startsWith("width: ")){
            this.width = Float.parseFloat(data.substring( ("width: ").length() ));
        
        }else  if(data.startsWith("height: ")){
            this.height = Float.parseFloat(data.substring( ("height: ").length() ));
            //System.out.println("Parse Height:  " + Integer.parseInt(data.substring(length)));
        
        }else  if(data.startsWith("behavior: ")){

            if(data.contains(",")){
                String[] bParts = data.substring(("behavior: ").length()).split(",");
                
                for(int i = 0; i < bParts.length; i++){
                    if(eng.getBehavior(bParts[i]) != null){
                        this.behaviors.add(eng.getBehavior(bParts[i]));
                    }
                    
                }
            }else {
                if(eng.getBehavior(data.substring(("behavior: ").length())) != null){
                    behaviors.add(eng.getBehavior(data.substring(("behavior: ").length())));
                }
               
            }
            

            
        }

    }

    private String[] splitData(String data){
        return data.split(";");
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
    public float getX(){
        return x;
    }
    
    public float getY(){
        return y;
    }
    
    public float getWidth(){
        return width;
    }
    
    public float getHeight(){
        return height;
    }
    
    public void setX(float x){
        this.x = x;
    }
    
    public void setY(float y){
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

    public void setBehavior(Behavior b){
        this.behavior = b;
    }

    public Behavior getBehavior(){
        return this.behavior;
    }

    public Behavior getBehaviors(String name){
        for(int i = 0; i < behaviors.size(); i++){
            Behavior temp = behaviors.get(i);
            if(temp.getClass().getSimpleName().equals(name)){
                return temp;
            }
        }

        return null;
    }
}
