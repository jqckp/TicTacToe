import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;


/**
 * Simple Tic-Tac-Toe terminal game, a Java classic.
 * 
 * @author - Jack Porter
 * @version - 2/12/2024
 */
public class TicTacToe
{
    public static final int ROWS = 3, COLUMNS = 3;

    public static final int MAX_ACCEPTED_ROW_OR_COLUMN = 2;

    public static final int MIN_ACCEPTED_ROW_OR_COLUMN = 0;

    private static final WinCondtion[] WIN_CONDITIONS = WinCondtion.values();

    public LinkedList<Position> playerMoves;

    public LinkedList<Position> opponentMoves;

    public static int[][] moveTracker;

    public static char[][] gameBoard;

    public Scanner moveCollector;

    public Random random;

    public int playerSelectedRow;

    public int playerSelectedColumn;

    public int opponentSelectedRow;

    public int opponentSelectedColumn;

    public boolean hasWinner;
    

    public TicTacToe(Scanner scanner, Random random)
    {
        moveCollector = scanner;
        moveTracker = new int[ROWS][COLUMNS];
        gameBoard = new char[ROWS][COLUMNS];
        playerMoves = new LinkedList<>();
        opponentMoves = new LinkedList<>();
        this.random = random;

    }

    /**
     * Validates player and opponent moves.
     * @return - True indicating a valid move, false indicating an invalid move.
     */
    public boolean validPosition(int selectedRow, int selectedColumn, LinkedList<Position> moves)
    {
        //Default position set to invalid.
        Position selectedPosition = Position.INVALID_POSITION;

        if (selectedColumn > MAX_ACCEPTED_ROW_OR_COLUMN || 
            selectedColumn < MIN_ACCEPTED_ROW_OR_COLUMN)
        {
            return false;
        }

        if (selectedRow > MAX_ACCEPTED_ROW_OR_COLUMN || 
            selectedRow < MIN_ACCEPTED_ROW_OR_COLUMN)
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

        if (selectedPosition.isTaken())
        {
            return false;
        }

        selectedPosition.setTaken(true);
        moves.add(selectedPosition);
        return true;
    }
    
    public void printGameBoard()
    {
        
    }

    public void collectPlayerMove()
    {
        playerSelectedColumn = -1;
        playerSelectedRow = -1;
        do
        {
            try
            {
                System.out.print("Enter row (1-3): ");
                playerSelectedRow = Integer.parseInt(moveCollector.nextLine());
                

                System.out.print("Enter column (1-3): ");
                playerSelectedColumn = Integer.parseInt(moveCollector.nextLine());
                
            } catch (NumberFormatException ex)
            {
                System.out.println("Enter a number");
                continue;
            }


            playerSelectedColumn -= 1;
            playerSelectedRow -= 1;
            
        }while(!validPosition(playerSelectedRow, playerSelectedColumn, playerMoves));
        
    }

    

    public void generateOpponentMove()
    {
        opponentSelectedRow = -1;
        opponentSelectedColumn = -1;

        do
        {
            opponentSelectedColumn = random.nextInt(COLUMNS);
            opponentSelectedRow = random.nextInt(ROWS);

        } while (!validPosition(opponentSelectedRow, opponentSelectedColumn, opponentMoves));

    }

    public void checkGameOver()
    {
        
        


    }

    

    public void play()
    {
        while (!hasWinner)
        {
            
        }

    }

       

    public static void main(String[] args) 
    {
       TicTacToe game = new TicTacToe(new Scanner(System.in), new Random());
       game.collectPlayerMove();
       
       
    }

    



}