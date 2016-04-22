import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class MyMatrixTest {

	PrintStream console = null;
    ByteArrayOutputStream bytes = null;
    MatrixC matrix;
    
    byte[] inputBytes;

    @org.junit.Before
    public void setUp() throws Exception {
    	// Just a demo to show, data array here is of no use
    	int[][] data = {
    			{1 , 1 , 1},
    			{1 , 1 , 1},
    			{1 , 1 , 1}
    	};
    	
        bytes = new ByteArrayOutputStream();
        console = System.out;
        matrix = new MatrixC(data);

        System.setOut(new PrintStream(bytes));

    }

    @org.junit.After
    public void tearDown() throws Exception {
        
        System.setOut(console);
    }

    
    
}
