package project4;
/**
 * This class tests the parseWordData method of WordData.
 * @author Andrew Liao
 */

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import org.junit.Test;

public class WordDataTest {

	@Test
	public void testParseWordData() throws FileNotFoundException {
		/** creating a scanner object to read the file SmallWordIndex */
		Scanner scanner = new Scanner(new File("/Users/andrewliao/code/programmingprojects/project4/SmallWordIndex"));
		String line = scanner.nextLine();
		/** need a WordData object to access a parseWordData */
		WordData y = WordData.parseWordData(line);
		assertTrue(y.getFlag() == false);
		assertTrue(y.getLineNumber() == 0);
		assertTrue(y.getWord().compareTo("bat") == 0.0);
		/** creat9jg a comparison linkedlist that should contain 11, 10, 7, 3 */
		LinkedList<Integer> z = new LinkedList<Integer>();
		z.add(11);
		z.add(10);
		z.add(7);
		z.add(3);
		assertTrue(y.getLlData().containsAll(z));
		
	}

}
