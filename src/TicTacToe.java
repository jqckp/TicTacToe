package src;
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

    private static final int MAXIMUM_NUM_OF_MOVES = 9;

    private static final char EMPTY_POSITION = '\u0000';

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

    private boolean playerGoesFirst;

    private int totalMoveCount;

    private char playerMarker = 'x';

    private char opponentMarker = 'o';
    

    public TicTacToe(Scanner scanner, Random random)
    {
        moveCollector = scanner;
        gameBoard = new char[ROWS][COLUMNS];
        playerMoves = new LinkedList<>();
        opponentMoves = new LinkedList<>();
        this.random = random;
        playerGoesFirst = random.nextBoolean();

    }

    /**
     * Validates player and opponent moves.
     * @return - True indicating a valid move, false indicating an invalid move.
     */
    private boolean positionAvailable(int selectedRow, int selectedColumn,
         LinkedList<Position> moves, char marker)
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
        totalMoveCount++;
        gameBoard[selectedPosition.getRow()][selectedPosition.getColumn()] = marker;
        return true;
    }
    
    private void printGameBoard()
    {
        System.out.println(gameBoard[0][0] + " | " + gameBoard[0][1] + " | " + gameBoard[0][2]);
        System.out.println("-----------");
        System.out.println(gameBoard[1][0] + " | " + gameBoard[1][1] + " | " + gameBoard[1][2]);
        System.out.println("--------------");
        System.out.println(gameBoard[2][0] + " | " + gameBoard[2][1] + " | " + gameBoard[2][2]);
        System.out.println();
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
            
        }while(!positionAvailable(selectedRow, selectedColumn, playerMoves, playerMarker));
        
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

        } while (!positionAvailable(selectedRow, selectedColumn, opponentMoves, opponentMarker));

    }

    private void checkGameOver(LinkedList<Position> moves)
    {
        if (!(totalMoveCount >= MIN_COMBINED_MOVES_TO_WIN))
        {
            return;
        }

        for (WinCondtion winCondition : WIN_CONDITIONS)
        {
            if (moves.containsAll(winCondition.getPositions()))
            {
                hasWinner = true;
            }
            
        }

        if (totalMoveCount == MAXIMUM_NUM_OF_MOVES && !hasWinner)
        {
            printGameBoard();
            System.out.println("Tie");
            System.exit(0);
        }

        if(hasWinner)
        {
            printGameBoard();
            System.exit(0);
        }
        
    }

    

    public void play()
    {
        while (true)
        {
            if (playerGoesFirst)
            {
                executePlayerTurn();
                executeOpponentTurn();
                continue;
            }
            
            executeOpponentTurn();
            executePlayerTurn();
        }

    }


    private void executePlayerTurn()
    {
        collectPlayerMove();
        checkGameOver(playerMoves);
        printGameBoard();
    }

    private void executeOpponentTurn()
    {
        generateOpponentMove();
        checkGameOver(opponentMoves);
        printGameBoard();
    }

    

       

    public static void main(String[] args) 
    {
       TicTacToe game = new TicTacToe(new Scanner(System.in), new Random());
       game.play();
       
    }

    



}