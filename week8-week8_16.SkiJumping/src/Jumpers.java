/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cody
 */

import java.util.ArrayList;
import java.util.List;

public class Jumpers implements Comparable<Jumpers> {

    private String name;
    private int points;
    private List<Integer> jumps;

    public Jumpers(String name) {
        this.name = name;
        jumps = new ArrayList<Integer>();
    }

    public void addJump(int points, int jump) {
        this.points += points;
        jumps.add(jump);
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Jumpers jumper) {
        return jumper.points - this.points;
        }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return name + " (" + points + " points)";
    }

    public void printJumps() {
        System.out.print("            jump lengths: ");
        
        int i = 0;
        for (Integer item : jumps) {

            
            if (i < jumps.size() - 1) {
                System.out.print(item + "m, ");
                
                
            } else {
                System.out.print(item + "m");
            }
            System.out.print("");
            i++;
        }
    }

}