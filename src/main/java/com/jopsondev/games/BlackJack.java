package com.jopsondev.games;

import com.jopsondev.background.Wallet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BlackJack {
    private List<String> hand;
    private List<String> deck;
    private List<String> cardView;

    public BlackJack(){
        this.deck = new ArrayList<>();
        this.hand = new ArrayList<>();
    }

    public void shuffle(){
        String deckType = "A, K, Q, J, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1";
        String suit = "Heart, Spade, Diamond, Club";

        String[] card = deckType.split(",");
        String[] suitCard = suit.split(",");
        int x = 52 * 6;
        while(x > 0) {
            for (int i = 13; i >= 0; i--) {
                for (int s = 3; s >= 0; s--) {
                    deck.add(card[i] + " " + suitCard[s]);
                    x--;
                }
            }
        }
    }

    public List<String> deal(int i){
        Random rand = new Random();
        while(i > 0) {
            int r1 = rand.nextInt(312);
            hand.add(deck.get(r1));
            i--;
        }
        return hand;
    }

    public int findValue(Wallet player){
        int total = 0;
        for(int i = 0; i < hand.size(); i++) {
            int num;
            String[] value = hand.get(i).trim().split(" ");
            switch (value[0]){
                case "A" -> num = 11;
                case "K", "Q", "J" -> num = 10;
                default -> num = Integer.parseInt(value[0]);
            }
            total += num;
        }
        return total;
    }

    public void saveHand(Wallet player, int i){
        player.getCurrentHand(deal(i));
    }

    public void hitOrStand(Wallet player, Scanner scanner){
        int total = findValue(player);
        System.out.println(total);
        while(total < 21) {
            System.out.print("Hit or Stand: ");
            String input = scanner.nextLine();

            if(input.equalsIgnoreCase("hit")){
                saveHand(player, 1);
                total = findValue(player);
                System.out.println(player.getHand());
            } else if (input.equalsIgnoreCase("Stand")){
                return;
            } else {
                System.out.println("invalid input");
            }
        }
        if(total > 21){
            System.out.println(total);
            System.out.println("BUST");
        }
        System.out.println("Total: " + total);
    }
}
