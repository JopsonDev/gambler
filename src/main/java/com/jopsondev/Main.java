package com.jopsondev;

import com.jopsondev.background.Wallet;
import com.jopsondev.games.Slot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserInterface system = new UserInterface();
        system.display();

        /*Slot slot = new Slot();
        slot.reels();*/
        //add slot display have it print different symbols before landing on correct one (mite not work with askey slot picture)
        //add bonus spins
        //switch the switch case to if state to have better probability spins DONE
        //maybe make a slot machine with askey art DONE
        //hi and low thinks that 10 J Q K are all valued at 10 FIXED
        //HL loses if there's a tie
        //maybe in value method do a another parameter and just put String game and an if statement DONE

    }
}
