
/**
 * Write a description of class FileManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.*;

public class FileManager //A Basic class for reading and writing data to files
{
    //Write 
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
        return "";
    }
    //Add ability to read sprites
    //Possibly create a system for loading game saves and writing to game saves
}
