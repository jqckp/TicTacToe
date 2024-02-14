import java.util.InputMismatchException;
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
    public boolean validPosition(int selectedRow, int selectedColumn)
    {
        //Default position set to invalid.
        Position selectedPosition = Position.INVALID_POSITION;

        if (selectedColumn > 2 || selectedColumn < 0)
        {
            return false;
        }

        if (selectedRow > 2 || selectedRow < 0)
        {
            return false;
        }

        for (Position position : Position.values())
        {
            if (position.getRow() == selectedRow && position.getColumn() == selectedColumn)
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
        
        System.out.print("Enter row (1-3): ");
        playerSelectedRow = moveCollector.nextInt();


        System.out.print("Enter column (1-3): ");
        playerSelectedColumn = moveCollector.nextInt();

    }

    public void generateOpponentMove()
    {

    }

       

    public static void main(String[] args) 
    {
       TicTacToe game = new TicTacToe();
       game.collectPlayerMove();
       
       
    }

    



}