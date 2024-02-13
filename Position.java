public enum Position 
{
    TOP_LEFT(0,0),
    TOP_CENTER(0,1),
    TOP_RIGHT(0, 2),
    MIDDLE_LEFT(1, 0),
    CENTER(1, 1),
    MIDDLE_RIGHT(1, 2),
    BOTTOM_LEFT(2,0),
    BOTTOM_CENTER(2, 1),
    BOTTOM_RIGHT(2, 2);

    private int row;
    private int column;

    Position(int row, int column)
    {
        this.row = row;
        this.column = column;
    }
}
