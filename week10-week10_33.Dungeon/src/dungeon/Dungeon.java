/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;
import java.util.*;
/**
 *
 * @author Cody
 */
public class Dungeon {
    private int length;
    private int height;
    private int vampires;
    private int moves;
    private boolean vampireMoves;
    private List<Vampire> allVampires = new ArrayList<Vampire>();
    private Player player = new Player();
    private Scanner reader = new Scanner(System.in);
    
    public Dungeon(int length, int height, int vampires, int moves, boolean vampireMoves){
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.moves = moves;
        this.vampireMoves = vampireMoves;
        for (int i = 0; i < vampires; i++){
            allVampires.add(new Vampire(height, length));
        }
    }
    
    
    
    public void drawBoard(){
        int holder = 0;
        for (int i = 0; i < height; i++){
            for (int j = 0; j < length; j++){
                for (Vampire vamp : allVampires){
                    if (vamp.getX() == j && vamp.getY() == i){
                        holder ++;
                        System.out.print(vamp.getSymbol());
                    }
                }
                if (player.getX() == j && player.getY() == i){
                    holder ++;
                    System.out.print(player.getSymbol());
                }
                if (holder == 0){
                    System.out.print(".");
                }
                else {
                    holder --;
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public void setVampStart(){
        for(Vampire i : allVampires){
            Random randomizer = new Random();
            while(true){
                int x = randomizer.nextInt(length);
                int y = randomizer.nextInt(height);
                if(x != 0 && y != 0 && this.isFree(x, y)){
                    i.setX(x);
                    i.setY(y);
                    break;
                }
            }
        }
    }
    
    public boolean isFree(int x, int y){
        for (Vampire i : allVampires){
            int currentX = i.getX();
            int currentY = i.getY();
            if (currentX == x && currentY == y){
                return false;
            }
        }
        return true;
    }
    
    public void printAllPos() {
        System.out.println(player.getSymbol() + " " + player.getX() + " " + player.getY());
        for (Vampire i : allVampires) {
            System.out.println(i.getSymbol() + " " + i.getX() + " " + i.getY());
        }
    }
    
    public void run(){
        setVampStart();
        while (true){
            if (allDead()){
                System.out.println("YOU WIN");
                break;
            }
            if (this.moves == 0){
                System.out.println("YOU LOSE");
                break;
            }
            System.out.println(this.moves + "\n");
            printAllPos();
            System.out.println("");
            drawBoard();
            turn();
        }
    }
    
    public boolean allDead(){
        return allVampires.isEmpty();
    }
    
   
    
    public void turn(){
        String input = reader.nextLine();
        if (input.contains("\n")){
            input = "p";  
        }
        for (int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if (c == 'a'){
                if (player.getX() - 1 >= 0){
                    player.setX(player.getX() - 1);
                    catchVamp();
                }
            }
            if (c == 'w'){
                if (player.getY() - 1 >= 0){
                    player.setY(player.getY() - 1);
                    catchVamp();
                }
            }
            if (c == 'd'){
                if (player.getX() + 1 < length){
                    player.setX(player.getX() + 1);
                    catchVamp();
                }
            }
            if (c == 's'){
                if (player.getY() + 1 < height){
                    player.setY(player.getY() + 1);
                    catchVamp();
                }
            }
            if (c == 'p'){
                System.out.println("YOU LOSE");
                this.moves = 0;
                break;
           }
            moveVamps();
        }
        this.moves--;
    }
    
    public void catchVamp(){
        List<Vampire> toRemove = new ArrayList<Vampire>();
        for (Vampire i : allVampires){
            if (i.getX() == player.getX() && i.getY() == player.getY()){
                toRemove.add(i);
            }
        }
        allVampires.removeAll(toRemove);
    }
    
    public void moveVamps(){
        Random randGen = new Random();
        if (vampireMoves){
            for (Vampire i : allVampires){
                int rand = randGen.nextInt(4);
                if (rand == 0){
                    if (i.getX() - 1 >= 0 && this.isFree(i.getX() - 1, i.getY())){
                        i.setX(i.getX() - 1);
                    }
                }
                if (rand == 1){
                    if (i.getY() - 1 >= 0 && this.isFree(i.getX(), i.getY() - 1)){
                        i.setY(i.getY() - 1);
                    }
                }
                if (rand == 2){
                    if (i.getX() + 1 < length && this.isFree(i.getX() + 1, i.getY())){
                        i.setX(i.getX() + 1);
                    }
                }
                if (rand == 3){
                    if (i.getY() + 1 < height && this.isFree(i.getX(), i.getY() + 1)){
                        i.setY(i.getY() + 1);
                    }
                }
            }
        }
    }
}    

