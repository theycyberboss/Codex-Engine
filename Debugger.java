
/**
 * Write a description of class Debugger here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import javax.swing.*;
import java.awt.event.*;

public class Debugger
{
    private Window window;
    private JScrollPane scroll;
    private static JTextArea area;
    
    public Debugger(int width, int height){
        window = new Window(width,height,"DEBUGGER");
        
        area = new JTextArea();
        scroll = new JScrollPane(area);
        scroll.setSize(width,height);
        
        area.setSize(width,height);
        area.setLineWrap(true);
        area.setEditable(false);
        
        window.addComponent(scroll);
        
        scroll.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {  
            public void adjustmentValueChanged(AdjustmentEvent e) {  
                e.getAdjustable().setValue(e.getAdjustable().getMaximum());  
            }
        });
        
        
    }
    
    public static void log(String str){
         if(area != null){
             
             area.append("> " + str + "\n");
         }
    }
    
    
}
