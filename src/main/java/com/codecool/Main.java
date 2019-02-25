package com.codecool;



public class Main {

    public static void main(String[] args) {
        XMLParser xml = new XMLParser();
        try {
            System.out.println(xml.CardParser(xml.getDoc("src/main/resources/heroes.xml")));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
