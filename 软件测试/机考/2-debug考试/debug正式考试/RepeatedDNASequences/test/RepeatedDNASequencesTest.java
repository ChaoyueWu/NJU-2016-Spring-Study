import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

public class RepeatedDNASequencesTest {
	RepeatedDNASequences seq = new RepeatedDNASequences();

	@Test
	public void test1() {
		String str = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		List<String> actual = seq.findRepeatedDnaSequences(str);
		List<String> expected = new ArrayList<String>() {
			{
				add("AAAAACCCCC");
				add("CCCCCAAAAA");
			}
		};
		assertEquals(expected, actual);
	}
	
	@Test
	public void test2() {
		String str = "AAAAAAAAAAAAA";
		List<String> actual = seq.findRepeatedDnaSequences(str);
		List<String> expected = new ArrayList<String>() {
			{
				add("AAAAAAAAAA");
			}
		};
		assertEquals(expected, actual);
	}
	
	@Test
	public void test3() {
		String str = "";
		List<String> actual = seq.findRepeatedDnaSequences(str);
		List<String> expected = new ArrayList<String>() {
			{
			}
		};
		assertEquals(expected, actual);
	}
	@Test
	public void test4() {
		String str = "AAAAAAAAAA";
		List<String> actual = seq.findRepeatedDnaSequences(str);
		List<String> expected = new ArrayList<String>() {
			{
			}
		};
		assertEquals(expected, actual);
	}
	@Test
	public void test5() {
		String str = "AAAAAAAAAAA";
		List<String> actual = seq.findRepeatedDnaSequences(str);
		List<String> expected = new ArrayList<String>() {
			{
				add("AAAAAAAAAA");
			}
		};
		assertEquals(expected, actual);
	}
	@Test
	public void test6() {
		String str = "ACGTACGTACGTACGTACGTACGTACGT";
		List<String> actual = seq.findRepeatedDnaSequences(str);
		List<String> expected = new ArrayList<String>() {
			{
				add("ACGTACGTAC");
				add("CGTACGTACG");
				add("GTACGTACGT");
				add("TACGTACGTA");
			}
		};
		assertEquals(expected, actual);
	}
	@Test
	public void test7() {
		String str = "AAAAAACCCCCCCCAAAAAAAACCCCCCCCAAAAAA";
		List<String> actual = seq.findRepeatedDnaSequences(str);
		List<String> expected = new ArrayList<String>() {
			{
				add("AAAAAACCCC");
				add("AAAAACCCCC");
				add("AAAACCCCCC");
				add("AAACCCCCCC");
				add("AACCCCCCCC");
				add("ACCCCCCCCA");
				add("CCCCCCCCAA");
				add("CCCCCCCAAA");
				add("CCCCCCAAAA");
				add("CCCCCAAAAA");
				add("CCCCAAAAAA");
			}
		};
		assertEquals(expected, actual);
	}
	@Test
	public void test8() {
		String str = "AAAAACCCCCGGGGGTTTTT";
		List<String> actual = seq.findRepeatedDnaSequences(str);
		List<String> expected = new ArrayList<String>() {
			{
			}
		};
		assertEquals(expected, actual);
	}
	@Test
	public void test9() {
		String str = "AAGGCCTTAAGGCCTTTTCCGGAATTCCGGAA";
		List<String> actual = seq.findRepeatedDnaSequences(str);
		List<String> expected = new ArrayList<String>() {
			{
			}
		};
		assertEquals(expected, actual);
	}

	@Test
	public void test10() {
		String str = "AAAAACCCCCAAAAACCCCCCCCCCAAAAACCCCCAAAAA";
		List<String> actual = seq.findRepeatedDnaSequences(str);
		List<String> expected = new ArrayList<String>() {
			{
				add("AAAAACCCCC");
				add("CCCCCAAAAA");
				add("CCCCAAAAAC");
				add("CCCAAAAACC");
				add("CCAAAAACCC");
				add("CAAAAACCCC");
				add("AAAACCCCCA");
				add("AAACCCCCAA");
				add("AACCCCCAAA");
				add("ACCCCCAAAA");
			}
		};
		assertEquals(expected, actual);
	}
}
