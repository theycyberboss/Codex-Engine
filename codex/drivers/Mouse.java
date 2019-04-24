package codex.drivers;


import codex.engine.*;
/**
 * Write a description of class Mouse here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.awt.event.*;
import java.util.*;
import java.awt.geom.*;
import java.awt.*;
import java.io.*;
/**

 */

public class Mouse extends MouseAdapter implements Serializable
{
    private static final long serialVersionUID = 1L;
    private static boolean mouseClicked, mousePressed, mouseReleased;
  private static int mx,my;
  private static int trueMx,trueMy;
  private int clickCount,pastClickCount;
  private static boolean wasPressed;
  private static Engine eng;
  private static AffineTransform transform;

  private static boolean left,right,middle;
    
  
  //A simple class that adds mouse support to the game engine  
  public Mouse(Engine eng)
  {
      this.eng = eng;
      mx = 0;
      my = 0;
      clickCount = 0;
      pastClickCount = 0;
      wasPressed = false;
      transform = new AffineTransform();
      transform.scale(1,1);
      
      
      mouseClicked = false;
      mousePressed = false;
      mouseReleased = false;
  }
  
  public void mouseDragged(MouseEvent e)
  {
      mx = (int)e.getPoint().getX();
      my = e.getY(); 
      transform.translate(mx,my);
  }
  
  public void mouseMoved(MouseEvent e)
  {
      mx = e.getX();
      my = e.getY();
      transform.translate(mx,my);

      if(e.getButton() == MouseEvent.BUTTON1){
        left = true;
    }

    if(e.getButton() == MouseEvent.BUTTON2){
      middle = true;
      
  }

  if(e.getButton() == MouseEvent.BUTTON3){
      right = true;
  }
      
  }
  
  public void mousePressed(MouseEvent e)
  {
      wasPressed = false;
      mousePressed = true;
      mouseReleased = false;

      if(e.getButton() == MouseEvent.BUTTON1){
          left = true;
      }

      if(e.getButton() == MouseEvent.BUTTON2){
        middle = true;
        
    }

    if(e.getButton() == MouseEvent.BUTTON3){
        right = true;
    }
  }
  
  public void mouseReleased(MouseEvent e)
  {
      wasPressed = true;
      
      mousePressed = false;
      mouseReleased = true;

      if(e.getButton() == MouseEvent.BUTTON1){
        left = false;
    }

    if(e.getButton() == MouseEvent.BUTTON2){
      middle = false;
      
  }

  if(e.getButton() == MouseEvent.BUTTON3){
      right = false;
  }
  }
  
  public static boolean isClicked()
  {
      if(mouseReleased && wasPressed)
      { 
          wasPressed = false;
          return true;
      }
      
      return false;
  }
  
  public static boolean isPressed()
  {
      return mousePressed;
  }
  
  public static boolean isReleased()
  {
      return mouseReleased;
  }
  
  public static int getX()
  {
     
      
      //System.out.println("MX: " + mx + " SCALE X: " + transform.getScaleX());
      return trueMx;
      
  }
  //fixedPoint.x * (1 - scale) / scale

  public void update(double scaleX, double scaleY){
      transform = AffineTransform.getScaleInstance(scaleX,scaleY); //Create a transform then scale it


      try{
          transform = transform.createInverse(); //Invert the transform
      }catch(Exception e){

      }
      Point2D location = new Point(mx,my);
    

      transform.transform(location,location); //Create the scaled cordnates and push them to the location point
      //System.out.println("Scale: " + scaleX);
      //System.out.println("X: " + location.getX());

      trueMx = (int)location.getX();
      trueMy = (int)location.getY();
  }

  public void update(double scaleX, double scaleY,int offSetX,int offSetY){
    transform = AffineTransform.getScaleInstance(scaleX,scaleY); //Create a transform then scale it


    try{
        transform = transform.createInverse(); //Invert the transform
    }catch(Exception e){

    }
    Point2D location = new Point(mx ,my );
    //System.out.println(mx);
    //System.out.println(mx + offSetX);
  

    transform.transform(location,location); //Create the scaled cordnates and push them to the location point
    //System.out.println("Scale: " + scaleX);
    //System.out.println("X: " + location.getX());

    trueMx = (int)location.getX() + offSetX ;
    trueMy = (int)location.getY() + offSetY;
}
  
  public static int getY()
  {
   
      return trueMy;
  }

  public static boolean getMiddlePressed(){
      return middle;
  }

  public static boolean getLeftPressed(){
      return left;
  }

  public static boolean getRighrPressed(){
      return right;
  }
  
}
