package com.jopsondev;

import java.util.Scanner;

public class UserInterface {
    public void display(){
        Scanner scanner = new Scanner(System.in);
        CasinoGame game = new CasinoGame();

        System.out.println("New User please Deposit an amount and add name.");
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Deposit: ");
        double deposit = scanner.nextDouble();
        scanner.nextLine();

        Wallet player = new Wallet(name, deposit);

        System.out.println("Welcome! Please Make a Selection");
        System.out.println("1). Slots");
        System.out.println("2). Roulette");
        System.out.println("3#. TBA");
        System.out.println("4). TBA");
        System.out.println("Input: ");
        int input = scanner.nextInt();
        scanner.nextLine();

        switch (input){
            case 1 -> game.RunSlots(player, scanner);
            case 2 -> game.runRoulette(player, scanner);
            case 3 -> System.out.println("==========");
            case 4 -> System.out.println("==========");
            default -> System.out.println("==========");
        }

    }
}
