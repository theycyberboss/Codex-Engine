package codex.engine;
/**
 * Write a description of class State here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public abstract class State
{
    private ArrayList<GameObject> currentObjects = new ArrayList<GameObject> ();
  
    public void addGameObject(GameObject o){
        currentObjects.add(o);
    }
    
    public void removeGameObject(GameObject o){
        currentObjects.remove(o);
    }
    
    public ArrayList<GameObject> getStateObjects(){
        return currentObjects;
    }
    
    public abstract void init(Engine eng);
    public abstract void update(Engine eng);
    public abstract void render(Engine eng);
}
