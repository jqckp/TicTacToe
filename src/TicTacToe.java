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

    private static final WinCondtion[] WIN_CONDITIONS = WinCondtion.values();

    private static final Position[] POSITIONS = Position.values();

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
    

    /**
     * Initializes a game of Tic-Tac-Toe.
     * 
     * @param scanner - Instance of Scanner class.
     * @param random - Instance of Random class.
     */
    public TicTacToe(Scanner moveCollector, Random random)
    {
        this.moveCollector = moveCollector;
        playerMoves = new LinkedList<>();
        opponentMoves = new LinkedList<>();
        this.random = random;
        playerGoesFirst = random.nextBoolean();


    }

    /**
     * Validates player and opponent moves.
     * 
     * @param selectedRow - Row chosen by player or opponent.
     * @param selectedColumn - Column selected by player or opponent.
     * @param moves - All previous moves of player or opponent.
     * @param marker - Character (x or o) that user or opponent is playing as.
     * 
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
        selectedPosition.setOccupyingPlayer(marker);
        return true;
    }
    
    /**
     * Prints the game board to the terminal.
     */
    private void printGameBoard()
    {
        System.out.print("\033[H\033[2J");
        System.out.println(Position.TOP_LEFT.getOccupyingPlayer() + " | " + Position.TOP_CENTER.getOccupyingPlayer() + " | " + Position.TOP_RIGHT.getOccupyingPlayer());
        System.out.println("----------");
        System.out.println(Position.MIDDLE_LEFT.getOccupyingPlayer() + " | " + Position.CENTER.getOccupyingPlayer() + " | " + Position.MIDDLE_RIGHT.getOccupyingPlayer());
        System.out.println("----------");
        System.out.println(Position.BOTTOM_LEFT.getOccupyingPlayer() + " | " + Position.BOTTOM_CENTER.getOccupyingPlayer() + " | " + Position.BOTTOM_RIGHT.getOccupyingPlayer());
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

    /**
     * Checks to see if the game is over or not.
     * 
     * Only checks to see if the game is over if the combined number of moves
     * is 5 or greater (the minimum before someone can win).
     * 
     * If a player's moves match a win condition, that player wins.
     * 
     * If the max number of combined moves has been made (9)
     * and there isn't winner, game is a tie.
     * 
     * 
     * @param moves - All claimed positions by that specific player.
     */
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

            if (moves.equals(playerMoves))
            {
                System.out.println("You won!");
            }

            else
            {
                System.out.println("You lost!");
            }

            System.exit(0);
        }
        
    }

    
    /**
     * Main game loop.
     */
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


    /**
     * All steps for one turn of player.
     */
    private void executePlayerTurn()
    {
        collectPlayerMove();
        checkGameOver(playerMoves);
        printGameBoard();
    }

    /**
     * All steps for one turn of opponent.
     */
    private void executeOpponentTurn()
    {
        generateOpponentMove();
        checkGameOver(opponentMoves);

        try 
        {
            System.out.println("Waiting for opponent...\n");
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println("Interupted");
        }


        printGameBoard();
    }

    

       

    public static void main(String[] args) 
    {
       TicTacToe game = new TicTacToe(new Scanner(System.in), new Random());
       game.play();
       
    }

    



}