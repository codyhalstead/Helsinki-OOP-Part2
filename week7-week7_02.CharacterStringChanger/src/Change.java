/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cody
 */
public class Change {
    private char origionalChar;
    private char changeTo;
    
    public Change(char origionalChar, char changeTo){
        this.origionalChar=origionalChar;
        this.changeTo=changeTo;
    }
    
    public String change(String wordToModify){
        return wordToModify.replace(origionalChar, changeTo);
    }
    
}
