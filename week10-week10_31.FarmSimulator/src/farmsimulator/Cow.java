/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;
import java.util.*;
/**
 *
 * @author Cody
 */
public class Cow implements Alive, Milkable{
        private static final String[] NAMES = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};
        private String name;
        private double UdderCap;
        private double volume = 0;
        
    public Cow(){
        this.name = NAMES[new Random().nextInt(NAMES.length)];
        this.UdderCap = 15 + new Random().nextInt(26);
    }
    
    public Cow(String name){
        this.name = name;
        this.UdderCap = 15 + new Random().nextInt(26) * 1.0;
    }
    
    public String getName(){
        return this.name;
    }
    
    public double getCapacity(){
        return this.UdderCap;
    }
    
    public double getAmount(){
        return this.volume;
    }
    
    @Override
    public String toString(){
        return this.name + " " + Math.ceil(volume) + "/" + this.UdderCap;
    }

    @Override
    public void liveHour() {
        this.volume += (7 + new Random().nextInt(14) * 1.0) / 10;
        if (this.volume > this.UdderCap){
            volume = UdderCap;
        }
    }

    @Override
    public double milk() {
        double milked = this.volume;
        this.volume = 0.0;
        return milked;
    }
}
