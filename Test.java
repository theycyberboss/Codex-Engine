import codex.engine.*;
import java.awt.*;
import codex.drivers.*;
public class Test extends Application{


    
    public void init(Engine eng){
		eng.getStateManager().addState(new GameState(),0);
    }

    public void update(Engine eng){

    }

    public void render(Engine eng){
        eng.getGraphics().setColor(Color.cyan);
        //eng.getGraphics().fillRect(Mouse.getX(),Mouse.getY(),16,16);
    }

    public static void main(String[] args){
        Engine eng = new Engine(720,480,"Mouse Test",false, new Test());
        eng.start();
    }
}