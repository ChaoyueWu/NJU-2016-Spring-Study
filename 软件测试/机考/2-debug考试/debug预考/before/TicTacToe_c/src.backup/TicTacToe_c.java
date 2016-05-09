import java.util.ArrayList;

/**
 * TicTacToe_c 是一个游戏。在一个3*3的棋盘中，由X和O两方轮流下棋（X是玩家，O是计算机AI）。先连成连续的横向或纵向或斜向的三个棋子的一方的胜出。
 */
public class TicTacToe_c
{
	private GameRecord gameRecord;
	
    public static final int MAX_NUMBER_OF_MOVES = 9;

    public static final char DRAW_CHAR = 'D';

    /*
    *   Unicode representation of CROSS_CHAR symbol
    * */
    public static final char CROSS_CHAR = 'X';

    /*
    *   Unicode representation of ZERO_CHAR symbol
    * */
    public static final char ZERO_CHAR = 'O';

    protected static int  currentXPos = 0;
    protected static int  currentYPos = 0;
    protected static char currentSign = CROSS_CHAR;

    protected Field field;
    private Player human = new Human();
    private Player computer = new Computer();

    protected int movesCounter = 0;

    public TicTacToe_c(GameRecord gameRecord)
    {
    	this.gameRecord = gameRecord;
        field = new Field();
    }

    public boolean run()
    {
        printGreetings();
    	
        field.drawGameField();

        // start index (first player will be human or computer)
        // i = 0 or 1
        int i = gameRecord.getFirstPlayer();

        for (int idx = 0 ; idx < gameRecord.getSteps().size() ; idx++ ){
        	if (i == 0){
        		nextMove(idx * 2 , gameRecord.getSteps());
                field.drawGameField();
        		if (isEndOfGame()){
        			break;
        		}
        		nextMove(idx * 2 + 1 , gameRecord.getSteps());
        	}
        	else{
        		nextMove(idx * 2 + 1, gameRecord.getSteps());
                field.drawGameField();
                
        		if (isEndOfGame()){
        			break;
        		}
        		
        		nextMove(idx * 2 , gameRecord.getSteps());
        	}
            field.drawGameField();
        }
        
        // If computer goes first, let it have the last try to beat you.
        if (i == 1){
        	nextMove(1 , gameRecord.getSteps());
        }

        field.drawGameField();
        
        return isEndOfGame();
    }

    /**
     * 在某个位置下棋
     * @param sing
     * @param row
     * @param column
     */
    public static void setNewSign(char sing, int row, int column)
    {
        Field.gameField[row][column] = sing;

        // initialize current values
        currentXPos = row;
        currentYPos = column;
        currentSign = sing;
    }

    /**
     * 测试某个位置是否有空位
     * @param row
     * @param column
     * @return
     */
    public static boolean haveFreeCellAt(int row, int column)
    {
        return Field.gameField[row][column] == Field.DEFAULT_VALUE;
    }

    public static boolean isValidMove(int row, int column)
    {
        return row >= 0 && row < 3 &&
                column >= 0 && column < 3 &&
                haveFreeCellAt(row, column);

    }

    public static void printGreetings()
    {
        System.out.println("==========================================================================");
        System.out.println("================================TIC-TAC-TOE===============================");
        System.out.println("==========================================================================");
    }

    public void nextMove(int moveIndex, ArrayList<Integer> steps)
    {
        if (moveIndex % 2 == 0)
        {
            human.makeMove(steps.get(moveIndex / 2));
            checkWhoWon();
        }

        else
        {
            computer.makeMove(-1);
            checkWhoWon();
        }

        movesCounter++;
    }

    public char checkWhoWon()
    {
        //check col
        for (int i = 0; i < Field.FIELD_SIZE; i++)
        {
            if (Field.gameField[currentXPos][i] != currentSign)
            {
                break;
            }

            else if (i == Field.FIELD_SIZE - 1)
            {
                return currentSign;
            }
        }

        //check row
        for (int i = 0; i < Field.FIELD_SIZE; i++)
        {
            if (Field.gameField[i][currentYPos] != currentSign)
            {
                break;
            }

            else if (i == Field.FIELD_SIZE - 1)
            {
                return currentSign;
            }
        }

        //check main diagonal
        if (currentXPos == currentYPos)
        {
            for (int i = 0; i < Field.FIELD_SIZE; i++)
            {
                if (Field.gameField[i][i] != currentSign)
                {
                    break;
                }

                else if (i == Field.FIELD_SIZE - 1)
                {
                    return currentSign;
                }
            }
        }

        //check anti diagonal
        for (int i = 0; i < Field.FIELD_SIZE; i++)
        {
            if (Field.gameField[i][Field.FIELD_SIZE - 1 - i] != currentSign)
            {
                break;
            }

            else if (i == Field.FIELD_SIZE - 1)
            {
                return currentSign;
            }
        }

        //check draw
        if (movesCounter == MAX_NUMBER_OF_MOVES)
        {
            return DRAW_CHAR;
        }

        return Field.DEFAULT_VALUE;
    }

    public boolean isEndOfGame()
    {
        if (checkWhoWon() == CROSS_CHAR)
        {
            System.out.println("\n  -------------------");
            System.out.println("  --- PLAYER WON! ---");
            System.out.println("  -------------------\n");
            return true;
        }

        else if (checkWhoWon() == ZERO_CHAR)
        {
            System.out.println("\n  ---------------------");
            System.out.println("  --- COMPUTER WON! ---");
            System.out.println("  ---------------------\n");
            return true;
        }

        else if (checkWhoWon() == DRAW_CHAR)
        {
            System.out.println("\n  -------------");
            System.out.println("  --- DRAW! ---");
            System.out.println("  -------------\n");
            return true;
        }

        else
        {
            return false;
        }
    }
}
