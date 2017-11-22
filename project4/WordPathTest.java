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
	
	/**
	@Test
	public void testMakeWordArray() throws IOException{
		WordPath x = new WordPath();
		WordData[] comparison = new WordData[15];
		
		WordData[] y = WordPath.makeWordArray("/Users/andrewliao/code/programmingprojects/project4/SmallWordIndex");
		for(WordData object: y) {
			System.out.println(object.getVisited());
			System.out.println(object.getLineNumber());
			System.out.println(object.getWord());
			System.out.println(object.getLlData());
		}
	}
	*/

	@Test
	public void testGetPath() throws IOException {
		
		LinkedList<Integer> test = new LinkedList<Integer>();
		WordData[] y = WordPath.makeWordArray("/Users/andrewliao/code/programmingprojects/project4/SmallWordIndex");
		test = WordPath.getPath(1, 10, y);
		System.out.println("Testing:");
		System.out.println(test);
		
		assertTrue(test.get(0) == 1);
		assertTrue(test.get(test.size() -1 ) == 10);
		
		LinkedList<Integer> test2 = new LinkedList<Integer>();
		test2 = WordPath.getPath(1, 10, null);
		System.out.println(test2);
		
	}
	
}
