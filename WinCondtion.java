public enum WinCondtion 
{
    TOP_HORIZONTAL(Position.TOP_LEFT, Position.TOP_CENTER, Position.TOP_RIGHT),
    MIDDLE_HORIZONTAL(Position.MIDDLE_LEFT, Position.CENTER, Position.MIDDLE_RIGHT),
    BOTTOM_HORIZONTAL(Position.BOTTOM_LEFT, Position.BOTTOM_CENTER, Position.BOTTOM_RIGHT),
    LEFT_VERTICAL(Position.TOP_LEFT, Position.MIDDLE_LEFT, Position.BOTTOM_RIGHT),
    MIDDLE_VERTICAL(Position.TOP_CENTER, Position.CENTER, Position.BOTTOM_CENTER),
    RIGHT_VERTICAL(Position.TOP_RIGHT, Position.MIDDLE_RIGHT, Position.BOTTOM_RIGHT),
    TOP_LEFT_TO_BOTTOM_RIGHT(Position.TOP_LEFT, Position.CENTER, Position.BOTTOM_RIGHT),
    TOP_RIGHT_TO_BOTTOM_LEFT(Position.TOP_RIGHT, Position.CENTER, Position.BOTTOM_LEFT);

    Position posOne;
    Position posTwo;
    Position posThree;

    WinCondtion(Position posOne, Position posTwo, Position posThree)
    {
        this.posOne = posOne;
        this.posTwo = posTwo;
        this.posThree = posThree;
    }

    
}
