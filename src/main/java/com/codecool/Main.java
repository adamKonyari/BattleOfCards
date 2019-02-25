package com.codecool;



public class Main {

    public static void main(String[] args) {
        XMLParser xml = new XMLParser();
        try {
            System.out.println(xml.CardParser(xml.getDoc("heroes.xml")));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
