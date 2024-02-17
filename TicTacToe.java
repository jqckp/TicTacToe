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
    private static final int ROWS = 3, COLUMNS = 3;

    private static final int MIN_COMBINED_MOVES_TO_WIN = 5;

    private static final WinCondtion[] WIN_CONDITIONS = WinCondtion.values();

    private static final Position[] POSITIONS = Position.values();

    private static char[][] gameBoard;

    private LinkedList<Position> playerMoves;

    private LinkedList<Position> opponentMoves;

    private Scanner moveCollector;

    private Random random;

    private int selectedRow;

    private int selectedColumn;

    private boolean hasWinner;

    private int moveCount;
    

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
    
    private void printGameBoard()
    {
        System.out.println("+-----------+");
        System.out.println("+-----------+");
    }

    /**
     * Collects the human players move from the terminal.
     * 
     * Row and column selections are set to -1 by default in case the player
     * enters in a string that can't be parsed to an integer. Row and column choices 
     * are validated through positionAvailable.
     */
    private void collectPlayerMove()
    {
        //Set row and column to negative one (invalid) in case user doesn't enter a number.
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

    
    /**
     * Generates the opponent's move by randomly selecting column and row num.
     * 
     * Row and column numbers randomly generated are between 0 and 2 inclusive.
     */
    private void generateOpponentMove()
    {
        do
        {
            selectedColumn = random.nextInt(COLUMNS);
            selectedRow = random.nextInt(ROWS);

        } while (!positionAvailable(selectedRow, selectedColumn, opponentMoves));

    }

    private void checkGameOver()
    {
        if (moveCount >= MIN_COMBINED_MOVES_TO_WIN)
        {

        }
        


    }

    

    public void play()
    {
        while (!hasWinner)
        {
            runGame();
            moveCount++;
        }

    }

    private void runGame()
    {
        if (playerGoesFirst())
        {
            collectPlayerMove();
            checkGameOver();
            generateOpponentMove();
            checkGameOver();
        }
    }

    private boolean playerGoesFirst()
    {
        return random.nextBoolean();
    }

       

    public static void main(String[] args) 
    {
       TicTacToe game = new TicTacToe(new Scanner(System.in), new Random());
       
       
    }

    



}