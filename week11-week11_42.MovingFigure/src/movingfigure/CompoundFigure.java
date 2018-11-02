/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingfigure;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**
 *
 * @author Cody
 */
public class CompoundFigure extends Figure{
    private ArrayList<Figure> figures;
    
    public CompoundFigure(){
        super(0,0);
        this.figures = new ArrayList<Figure>();
    }
    
    public void add(Figure f){
        figures.add(f);
    }
    
    @Override
    public void move(int mx, int my){
        for (Figure i : figures){
            i.move(mx, my);
        }
    }

    @Override
    public void draw(Graphics graphics) {
        for (Figure i : figures){
            i.draw(graphics);
        }
    }
}