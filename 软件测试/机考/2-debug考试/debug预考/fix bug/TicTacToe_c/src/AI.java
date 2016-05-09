/**
 * 
 * The Artificial intelligence that plays the game.
 *
 */
public class AI
{
    public static final int DEFAULT_INDEX = -1;

    private int bestRowIndex;
    private int bestColumnIndex;

    private int emptyRowIndex = 0;
    private int emptyColumnIndex = 0;

    /* how many 'X' or 'O' sings is in row/column/diagonal */
    private int singCounter = 0;

    public AI()
    {
        bestColumnIndex = DEFAULT_INDEX;
        bestRowIndex = DEFAULT_INDEX;
    }

    public int getBestRowIndex()
    {
        return bestRowIndex;
    }

    public int getBestColumnIndex()
    {
        return bestColumnIndex;
    }

    public boolean canGenerateBestMove(char playerSing)
    {
        return findInRows(playerSing) ||
               findInColumns(playerSing) ||
               findInDiagonal(playerSing) ||
               findInAntiDiagonal(playerSing);
    }

    public boolean findInRows(char playerSing)
    {
        emptyColumnIndex = 0;
        singCounter = 0;

        for (int i = 0; i < Field.FIELD_SIZE; i++)
        {
            singCounter = 0;
            emptyColumnIndex = -1;

            for (int j = 0; j < Field.FIELD_SIZE; j++)
            {
                if (Field.gameField[i][j] == playerSing)
                {
                    singCounter++;
                }

                else if (Field.gameField[i][j] == Field.DEFAULT_VALUE)
                {
                    emptyColumnIndex = j;
                }
            }

            if (singCounter == 2 && emptyColumnIndex != -1)
            {
                bestRowIndex = i;
                bestColumnIndex = emptyColumnIndex;
                return true;
            }
        }

        return false;
    }

    public boolean findInColumns(char playerSing)
    {
        emptyRowIndex = 0;
        singCounter = 0;

        for (int i = 0; i < Field.FIELD_SIZE; i++)
        {
            singCounter = 0;
            emptyRowIndex = -1;

            for (int j = 0; j < Field.FIELD_SIZE; j++)
            {
                if (Field.gameField[j][i] == playerSing)
                {
                    singCounter++;
                }

                else if (Field.gameField[j][i] == Field.DEFAULT_VALUE)
                {
                    emptyRowIndex = j;
                }
            }

            if (singCounter == 2 && emptyRowIndex != -1)
            {
                bestRowIndex = emptyRowIndex;
                bestColumnIndex = i;
                return true;
            }
        }

        return false;
    }

    public boolean findInDiagonal(char playerSing)
    {
        singCounter = 0;
        emptyRowIndex = -1;
        emptyColumnIndex = -1;

        for (int i = 0; i < Field.FIELD_SIZE; i++)
        {
            if (Field.gameField[i][i] == playerSing)
            {
                singCounter++;
            }

            else if (Field.gameField[i][i] == Field.DEFAULT_VALUE)
            {
                emptyRowIndex = i;
                emptyColumnIndex = emptyRowIndex;
            }
        }

        if (singCounter == 2 && emptyRowIndex != -1)
        {
            bestRowIndex = emptyRowIndex;
            bestColumnIndex = emptyColumnIndex;
            return true;
        }

        return false;
    }

    public boolean findInAntiDiagonal(char playerSing)
    {
        singCounter = 0;
        emptyRowIndex = -1;
        emptyColumnIndex = -1;

        for (int i = 0; i < Field.FIELD_SIZE; i++)
        {
            if (Field.gameField[i][2-i] == playerSing)
            {
                singCounter++;
            }

            else if (Field.gameField[i][2-i] == Field.DEFAULT_VALUE)
            {
                emptyRowIndex = i;
                emptyColumnIndex = 2 - i;
            }
        }

        if (singCounter == 2 && emptyRowIndex != -1 && emptyColumnIndex != -1)
        {
            bestRowIndex = emptyRowIndex;
            bestColumnIndex = emptyColumnIndex;
            return true;
        }

        return false;
    }

    
	public void generateMinAvaiMove() {
		// possible interval: (min,max)
        int min = 0;
        int max = 2;
        
        boolean find = false;
        
        for (bestRowIndex = min ; bestRowIndex <= max ; bestRowIndex++){
        	for (bestColumnIndex = min ; bestColumnIndex <= max ; bestColumnIndex++){
            	if (TicTacToe_c.isValidMove(bestRowIndex, bestColumnIndex)){
            		find = true;
            		break;
            	}
        	}
        	if (find){
        		break;
        	}
        }
	}
}
