
/**
 * Write a description of class Launcher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Launcher
{
    public static void main(String[] args)
    {
        Engine mainEngine = new Engine(720,480,"Codex Engine",true);
        temp temp = new temp(mainEngine,32,32);
        temp2 temp2 = new temp2(mainEngine,200,200);
        mainEngine.addGameObject(temp);
        mainEngine.addGameObject(temp2);
        mainEngine.start();
        
        
        Debugger.log(temp + " " +temp.getID());
        
    }
}
