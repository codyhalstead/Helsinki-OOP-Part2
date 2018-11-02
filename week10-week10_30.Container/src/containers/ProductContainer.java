/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

/**
 *
 * @author Cody
 */
public class ProductContainer extends Container{
    private String productName;

    public ProductContainer(String name, double tilavuus) {
        super(tilavuus);
        this.productName = name;
    }
    
    public String getName(){
        return this.productName;
    }
    
    public void setName(String newName){
        this.productName = newName;
    }
    
    @Override
    public String toString(){
        return this.productName + ": " + super.toString();
    }
}
