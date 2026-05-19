package com.jopsondev.games;

import com.jopsondev.background.Deck;
import com.jopsondev.background.IsBet;
import com.jopsondev.background.Wallet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BlackJack extends Deck implements IsBet {


    public void saveHand(Wallet player, int i) {
        player.getCurrentHand(deal(i, player, 6));
    }

    public void hitOrStand(Wallet player, Scanner scanner) {
        List<Integer> totalList;
        int total = totalTrueValue(player);
        System.out.println(total);
        while (total < 21) {
            System.out.print("Hit or Stand: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("hit")) {
                saveHand(player, 1);
                totalList = findValue(player);
                total = totalTrueValue(player);

                if (total > 21){
                    total = aceAdjuster(total, totalList);
                }

                System.out.println(player.getHand());
                System.out.println(total);
            } else if (input.equalsIgnoreCase("Stand")) {
                return;
            } else {
                System.out.println("invalid input");
            }
        }
        if (total > 21){
            System.out.println("BUST");
        }
        System.out.println("Total: " + total);
    }

    public int aceAdjuster(int total, List<Integer> totalList){
        while (total > 21 && totalList.contains(11)) {
            int change = totalList.indexOf(11);
            totalList.set(change, 1);

            total = 0;
            for (int num : totalList) {
                total += num;
            }
        }
        return total;
    }

    public void dealerStarting(Wallet hand) {
        saveHand(hand, 2);
        System.out.println("Dealers Top Card " + hand.getHand().get(1));
    }

    public void dealerPlay(Wallet player) {
        List<Integer> totalList;
        int total = totalTrueValue(player);

        while (total < 17) {
            saveHand(player, 1);
            totalList = findValue(player);
            total = totalTrueValue(player);

            total = aceAdjuster(total,totalList);

            System.out.println(player.getHand());
            System.out.println("Dealer " + total);
        }
    }

    @Override
    public double bet(Wallet player, Scanner scanner) {
        while(true) {
            System.out.print("Place your bets or X to return: ");

            if(!scanner.hasNextDouble()){
                scanner.nextLine();
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

    public double winBlackJack(int player, int dealer, double bet) {
        double total = 0;
        if ((player > dealer && player < 21) || (dealer > 21 && player < 21)){
            total = bet * 2;
        } else if (player == 21 && dealer != 21) {
            total = bet * 2.5;
        } else if (player == dealer){
            total = bet;
        }
        return total;
    }
}
