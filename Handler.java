
/**
 * Write a description of class Handler here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;
import java.awt.geom.*;
public class Handler
{
    private LinkedList<GameObject> objects;
    
    public Handler(){
        objects = new LinkedList<GameObject> ();
    }
    
    //updates the the gameobjects in the game engine
    public void update(Engine eng){
        for(int i = 0; i < objects.size(); i++){
            GameObject temp = objects.get(i);
            temp.update(eng);
            temp.getHitBox().updatePosition(temp.getX(),temp.getY());
        }
    }
    
    //Renders all of the gameobjects in the game engine
    public void render(Engine eng){
        for(int i = 0; i < objects.size(); i++){
            GameObject temp = objects.get(i);
            
            AffineTransform old = eng.getGraphics().getTransform();
            eng.getGraphics().rotate(Math.toRadians(temp.getRotation()),temp.getX(),temp.getY());
            
            temp.render(eng);
            eng.getGraphics().setTransform(old);
        }
    }
    
    //The list that holds the data for all game objects
    //Possibly will make it so you can change the order of the gameObjects
    //allowing for you to also change the depth at which they are drawn
    public LinkedList<GameObject> getObjects(){
        return objects;
    }
}
