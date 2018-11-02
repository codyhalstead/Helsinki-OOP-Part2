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

public class ShoppingBasket {
    private Map<String,Purchase> basket;
    
    public ShoppingBasket(){
        this.basket=new HashMap<String,Purchase>();
        
    }
    
    public void add(String product, int price){
        if(basket.containsKey(product)){
            basket.get(product).increaseAmount();
        }
        else{
            basket.put(product, new Purchase(product,1,price));
        }
    }
    
    public int price(){
        int cost=0;
        for(Purchase i:basket.values()){
            cost+=i.price();
        }
        return cost;
    }
    
    public void print() {
        for (Purchase purchase : this.basket.values()) {
            System.out.println(purchase);}}
    
}
