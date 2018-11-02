/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import java.util.*;
import gameoflife.GameOfLifeBoard;

/**
 *
 * @author Cody
 */
public class PersonalBoard extends GameOfLifeBoard{
    
    public PersonalBoard(int width, int height){
        super(width, height);
    }

    @Override
    public void initiateRandomCells(double d) {
        Random rand = new Random();
        for (int i = 0; i < this.getHeight(); i++){
            for (int j = 0; j < this.getWidth(); j++){
                double pick = rand.nextDouble();
                if(pick < d){
                    turnToLiving(j, i);
                }
            }
        }
    }

    @Override
    public boolean isAlive(int i, int i1) {
        if (i >= 0 && i < this.getWidth() && i1 >= 0 && i1 < this.getHeight()){
            return (getBoard() [i][i1]);
        }
        return false;
    }

    @Override
    public void turnToLiving(int i, int i1) {
        if (i >= 0 && i < this.getWidth() && i1 >= 0 && i1 < this.getHeight()){
            getBoard() [i][i1] = true;
        }
    }

    @Override
    public void turnToDead(int i, int i1) {
        if (i >= 0 && i < this.getWidth() && i1 >= 0 && i1 < this.getHeight()){
            getBoard() [i][i1] = false;
        }
    }

    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
        int counter = 0;
        for (int i = -1; i < 2; i++){
            for (int j = -1; j < 2; j++){
                if (j == 0 && i == 0){
                    
                }
                else{
                    if (isAlive(x + j, y + i)){
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    @Override
    public void manageCell(int x, int y, int livingNeighbors) {
        if (livingNeighbors == 3){
            turnToLiving(x, y);
        }
        else if (livingNeighbors == 2){
            
        }
        else{
            turnToDead(x, y);
        }
    }
}
