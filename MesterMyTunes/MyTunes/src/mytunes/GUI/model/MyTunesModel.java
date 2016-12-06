/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.GUI.model;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mytunes.be.MyTunes;
import mytunes.bll.MyTunesManager;

/**
 *
 * @author FrederikD
 */
public class MyTunesModel {
    private static MyTunesModel INSTANCE;
    
    private final ObservableList<MyTunes> allMusic;
    
    private final MyTunesManager mytunesmanager;
    
    private MyTunesModel(){
        mytunesmanager = new MyTunesManager();
        
        allMusic = FXCollections.observableArrayList();
    }
    public ObservableList<MyTunes> getAllMusic()
    {
        return allMusic;
    }
    public void SaveSongsToFile(File file) throws IOException
    {       
        mytunesmanager.saveMusic(allMusic, file);
    }
    public void LoadSongsToFile(File file) throws IOException, ClassNotFoundException{
        List<MyTunes> newAllMusic = mytunesmanager.loadMusicFiles(file);
        allMusic.setAll(newAllMusic);
        
        
    }
    
    
}
