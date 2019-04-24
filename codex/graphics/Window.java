package codex.graphics;
/**
 * Write a description of class Window here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class Window implements Serializable
{
    private static final long serialVersionUID = 1L;
    private JFrame frame;
   private int baseWidth,baseHeight;

   public static boolean resized;
    
   public Window(int width, int height, String title)
   {
       frame = new JFrame(title);
       resized = false;
       
       baseWidth = width;
       baseHeight = height;
       
       Dimension dim = new Dimension(width,height);
       frame.setPreferredSize(dim);
       //frame.setMaximumSize(dim);
       frame.setMinimumSize(dim);
       
       frame.setResizable(true);
      // frame.setLocationRelativeTo(null);
       frame.setVisible(true);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.addComponentListener(new FrameListen());
       
   }
   
   public JFrame getFrame(){
       return frame;
   }
   
   //Add components to the jfraome
   public void addComponent(Component c)
   {
       frame.add(c);
   }
   
   //Returns the current width;
   public int getWidth()
   {
       return frame.getWidth();
   }
   
   //Returns the current height;
   public int getHeight()
   {
       return frame.getHeight();
   }
   
   //Returns what the width was when you created the window
   public int getBaseWidth()
   {
       return baseWidth;
   }
   
   //Returns what the height was when you created the window
   public int getBaseHeight()
   {
       return baseHeight;
   }

   public boolean isResizing(){
       if(resized){
           resized = false;
           
           return true;
       }

       return false;
       
   }
   
   private class FrameListen implements ComponentListener{
        public void componentHidden(ComponentEvent arg0) {
        }
        public void componentMoved(ComponentEvent arg0) {   
        }
        public void componentResized(ComponentEvent arg0) {
            resized = true;

        }
        public void componentShown(ComponentEvent arg0) {

        }
    }
}


