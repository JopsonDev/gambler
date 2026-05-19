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

    public void playingGame(Wallet player, Scanner scanner){
        currentHand(player);
        System.out.print("\n");


        while(true) {
            double bet = bet(player, scanner);
            int score = totalTrueValue(player);
            double totalWin = 0;
            System.out.println("Will the next card be higher or lower? X to cash out");
            String input = scanner.nextLine();

            if(input.equalsIgnoreCase("X")){
                System.out.println("Finish");
                break;
            }

            currentHand(player);
            System.out.print("\n");
            int newCard = totalTrueValue(player);

            if (score < newCard && input.equalsIgnoreCase("Higher")) {
                System.out.println("Winner\n");
                totalWin = win(bet);
            } else if (score > newCard && input.equalsIgnoreCase("Lower")) {
                System.out.println("Winner\n");
                totalWin = win(bet);
            } else {
                System.out.println("Loser\n");
            }
            player.lose(bet);
            player.gain(totalWin);
        }
    }

    @Override
    public double bet(Wallet player, Scanner scanner) {
        while(true) {
            System.out.print("Place your bets or X to return: ");

            if(!scanner.hasNextDouble()){
                return 0;
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
