
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
        Engine eng = new Engine(720,480,"File Test",true,new App());
        eng.start();
    }
}
