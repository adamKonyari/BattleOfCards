package com.codecool;

/*
strength, endurance, intelligence, vitality
*/

public class Card {

    private String name;
    private String game;

    private int strength;
    private int endurance;
    private int intelligence;
    private int agility;

    public Card(String name, String game, int strength, int endurance, int intellingence, int agility) {
        this.name = name;
        this.game = game;
        this.strength = strength;
        this.endurance = endurance;
        this.intelligence = intellingence;
        this.agility = agility;
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

    public int getAgility() {
        return agility;
    }

    @Override
    public String toString() {
        return "Card{" +
            "name='" + name + '\'' +
            ", game='" + game + '\'' +
            ", strength=" + strength +
            ", endurance=" + endurance +
            ", intellingence=" + intelligence +
            ", agility=" + agility +
            '}';
    }
}
