package com.jopsondev.games;

import com.jopsondev.background.Deck;
import com.jopsondev.background.IsBet;
import com.jopsondev.background.Wallet;

import java.util.Scanner;

public class HighLow extends Deck implements IsBet {

    public void currentHand(Wallet player){
        player.clearHand();
        player.setHand(deal(1, player, 1));
        System.out.println(player.getHand());
    }

    public void playingGame(Wallet player, Scanner scanner) {
        System.out.print("\n");
        currentHand(player);

        while (player.getBalance() > 0) {
            System.out.println("\nCurrent balance: " + player.getBalance());

            double bet = bet(player, scanner);

            if (bet <= 0) {
                break;
            }

            int score = totalTrueValue(player);
            double totalWin = 0;

            System.out.println("Will the next card be higher or lower?");
            String input = scanner.nextLine();

            if (!input.equalsIgnoreCase("Lower") && !input.equalsIgnoreCase("Higher")) {
                System.out.println("Invalid entry");
                continue;
            }

            currentHand(player);
            System.out.print("\n");

            int newCard = totalTrueValue(player);

            if (score < newCard && input.equalsIgnoreCase("Higher")) {
                System.out.println("Winner");
                totalWin = win(bet);
            } else if (score > newCard && input.equalsIgnoreCase("Lower")) {
                System.out.println("Winner");
                totalWin = win(bet);
            } else {
                System.out.println("Loser");
            }

            player.lose(bet);
            player.gain(totalWin);
        }
    }

    @Override
    public double bet(Wallet player, Scanner scanner) {
        while(true) {
            System.out.print("Place your bets or X to forfeit round: ");

            if(!scanner.hasNextDouble()){
                if(scanner.nextLine().equalsIgnoreCase("X")) {
                    return 0;
                } else {
                    System.out.println("Invalid Input");
                }
            } else {
                double bet = scanner.nextDouble();
                scanner.nextLine();

                if(bet <= player.getBalance()){
                    return bet;
                } else {
                    System.out.println("Not Enough");
                }
            }

        }
    }

    public double win(double bet){
        return bet * 2;
    }
}
