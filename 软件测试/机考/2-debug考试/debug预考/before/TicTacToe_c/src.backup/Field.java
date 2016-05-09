public class Field
{
    public static final char DEFAULT_VALUE = ' ';

    public static final int FIELD_SIZE = 3;

    public static int cellIndex = 1;

    protected static char[][] gameField;

    public Field()
    {
        gameField = new char[FIELD_SIZE][FIELD_SIZE];

        for (int i = 0; i < gameField.length; ++i)
        {
            for (int j = 0; j < gameField[i].length; ++j)
            {
                gameField[i][j] = DEFAULT_VALUE;
            }
        }
    }

    public void drawGameField()
    {
    	cellIndex = 1;
        System.out.println("\n-------------");
        
        for (int i = 0; i< gameField.length; i++)
        {
        	char[] row = gameField[i];
            for (int j = 0; j < row.length;j++)
            {
                drawCell(row[j]);
            }

            System.out.print("|");
            System.out.println("\n-------------");
        }

        System.out.println();
    }

    public void drawCell(char cell)
    {
        if (cell == DEFAULT_VALUE)
        {
            System.out.print("| " + cellIndex + " ");
        }

        else
        {
            System.out.print("| " + cell + " ");
        }

        cellIndex++;
    }
}
