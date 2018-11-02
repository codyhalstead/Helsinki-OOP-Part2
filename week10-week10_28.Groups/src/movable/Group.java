/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movable;
import java.util.*;
/**
 *
 * @author Cody
 */
public class Group implements Movable{
    private List<Movable> list;
    
    public Group(){
    this.list = new ArrayList<Movable>();    
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Movable movable : list) {
            sb.append(movable.toString()).append("\n");
        }
        return sb.toString();
    }
    
    public void addToGroup(Movable movable){
        list.add(movable);
    }
    
    @Override
    public void move(int dx, int dy){
        for(Movable i : list){
            i.move(dx, dy);
        }
    }
}
