package codex.engine;
/**
 * Write a description of class Utils here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Utils
{
    public static double getAngle(float x1, float y1, float x2, float y2){
        double hyp = getDistance(x1,y1,x2,y2);
        double ops = y2 - y1;
        double ajs = x2- x1;
        
        //double angle = Math.toDegrees(Math.asin(ops/hyp));
        
        double angle = (float) Math.toDegrees(Math.atan2(y2 - y1, x2 - x1));
        
        angle = angle + Math.ceil( -angle / 360 ) * 360;
        
        
        return angle;
        
    }
    
    public static double getDistance(float x1, float y1, float x2, float y2){
        double xx = Math.pow((x1-x2),2);
        double yy = Math.pow((y1-y2),2);
        
        return Math.sqrt(xx + yy);
    }

    public static float[] getDirectionCords(double angle){
        float vx = (float)Math.cos(Math.toRadians(angle));
        float vy = (float)Math.sin(Math.toRadians(angle));

        float[] points = new float[2];
        points[0] = vx;
        points[1] = vy;

        return points;
    }
}
