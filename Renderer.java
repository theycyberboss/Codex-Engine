
/**
 * Write a description of class Renderer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.*;
import java.awt.image.*;

public class Renderer
{
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
    
    public void init()
    {
        canvas.createBufferStrategy(4);
    }
    
    public Canvas getCanvas()
    {
        return canvas;
    }
    
    public void updateGraphics()
    {    
        
        bs = canvas.getBufferStrategy();
        g = (Graphics2D) bs.getDrawGraphics();      
        g.setColor(Color.black);
        g.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        
       
        
    }
    
    public void cleanUp()
    {
        bs.show();
        g.dispose();
    }
    
    public Graphics2D getGraphics()
    {
        return g;
    }
    
    public Graphics2D getGraphicsScaled()
    {
        return gScale;
    }
    
    public void resizeGraphics(int baseWidth, int baseHeight, int newWidth, int newHeight)
    {
        scaleX = newWidth / (baseWidth * 1.0);
        scaleY = newHeight / (baseHeight * 1.0);
        gScale = g;
        
        //g.scale(scaleX, scaleY);
        gScale.scale(scaleX,scaleY);
    }
    
    public double getScaleX()
    {
        return scaleX;
    }
    
    public double getScaleY()
    {
        return scaleY;
    }
    
}
