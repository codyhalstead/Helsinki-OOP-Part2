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

public class Manager {
    private Scanner reader;
    private ArrayList<Airplane> planes;
    private ArrayList<Flights> flights;
    
    public Manager(Scanner reader){
        this.reader=reader;
        this.planes=new ArrayList<Airplane>();
        this.flights=new ArrayList<Flights>();
    }
    
    public void start(){
        airportPanal();
        System.out.println("");
        flightService();
    }
    
    private void airportPanal(){
        System.out.println("Airport panel");
        System.out.println("--------------------\n");
        while(true){
            System.out.print("Choose operation:\n"
                    +"[1] Add airplane\n"
                    +"[2] Add flight\n"
                    +"[x] Exit\n"
                    +"> ");
            String choice=reader.nextLine();
            if (choice.equals("x")){
                break;
            }
            else if(choice.equals("1")){
                addPlane();
            }
            else if(choice.equals("2")){
                addFlight();
            }
        }
    }
        
    
    private void flightService(){
        System.out.println("Flight service");
        System.out.println("------------\n");
        while(true){
            System.out.print("Choose operation:\n"
                    +"[1] Print planes\n"
                    +"[2] Print flights\n"
                    +"[3] Print plane info\n"
                    +"[x] Quit\n"
                    +"> ");
            String choice=reader.nextLine();
            if(choice.equals("x")){
                break;
            }
            else if(choice.equals("1")){
                for(Airplane i:planes){
                    System.out.println(i);
                
                }
                System.out.println("");
            }
            else if(choice.equals("2")){
                for(Flights i:flights){
                    System.out.println(i);
                }
                System.out.println("");
            }
            else if(choice.equals("3")){
                planeInfo();
                System.out.println("");
            }
            
        }
        
    }
    
    private void addPlane(){
        System.out.print("Give plane ID: ");
        String id=reader.nextLine();
        System.out.print("Give plane capacity: ");
        int capacity=Integer.parseInt(reader.nextLine());
        planes.add(new Airplane(id,capacity));
        }
    
    private void addFlight(){
        System.out.print("Give plane ID: ");
        String id=reader.nextLine();
        System.out.print("Give departure airport code: ");
        String dep=reader.nextLine();
        System.out.println("Give destination airport code: ");
        String des=reader.nextLine();
        flights.add(new Flights(findPlane(id,planes), dep, des));
    }
    
    private Airplane findPlane(String id, ArrayList<Airplane> planes){
        for(Airplane i:planes){
            if(id.equals(i.getId())){
                return i;
            }
        }
        return null;
    }
    
    private void planeInfo(){
        System.out.print("Give plane ID: ");
        String id=reader.nextLine();
        System.out.println(findPlane(id,planes));
    }
    
    
}
