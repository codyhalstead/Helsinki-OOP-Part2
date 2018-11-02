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

public class Storehouse {
    private Map<String,Integer> inventory=new HashMap<String,Integer>();
    private Map<String,Integer> prices=new HashMap<String,Integer>();
    
    public void addProduct(String product, int price, int inventory){
        this.inventory.put(product,inventory);
        this.prices.put(product, price);
    }
    
    public int price(String product){
        if(prices.get(product)==null){
            return -99;
        }
        else{
            return prices.get(product);
    }
    }
    
    public int stock(String product){
        if(inventory.get(product)==null){
            return 0;
        }
        else{
            return inventory.get(product);
        }
    }
    
    public boolean take(String product){
        if(stock(product)>0){
            inventory.put(product,inventory.get(product)-1);
            return true;
        }
        return false;
    }
    
    public Set<String> products(){
        return inventory.keySet();
    }
}
