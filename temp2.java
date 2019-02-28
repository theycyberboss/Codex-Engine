
/**
 * Write a description of class temp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.*;
public class temp2 extends GameObject
{
    private double angle;
    
    public temp2(Engine eng,int x, int y){
        super(eng,x,y);
        angle = 0;
        super.setID("Enemy");
    }
    
    public void update(Engine eng){
        //super.setX(Mouse.getX());
        //super.setY(Mouse.getY());
        angle += 5;
        super.setRotation(angle);
        
       
    }
    
    public void render(Engine eng){
        eng.getGraphics().setColor(Color.BLUE);
        eng.getGraphics().fillRect(super.getX()-16,super.getY()-16,32,32);
    }
}
