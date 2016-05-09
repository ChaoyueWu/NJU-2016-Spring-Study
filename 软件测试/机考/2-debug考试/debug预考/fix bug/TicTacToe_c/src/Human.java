import java.util.Scanner;

/**
 * »À¿‡ÕÊº“
 *
 */
public class Human extends Player
{
    public static Scanner playerInput = new Scanner(System.in);

    private int rowIndex;
    private int columnIndex;

    public Human()
    {
        setPlayerSing(TicTacToe_c.CROSS_CHAR);
    }

    public void makeMove(int pos)
    {
        char playerSing = getPlayerSing();
            System.out.println("Your move, Player.");
            System.out.println("You put your chess on " + pos);
            setIndexes(pos);
            
            TicTacToe_c.setNewSign(playerSing, rowIndex, columnIndex);
    }

    public void setIndexes(int cellIndex)
    {
        switch (cellIndex)
        {
            case 1:
                rowIndex = 0;
                columnIndex = 0;
                break;

            case 2:
                rowIndex = 0;
                columnIndex = 1;
                break;

            case 3:
                rowIndex = 0;
                columnIndex = 2;
                break;

            case 4:
                rowIndex = 1;
                columnIndex = 0;
                break;

            case 5:
                rowIndex = 1;
                columnIndex = 1;
                break;

            case 6:
                rowIndex = 1;
                columnIndex = 2;
                break;

            case 7:
                rowIndex = 2;
                columnIndex = 0;
                break;

            case 8:
                rowIndex = 2;
                columnIndex = 1;
                break;

            case 9:
                rowIndex = 2;
                columnIndex = 2;
                break;
        }
    }
}
