package com.codecool;

import java.util.Collections;
import java.util.List;

public class Deck {

    private XMLParser xml = new XMLParser();
    private List<Card> cards;

    public Deck() {
        this.cards = xml.CardParser(xml.getDoc("src/main/resources/heroes.xml"));
    }

    public void shuffle() {

        Collections.shuffle(this.cards);
    }

    public void sort() {
        Collections.sort(this.cards);
    }

    public List<Card> getCards() {
        return cards;
    }
}
