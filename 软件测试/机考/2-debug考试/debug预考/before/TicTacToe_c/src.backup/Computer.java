/**
 * 
 * Computer player that uses AI
 *
 */
public class Computer extends Player
{
    AI intellect;

    public Computer()
    {
        setPlayerSing(TicTacToe_c.ZERO_CHAR);
        intellect = new AI();
    }

    public void makeMove(int pos)
    {
        int columnIndex;
        int rowIndex;

        char humanSing = new Human().getPlayerSing();
        char computerSing = getPlayerSing();

        if (intellect.canGenerateBestMove(computerSing))
        {
            rowIndex = intellect.getBestRowIndex();
            columnIndex = intellect.getBestColumnIndex();
        }

        else if (intellect.canGenerateBestMove(humanSing))
        {
            rowIndex = intellect.getBestRowIndex();
            columnIndex = intellect.getBestColumnIndex();
        }

        else if (TicTacToe_c.haveFreeCellAt(1, 1))
        {
            rowIndex = 1;
            columnIndex = 1;
        }

        else
        {
            intellect.generateMinAvaiMove();
            rowIndex = intellect.getBestRowIndex();
            columnIndex = intellect.getBestColumnIndex();
        }

        TicTacToe_c.setNewSign(computerSing, rowIndex, columnIndex);

        System.out.println("Computer played:");
    }
}
