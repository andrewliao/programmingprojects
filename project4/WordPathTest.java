package project4;

import static org.junit.Assert.*;
import java.io.*;
import java.util.*;

import org.junit.Test;

public class WordPathTest {

	@Test
	public void testNumLines() throws IOException {
		FileReader x = new FileReader("/Users/andrewliao/code/programmingprojects/project4/SmallWordIndex");
		assertTrue(WordPath.numLines(x) == 15);
	
	}
	
	@Test
	public void testMakeWordArray() throws IOException{
		WordPath x = new WordPath();
		WordData[] comparison = new WordData[15];
		
		WordData[] y = WordPath.makeWordArray("/Users/andrewliao/code/programmingprojects/project4/SmallWordIndex");
		for(WordData object: y) {
			System.out.println(object.getFlag());
			System.out.println(object.getLineNumber());
			System.out.println(object.getWord());
			System.out.println(object.getLlData());
		}
	}

	@Test
	public void testGetPath() throws IOException {
		LinkedList<Integer> test = new LinkedList<Integer>();
		WordData[] y = WordPath.makeWordArray("/Users/andrewliao/code/programmingprojects/project4/SmallWordIndex");
		test = WordPath.getPath(0, 11, y);
		System.out.println("Testing:");
		System.out.println(test);
	}
}
