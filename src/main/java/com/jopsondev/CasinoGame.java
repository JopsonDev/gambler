package com.jopsondev;

import java.util.Scanner;

public class CasinoGame {

    public void RunSlots(Wallet player, Scanner scanner){
        Slot slot = new Slot();
        double bet = slot.bet(player, scanner);
        slot.win(player, slot.reels(), bet);
        System.out.println(player.getBalance());
    }
    public void runRoulette(Wallet player, Scanner scanner){
        Roulette roulette = new Roulette();
        double win = roulette.bet(player, scanner);
        player.setBalance(player.getBalance() + win);
        System.out.println(player.getBalance());
    }
}
