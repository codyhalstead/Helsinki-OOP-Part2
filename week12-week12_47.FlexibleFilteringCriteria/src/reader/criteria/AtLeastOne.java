/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.criteria;
import java.util.*;
/**
 *
 * @author Cody
 */
public class AtLeastOne implements Criterion{
    private Criterion[] search;
    
    public AtLeastOne(Criterion... search){
    this.search = search;   
    }

    @Override
    public boolean complies(String line) {
        for (Criterion i : search){
            if (i.complies(line)){
                return true;
            }
        }
        return false;
    }
    
}
