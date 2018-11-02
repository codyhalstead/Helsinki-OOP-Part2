/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cody
 */
public class CD implements ToBeStored{
    private String artist;
    private String title;
    private int pubYear;
    private double weight;
    
    public CD(String artist, String title, int pubYear){
        this.artist=artist;
        this.title=title;
        this.pubYear=pubYear;
        this.weight=0.1;
    }
    
    @Override
    public double weight(){
        return this.weight;
    }
    
    @Override
    public String toString(){
        return this.artist+": "+this.title+" ("+this.pubYear+")";
    }
}
