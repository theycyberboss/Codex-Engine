package codex.managers;
import codex.engine.*;
/**
 * Write a description of class Handler here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;
import java.awt.geom.*;
public class ObjectManager
{
    private LinkedList<GameObject> objects;
    
    public ObjectManager(){
        objects = new LinkedList<GameObject> ();
    }
    
    //updates the the gameobjects in the game engine
    public void update(Engine eng){
        for(int i = 0; i < objects.size(); i++){
            GameObject temp = objects.get(i);
            temp.update(eng);
            temp.getHitBox().updatePosition(temp.getX(),temp.getY());
            if(temp.getBehavior() != null){
                temp.getBehavior().run(eng,temp);
            }

            temp.updateBehaviors(eng,temp);
        }
    }
    
    //Renders all of the gameobjects in the game engine
    public void render(Engine eng){
        for(int i = 0; i < objects.size(); i++){
            GameObject temp = objects.get(i);
            
            AffineTransform old = eng.getGraphics().getTransform();
            eng.getGraphics().rotate(Math.toRadians(temp.getRotation()),temp.getX(),temp.getY());
            
            
            if(temp.getSprite() != null){
                if(temp.getSprite().getRawImage() != null){
                    AffineTransform t = new AffineTransform();
                    t.translate(temp.getX(),temp.getY());
                    //t.scale(temp.getWidth() / temp.getSprite.getRawImage().getWidth(),temp.getHeight() / temp.getSprite.getRawImage().getHeight())
                    
                     eng.getGraphics().drawImage(temp.getSprite().getRawImage(),t,null);
                }else {
                     temp.render(eng);
                }
               
            }else {
                temp.render(eng);
            }
            eng.getGraphics().setTransform(old);
        }
    }

    public int getObjectCount(){
        return objects.size();
    }
    
    //Function used to set a new list of gameObjects, used with states in order
    //to keep objects relative to what state they were added too
    public void setObjectList(LinkedList<GameObject> newList){
        objects = newList;
    }
    
    //The list that holds the data for all game objects
    //Possibly will make it so you can change the order of the gameObjects
    //allowing for you to also change the depth at which they are drawn
    public LinkedList<GameObject> getObjects(){
        return objects;
    }
}
