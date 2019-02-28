
/**
 * Write a description of class IDManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;
public class IDManager 
{
    private static Handler handler;
    
    //This class allows groups of objects to be grouped under on id and
    //allows them to interect as if they had one id
    public IDManager(Handler handler){
        this.handler = handler;
    }
    
    public void addID(String id){
        
    }
    public void removeID(String id){
        
    }
    /*
    public static String getID(GameObject object){
        return "";
    }
    */
    public static GameObject getObjectWithID(String id){
        for(int i = 0; i < handler.getObjects().size(); i++){
            GameObject temp = handler.getObjects().get(i);
            if(temp.getID().equals(id)){
                return temp;
            }
        }
        
        return null;
    }
    
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
