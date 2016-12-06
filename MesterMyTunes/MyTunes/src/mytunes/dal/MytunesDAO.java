/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.dal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;  
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import mytunes.be.MyTunes;

/**
 *
 * @author FrederikD
 */
public class MytunesDAO {
    private static final String wordFileName = "brit-a-z.txt";
    
        public void saveMusicToFile(List<MyTunes> allMusic, File file) throws IOException
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file)))
        {
            oos.writeObject(allMusic);
        }
    }
    
    public List<MyTunes> loadMusicFromFile(File file) throws IOException, ClassNotFoundException
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file)))
        {
            return (List<MyTunes>) ois.readObject();
        }
    }
    
    
      public List<String> getAllWords() throws FileNotFoundException 
    {
        
        ArrayList<String> words = new ArrayList<>();

        //1 get a hold of the file:
        File wordFile = new File(wordFileName);
        //2 Put the file in a file reader so we can read characters in from the file:
        FileReader fr = new FileReader(wordFile);
        //3 Put the file reader in a buffered reader to increase efficiency 
        //(Like videos on youtube are buffered):
        BufferedReader br = new BufferedReader(fr);
        //4 Put the buffered reader in a scanner just to get some usefull functionality:
        Scanner scan = new Scanner(br);
        
        //Start iterating on the data, as long as there are new lines:
        while(scan.hasNextLine())
        {
            //We extract the current nextline:
            String word = scan.nextLine();
            //We add the line to our arraylist of words:
            words.add(word);
        }
        //We close the scanner, and thus all the used connections to the file:
        scan.close();
        //We return the list of words:
        return words;
    }
    
}
