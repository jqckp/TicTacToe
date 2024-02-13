import java.util.Scanner;

public class TicTacToe
{
    public static final int ROWS = 3, COLUMNS = 3;

    public static int[][] moveTracker = new int[ROWS][COLUMNS];

    public static char[][] gameBoard = new char[ROWS][COLUMNS];

    public Scanner moveCollector;

    public int playerSelectedRow;

    public int playerSelectedColumn;
    

    public TicTacToe()
    {
        moveCollector = new Scanner(System.in);

    }

    /**
     * Validates player and opponent moves.
     * @return - True indicating a valid move, false indicating an invalid move.
     */
    public boolean validPosition()
    {
        //Default position set to invalid.
        Position selectedPosition = Position.INVALID_POSITION;

        if (playerSelectedColumn > 2 || playerSelectedColumn < 0)
        {
            return false;
        }

        if (playerSelectedRow > 2 || playerSelectedRow < 0)
        {
            return false;
        }

        for (Position position : Position.values())
        {
            if (position.getRow() == playerSelectedRow && position.getColumn() == playerSelectedColumn)
            {
                selectedPosition = position;
                break;
            }
        }

        if (selectedPosition.getTaken())
        {
            return false;
        }

        selectedPosition.setTaken(true);
        return true;
    }
    
    public void printGameBoard()
    {
        
    }

    public void collectPlayerMove()
    {


    }

    public void generateOpponentMove()
    {

    }

       

    public static void main(String[] args) 
    {
       TicTacToe game = new TicTacToe();
       game.printGameBoard();
       
       
    }

    



}