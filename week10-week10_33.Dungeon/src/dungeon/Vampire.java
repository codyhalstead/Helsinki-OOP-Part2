/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;
import java.util.*;
/**
 *
 * @author Cody
 */
public class Vampire {
    private int heightOfGame;
    private int widthOfGame;
    private int xPos;
    private int yPos;
    private final char symbol = 'v';
    
    public Vampire(int height, int width){
        this.heightOfGame = height;
        this.widthOfGame = width;
    }
    
    public char getSymbol(){
        return symbol;
    }
    
    public void setX(int x){
        xPos = x;
    }
    
    public void setY(int y){
        yPos = y;
    }
    
    public int getX(){
        return xPos;
    }
    
    public int getY(){
        return yPos;
    }
}
