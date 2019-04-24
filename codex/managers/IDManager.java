package codex.managers;
import codex.engine.*;
/**
 * Write a description of class IDManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;
import java.io.*;
public class IDManager implements Serializable
{
    private static final long serialVersionUID = 1L;
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
    public static ArrayList<GameObject> getObjectsWithID(String id){
        ArrayList<GameObject> output = new ArrayList<GameObject> ();
        
        for(int i = 0; i < handler.getObjects().size(); i++){
            GameObject temp = handler.getObjects().get(i);
            if(temp.getID().equals(id)){
                output.add(temp);
            }
        }
        
        return output;
    }
    
}
