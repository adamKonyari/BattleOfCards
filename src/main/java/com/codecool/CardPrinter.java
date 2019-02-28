package com.codecool;

public class CardPrinter {

    String top = "/––––––––––––––––––––––––––––––––––––––––\\";
    String side = "|                                        |";
    String divider = "|––––––––––––––––––––––––––––––––––––––––|";
    String bottom = "\\––––––––––––––––––––––––––––––––––––––––/";
    String spaceBetweenCards = "      ";

    public void printer(Card card) {

        System.out.println(top);
        System.out.println(namePrinter(card.getGame()));
        System.out.println(divider);
        System.out.println(side);
        System.out.println(side);
        System.out.println(side);
        logoPrinter();
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

    public void printer(Card winnerCard, Card looserCard) {

        System.out.println(top + spaceBetweenCards + top);
        System.out.println(namePrinter(winnerCard.getGame(), looserCard.getGame()));
        System.out.println(divider + spaceBetweenCards + divider);
        System.out.println(side + spaceBetweenCards + side);
        System.out.println(side + spaceBetweenCards + side);
        System.out.println(side + spaceBetweenCards + side);
        twoLogoPrinter();
        System.out.println(side + spaceBetweenCards + side);
        System.out.println(side + spaceBetweenCards + side);
        System.out.println(side + spaceBetweenCards + side);
        System.out.println(side + spaceBetweenCards + side);
        System.out.println(divider + spaceBetweenCards + divider);
        System.out.println(namePrinter(winnerCard.getName(), looserCard.getName()));
        System.out.println(divider + spaceBetweenCards + divider);
        attributePrinter(winnerCard, looserCard);
        System.out.println(bottom + spaceBetweenCards + bottom);
    }

    public String namePrinter(String name) {
        int nameLen = name.length();
        int whiteSpacesBefore = Math.round((40 - nameLen) / 2);
        int whiteSpacesAfter = 40 - (whiteSpacesBefore + nameLen);
        return "|" + stringMultiplyer(" ", whiteSpacesBefore) + name + stringMultiplyer(" ", whiteSpacesAfter) + "|";
    }

    public String namePrinter(String winnerName, String looserName) {
        int winnerLen = winnerName.length();
        int looserLen = looserName.length();
        int whiteSpacesBeforeW = Math.round((40 - winnerLen) / 2);
        int whiteSpacesBeforeL = Math.round((40 - looserLen) / 2);
        int whiteSpacesAfterW = 40 - (whiteSpacesBeforeW + winnerLen);
        int whiteSpacesAfterL = 40 - (whiteSpacesBeforeL + looserLen);
        return "|" + stringMultiplyer(" ", whiteSpacesBeforeW) + winnerName + stringMultiplyer(" ", whiteSpacesAfterW) + "|"
            + spaceBetweenCards + "|" + stringMultiplyer(" ", whiteSpacesBeforeL) + looserName + stringMultiplyer(" ", whiteSpacesAfterL) + "|";
    }

    public void attributePrinter(Card card) {
        System.out.println(side);
        System.out.println("| 1. Strength:     " + card.getStrength() + "   2. Endurance: " + card.getEndurance() + " |");
        System.out.println(side);
        System.out.println(side);
        System.out.println("| 3. Intelligence: " + card.getIntelligence() + "   4. Agility:   " + card.getAgility() + " |");
        System.out.println(side);
    }

    public void attributePrinter(Card winnerCard, Card looserCard) {
        System.out.println(side + spaceBetweenCards + side);
        System.out.println("| 1. Strength:     " + winnerCard.getStrength() + "   2. Endurance: " + winnerCard.getEndurance() + " |"
            + spaceBetweenCards + "| 1. Strength:     " + looserCard.getStrength() + "   2. Endurance: " + looserCard.getEndurance() + " |");
        System.out.println(side + spaceBetweenCards + side);
        System.out.println(side + spaceBetweenCards + side);
        System.out.println("| 3. Intelligence: " + winnerCard.getIntelligence() + "   4. Agility:   " + winnerCard.getAgility() + " |"
            + spaceBetweenCards + "| 3. Intelligence: " + looserCard.getIntelligence() + "   4. Agility:   " + looserCard.getAgility() + " |");
        System.out.println(side + spaceBetweenCards + side);
    }

    public void logoPrinter() {
        System.out.println("|              ____        ______        |");
        System.out.println("|             / __ )____  / ____/        |");
        System.out.println("|            / __  / __ \\/ /             |");
        System.out.println("|           / /_/ / /_/ / /___           |");
        System.out.println("|          /_____/\\____/\\____/           |");
    }
    public void twoLogoPrinter() {
        System.out.println("|              ____        ______        |" + spaceBetweenCards + "|              ____        ______        |");
        System.out.println("|             / __ )____  / ____/        |" + spaceBetweenCards + "|             / __ )____  / ____/        |");
        System.out.println("|            / __  / __ \\/ /             |" + spaceBetweenCards + "|            / __  / __ \\/ /             |");
        System.out.println("|           / /_/ / /_/ / /___           |" + spaceBetweenCards + "|           / /_/ / /_/ / /___           |" );
        System.out.println("|          /_____/\\____/\\____/           |" + spaceBetweenCards + "|          /_____/\\____/\\____/           |");
    }

    public String stringMultiplyer(String s, int count) {
        String returnString = "";
        for (int i = 0; i < count; i++) {
            returnString += s;
        }
        return returnString;
    }

}
