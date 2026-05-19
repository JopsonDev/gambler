package com.jopsondev;

import com.jopsondev.background.Wallet;

import java.util.Scanner;

public class UserInterface extends CasinoGame {
    public void display(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("New User please Deposit an amount and add name.");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Deposit: ");
        double deposit = scanner.nextDouble();
        scanner.nextLine();

        Wallet player = new Wallet(name, deposit);
        while(true) {
            System.out.println("Welcome! Please Make a Selection");
            System.out.println("1). Slots");
            System.out.println("2). Roulette");
            System.out.println("3). BlackJack");
            System.out.println("4). High or Low");
            System.out.println("99). Quit");
            System.out.print("Input: ");
            if(!scanner.hasNextInt()){
                System.out.println("invalid input");
                scanner.nextLine();
            } else {
                int input = scanner.nextInt();
                scanner.nextLine();

                switch (input) {
                    case 1 -> runSlots(player, scanner);
                    case 2 -> runRoulette(player, scanner);
                    case 3 -> runBlackJack(player, scanner);
                    case 4 -> runHighLow(player, scanner);
                    case 99 -> {
                        return;
                    }
                    default -> System.out.println("Invalid input");
                }
            }
        }
    }
}
