package com.jopsondev;

import com.jopsondev.background.Wallet;
import com.jopsondev.games.BlackJack;
import com.jopsondev.games.Roulette;
import com.jopsondev.games.Slot;

import java.util.Scanner;

public class CasinoGame {

    public void runSlots(Wallet player, Scanner scanner){
        Slot slot = new Slot();
        double bet = slot.bet(player, scanner);
        slot.win(player, slot.reels(), bet);
        System.out.println(player.getBalance());
    }

    public void runRoulette(Wallet player, Scanner scanner){
        Roulette roulette = new Roulette();
        double bet = roulette.bet(player, scanner);
        double win = roulette.win(player, 0, 0);
        player.setBalance(player.getBalance() - bet);
        player.setBalance(player.getBalance() + win);
        System.out.println(player.getBalance());
    }

    public void runBlackJack(Wallet player, Scanner scanner){
        BlackJack bj = new BlackJack();
        bj.shuffle();
        bj.saveHand(player, 2);
        System.out.println(player.getHand());
        bj.findValue(player);
        bj.hitOrStand(player, scanner);
    }
}
