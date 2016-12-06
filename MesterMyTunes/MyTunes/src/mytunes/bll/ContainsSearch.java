/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.bll;

/**
 *
 * @author EUC
 */
public class ContainsSearch implements IWordComparer{
    
    private final String query;

    public ContainsSearch(String query) {
        this.query = query;
    }
    
    @Override
    public boolean compare(String word) {
        return word.contains(query);
    }
    
}
