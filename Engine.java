
/**
 * A game engine that allows for easier creation of video games
 *
 * @author Nathan Colbath
 * @version 0.02
 */
import java.awt.*;

public class Engine implements Runnable
{
   private Window window;
   private Renderer renderer;
   private boolean isRunning;
   private Thread thread;
   
   private int fps;
   
   private Keyboard keyboard;
   private Mouse mouse;
   private Handler handler;
   private IDManager idManager;
   private FileManager fileManager;
   
   
    public Engine(boolean createDebugger)
    {

       keyboard = new Keyboard();
       mouse = new Mouse(this);
       handler = new Handler();
       idManager = new IDManager(handler);
       isRunning = false;
       fps = 0;
       
       window = new Window(720,480,"New Window");
       renderer = new Renderer(window);
       window.addComponent(renderer.getCanvas());
       
       renderer.getCanvas().addKeyListener(keyboard);
       renderer.getCanvas().addMouseListener(mouse);
       renderer.getCanvas().addMouseMotionListener(mouse);
       renderer.init(); 
       
       

       if(createDebugger){
           new Debugger(300,500);
       }
        
    }
    
    public Engine(int width, int height,String title, boolean createDebugger){

        
       keyboard = new Keyboard();
       mouse = new Mouse(this);
       handler = new Handler();
       idManager = new IDManager(handler);
       fileManager = new FileManager();
       isRunning = false;
       fps = 0;
       
       window = new Window(width,height,title);
       renderer = new Renderer(window);
       window.addComponent(renderer.getCanvas());
       
       renderer.getCanvas().addKeyListener(keyboard);
       renderer.getCanvas().addMouseListener(mouse);
       renderer.getCanvas().addMouseMotionListener(mouse);
       renderer.init(); 

       
       if(createDebugger){
           new Debugger(300,500);
       }
    }
    
    //The master update method, all update methods
    //are called from this method
    private void update()
    {
        handler.update(this);
    }
    
    //The master render method, all render method calls
    //stem from this method
    private void render()
    {
       renderer.resizeGraphics(window.getBaseWidth(),window.getBaseHeight(),window.getWidth(),window.getHeight());
       
       
       Graphics2D g = renderer.getGraphicsScaled();
       g.setColor(Color.black);
       g.fillRect(0,0,100,100); 
       handler.render(this);
    
       
       g.setColor(Color.yellow);
       g.drawString("FPS: " + fps,10,20);
       
        
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
    
    public void addGameObject(GameObject o){
        handler.getObjects().add(o);
    }
    
    public void removeGameObject(GameObject o){
        handler.getObjects().remove(o);
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
}
