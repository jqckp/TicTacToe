package src;
import java.util.LinkedList;
import java.util.List;

/**
 * Defines Tic-Tac-Toe win conditions.
 * 
 * @author - Jack Porter
 * @version - 2/12/2024
 */
public enum WinCondtion 
{
    TOP_HORIZONTAL(Position.TOP_LEFT, Position.TOP_CENTER, Position.TOP_RIGHT),
    MIDDLE_HORIZONTAL(Position.MIDDLE_LEFT, Position.CENTER, Position.MIDDLE_RIGHT),
    BOTTOM_HORIZONTAL(Position.BOTTOM_LEFT, Position.BOTTOM_CENTER, Position.BOTTOM_RIGHT),
    LEFT_VERTICAL(Position.TOP_LEFT, Position.MIDDLE_LEFT, Position.BOTTOM_LEFT),
    MIDDLE_VERTICAL(Position.TOP_CENTER, Position.CENTER, Position.BOTTOM_CENTER),
    RIGHT_VERTICAL(Position.TOP_RIGHT, Position.MIDDLE_RIGHT, Position.BOTTOM_RIGHT),
    TOP_LEFT_TO_BOTTOM_RIGHT(Position.TOP_LEFT, Position.CENTER, Position.BOTTOM_RIGHT),
    TOP_RIGHT_TO_BOTTOM_LEFT(Position.TOP_RIGHT, Position.CENTER, Position.BOTTOM_LEFT);

    private Position posOne;
    private Position posTwo;
    private Position posThree;

    private static List<Position> positions;

    /**
     * Initializes win conditions.
     * @param posOne - First position of win condition.
     * @param posTwo - Second position of win condition.
     * @param posThree - Third position of win condition.
     */
    WinCondtion(Position posOne, Position posTwo, Position posThree)
    {
        this.posOne = posOne;
        this.posTwo = posTwo;
        this.posThree = posThree;
    }

    /**
     * Gets first position of win condition.
     * @return - Position one.
     */
    public Position getPosOne()
    {
        return posOne;
    }

    /**
     * Gets second position of win condition.
     * @return - Position two.
     */
    public Position getPosTwo()
    {
        return posTwo;
    }

    /**
     * Gets third position of win condition.
     * @return - Position three.
     */
    public Position getPosThree()
    {
        return posThree;
    }

    /**
     * Gets all positions of specified win condition.
     * @return - List of all positions that define specified win condition.
     */
    public List<Position> getPositions()
    {
        if (positions == null)
        {
            positions = new LinkedList<>();
        }
        positions.clear();
        positions.add(this.posOne);
        positions.add(this.posTwo);
        positions.add(this.posThree);
        return positions;

    }

    
}
