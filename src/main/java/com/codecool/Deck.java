package com.codecool;

import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cards;

    public Deck(List<Card> cards) {
        this.cards = cards;
    }

    public void shuffle(List<Card> cards) {

        Collections.shuffle(cards);
    }
    public void sort(List<Card> cards) {
        Collections.sort(cards);
    }
}
