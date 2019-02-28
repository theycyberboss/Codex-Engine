
/**
 * Write a description of class Utils here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Utils
{
    public static double getAngle(int x1, int y1, int x2, int y2){
        double hyp = getDistance(x1,y1,x2,y2);
        double ops = y2 - y1;
        double ajs = x2- x1;
        
        //double angle = Math.toDegrees(Math.asin(ops/hyp));
        
        double angle = (float) Math.toDegrees(Math.atan2(y2 - y1, x2 - x1));
        
        angle = angle + Math.ceil( -angle / 360 ) * 360;
        
        
        return angle;
        
    }
    
    public static double getDistance(int x1, int y1, int x2, int y2){
        double xx = Math.pow((x1-x2),2);
        double yy = Math.pow((y1-y2),2);
        
        return Math.sqrt(xx + yy);
    }
}
