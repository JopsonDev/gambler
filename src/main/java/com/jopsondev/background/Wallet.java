package com.jopsondev.background;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private double balance;
    private String name;
    private List<String> hand;

    public Wallet(String name, double balance) {
        this.balance = balance;
        this.name = name;
        this.hand = new ArrayList<String>();
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public List<String> getHand() {
        return hand;
    }

    public void setHand(List<String> hand) {
        this.hand = hand;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double gain(double amount){
        return this.balance += amount;
    }

    public double lose(double amount){
        return this.balance -= amount;
    }

    public void getCurrentHand(List<String> hand){
        this.hand = hand;
    }

    public void clearHand(){
        hand.clear();
    }
}
