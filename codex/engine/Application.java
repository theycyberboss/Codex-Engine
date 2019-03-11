package codex.engine;
import codex.engine.*;
/**
 * Write a description of class Application here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Application
{
    public abstract void init(Engine eng);
    
    public void render(Engine eng){
        
    }
    
    public abstract void update(Engine eng);
}
