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
public class Both implements Criterion{
    private Criterion search1;
    private Criterion search2;
    
    public Both(Criterion search1, Criterion search2){
        this.search1 = search1;
        this.search2 = search2;
    }

    @Override
    public boolean complies(String line) {
        if (search1.complies(line) == true && search2.complies(line) == true){
            return true;
        }
        return false;
    }
    
}
