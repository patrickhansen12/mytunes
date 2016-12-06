/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.be;

import java.io.Serializable;

/**
 *
 * @author FrederikD
 */
public class MyTunes implements Serializable {
    
    public String songName;
    public String artistName;
    public String songCategory;
    public int playTime;
    
    public MyTunes(String songName,String artistName,String songCategory, int playTime){
        this.songName = songName;
        this.playTime = playTime;
        this.artistName = artistName;
        this.songCategory = songCategory;
    }
    
    public String getSongName()
    {
        return songName;
    }
    public String getArtistName()
    {
        return artistName;
    }
    public String getSongCategory()
    {
        return songCategory;
    }
    public int getPlayTime()
    {
        return playTime;
    }
   
}
    
    

