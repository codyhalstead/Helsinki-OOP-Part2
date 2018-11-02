/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cody
 */
import java.util.*;

public class Dictionary {
    private HashMap<String,String> translation;
    
    public Dictionary(){
        this.translation=new HashMap<String,String>();
    }
    
    public String translate(String word){
        if(translation.containsKey(word)){
            return translation.get(word);
        }
        return null;
    }
    
    public void add(String word, String translation){
        this.translation.put(word,translation);
    }
    
    public int amountOfWords(){
        return this.translation.size();
    }
    
    public ArrayList<String> translationList(){
        ArrayList<String> translationList=new ArrayList<String>();
        for(String key:translation.keySet()){
            translationList.add(key+" = "+translate(key));
        }
        return translationList;
    }
}
