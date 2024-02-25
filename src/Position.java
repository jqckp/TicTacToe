package src;

/**
 * Defines valid positions on the gameboard and 
 * stores information on spot availability.
 * 
 * @author - Jack Porter
 * @version - 2/12/2024
 */
enum Position 
{
    TOP_LEFT(0,0, false, ' '),
    TOP_CENTER(0,1, false, ' '),
    TOP_RIGHT(0, 2, false, ' '),
    MIDDLE_LEFT(1, 0, false, ' '),
    CENTER(1, 1, false, ' '),
    MIDDLE_RIGHT(1, 2, false, ' '),
    BOTTOM_LEFT(2,0, false, ' '),
    BOTTOM_CENTER(2, 1, false, ' '),
    BOTTOM_RIGHT(2, 2, false, ' '),
    INVALID_POSITION(-1, -1, true, ' ');

    private int row;
    private int column;
    private boolean taken;
    private char occupyingPlayer;

    /**
     * Initializes position of gameboard.
     * 
     * @param row - Row of position
     * @param column - Column of position
     * @param taken - Position availablity
     */
    Position(int row, int column, boolean taken, char occupyingPlayer)
    {
        this.row = row;
        this.column = column;
        this.taken = taken;
        this.occupyingPlayer = occupyingPlayer;
    }

    /**
     * Gets row of position.
     * @return - row of position.
     */
    protected int getRow()
    {
        return row;
    }

    /**
     * Gets column of position.
     * @return - column of position.
     */
    protected int getColumn()
    {
        return column;
    }

    /**
     * Gets the player that is occupying specified spot.
     * @return - occupyingPlayer
     */
    protected char getOccupyingPlayer()
    {
        return occupyingPlayer;
    }

    /**
     * Updates the player occupying specified spot.
     * @param occupyingPlayer - which player?
     */
    protected void setOccupyingPlayer(char occupyingPlayer)
    {
        if (this != INVALID_POSITION)
        {
            this.occupyingPlayer = occupyingPlayer;
        }
        
    }

    /**
     * Gets state of spot availability.
     * @return - spot availability.
     */
    protected boolean isTaken()
    {
        return taken;
    }

    /**
     * Updates status of spot availability
     * @param taken - new availability status.
     */
    protected void setTaken(boolean taken)
    {
        if (this != INVALID_POSITION)
        {
            this.taken = taken;
        }

    }
}
