package src;
public enum Position 
{
    TOP_LEFT(0,0, false),
    TOP_CENTER(0,1, false),
    TOP_RIGHT(0, 2, false),
    MIDDLE_LEFT(1, 0, false),
    CENTER(1, 1, false),
    MIDDLE_RIGHT(1, 2, false),
    BOTTOM_LEFT(2,0, false),
    BOTTOM_CENTER(2, 1, false),
    BOTTOM_RIGHT(2, 2, false),
    INVALID_POSITION(-1, -1, true);

    private int row;
    private int column;
    private boolean taken;

    Position(int row, int column, boolean taken)
    {
        this.row = row;
        this.column = column;
        this.taken = taken;
    }

    public int getRow()
    {
        return row;
    }

    public int getColumn()
    {
        return column;
    }

    public boolean isTaken()
    {
        return taken;
    }

    public void setTaken(boolean taken)
    {
        if (this != INVALID_POSITION)
        {
            this.taken = taken;
        }

    }
}
