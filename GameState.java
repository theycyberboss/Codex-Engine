
import codex.engine.*;
import codex.drivers.*;
import java.awt.*;
public class GameState extends State{
	
	boolean pressed;
	int startX,startY;

	Camera cam;
	public void init(Engine eng){
		cam = new Camera(0,0,100,100);
		eng.addGameObject(new Button(eng,100,100));
		eng.setCamera(cam);
		pressed = false;
	}
	
	public void update(Engine eng){
		//cam.updatePosition(Mouse.getX(),Mouse.getY());
	}
	
	public void render(Engine eng){

		

	
		
	}
	
}