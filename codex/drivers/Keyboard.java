package codex.drivers;
/**
 * Write a description of class Keyboard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
 /**
  */
import java.awt.event.KeyAdapter;
import java.awt.event.*;
import java.io.*;

public class Keyboard extends KeyAdapter implements Serializable
{
    private static final long serialVersionUID = 1L;
    private static boolean keyCodes[];
    
    public Keyboard()
    {
        keyCodes = new boolean[256];
    }
    
    public void keyPressed(KeyEvent e)
    {   
        keyCodes[e.getKeyCode()] = true;
    }
    
    public void keyReleased(KeyEvent e)
    {
        keyCodes[e.getKeyCode()] = false;
    }
    
    public static boolean keyPressed(int keyCode)
    {
        return keyCodes[keyCode];
    }
}
