
/**
 * Write a description of class Window here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.*;
import javax.swing.*;

public class Window
{
   private JFrame frame;
   private int baseWidth,baseHeight;
    
   public Window(int width, int height, String title)
   {
       frame = new JFrame(title);
       
       baseWidth = width;
       baseHeight = height;
       
       Dimension dim = new Dimension(width,height);
       frame.setPreferredSize(dim);
       //frame.setMaximumSize(dim);
       frame.setMinimumSize(dim);
       
       frame.setResizable(false);
      // frame.setLocationRelativeTo(null);
       frame.setVisible(true);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
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
}
