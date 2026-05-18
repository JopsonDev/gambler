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

    public void saveHand(Wallet player, int i){
        player.getCurrentHand(deal(i));
    }

    public void hitOrStand(Wallet player, Scanner scanner){
        while(true) {
            System.out.println("Hit or Stand");
            String input = scanner.nextLine();

            if(input.equalsIgnoreCase("hit")){
                saveHand(player, 1);
                System.out.println(player.getHand());
            } else if (input.equalsIgnoreCase("Stand")){
                return;
            } else {
                System.out.println("invalid input");
            }
        }
    }
}
