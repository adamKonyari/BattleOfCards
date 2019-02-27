package com.codecool;

import java.util.*;

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
            while (true) {
                menuPrinter(new String[]{
                    "New Game!",
                    "Not implemented"
                });
                System.out.print("Please select an option: ");
                try {
                    menuOption = Integer.parseInt(getUserInput());
                    break;
                } catch (NumberFormatException ne) {
                    System.out.println("Invalid input. Please try again!");
                    promptEnterKey();
                    continue;
                }
            }
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
        String p1Name;
        String p2Name;
        int p2Age;
        int p1Age;
        while (true) {
            try {
                System.out.print("Player one name: ");
                p1Name = getUserInput();
                System.out.print("Player one age: ");
                p1Age = Integer.parseInt(getUserInput());
                System.out.print("Player two name: ");
                p2Name = getUserInput();
                System.out.print("Player two age: ");
                p2Age = Integer.parseInt(getUserInput());
                break;
            } catch (NumberFormatException ne) {
                System.out.println("Invalid input. Please try again!");
                promptEnterKey();
                continue;
            }
        }
        player1 = new Player(p1Name, p1Age, new ArrayList<>());
        player2 = new Player(p2Name, p2Age, new ArrayList<>());
        if (p1Age <= p2Age) {
            player1.starts();
        } else
            player2.starts();

        deck.shuffle();

        for (int i = 0; i < deck.getCards().size(); i++) {
            if ((i + 1) % 2 == 1) {
                player1.addCardToHand(deck.getCards().get(i));
            } else {
                player2.addCardToHand(deck.getCards().get(i));
            }
        }
    }

    public void pvp() {
        do {
            if (player1.ifStarts()) {
                round(player1, player2);
            } else {
                round(player2, player1);
            }
            System.out.println("p1: " + player1.getHand().size());
            System.out.println("p2: " + player2.getHand().size());
        } while (player1.getHand().size() != 0 && player2.getHand().size() != 0);

        if (player2.getHand().size() == 0) {
            System.out.println(player1.getName() + " won the game!");
        } else if (player1.getHand().size() == 0) {
            System.out.println(player2.getName() + " won the game!");
        }
        promptEnterKey();
    }

    private Player round(Player p1, Player p2) {

        List<Card> cardsToCompare = new ArrayList<>();
        int input;
        System.out.println(p1.getName() + " will start!");
        if (p1.getHand().size() != 0 && p2.getHand().size() != 0) {
            cardsToCompare.add(p1.getHand().get(0));
            cardsToCompare.add(p2.getHand().get(0));
        }
        cardDrawer(p1.getHand().get(0));

        System.out.println("1. Strength\n2. Endurance\n3. Intelligence\n4. Agility\n");
        System.out.print("Choose an attribute: ");
        input = Integer.parseInt(getUserInput());

        switch (input) {
            case 1:
                Collections.sort(cardsToCompare, strengthComp);
                break;
            case 2:
                Collections.sort(cardsToCompare, enduranceComp);
                break;
            case 3:
                Collections.sort(cardsToCompare, intelligenceComp);
                break;
            case 4:
                Collections.sort(cardsToCompare, agilityComp);
                break;
        }
        Card winnerCard = cardsToCompare.get(0);
        Card looserCard = cardsToCompare.get(1);

        if (p1.getHand().get(0) == winnerCard) {
            System.out.println("The looser card is:");
            cardDrawer(looserCard);
            System.out.println("The winner card is:");
            cardDrawer(winnerCard);
            System.out.println(p1.getName() + " won the round.");
            p1.wonTheRound();
            p2.lostTheRound();
            p1.addCardToHand(looserCard);
            //promptEnterKey();
            return p1;
        } else {
            System.out.println("The looser card is:");
            cardDrawer(looserCard);
            System.out.println("The winner card is:");
            cardDrawer(winnerCard);

            System.out.println(p2.getName() + " won the round.");
            p2.wonTheRound();
            p1.lostTheRound();
            p2.addCardToHand(looserCard);
            p2.starts();
            p1.doesNotStart();
            //promptEnterKey();
            return p2;
        }
    }


    Comparator<Card> strengthComp = new Comparator<Card>() {
        @Override
        public int compare(Card o1, Card o2) {
            if (o1.getStrength() < o2.getStrength()) {
                return 1;
            } else if ((o1.getStrength() > o2.getStrength())) {
                return -1;
            }
            return 0;
        }
    };

    Comparator<Card> enduranceComp = new Comparator<Card>() {
        @Override
        public int compare(Card o1, Card o2) {
            if (o1.getEndurance() < o2.getEndurance()) {
                return 1;
            } else if ((o1.getEndurance() > o2.getEndurance())) {
                return -1;
            }
            return 0;
        }
    };

    Comparator<Card> agilityComp = new Comparator<Card>() {
        @Override
        public int compare(Card o1, Card o2) {
            if (o1.getAgility() < o2.getAgility()) {
                return 1;
            } else if ((o1.getAgility() > o2.getAgility())) {
                return -1;
            }
            return 0;
        }
    };

    Comparator<Card> intelligenceComp = new Comparator<Card>() {
        @Override
        public int compare(Card o1, Card o2) {
            if (o1.getIntelligence() < o2.getIntelligence()) {
                return 1;
            } else if ((o1.getIntelligence() > o2.getIntelligence())) {
                return -1;
            }
            return 0;
        }
    };
}
