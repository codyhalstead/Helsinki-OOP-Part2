/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import wormgame.Direction;

/**
 *
 * @author Cody
 */
public class Worm {
    private int originalX, originalY;
    private Direction originalDirection;
    private List<Piece> pieces;
    private Piece head;
    private boolean needToGrow = false;
    
    public Worm(int originalX, int originalY, Direction originalDirection){
        this.originalX = originalX;
        this.originalY = originalY;
        this.originalDirection = originalDirection;
        this.head = new Piece(originalX, originalY);
        pieces = new ArrayList<Piece>();
        pieces.add(head);
    }
    
    public Direction getDirection(){
        return originalDirection;
    }
    
    public void setDirection(Direction direction){
        originalDirection = direction;
    }
    
    public int getLength(){
        return pieces.size();
    }
    
    public List<Piece> getPieces(){
        return pieces;
    }
    
    public void move(){
        if(this.getLength()<3){
            this.needToGrow = true;
        }
        if(originalDirection == Direction.UP){
            if(!needToGrow){
                pieces.remove(0);
            }
            originalY -= 1;
            pieces.add(new Piece(originalX, originalY));
            needToGrow = false;
        }
        else if(originalDirection == Direction.DOWN){
            if(!needToGrow){
                pieces.remove(0);
            }
            originalY += 1;
            pieces.add(new Piece(originalX, originalY));
            needToGrow = false;
        }
        else if(originalDirection == Direction.LEFT){
            if(!needToGrow){
                pieces.remove(0);
            }
            originalX -= 1;
            pieces.add(new Piece(originalX, originalY));
            needToGrow = false;
        }
        else if(originalDirection == Direction.RIGHT){
            if(!needToGrow){
                pieces.remove(0);
            }
            originalX += 1;
            pieces.add(new Piece(originalX, originalY));
            needToGrow = false;
        }
    }
    
    public void grow(){
        needToGrow = true;
    }
    
    public boolean runsInto(Piece piece){
        for (Piece i : pieces){
            if(i.getX() == piece.getX() && i.getY() == piece.getY()){
                return true;
            }
        }
        return false;
    }

    public boolean runsIntoItself(){
        int helper = 0;
        for (Piece i : pieces){
            if(i.getX() == this.originalX && i.getY() == this.originalY){
                helper++;
            }
        }
        return (helper == 2);
    }  
    
    public boolean leavesBorder(int width, int height){
        return ((this.originalX < 0 || this.originalX >= width) || (this.originalY < 0 || this.originalY >= height));
    }
    
   // public void drawWorm(Graphics graphics){
        //graphics.setColor(Color.BLACK);
        //for (Piece i : pieces){
     //   graphics.fill3DRect(originalX, originalY, 20, 20, true);
        //}
   // }
}
