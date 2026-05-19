package com.jopsondev.background;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<String> hand;
    private List<String> deck;

    public Deck() {
        this.deck = new ArrayList<>();
        this.hand = new ArrayList<>();
    }
    public void shuffle() {
        String deckType = "A, K, Q, J, 10, 9, 8, 7, 6, 5, 4, 3, 2";
        String suit = "Heart, Spade, Diamond, Club";

        String[] card = deckType.split(",");
        String[] suitCard = suit.split(",");
        int x = 52 * 6;
        while (x > 0) {
            for (int i = 12; i >= 0; i--) {
                for (int s = 3; s >= 0; s--) {
                    deck.add(card[i] + " " + suitCard[s]);
                    x--;
                }
            }
        }
    }

    public List<String> deal(int i, Wallet player, int decks) {
        Random rand = new Random();
        while (i > 0) {
            int r1 = rand.nextInt(decks * 52);
            player.getHand().add(deck.get(r1));
            i--;
        }
        return player.getHand();
    }

    public List findValue(Wallet player) {
        List<Integer> total = new ArrayList<>();
        for (int i = 0; i < player.getHand().size(); i++) {
            int num;
            String[] value = player.getHand().get(i).trim().split(" ");
            switch (value[0]) {
                case "A" -> num = 11;
                case "K", "Q", "J" -> num = 10;
                default -> num = Integer.parseInt(value[0]);
            }
            total.add(num);
        }
        return total;
    }

    public int totalTrueValue(Wallet player) {
        List<Integer> totalList = findValue(player);
        int total = 0;

        for (int t = 0; t < totalList.size(); t++) {
            total += totalList.get(t);
        }

        return total;
    }

}
