package com.codecool;

/*
strength, endurance, intelligence, vitality


*/

public class Card implements Comparable<Card>{

    private String name;
    private String game;

    private int strength;
    private int endurance;
    private int intelligence;
    private int vitality;

    public Card(String name, String game, int strength, int endurance, int intellingence, int vitality) {
        this.name = name;
        this.game = game;
        this.strength = strength;
        this.endurance = endurance;
        this.intelligence = intellingence;
        this.vitality = vitality;
    }

    public String getName() {
        return name;
    }

    public String getGame() {
        return game;
    }

    public int getStrength() {
        return strength;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getVitality() {
        return vitality;
    }


    @Override
    public int compareTo(Card o) {

        return this.getName().compareTo(o.getName());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
