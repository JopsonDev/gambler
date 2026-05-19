package com.jopsondev.games;

import com.jopsondev.background.IsBet;
import com.jopsondev.background.Wallet;

import java.util.Random;
import java.util.Scanner;

public class Slot implements IsBet {
    public int reels() {
      int r1 = result();
      int r2 = result();
      int r3 = result();

      int score = r1 + r2 + r3;
      slotDisplay(r1, r2, r3);
      System.out.println(score);
      return score;
    }

    public int result(){
        Random rand = new Random();

        int r1 = rand.nextInt(5);

        switch(r1){
            case 2 -> {
                return  5;
            }
            case 3 -> {
                return 10;
            }
            case 4 -> {
                return 15;
            }
            default -> {
                return 0;
            }
        }
    }

    public void slotDisplay(int r1, int r2, int r3){
        String p1 = slotIcons(r1);
        String p2 = slotIcons(r2);
        String p3 = slotIcons(r3);
        System.out.println("                                 _________   \n" +
                "                             ___/=========\\\\___\n" +
                "                           /  o  o  o  o  o   \\\\\n" +
                "                          /_____________________\\\\\n" +
                "                          ||   SLOT MACHINE     ||\n" +
                "                  ________||====================||________\n" +
                "                /      o   o   o   o   o   o    o       \\\\\n" +
                "               /_________________________________________\\\\\n" +
                "              |      __________ ___________ __________    |\n" +
                "              |     |          |           |          |   |\n" +
                "              |     |    "+p1+"     |     "+p2+"     |     "+p3+"    |   |\n" +
                "              |     |          |           |          |   |\n" +
                "              |     |__________|___________|__________|   |\n" +
                "              |    ___________________________________    |\n" +
                "              |  /_____________________________________\\\\\\\\\n" +
                "              |  |       ___       ___       ___         ||\n" +
                "              |  |      |___|     |___|     |___|        ||\n" +
                "              |  |                                  ()   ||\n" +
                "              |  |_______________________________________||\n" +
                "              |/__________________________________________|");
    }

    public String slotIcons(int r){
        String result;
        switch(r){
            case 5 -> result = "J";
            case 10 -> result = "Q";
            case 15 -> result = "K";
            default -> result = "X";
        }
        return result;
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


    public double winSlots(Wallet player, int score, double bet) {
        double win = bet + (score * .15) * bet;
        player.gain(win);
        return win;
    }
}
