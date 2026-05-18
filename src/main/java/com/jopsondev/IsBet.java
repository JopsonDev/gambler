package com.jopsondev;

import java.util.Scanner;

public interface IsBet {
    public double bet(Wallet player, Scanner scanner);

    public double win(Wallet player, int score, double bet);
}
