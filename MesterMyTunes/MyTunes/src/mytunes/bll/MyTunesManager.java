/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.bll;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import mytunes.be.MyTunes;
import mytunes.dal.MytunesDAO;

/**
 *
 * @author FrederikD
 */
public class MyTunesManager {
    private MytunesDAO mytunesDAO;
    
    public MyTunesManager()
    {
        mytunesDAO = new MytunesDAO();
    }
    /**
     * Creates a new song object
     * @param songName
     * @param artistName
     * @param songCategory
     * @param playTime
     * @return 
     */
    public MyTunes createNewSong(String songName,String artistName,String songCategory, int playTime)
    {
        return new MyTunes(songName, artistName, songCategory, playTime);
    }
    
    public List<MyTunes> loadMusicFiles(File file) throws IOException, ClassNotFoundException
    {
       return mytunesDAO.loadMusicFromFile(file);
    }
    public void saveMusic(List<MyTunes> allMusic, File file) throws IOException
    {
        //Because the observerable list is not serializable we have to convert it to a normal arraylist.
        ArrayList<MyTunes> serializableList = new ArrayList<>(allMusic);
        mytunesDAO.saveMusicToFile(serializableList, file);
    }
}
