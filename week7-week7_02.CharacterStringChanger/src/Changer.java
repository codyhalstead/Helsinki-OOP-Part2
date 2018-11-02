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

public class Changer {
    private ArrayList<Change> changes;
    
    public Changer(){
        changes=new ArrayList<Change>();
    }
    
    public void addChange(Change change){
        this.changes.add(change);
    }
    
    public String change(String characterString){
        for(Change i:changes){
           characterString = i.change(characterString);
        }
        return characterString;
    }
}
