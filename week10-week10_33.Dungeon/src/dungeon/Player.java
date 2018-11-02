/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

/**
 *
 * @author Cody
 */
public class Player {
    private final char symbol = '@';
    private int xPos = 0;
    private int yPos = 0;
    
    public int getX(){
        return xPos;
    }
    
    public int getY(){
        return yPos;
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
}
