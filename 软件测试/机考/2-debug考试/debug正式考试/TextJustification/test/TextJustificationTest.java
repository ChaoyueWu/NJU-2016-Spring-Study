import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

public class TextJustificationTest {
	TextJustification tj = new TextJustification();

	@Test
	public void test1() {
		String[] words = { "This", "is", "an", "example", "of", "text", "justification." };
		int maxWidth = 16;
		List<String> actual = tj.fullJustify(words, maxWidth);
		List<String> expected = new ArrayList<String>() {
			{
				add("This    is    an");
				add("example  of text");
				add("justification.  ");
			}
		};
		assertEquals(expected, actual);
	}

	@Test
	public void test2() {
		String[] words = {"What","must","be","shall","be."};
		int maxWidth = 12;
		List<String> actual = tj.fullJustify(words, maxWidth);
		List<String> expected = new ArrayList<String>(){
			{
				add("What must be");
				add("shall be.   ");
			}
		};
		assertEquals(expected, actual);
	}
	
	@Test
	public void test3() {
		String[] words = {"Basketball", "nice"};
		int maxWidth = 12;
		List<String> actual = tj.fullJustify(words, maxWidth);
		List<String> expected = new ArrayList<String>(){
			{
				add("Basketball  ");
				add("nice        ");
			}
		};
		assertEquals(expected, actual);
	}
	
	@Test
	public void test4() {
		String[] words = {"Good", "job!"};
		int maxWidth = 8;
		List<String> actual = tj.fullJustify(words, maxWidth);
		List<String> expected = new ArrayList<String>(){
			{
				add("Good    ");
				add("job!    ");
			}
		};
		assertEquals(expected, actual);
	}
	
	@Test
	public void test5() {
		String[] words = {"I","love","you."};
		int maxWidth = 20;
		List<String> actual = tj.fullJustify(words, maxWidth);
		List<String> expected = new ArrayList<String>(){
			{
				add("I love you.         ");
			}
		};
		assertEquals(expected, actual);
	}
	
	@Test
	public void test6() {
		String[] words = {"I", "have", "a", "big", "dream"};
		int maxWidth = 5;
		List<String> actual = tj.fullJustify(words, maxWidth);
		List<String> expected = new ArrayList<String>(){
			{
				add("I    ");
				add("have ");
				add("a big");
				add("dream");
			}
		};
		assertEquals(expected, actual);
	}
	
	@Test
	public void test7() {
		String[] words = {"fruit","apple","peach","lemon","mango"};
		int maxWidth = 5;
		List<String> actual = tj.fullJustify(words, maxWidth);
		List<String> expected = new ArrayList<String>(){
			{
				add("fruit");
				add("apple");
				add("peach");
				add("lemon");
				add("mango");
			}
		};
		assertEquals(expected, actual);
	}
	
	@Test
	public void test8() {
		String[] words = {"Do", "you", "think", "of", "me"};
		int maxWidth = 8;
		List<String> actual = tj.fullJustify(words, maxWidth);
		List<String> expected = new ArrayList<String>(){
			{
				add("Do   you");
				add("think of");
				add("me      ");
			}
		};
		assertEquals(expected, actual);
	}
	
	@Test
	public void test9() {
		String[] words = {"Good", "for", "you!"};
		int maxWidth = 6;
		List<String> actual = tj.fullJustify(words, maxWidth);
		List<String> expected = new ArrayList<String>(){
			{
				add("Good  ");
				add("for   ");
				add("you!  ");
			}
		};
		assertEquals(expected, actual);
	}
}
