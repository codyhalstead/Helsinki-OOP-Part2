/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.*;

/**
 *
 * @author Cody
 */
public class PersonalDuplicateRemover implements DuplicateRemover {
    private Set<String> words;
    private int duplicates = 0;
    
    public PersonalDuplicateRemover(){
        this.words = new HashSet<String>();
    }

    @Override
    public void add(String characterString) {
        if(words.contains(characterString)){
            duplicates++;
        }
        words.add(characterString);
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        return duplicates;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        return words;
        }

    @Override
    public void empty(){
        words.clear();
        duplicates = 0;
    }
    
}
