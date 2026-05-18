package com.jopsondev;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Roulette implements IsBet{
    Random rand = new Random();

    public int spin(){
        int spin = rand.nextInt(37);
        System.out.println(spin);
        return spin;
    }


    @Override
    public double bet(Wallet player, Scanner scanner) {
        List<Integer> numbers = new ArrayList<>();
        List<Double> bets = new ArrayList<>();
        while(true) {
            System.out.println("What number would you like to bet on: ");
            numbers.add(scanner.nextInt());

            System.out.println("Place your bet: ");
            bets.add(scanner.nextDouble());
            scanner.nextLine();

            System.out.println("Would you like to bet another number?(Y/N) ");
            String input = scanner.nextLine();
            if(!input.equalsIgnoreCase("Y")){
                break;
            }
        }
        int result = spin();
        double winnings = 0;
        for (int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) == result){
                winnings = winnings + (bets.get(i) * 37);
            }
        }
        System.out.println(winnings);
        return winnings;
    }

    @Override
    public double win(Wallet player, int score, double bet) {
        return 0;
    }
}
