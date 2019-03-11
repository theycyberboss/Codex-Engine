package codex.engine;
/**
 * Write a description of class Sprite here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.io.*;
import javax.imageio.*;
import java.awt.image.*;
public class Sprite
{
    
    private File rawFile;
    private BufferedImage rawImage;
    
    
    public Sprite(String path){
        rawImage = null;
        rawFile = new File(path);
        createImage();
    }
    
    public Sprite(File file){
        rawImage = null;
        rawFile = file;
        createImage();
    }
    
    private void createImage(){
        try{
            rawImage = ImageIO.read(rawFile);
            System.out.println(rawImage);
        }catch(Exception e){
            e.printStackTrace();
            rawImage = null;
        }
    }
    
    public BufferedImage getRawImage(){
        return rawImage;
    }
    
    
    
}
