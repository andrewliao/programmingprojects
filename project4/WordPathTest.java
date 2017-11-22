package project4;

import static org.junit.Assert.*;
import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

import org.junit.Test;

public class WordPathTest {
	

	@Test
	public void testNumLines() throws IOException {
		/** testing this method with 5 lines using a StringReader variable called lines */
		StringReader lines = new StringReader("a \n ba \n asdf \n asdf \n df ");
		assertTrue(WordPath.numLines(lines) == 5);
		
		/** testing 0: a buffered reader with a reader input that has no lines */
		StringReader zero = new StringReader("");
		assertTrue(WordPath.numLines(zero) == 0);
		
		/** testing 1: a buffered reader with a reader input that has 1 line */
		StringReader one = new StringReader("asdf");
		assertTrue(WordPath.numLines(one) == 1);
		
		/** testing 2: a buffered reader with a reader input of more than 1 line */
		StringReader two = new StringReader("asdfds\nasdfsdf");
		assertTrue(WordPath.numLines(two) == 2);
	}

    @Test
    public void testGetPath() throws IOException {
	    /** creating a linkedlist variable test which will store the path */
	    LinkedList<Integer> test;
	    /** w stores the WordData array which we will be getting a path from*/
	    WordData[] w = new WordData[4];
	    w[0] = WordData.parseWordData("0 cat 1 3");
	    w[1] = WordData.parseWordData("1 bat 2");
	    w[2] = WordData.parseWordData("2 bad 1 3");
	    w[3] = WordData.parseWordData("3 cad 0");
	    test = WordPath.getPath(0, 2, w);

	    assertEquals((int)test.get(0), 0);
	    assertEquals((int)test.get(1), 1);
	    assertEquals((int)test.get(2), 2);
	}   
	
	@Test
	public void testGetPathForEmpty() throws IOException {
	  /** creating a linkedlist test to store which will store an empty path */
	  LinkedList<Integer> test;
	  /** an empty array which should store no path */
	  WordData[] w = new WordData[0];
	  test = WordPath.getPath(0, 0, w);
	  assertNull(test);
	}
	
	@Test
	public void testGetPathSameWord() throws IOException {
	  /** creating a linkedlist test to store which will store an empty path */
	  LinkedList<Integer> test;
	  WordData[] w = new WordData[4];
	  /** w stores the WordData array which we will be getting a path from */
	  w[0] = WordData.parseWordData("0 cat 1 3");
	  w[1] = WordData.parseWordData("1 bat 2");
	  w[2] = WordData.parseWordData("2 bad 1 3");
	  w[3] = WordData.parseWordData("3 cad 0");
	  test = WordPath.getPath(0, 0, w);

	  assertEquals(test.size(), 1);
	}
	
	@Test
	public void testGetPathNoMatch() throws IOException {
	  /** creating a linkedlist test to store which will store an empty path */
	  LinkedList<Integer> test;
	  /** w stores the WordData array which we will be getting a path from */
	  WordData[] w = new WordData[5];
	  w[0] = WordData.parseWordData("0 cat 1 3");
	  w[1] = WordData.parseWordData("1 bat 2");
	  w[2] = WordData.parseWordData("2 bad 1 3");
	  w[3] = WordData.parseWordData("3 cad 0");  
	  w[4] = WordData.parseWordData("4 bow");
	  test = WordPath.getPath(0, 4, w);

	  assertNull(test);
	}
	
}