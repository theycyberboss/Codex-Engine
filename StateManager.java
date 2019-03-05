
/**
 * Write a description of class StateManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;
public class StateManager
{
    private LinkedList<State> gameStates;
    
    private State currentState;
    private Engine eng;
    public StateManager(Engine eng){
        gameStates = new LinkedList<State> ();
        currentState = null;
        this.eng = eng;
    }
    
    //Function used to get the current state thate
    //the state manager is in
    public State getCurrentState(){
        return currentState;
    }
    
    //Function used to set the current state based on
    //the id that is passed in
    public void setState(int id){
        currentState = gameStates.get(id);
        eng.getObjectManager().setObjectList(currentState.getStateObjects());
    }
    
    //Function used to add a new state to the state manager
    //and change the state to be the state that you just added
    public void addState(State state, int id){
        gameStates.add(id,state);
        setState(id);
        state.init(eng);
        
    }
    
}
