/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cody
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UI {

    private Scanner input = new Scanner(System.in);
    private List<Jumpers> jumpers;
    private int round = 1;

    public UI() {
        jumpers = new ArrayList<Jumpers>();
    }

    public void start() {
        //Welcome the jumpers
        System.out.println("Kumpula ski jumping week\n");
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");

        //Get names
        getNames();

        System.out.println("\nThe tournament begins!");
        while (true) {
            System.out.print("\nWrite \"jump\" to jump; otherwise you quit: ");
            String token = input.nextLine();
            if (token.contains("jump")) {
                System.out.println("\nRound " + round + "\n");
                System.out.println("Jumping order:");

                playerOrder();

                System.out.println("\nResults of round " + round + "\n");
                takeJumps();

                round++;
            } else {
                //quit
                System.out.println("\nThanks!");
                break;
            }
        }
        results();
    }

    public void getNames() {
        while (true) {
            System.out.print("  Participant name:");
            String name = input.nextLine();

            if (name.isEmpty()) {
                break;
            } else {
                Jumpers jumper = new Jumpers(name);
                jumpers.add(jumper);
            }
        }
    }

    public void playerOrder() {
        Collections.sort(jumpers);
        Collections.reverse(jumpers);
        int i = 1;
        for (Jumpers item : jumpers) {
            System.out.println("  " + i + ". " + item);
            i++;
        }
    }

    public void takeJumps() {

        for (Jumpers item : jumpers) {

            Jump jump = new Jump();
            jump.goJump();
            item.addJump(jump.getScore(), jump.getJump());

            System.out.println("  " + item.getName());
            System.out.println("    length: " + jump.getJump());
            System.out.println("    judge votes: " + jump);
        }

    }

    public void results() {
        System.out.println("\nTournament results:");
        System.out.println("Position    Name");
        Collections.sort(jumpers);
       
        int i = 1;
        for (Jumpers item : jumpers) {
            System.out.println(i + "           " + item);
            item.printJumps();
            System.out.print("\n");
            i++;
        }
    }

}