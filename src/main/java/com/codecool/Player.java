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

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public boolean isStarts() {
        return starts;
    }

    public void starts() {
        this.starts = true;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }
    public void addHand(Card card){
        hand.add(card);
    }
    public void removeCardFromHand(Card card){
        hand.remove(card);
    }
    public void addCardToHand(Card card) { hand.add(card);}
}
