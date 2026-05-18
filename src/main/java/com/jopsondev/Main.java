package com.jopsondev;

import com.jopsondev.background.Wallet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //SlotDisplayOutput slot = new SlotDisplayOutput();
        Wallet player1 = new Wallet("Mason",100);
        //int score = slot.reels();
        //double bet = slot.bet(player1, scanner);
        //double win = slot.win(player1, score, bet);
        //System.out.println(win);
        //System.out.println(player1.getBalance());*/
        CasinoGame game = new CasinoGame();
        //game.RunSlots(player1, scanner);
        //Roulette r = new Roulette();
        //r.spin();
        //r.bet(player1,scanner);
        //game.runRoulette(player1, scanner);
        game.runBlackJack(player1, scanner);

    }
}
