package com.jopsondev.games;

import com.jopsondev.background.Wallet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BlackJack {
    private List<String> hand;
    private List<String> deck;

    public BlackJack() {
        this.deck = new ArrayList<>();
        this.hand = new ArrayList<>();
    }

    public void shuffle() {
        String deckType = "A, K, Q, J, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1";
        String suit = "Heart, Spade, Diamond, Club";

        String[] card = deckType.split(",");
        String[] suitCard = suit.split(",");
        int x = 52 * 6;
        while (x > 0) {
            for (int i = 13; i >= 0; i--) {
                for (int s = 3; s >= 0; s--) {
                    deck.add(card[i] + " " + suitCard[s]);
                    x--;
                }
            }
        }
    }

    public List<String> deal(int i, Wallet player) {
        Random rand = new Random();
        while (i > 0) {
            int r1 = rand.nextInt(312);
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

    public void saveHand(Wallet player, int i) {
        player.getCurrentHand(deal(i, player));
    }

    public int totalTrueValue(Wallet player) {
        List<Integer> totalList = findValue(player);
        int total = 0;

        for (int t = 0; t < totalList.size(); t++) {
            total += totalList.get(t);
        }

        return total;
    }

    public void hitOrStand(Wallet player, Scanner scanner) {
        List<Integer> totalList = findValue(player);
        int total = totalTrueValue(player);
        System.out.println(total);
        while (total < 21) {
            System.out.print("Hit or Stand: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("hit")) {
                saveHand(player, 1);
                total = totalTrueValue(player);
                System.out.println(player.getHand());
                System.out.println(total);
            } else if (input.equalsIgnoreCase("Stand")) {
                return;
            } else {
                System.out.println("invalid input");
            }
        }
        while (total > 21) {
            if (totalList.contains(11)) {
                int change = totalList.indexOf(11);
                totalList.set(change, 1);

                total = 0;
                for (int num : totalList) {
                    total += num;
                }
            } else {
                System.out.println(total);
                System.out.println("BUST");
                break;
            }
        }
        System.out.println("Total: " + total);
    }

    public void dealerStarting(Wallet hand) {
        saveHand(hand, 2);
        System.out.println("Dealers Top Card " + hand.getHand().get(1));
    }

    public void dealerPlay(Wallet player) {
        List<Integer> totalList = findValue(player);
        int total = totalTrueValue(player);

        while (total < 17) {
            saveHand(player, 1);
            totalList = findValue(player);
            total = totalTrueValue(player);

            while (total > 21 && totalList.contains(11)) {
                int change = totalList.indexOf(11);
                totalList.set(change, 1);

                total = 0;
                for (int num : totalList) {
                    total += num;
                }
            }

            System.out.println(player.getHand());
            System.out.println("Dealer " + total);
        }
    }
}
