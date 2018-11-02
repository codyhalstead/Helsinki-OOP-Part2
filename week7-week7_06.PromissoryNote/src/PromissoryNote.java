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

public class PromissoryNote {
    private HashMap<String,Double> loans;
    
    public PromissoryNote(){
        this.loans=new HashMap<String,Double>();
    }
    
    public void setLoan(String toWhom, double value){
        loans.put(toWhom, value);
    }
    
    public double howMuchIsTheDebt(String whose){
        if(this.loans.containsKey(whose)){
        return loans.get(whose);
        }
        return 0;
    }
}
