import java.util.Random;
import java.util.Scanner;

import src.TicTacToe;

public class Play 
{
    public static void main(String[] args) 
    {
        TicTacToe game = new TicTacToe(new Scanner(System.in), new Random());
        game.play();
    }
}
