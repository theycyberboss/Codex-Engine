
/**
 * Write a description of class AudioManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import  sun.audio.*;    //import the sun.audio package
import  java.io.*;
import java.util.*;
import javax.sound.sampled.*;
public class AudioManager
{
    private HashMap<String,AudioStream> audioTracks;
    private HashMap<String,File> soundTracks;
    //Default constuctor
    public AudioManager(Engine eng){
        audioTracks = new HashMap<String, AudioStream> ();
        soundTracks = new HashMap<String, File> ();
    }
    
    
    //Function used to add an audio file with a specific name
    //that it can be refered to when it needs to be useds
    public void addClip(String key, File file){
        try{
            AudioStream temp = new AudioStream(new FileInputStream(file));
            audioTracks.put(key,temp);
            
        }catch(Exception e){
            
        }
        
    }
    
    //Function used to add an audio file based on the path of the file
    //file is then given a name that it can be refered to when it is needed
    public void addClip(String key, String file){
        try{
            AudioStream temp = new AudioStream(new FileInputStream(file));
            audioTracks.put(key,temp);
            
        }catch(Exception e){
            
        }
        
    }
    
    //Function used to add a sound clip to the soundTrack map
    //we have a seperate function becasuse sound clips are created and operate
    //differently then normal music clips
    public void addSoundClip(String key, String file){
        try{
            AudioStream temp = new AudioStream(new FileInputStream(file));
            soundTracks.put(key,new File(file));
            
        }catch(Exception e){
            
        }
        
    }
    
    public void addSoundClip(String key, File file){
        try{
            AudioStream temp = new AudioStream(new FileInputStream(file));
            soundTracks.put(key,file);
            
        }catch(Exception e){
            
        }
        
    }
    
    //Function used to remove audio clips from the manager
    public void removeClip(String key){
        audioTracks.remove(key);
    }
    
    //Function used to play a specified track
    public void play(String key){
        AudioStream temp = audioTracks.get(key);
       AudioPlayer.player.start(temp);
       
    }
    public void playSound(String key){
       AudioStream temp = audioTracks.get(key);
       try{
           AudioPlayer.player.start(new AudioStream(new FileInputStream(soundTracks.get(key))));
        }catch(Exception e){
            
        }
       
       
    }
    
    
        
    
  
    
    //Function used to stop a specific track
    public void stop(String key){
        AudioPlayer.player.stop(audioTracks.get(key));
    }
    
    public void loop(String key){
       //  AudioPlayer.player.loop(audioTracks.get(key));
    }
    
}
