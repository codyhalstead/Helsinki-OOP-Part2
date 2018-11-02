/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingfigure;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Cody
 */
public abstract class Figure {
    private int x,y;
    
    public Figure(int x, int y){
        this. x = x;
        this.y = y;
    }
    
    public void move(int mx, int my){
        this.x += mx;
        this.y += my;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public abstract void draw(Graphics graphics);
}
