/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.bll;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import mytunes.dal.MytunesDAO;

/**
 *
 * @author pgn
 */
public class WordManager {

    private MytunesDAO wordDAO;

    /**
     * Constructs a wordManager object.
     */
    public WordManager() {
        wordDAO = new MytunesDAO();
        
    }

    /**
     * Gets all the searchable words.
     * @return List of all words;
     */
    public List<String> getAllWords() throws FileNotFoundException {
        List<String> allWords = wordDAO.getAllWords();
        return allWords;
    }
    
    public List<String> search(IWordComparer comparer) throws FileNotFoundException
    {
        List<String> allWords = getAllWords();
        List<String> result = new ArrayList<>();
        for(String word : allWords)
        {
            if(comparer.compare(word))
            {
                result.add(word);
            }
        }
        return result;
    }
}
