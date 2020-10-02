package com.company;

import java.util.ArrayList;
import java.util.Collections;

abstract class MusicShop implements Comparable<MusicShop>{

    abstract double getOverallPrice();
    @Override
    public int compareTo(MusicShop s)
    {
        return Double.compare(this.getOverallPrice(), s.getOverallPrice()); // compare prices in the storage
    }

}
class Guitar extends MusicShop
{
    Guitar(int price, int quantity)
    {
        this.price = price;
        this.quantity = quantity;
    }
    int price;
    int quantity;
    @Override
    double getOverallPrice() {
        return price*quantity;
    }
    public String toString(){
        return " Guitar's price: "+price+" Guitar's quantity: "+quantity;
    }
    @Override
    public boolean equals(Object s) {
        if (s == this) {
            return true;
        }
        if (!(s instanceof Guitar)) {
            return false;
        }
        Guitar c = (Guitar) s;
        return Integer.compare(price, c.price) == 0 && Integer.compare(quantity, c.quantity) == 0;
    }
}
class Wire extends MusicShop
{
    Wire(int price, int quantity, int length)
    {
        this.price = price;
        this.quantity = quantity;
        this.length = length;
    }
    int price;
    int quantity;
    int length;
    @Override
    double getOverallPrice() {
        return price*quantity;
    }
    public String toString(){
        return " Wire's price: "+price+" Wire's quantity: "+quantity + " Wire's length (m): "+ length;
    }
    @Override
    public boolean equals(Object s) {
        if (s == this) {
            return true;
        }
        if (!(s instanceof Wire)) {
            return false;
        }
        Wire c = (Wire) s;
        return Integer.compare(price, c.price) == 0 && Integer.compare(quantity, c.quantity) == 0 && Integer.compare(length, c.length) == 0;
    }
}

class Microphone extends MusicShop
{
    Microphone(int price, int quantity, boolean wireless)
    {
        this.price = price;
        this.quantity = quantity;
        this.wireless = wireless;
    }
    int price;
    int quantity;
    boolean wireless;

    @Override
    double getOverallPrice() {
        return price*quantity;
    }
    public String toString(){
        return " Microphone's price: "+price+" Microphone's quantity: "+quantity + " Is it wireless? "+ wireless;
    }
    @Override
    public boolean equals(Object s) {
        if (s == this) {
            return true;
        }
        if (!(s instanceof Wire)) {
            return false;
        }
        Microphone c = (Microphone) s;
        return Integer.compare(price, c.price) == 0 && Integer.compare(quantity, c.quantity) == 0 && Boolean.compare(wireless, c.wireless) == 0;
    }
}
public class Main {
    public static void main(String[] args) {

        Guitar guitar = new Guitar(25000, 5);
        Wire wire= new Wire(10000, 4, 20);
        Wire wire2= new Wire(10000, 4, 40);
        Microphone mic = new Microphone(20000, 1,true);
        MusicShop s;
        MusicShop obj;

        System.out.println(guitar.toString());
        System.out.println(wire.toString());
        System.out.println(wire2.toString());
        System.out.println(" Compare wire and wire2 " +  wire.equals(wire2));
        System.out.println(mic.toString());

        if (mic.getOverallPrice() > guitar.getOverallPrice())
            System.out.println(" Drums cost more than guitar");
        else if (mic.getOverallPrice() < guitar.getOverallPrice())
            System.out.println(" Guitars cost more than drums");
        else
            System.out.println(" Drums and guitars have equal price");

        ArrayList<MusicShop> storage =  new ArrayList<>();
        storage.add(new Guitar(19000, 2));
        storage.add(new Microphone(8000, 1, false));
        storage.add(new Wire(1000, 1, 200));
        storage.add(new Guitar(50000, 1));
        storage.add(new Microphone(10000, 2, true));
        System.out.println(storage);
        Collections.sort(storage);
        System.out.println(storage);
    }
}