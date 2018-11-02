/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cody
 */
public class Calculator {
    private Reader reader;
    private int calculations;
    
    public Calculator(){
        this.reader=new Reader();
        this.calculations=0;
    }
    
    public void start() {
        while (true) {
            System.out.print("command: ");
            String command = reader.readString();
            if (command.equals("end")) {
                break;
            }

            if (command.equals("sum")) {
                sum();
            } else if (command.equals("difference")) {
                difference();
            } else if (command.equals("product")) {
                product();
            }
        }

        statistics();
    }
    
    private void sum(){
        System.out.print("Value1: ");
        int val1=reader.readInteger();
        System.out.print("Value2: ");
        int val2=reader.readInteger();
        System.out.println("sum of the values "+(val1+val2));
        calculations++;
        System.out.println("");
    }
    
    private void difference(){
        System.out.print("Value1: ");
        int val1=reader.readInteger();
        System.out.print("Value2: ");
        int val2=reader.readInteger();
        System.out.println("difference of the vaules "+(val1-val2));
        calculations++;
        System.out.println("");
    }
    
    private void product(){
        System.out.print("Value1: ");
        int val1=reader.readInteger();
        System.out.print("Value2: ");
        int val2=reader.readInteger();
        System.out.println("product of the values "+(val1*val2));
        calculations++;
        System.out.println("");
    }
        
    private void statistics(){
        System.out.println("Calculations done "+calculations);
    }
}
