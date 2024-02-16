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

    private static final WinCondtion[] WIN_CONDITIONS = WinCondtion.values();

    private static final Position[] POSITIONS = Position.values();

    public static char[][] gameBoard;

    public LinkedList<Position> playerMoves;

    public LinkedList<Position> opponentMoves;

    public Scanner moveCollector;

    public Random random;

    public int selectedRow;

    public int selectedColumn;

    public boolean hasWinner;
    

    public TicTacToe(Scanner scanner, Random random)
    {
        moveCollector = scanner;
        gameBoard = new char[ROWS][COLUMNS];
        playerMoves = new LinkedList<>();
        opponentMoves = new LinkedList<>();
        this.random = random;

    }

    /**
     * Validates player and opponent moves.
     * @return - True indicating a valid move, false indicating an invalid move.
     */
    private boolean positionAvailable(int selectedRow, int selectedColumn, LinkedList<Position> moves)
    {
        //Default position set to invalid.
        Position selectedPosition = Position.INVALID_POSITION;

        for (Position position : POSITIONS)
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
        selectedRow = -1;
        selectedColumn = -1;

        do
        {
            try
            {
                System.out.print("Enter row (1-3): ");
                selectedRow = Integer.parseInt(moveCollector.nextLine());
                
                System.out.print("Enter column (1-3): ");
                selectedColumn = Integer.parseInt(moveCollector.nextLine());
                
            } catch (NumberFormatException ex)
            {
                System.out.println("Enter a number");
            }


            selectedColumn -= 1;
            selectedRow -= 1;
            
        }while(!positionAvailable(selectedRow, selectedColumn, playerMoves));
        
    }

    

    public void generateOpponentMove()
    {
        do
        {
            selectedColumn = random.nextInt(COLUMNS);
            selectedRow = random.nextInt(ROWS);

        } while (!positionAvailable(selectedRow, selectedColumn, opponentMoves));

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
       
       
    }

    



}