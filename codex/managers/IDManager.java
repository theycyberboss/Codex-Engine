package codex.managers;
import codex.engine.*;
/**
 * Write a description of class IDManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;
public class IDManager 
{
    private static ObjectManager handler;
    
    //This class allows groups of objects to be grouped under on id and
    //allows them to interect as if they were one object
    public IDManager(ObjectManager handler){
        this.handler = handler;
    }
    
    
    //Function used to return the first gameObject with the specified id
    public static GameObject getObjectWithID(String id){
        for(int i = 0; i < handler.getObjects().size(); i++){
            GameObject temp = handler.getObjects().get(i);
            if(temp.getID().equals(id)){
                return temp;
            }
        }
        
        return null;
    }
    
    //Function used to return a list of all the current gameObjects
    //with the specified id
    public static LinkedList<GameObject> getObjectsWithID(String id){
        LinkedList<GameObject> output = new LinkedList<GameObject> ();
        
        for(int i = 0; i < handler.getObjects().size(); i++){
            GameObject temp = handler.getObjects().get(i);
            if(temp.getID().equals(id)){
                output.add(temp);
            }
        }
        
        return output;
    }
    
}
