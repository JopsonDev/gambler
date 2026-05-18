package com.jopsondev.games;

import com.jopsondev.background.Wallet;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BlackJackTest {

    @Test
    public void dealerPlay_CheckAcesChangeToOne_AcesChangeToOne(){
        //Arrange
        BlackJack jack = new BlackJack();
        Wallet dealer = new Wallet("Dealer", 999);
        List<String> cards = new ArrayList<>();
        jack.shuffle();
        cards.add("A clubs");
        cards.add("5 clubs");

        //Act
        dealer.setHand(cards);
        int expectedValue = 21;
        //int actualValue = jack.dealerPlay(dealer);

        //Assert
        assertEquals(expectedValue, actualValue);
        //works
    }

}