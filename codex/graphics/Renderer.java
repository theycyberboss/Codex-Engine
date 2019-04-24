package codex.graphics;
/**
 * Write a description of class Renderer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.io.*;

public class Renderer implements Serializable
{
    private static final long serialVersionUID = 1L;
    private Canvas canvas;
    private Graphics2D g,gScale;
    private BufferStrategy bs;
    
    private double scaleX,scaleY;
    
    public Renderer(Window window)
    {
        canvas = new Canvas();
        canvas.setSize(window.getWidth(),window.getHeight());
       
        scaleX = 1;
        scaleY = 1;
    }

    public Renderer(JPanel window)
    {
        canvas = new Canvas();
        canvas.setSize(window.getWidth(),window.getHeight());
       
        scaleX = 1;
        scaleY = 1;
    }
    
    //Init function used to determain they amount of BufferStrategys we are
    //going to be using 
    public void init()
    {
        canvas.createBufferStrategy(4);
    }
 
    
    //Function used to update and draw to the BufferStrategy before
    //we display it to the canvas
    public void updateGraphics()
    {    
        
        bs = canvas.getBufferStrategy();
        g = (Graphics2D) bs.getDrawGraphics();      
        g.setColor(Color.black);
        g.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        
       
        
    }
    
    
    //Function used to dispose/free memory space for the graphics object
    //and to show the BufferStrategy after we have wrote to it
    public void cleanUp()
    {
        bs.show();
        g.dispose();
    }
   
    
    
    //Function used to resize the orginal graphics object based on a scale ratio
    public void resizeGraphics(int baseWidth, int baseHeight, int newWidth, int newHeight)
    {
        scaleX = newWidth / (baseWidth * 1.0);
        scaleY = newHeight / (baseHeight * 1.0);
        gScale = g;
        
        //g.scale(scaleX, scaleY);
        g.scale(scaleX,scaleY);
    }
    
    
    //Getters and setters
    public double getScaleX()
    {
        return scaleX;
    }
    
    public double getScaleY()
    {
        return scaleY;
    }
    
       
    public Canvas getCanvas()
    {
        return canvas;
    }
     
    public Graphics2D getGraphics()
    {
        return g;
    }
    
    public Graphics2D getGraphicsScaled()
    {
        return gScale;
    }
    
}
