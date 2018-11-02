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
public class Box extends Figure{
    private int depth;
    private int length;
    
    public Box(int x, int y, int length, int depth){
        super(x,y);
        this.length = length;
        this.depth = depth;
    }
    
    @Override
    public void draw(Graphics graphics) {
        graphics.fillRect(this.getX(), this.getY(), length, depth);
    }
}