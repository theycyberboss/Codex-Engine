package codex.engine;
import codex.managers.*;

/**
 * A game engine that allows for easier creation of video games
 *
 * @author Nathan Colbath
 * @version 0.02
 */
import java.awt.*;
import java.util.*;
import codex.graphics.*;
import codex.graphics.Window;
import codex.drivers.*;

public class Engine implements Runnable
{
   private Window window;
   private Renderer renderer;
   private boolean isRunning;
   private Thread thread;
   private boolean showFpsCounter;
   
   private int fps;
   
   private Keyboard keyboard;
   private Mouse mouse;
   private ObjectManager handler;
   private IDManager idManager;
   private FileManager fileManager;
   private StateManager stateManager;
   //private AudioManager audioManager;
   private Application app;
   private HashMap<String,Behavior> behaviors;
   private Camera camera;

   
   
   
    public Engine(boolean createDebugger,Application app)
    {
       this.app = app;
       keyboard = new Keyboard();
       mouse = new Mouse(this);
       handler = new ObjectManager();
       idManager = new IDManager(handler);
       fileManager = new FileManager();
       stateManager = new StateManager(this);
       //audioManager = new AudioManager(this);
       isRunning = false;
       showFpsCounter = true;
       fps = 0;

       
       window = new Window(720,480,"New Window");
       renderer = new Renderer(window);
       window.addComponent(renderer.getCanvas());
       window.getFrame().setLocationRelativeTo(null);
       
       renderer.getCanvas().addKeyListener(keyboard);
       renderer.getCanvas().addMouseListener(mouse);
       renderer.getCanvas().addMouseMotionListener(mouse);
       renderer.init(); 
       app.init(this);
       

       if(createDebugger){
           new Debugger(300,500);
       }
        
    }
    
    public Engine(int width, int height,String title, boolean createDebugger, Application app){

       this.app = app;
       keyboard = new Keyboard();
       mouse = new Mouse(this);
       handler = new ObjectManager();
       idManager = new IDManager(handler);
       fileManager = new FileManager();
       stateManager = new StateManager(this);
       behaviors = new HashMap<String,Behavior> ();
       //audioManager = new AudioManager(this);
       isRunning = false;
       showFpsCounter = true;
       fps = 0;
       
       window = new Window(width,height,title);
       renderer = new Renderer(window);
       window.addComponent(renderer.getCanvas());
       window.getFrame().setLocationRelativeTo(null);
       
       renderer.getCanvas().addKeyListener(keyboard);
       renderer.getCanvas().addMouseListener(mouse);
       renderer.getCanvas().addMouseMotionListener(mouse);
       renderer.init(); 
       app.init(this);
       
       if(createDebugger){
           new Debugger(300,500);
       }
    }
    
    //The master update method, all update methods
    //are called from this method
    private void update()
    {
       if(stateManager.getCurrentState() != null){
           stateManager.getCurrentState().update(this);
       }
        
        handler.update(this);
        
        app.update(this);
    }
    
    //The master render method, all render method calls
    //stem from this method
    private void render()
    {
       
       renderer.resizeGraphics(window.getBaseWidth(),window.getBaseHeight(),window.getWidth(),window.getHeight());
        renderer.getGraphics();
       
       handler.renderGUI(this);
       
       
       if(camera != null){
           renderer.getGraphics().translate(-camera.getX(),-camera.getY());
       }
       //renderer.getGraphics().setColor(Color.black);
       //renderer.getGraphics().fillRect(0,0,100,100);
       app.render(this);
       mouse.update(renderer.getScaleX(),renderer.getScaleY());
       
       
       //Check to see if we have a state, if so, render it 
       if(stateManager.getCurrentState() != null){
           stateManager.getCurrentState().render(this);
       }
       
       handler.render(this);
	   
	   //g.translate(0,0);
	   
       
       //Only render the fps counter when the programmer decides to use 
       //it, active by default
       if(showFpsCounter){
           renderer.getGraphics().setColor(Color.yellow);
           renderer.getGraphics().drawString("FPS: " + fps,10,20);

           renderer.getGraphics().setColor(Color.yellow);
           renderer.getGraphics().drawString("OBJECTS: " + handler.getObjectCount(),10,40);
       }
       

       
       
        
    }
    
    
    //Function that stops the engine
    public synchronized void start()
    {
       thread = new Thread(this);
       thread.start();
       isRunning = true;
        
    }
    
    //Function that starts the engine
    public synchronized void stop()
    {
         try{
           thread.join();
           isRunning = false;
        }catch(Exception e)
        {
            
        }
    }
    
    //The main game loop that updates and renders the game
    //The updates are capped at 60 frames a second where the framerate
    //is not capped to a specific rate
    public void run()
    {
      long lastTime = System.nanoTime();
      double amountOfTicks = 60.0;
      double ns = 1000000000 / amountOfTicks;
      double delta = 0;
      long timer = System.currentTimeMillis();
      int frames = 0;
      while(isRunning) {
       long now = System.nanoTime();
       delta += (now - lastTime) / ns;
       lastTime = now;
       
       
       
       while(delta >= 1) {
        update();
        //updates++;
        delta--;
       }
       renderer.updateGraphics();
       render();
       renderer.cleanUp();
       frames++;

       if(System.currentTimeMillis() - timer > 1000) {
        timer += 1000;
        fps = frames;
        frames = 0;
        //updates = 0;
       }
       
       
      }
      stop();
        
    }
    
    
    //Function used to add a gameobject to the specific state that is 
    //currently active. Once a state has been changed, the gameObjectList is then changed
    public void addGameObject(GameObject o){
        if(stateManager.getCurrentState() != null){
            stateManager.getCurrentState().addGameObject(o);
        }
        
        
    }
    //Function used to remove a gameobject to the specific state that is 
    //currently active. Once a state has been changed, the gameObjectList is then changed
    public void removeGameObject(GameObject o){
        if(stateManager.getCurrentState() != null){
            stateManager.getCurrentState().removeGameObject(o);
        }
        
    }
    
    public void enableFpsCounter(boolean en){
        showFpsCounter = en;
    }
    
    public Renderer getRenderer()
    {
       return renderer;
    }
    
    public Window getWindow(){
        return window;
    }
    
    public Mouse getMouse(){
        return mouse;
    }
    
    public Keyboard getKeyboard(){
        return keyboard;
    }
    
    public Graphics2D getGraphics(){
        return renderer.getGraphics();
    }
    
    public FileManager getFileManager(){
        return fileManager;
    }
    
    public IDManager getIDManager(){
        return idManager;
    }
    
    public StateManager getStateManager(){
        return stateManager;
    }
    
    /*
    public AudioManager getAudioManager(){
        return audioManager;
    }
    */ 
    
    public ObjectManager getObjectManager(){
        return handler;
    }

    public void addBehavior(String key,Behavior behavior){
        behaviors.put(key,behavior);
    }

    public Behavior getBehavior(String key){
        Behavior temp = null;

        try{
        temp = behaviors.get(key).getClass().newInstance();

        if(temp == null){
            System.out.println("[ERROR] - Behavior with the name: " + key + " could not be found");
        }

        }catch(Exception e){

        }
        

        return temp;
    }

    public void printBehaviors(){
        System.out.println("BEHAVIOR: " + Arrays.asList(behaviors));
    }

    public void setCamera(Camera cam){
        camera = cam;
    }
	
	public Camera getCamera(){
		return camera;
	}
}
