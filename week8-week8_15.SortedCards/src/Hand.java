/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cody
 */
import java.util.*;

public class Hand implements Comparable<Hand>{
    private ArrayList<Card> cards;
    
    public Hand(){
        cards=new ArrayList<Card>();
    }
    
    public void add(Card card){
        cards.add(card);
    }
    
    public void print(){
        for(Card i:cards){
            System.out.println(i);
        }
    }
    
    public void sort(){
        Collections.sort(cards);
    }
    
    @Override
    public int compareTo(Hand hand){
        int thisHand=0, otherHand=0;
        for(Card i:this.cards){
            thisHand+=i.getValue();
        }
        for(Card i:hand.cards){
            otherHand+=i.getValue();
        }
        return thisHand-otherHand;
    }
    
    public void sortAgainstSuit(){
        SortAgainstSuitAndValue sorter=new SortAgainstSuitAndValue();
        Collections.sort(this.cards, sorter);
    }
    
}
