package com.codecool;

public class CardPrinter {

    String top = "/––––––––––––––––––––––––––––––––––––––––\\";
    String side = "|                                        |";
    String divider = "|––––––––––––––––––––––––––––––––––––––––|";
    String bottom = "\\––––––––––––––––––––––––––––––––––––––––/";

    public void printer(Card card) {

        System.out.println(top);
        System.out.println(namePrinter(card.getGame()));
        System.out.println(divider);
        System.out.println(side);
        System.out.println(side);
        System.out.println(side);
        System.out.println(side);
        System.out.println(side);
        System.out.println(divider);
        System.out.println(namePrinter(card.getName()));
        System.out.println(divider);
        attributePrinter(card);
        System.out.println(bottom);

    }

    public String namePrinter(String name) {
        int nameLen = name.length();
        int whiteSpacesBefore = Math.round((40 - nameLen) / 2);
        int whiteSpacesAfter = 40 - (whiteSpacesBefore + nameLen);
        return "|" + stringMultiplyer(" ", whiteSpacesBefore) + name + stringMultiplyer(" ", whiteSpacesAfter) + "|";
    }

    public void attributePrinter(Card card) {
        System.out.println(side);
        System.out.println("| 1. Strength:     " + card.getStrength() + "   2. Endurance: " + card.getEndurance() + " |");
        System.out.println(side);
        System.out.println(side);
        System.out.println("| 3. Intelligence: " + card.getIntelligence() + "   4. Agility:   " + card.getAgility() + " |");
        System.out.println(side);
    }

    public String stringMultiplyer(String s, int count) {
        String returnString = "";
        for (int i = 0; i < count; i++) {
            returnString += s;
        }
        return returnString;
    }
}
