package com.jopsondev.games;

import com.jopsondev.background.Deck;
import com.jopsondev.background.Wallet;

import java.util.Scanner;

public class HighLow extends Deck {

    public void currentHand(Wallet player){
        player.clearHand();
        player.setHand(deal(1, player, 1));
        System.out.println(player.getHand());
    }

    public void playingGame(Wallet player, Scanner scanner){
        currentHand(player);
        System.out.print("\n");


        while(true) {
            int score = totalTrueValue(player);
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
            } else if (score > newCard && input.equalsIgnoreCase("Lower")) {
                System.out.println("Winner\n");
            } else {
                System.out.println("Loser\n");
            }
        }
    }
}
