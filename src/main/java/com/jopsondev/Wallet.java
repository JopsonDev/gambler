package com.jopsondev;

public class Wallet {
    private double balance;
    private String name;

    public Wallet(String name, double balance) {
        this.balance = balance;
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
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
}
