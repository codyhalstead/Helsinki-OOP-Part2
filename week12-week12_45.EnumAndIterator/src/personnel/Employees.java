/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnel;
import java.util.*;
/**
 *
 * @author Cody
 */
public class Employees {
    private List<Person> employees = new ArrayList<Person>();
    
    public void add(Person person){
        employees.add(person);
    }
    
    public void add(List<Person> people){
        for (Person i : people){
            employees.add(i);
        }
    }
    
    public void print(){
        Iterator<Person> iter = employees.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }
    
    public void print (Education education){
        Iterator<Person> iter = employees.iterator();
        while (iter.hasNext()){
            Person x = iter.next();
            if (x.getEducation() == education){
                System.out.println(x);
            }
        }
    }
    
    public void fire(Education education){
        Iterator<Person> iter = employees.iterator();
        while (iter.hasNext()){
            if (iter.next().getEducation() == education){
                iter.remove();
            }
        }
    }
}
