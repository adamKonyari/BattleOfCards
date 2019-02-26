package com.codecool;

import java.util.ArrayList;
import java.util.Scanner;

public class Gameplay {
    private Scanner scanner = new Scanner(System.in);
    Deck deck = new Deck();
    Player player1;
    Player player2;
    Player firstPlayer;
    Player secondPlayer;

    public void start() {

        int menuOption;

        do {
            menuPrinter(new String[]{
                "New Game!",
                "Not implemented"
            });

            System.out.print("Please select an option: ");
            menuOption = Integer.parseInt(getUserInput());

            switch (menuOption) {
                case 1:
                    playerSetup();
                    pvp();
                    break;
            }
        }
        while (menuOption != 0);
    }

    public void cardDrawer(Card card) {
        System.out.println("Game: " + card.getGame());
        System.out.println("Hero: " + card.getName());
        System.out.println("Strength: " + card.getStrength());
        System.out.println("Endurance: " + card.getEndurance());
        System.out.println("Intelligence: " + card.getIntelligence());
        System.out.println("Agility: " + card.getAgility());
    }


    private void menuPrinter(String[] options) {
        int counter = 1;
        for (String option : options) {
            System.out.println(counter + ". " + option);
            counter++;
        }
        System.out.println("0. Exit\n");
    }

    void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    void promptEnterKey() {
        System.out.println("\n Press \"ENTER\" to continue...");
        scanner.nextLine();
    }

    public String getUserInput() {
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }

    private void playerSetup() {
        System.out.print("Player one name: ");
        String p1Name = getUserInput();
        System.out.print("Player one age: ");
        int p1Age = Integer.parseInt(getUserInput());
        System.out.print("Player two name: ");
        String p2Name = getUserInput();
        System.out.print("Player two age: ");
        int p2Age = Integer.parseInt(getUserInput());

        player1 = new Player(p1Name, p1Age, new ArrayList<>());
        player2 = new Player(p2Name, p2Age, new ArrayList<>());
        if (p1Age <= p2Age) {
            player1.starts();
        } else
            player2.starts();

        deck.shuffle();

        for (int i = 0; i < deck.getCards().size(); i++) {
            if ((i + 1) % 2 == 1) {
                player1.addHand(deck.getCards().get(i));
            } else {
                player2.addHand(deck.getCards().get(i));
            }
        }
        promptEnterKey();
    }

    public void pvp(){

        if(player1.isStarts()){
            firstPlayer = player1;
            secondPlayer = player2;
        }
        else{
            firstPlayer = player2;
            secondPlayer = player1;
        }
        System.out.println(firstPlayer.getName());

        cardDrawer(firstPlayer.getHand().get(0));
    }


}
