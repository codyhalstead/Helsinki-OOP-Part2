/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cody
 */
public class Flights {
    private Airplane airplane;
    private String from;
    private String to;
    
    public Flights(Airplane airplane, String from, String to){
        this.airplane=airplane;
        this.from=from;
        this.to=to;
    }
    
    @Override
    public String toString(){
        return airplane+" ("+from+"-"+to+")";
    }
}
