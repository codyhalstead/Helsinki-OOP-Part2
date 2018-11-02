/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;
import java.util.*;
/**
 *
 * @author Cody
 */
public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary {
    private Map<String,Set<String>> words;
    
    public PersonalMultipleEntryDictionary(){
        this.words = new HashMap<String,Set<String>>();
    }

    @Override
    public void add(String wordi, String entry) {
         if(!this.words.containsKey(wordi)){
             this.words.put(wordi, new HashSet<String>());
         }
         Set<String> word = this.words.get(wordi);
         word.add(entry);
    }

    @Override
    public Set<String> translate(String word) {
        return words.get(word);
    }

    @Override
    public void remove(String word) {
        words.remove(word);
    }
    
}
