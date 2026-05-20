package com.jopsondev;

import com.jopsondev.background.Wallet;
import com.jopsondev.games.BlackJack;
import com.jopsondev.games.HighLow;
import com.jopsondev.games.Roulette;
import com.jopsondev.games.Slot;

import java.util.Scanner;

public class CasinoGame {

    public void runSlots(Wallet player, Scanner scanner){
        Slot slot = new Slot();
        double bet = slot.bet(player, scanner);
        scanner.nextLine();
        while(player.getBalance() > 0) {
            player.lose(bet);
            slot.winSlots(player, slot.reels(), bet);
            System.out.println(player.getBalance());

            System.out.print("Bet to spin again or X to exit: ");
            if(scanner.hasNextDouble()){
                double amount = scanner.nextDouble();
                bet = amount;
            } else {
                scanner.nextLine();
                return;
            }
        }
    }

    public void runRoulette(Wallet player, Scanner scanner){
        Roulette roulette = new Roulette();
        double bet = roulette.bet(player, scanner);
        double win = roulette.winRoulette();
        player.lose(bet);
        player.gain(win);
        System.out.println(player.getBalance());
    }

    public void runBlackJack(Wallet player, Scanner scanner){
        BlackJack bj = new BlackJack();
        Wallet dealer = new Wallet("Dealer", 100000);
        while (player.getBalance() > 0) {
            player.clearHand();
            dealer.clearHand();

            double bet = bj.bet(player, scanner);
            if (bet <= 0){
                return;
            }
            bj.shuffle();
            bj.dealerStarting(dealer);

            bj.saveHand(player, 2);
            System.out.println(player.getHand());

            bj.findValue(player, "blackjack");
            bj.hitOrStand(player, scanner);
            bj.dealerPlay(dealer);

            player.lose(bet);
            player.gain(bj.winBlackJack(bj.totalTrueValue(player, "blackjack"), bj.totalTrueValue(dealer, "blackjack"), bet));

            System.out.println(player.getBalance());
        }
    }

    public void runHighLow(Wallet player, Scanner scanner){
        HighLow game = new HighLow();
        game.shuffle();
        game.playingGame(player, scanner);
    }
}
