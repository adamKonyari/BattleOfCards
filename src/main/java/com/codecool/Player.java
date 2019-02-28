package com.codecool;

import java.util.List;

public class Player {
    private int age;
    private String name;
    private List<Card> hand;
    private boolean starts = false;

    public Player(String name,int age, List<Card> hand) {
        this.age = age;
        this.name = name;
        this.hand = hand;
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public boolean ifStarts() {
        return starts;
    }

    public void starts() {
        this.starts = true;
    }

    public void doesNotStart() {
        this.starts = false;
    }

    public void addCardToHand(Card card){
        hand.add(card);
    }

    public void lostTheRound(){
        hand.remove(0);
    }

    public void wonTheRound() {
        Card tempCard = this.hand.get(0);
        this.hand.remove(tempCard);
        this.hand.add(tempCard);
    }
}
