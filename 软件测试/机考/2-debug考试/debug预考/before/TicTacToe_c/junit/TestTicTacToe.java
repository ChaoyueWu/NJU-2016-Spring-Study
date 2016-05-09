import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class TestTicTacToe {
	public static final int PLAYER_FIRST = 0 ;
	public static final int COMPUTER_FIRST = 1;
	
    public static final char DRAW = 'D';
    public static final char COMPUTER_WON = 'O';
    public static final char PLAYER_WON = 'X';
	

	@Test
	public void test_player_from1_1() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(1);
    	list.add(2);
    	list.add(8);
    	
    	GameRecord record = new GameRecord(PLAYER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	assertTrue(end);
    	
    	assertEquals(COMPUTER_WON , game.checkWhoWon());
	}
	
	@Test
	public void test_player_from1_2() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(1);
    	list.add(2);
    	list.add(7);
    	list.add(9);
    	
    	GameRecord record = new GameRecord(PLAYER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	assertTrue(end);
    	
    	assertEquals(COMPUTER_WON , game.checkWhoWon());
	}
	
	@Test
	public void test_player_from1_3() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(1);
    	list.add(2);
    	list.add(7);
    	list.add(6);
    	list.add(9);
    	
    	GameRecord record = new GameRecord(PLAYER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	assertTrue(end);
    	
    	assertEquals(DRAW , game.checkWhoWon());
	}
	
	@Test
	public void test_player_from1_4() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(1);
    	list.add(3);
    	list.add(4);
    	
    	GameRecord record = new GameRecord(PLAYER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	assertTrue(end);
    	
    	assertEquals(COMPUTER_WON , game.checkWhoWon());
	}
	
	@Test
	public void test_player_from1_5() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(1);
    	list.add(3);
    	list.add(8);
    	list.add(7);
    	
    	GameRecord record = new GameRecord(PLAYER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	assertTrue(end);
    	
    	assertEquals(COMPUTER_WON , game.checkWhoWon());
	}
	
	@Test
	public void test_player_from1_6() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(1);
    	list.add(3);
    	list.add(8);
    	list.add(4);
    	list.add(9);
    	
    	GameRecord record = new GameRecord(PLAYER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	assertTrue(end);
    	
    	assertEquals(DRAW , game.checkWhoWon());
	}
	
	@Test
	public void test_player_from1_7() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(1);
    	list.add(9);
    	list.add(6);
    	
    	GameRecord record = new GameRecord(PLAYER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	assertTrue(end);
    	
    	assertEquals(COMPUTER_WON , game.checkWhoWon());
	}
	
	
	@Test
	public void test_player_from1_8() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(1);
    	list.add(9);
    	list.add(8);
    	list.add(4);
    	
    	GameRecord record = new GameRecord(PLAYER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	assertTrue(end);
    	
    	assertEquals(COMPUTER_WON , game.checkWhoWon());
	}
	
	
	@Test
	public void test_player_from1_9() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(1);
    	list.add(9);
    	list.add(8);
    	list.add(3);
    	list.add(4);
    	
    	GameRecord record = new GameRecord(PLAYER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	assertTrue(end);
    	
    	assertEquals(DRAW , game.checkWhoWon());
	}
	
	
	
	
	
	@Test
	public void test_player_from5_1() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(5);
    	list.add(2);
    	list.add(3);
    	list.add(4);
    	
    	GameRecord record = new GameRecord(PLAYER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	assertTrue(end);
    	
    	assertEquals(COMPUTER_WON , game.checkWhoWon());
	}
	
	@Test
	public void test_player_from5_2() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(5);
    	list.add(2);
    	list.add(3);
    	list.add(9);
    	list.add(4);
    	
    	GameRecord record = new GameRecord(PLAYER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	assertTrue(end);
    	
    	assertEquals(DRAW , game.checkWhoWon());
	}
	
	@Test
	public void test_player_from5_3() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(5);
    	list.add(2);
    	list.add(4);
    	list.add(9);
    	list.add(7);
    	
    	GameRecord record = new GameRecord(PLAYER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	assertTrue(end);
    	
    	assertEquals(DRAW , game.checkWhoWon());
	}
	
	@Test
	public void test_player_from5_4() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(5);
    	list.add(2);
    	list.add(6);
    	list.add(7);
    	list.add(9);
    	
    	GameRecord record = new GameRecord(PLAYER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	assertTrue(end);
    	
    	assertEquals(DRAW , game.checkWhoWon());
	}
	
	@Test
	public void test_player_from5_5() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(5);
    	list.add(2);
    	list.add(7);
    	list.add(4);
    	list.add(9);
    	
    	GameRecord record = new GameRecord(PLAYER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	assertTrue(end);
    	
    	assertEquals(DRAW , game.checkWhoWon());
	}
	
	@Test
	public void test_player_from5_6() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(5);
    	list.add(3);
    	list.add(2);
    	
    	GameRecord record = new GameRecord(PLAYER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	assertTrue(end);
    	
    	assertEquals(COMPUTER_WON , game.checkWhoWon());
	}
	
	@Test
	public void test_player_from5_7() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(5);
    	list.add(3);
    	list.add(4);
    	list.add(9);
    	list.add(8);
    	
    	GameRecord record = new GameRecord(PLAYER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	assertTrue(end);
    	
    	assertEquals(DRAW , game.checkWhoWon());
	}
	
	@Test
	public void test_player_from5_8() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(5);
    	list.add(6);
    	list.add(8);
    	
    	GameRecord record = new GameRecord(PLAYER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	assertTrue(end);
    	
    	assertEquals(COMPUTER_WON , game.checkWhoWon());
	}
	
	@Test
	public void test_player_from5_9() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(5);
    	list.add(6);
    	list.add(7);
    	list.add(9);
    	
    	GameRecord record = new GameRecord(PLAYER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	assertTrue(end);
    	
    	assertEquals(COMPUTER_WON , game.checkWhoWon());
	}
	
	@Test
	public void test_player_from5_10() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(5);
    	list.add(6);
    	list.add(7);
    	list.add(2);
    	list.add(9);
    	
    	GameRecord record = new GameRecord(PLAYER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	assertTrue(end);
    	
    	assertEquals(DRAW , game.checkWhoWon());
	}
	
	@Test
	public void test_player_from5_11() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(5);
    	list.add(9);
    	list.add(6);
    	
    	GameRecord record = new GameRecord(PLAYER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	assertTrue(end);
    	
    	assertEquals(COMPUTER_WON , game.checkWhoWon());
	}
	
	@Test
	public void test_player_from5_12() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(5);
    	list.add(9);
    	list.add(3);
    	list.add(7);
    	
    	GameRecord record = new GameRecord(PLAYER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	assertTrue(end);
    	
    	assertEquals(PLAYER_WON , game.checkWhoWon());
	}
	
	
	
	
	
	
	@Test
	public void test_player_notfinished_1() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(5);
    	list.add(3);
    	list.add(4);
    	
    	GameRecord record = new GameRecord(PLAYER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	assertFalse(end);
	}
	
	@Test
	public void test_player_notfinished_2() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(8);
    	list.add(2);
    	list.add(9);
    	
    	GameRecord record = new GameRecord(PLAYER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	assertFalse(end);
	}
	
	
	
	
	
	
	@Test
	public void test_com_notfinished_1() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(7);
    	list.add(9);
    	list.add(2);
    	
    	GameRecord record = new GameRecord(COMPUTER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	assertFalse(end);
	}
	
	@Test
	public void test_com_notfinished_2() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(6);
    	list.add(9);
    	
    	GameRecord record = new GameRecord(COMPUTER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	assertFalse(end);
	}
	
	
	
	
	
	
	
	
	@Test
	public void test_com_from1_1() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(1);
    	list.add(3);
    	
    	GameRecord record = new GameRecord(COMPUTER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	
    	assertTrue(end);
    	
    	assertEquals(COMPUTER_WON , game.checkWhoWon());
	}
	
	@Test
	public void test_com_from1_2() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(1);
    	list.add(8);
    	list.add(9);
    	
    	GameRecord record = new GameRecord(COMPUTER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	
    	assertTrue(end);
    	
    	assertEquals(COMPUTER_WON , game.checkWhoWon());
	}
	
	@Test
	public void test_com_from1_3() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(1);
    	list.add(8);
    	list.add(7);
    	list.add(4);
    	
    	GameRecord record = new GameRecord(COMPUTER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	
    	assertTrue(end);
    	
    	assertEquals(COMPUTER_WON , game.checkWhoWon());
	}
	
	@Test
	public void test_com_from1_4() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(1);
    	list.add(8);
    	list.add(7);
    	list.add(6);
    	
    	GameRecord record = new GameRecord(COMPUTER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	
    	assertTrue(end);
    	
    	assertEquals(DRAW , game.checkWhoWon());
	}
	
	@Test
	public void test_com_from2_1() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(2);
    	list.add(3);
    	
    	GameRecord record = new GameRecord(COMPUTER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	
    	assertTrue(end);
    	
    	assertEquals(COMPUTER_WON , game.checkWhoWon());
	}
	
	@Test
	public void test_com_from2_2() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(2);
    	list.add(9);
    	list.add(4);
    	
    	GameRecord record = new GameRecord(COMPUTER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	
    	assertTrue(end);
    	
    	assertEquals(COMPUTER_WON , game.checkWhoWon());
	}
	
	@Test
	public void test_com_from2_3() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(2);
    	list.add(9);
    	list.add(7);
    	list.add(4);
    	
    	GameRecord record = new GameRecord(COMPUTER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	
    	assertTrue(end);
    	
    	assertEquals(DRAW , game.checkWhoWon());
	}
	
	@Test
	public void test_com_from4_1() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(4);
    	list.add(2);
    	
    	GameRecord record = new GameRecord(COMPUTER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	
    	assertTrue(end);
    	
    	assertEquals(COMPUTER_WON , game.checkWhoWon());
	}
	
	@Test
	public void test_com_from4_2() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(4);
    	list.add(9);
    	list.add(6);
    	
    	GameRecord record = new GameRecord(COMPUTER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	
    	assertTrue(end);
    	
    	assertEquals(COMPUTER_WON , game.checkWhoWon());
	}
	
	@Test
	public void test_com_from4_3() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(4);
    	list.add(9);
    	list.add(8);
    	
    	GameRecord record = new GameRecord(COMPUTER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	
    	assertTrue(end);
    	
    	assertEquals(COMPUTER_WON , game.checkWhoWon());
	}
	
	@Test
	public void test_com_from9_1() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(9);
    	list.add(2);
    	list.add(6);
    	
    	GameRecord record = new GameRecord(COMPUTER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	
    	assertTrue(end);
    	
    	assertEquals(COMPUTER_WON , game.checkWhoWon());
	}
	
	@Test
	public void test_com_from9_2() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(9);
    	list.add(2);
    	list.add(7);
    	list.add(6);
    	
    	GameRecord record = new GameRecord(COMPUTER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	
    	assertTrue(end);
    	
    	assertEquals(DRAW , game.checkWhoWon());
	}
	
	@Test
	public void test_com_from9_3() {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	list.add(9);
    	list.add(4);
    	list.add(3);
    	
    	GameRecord record = new GameRecord(COMPUTER_FIRST , list);
    	
    	TicTacToe_c game = new TicTacToe_c(record);
    	boolean end = game.run();
    	
    	assertTrue(end);
    	
    	assertEquals(COMPUTER_WON , game.checkWhoWon());
	}

}
