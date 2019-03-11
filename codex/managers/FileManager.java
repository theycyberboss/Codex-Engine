package codex.managers;
import codex.engine.*;
/**
 * Write a description of class FileManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.*;

public class FileManager //A Basic class for reading and writing data to files
{
    //Function used to write String data to a specified file using a charset
    //of your choosing
    public void writeStringFile(String data, String fileName,String exstention,String charSet){
        Writer writer = null;
        try{
            writer = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream(fileName + exstention),charSet));
            writer.write(data);
        }catch(Exception e){
            
         
        }finally{
            try{
                writer.close();
            }catch(Exception e){
                
            }
        }
    }
    public void writeObjectFile(Object data){}
    public Object readObjectFile(String path){return null;}
    public String readStringFile(String path){
       String out = "";
        
        try{
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            String st;
            
            while((st = br.readLine()) != null){
                out += st;
            }
       }catch(Exception e){
            e.printStackTrace();
       }
       
       return out;
    }
    //Add ability to read sprites
    //Possibly create a system for loading game saves and writing to game saves
}
