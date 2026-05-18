package com.jopsondev;

import java.util.Random;
import java.util.Scanner;

public class Slot implements IsBet{
    public int reels() {
      int r1 = result();
      int r2 = result();
      int r3 = result();

      int score = r1 + r2 + r3;
      System.out.println(score);
      return score;
    }

    public int result(){
        int K = 15;
        int Q = 10;
        int J = 5;
        Random rand = new Random();

        int r1 = rand.nextInt(5);
        int score = 0;
        switch(r1){
            case 0,1 -> System.out.println("X");
            case 2 -> {
                System.out.println("J");
                score += J;
            }
            case 3 -> {
                System.out.println("Q");
                score += Q;
            }
            case 4 -> {
                System.out.println("K");
                score += K;
            }
            default -> System.out.println("X");
        }
        return(score);
    }

    @Override
    public double bet(Wallet player, Scanner scanner) {
        while(true){
        System.out.println("Please place your bet");
        System.out.println("Bet: ");
        double bet = scanner.nextDouble();
            if(player.getBalance() < bet || bet < 0){
                System.out.println("Invalid bet");
            } else {
                player.lose(bet);
                return bet;
            }
        }
    }

    @Override
    public double win(Wallet player, int score, double bet) {
        double win = bet + (score * .15) * bet;
        player.gain(win);
        return win;
    }
}
