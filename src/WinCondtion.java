import java.util.LinkedList;
import java.util.List;

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

    WinCondtion(Position posOne, Position posTwo, Position posThree)
    {
        this.posOne = posOne;
        this.posTwo = posTwo;
        this.posThree = posThree;
    }

    public Position getPosOne()
    {
        return posOne;
    }

    public Position getPosTwo()
    {
        return posTwo;
    }

    public Position getPosThree()
    {
        return posThree;
    }

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
