
/**
 * Write a description of class temp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.*;
public class temp extends GameObject
{
    private double angle;
    
    public temp(Engine eng,int x, int y){
        super(eng,x,y);
        angle = 0;
    }
    
    public void update(Engine eng){
        super.setX(Mouse.getX());
        super.setY(Mouse.getY());
        //angle += 5;
        super.setRotation(angle);
        System.out.println(super.getHitBox().getPosition());
       if(super.getHitBox().isColliding("Enemy")){
           Debugger.log("Hitting");
       }
    }
    
    public void render(Engine eng){
        eng.getGraphics().setColor(Color.RED);
        eng.getGraphics().fillRect(super.getX(),super.getY(),32,32);
        super.drawHitBox(eng);
    }
}
