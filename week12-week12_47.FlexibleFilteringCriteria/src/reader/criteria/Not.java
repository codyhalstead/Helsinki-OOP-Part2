/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.criteria;

/**
 *
 * @author Cody
 */
public class Not implements Criterion {
    private Criterion search;
    
    public Not(Criterion search){
        this.search = search;
    }

    @Override
    public boolean complies(String line) {
        if (search.complies(line)){
            return false;
        }
        return true;
    }
    
}
