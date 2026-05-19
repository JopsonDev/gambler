package com.jopsondev;

import com.jopsondev.background.Wallet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserInterface system = new UserInterface();
        system.display();

        //dealer wins with higher number even if over 21
        //x doesnt work with blackjack
        //high and low is a mess
        //doesnt show wins
        //takes letter input on bet and counts as high or lower answer
        //doesnt stop even if outta money
    }
}
