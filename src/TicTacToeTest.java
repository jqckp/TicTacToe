package src;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import org.junit.Test;

public class TicTacToeTest 
{

    private TicTacToe game = new TicTacToe();
    

    @Test
    public void testPlayerMoveWhenPositionOccupied()
    {
        Position.CENTER.setTaken(true);
        int playerRowChoice = Position.CENTER.getRow();
        int playerColumnChoice = Position.CENTER.getColumn();
        char playerMarker = 'x';
        assertFalse(game.positionAvailable(playerRowChoice, playerColumnChoice, 
            new LinkedList<>(), playerMarker));

    }


    @Test
    public void testInvalidPlayerMoveSelection()
    {
        int playerRowChoice = 4;
        int playerColumnChoice = 3;
        char playerMarker = 'x';

        assertFalse(game.positionAvailable(playerRowChoice, playerColumnChoice, 
        new LinkedList<>(), playerMarker));
    }
}
