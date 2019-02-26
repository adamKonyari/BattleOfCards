package com.codecool;

import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    private Scanner scanner = new Scanner(System.in);
    Deck deck = new Deck();
    Player player1;
    Player player2;

    public String getUserInput() {
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }

    public void start() {
        boolean notQuit = true;
        while (notQuit) {
            System.out.println();
            System.out.println("    1. New Game!");
            System.out.println("    2. New Parking Space!");
            System.out.println("    3. List Vehicles!");
            System.out.println("    4. Add Vehicles!");
            System.out.println("    5. Park Vehicles!");
            System.out.println("    6. UnPark Vehicles!");
            System.out.println("    7. Quit\n");
            int menuOptions = Integer.parseInt(getUserInput());

            switch (menuOptions) {
                case 1:
                    System.out.println("p1 name?: ");
                    String p1Name = getUserInput();
                    System.out.println("p1 age?: ");
                    int p1Age = Integer.parseInt(getUserInput());
                    System.out.println("p2 name?: ");
                    String p2Name = getUserInput();
                    System.out.println("p2 age?: ");
                    int p2Age = Integer.parseInt(getUserInput());
                    player1 = new Player(p1Name, p1Age, new ArrayList<>());
                    player2 = new Player(p2Name, p2Age, new ArrayList<>());
                    deck.shuffle();
                    for (int i = 0; i < deck.getCards().size(); i++) {
                        if ((i + 1) % 2 == 1) {
                            player1.addHand(deck.getCards().get(i));
                        } else {
                            player2.addHand(deck.getCards().get(i));

                        }
                    }
                    System.out.println(player1.getHand().size());
                    System.out.println(player1.getHand());
                    System.out.println(player2.getHand());
                    System.out.println(player2.getHand().size());
            }
        }
    }
}
