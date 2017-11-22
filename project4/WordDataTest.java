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
		/** line variable whose data will be stored in WordData y later */
		String line = "21 cat 5 20 36 38";
		/** need a WordData object to store the object returned by aparseWordData */
		WordData y = WordData.parseWordData(line);
		assertTrue(y.getVisited() == false);
		assertTrue(y.getLineNumber() == 21);
		assertTrue(y.getWord().compareTo("cat") == 0.0);
		/** create a comparison linkedlist called z that should contain the integers 11, 10, 7, 3 */
		LinkedList<Integer> z = new LinkedList<Integer>();
		z.add(5);
		z.add(20);
		z.add(36);
		z.add(38);
		assertTrue(y.getLlData().containsAll(z));
		
		/** testing 0: for the while loop in parseWordData. This mean there are no indices(or numbers)W after the word cat. */
		WordData zero = WordData.parseWordData("0 cat");
		assertTrue(zero.getVisited() == false);
		assertTrue(zero.getLineNumber() == 0);
		assertTrue(zero.getWord().compareTo("cat") == 0);
		assertTrue(zero.getLlData().containsAll(new LinkedList<Integer>()));
		
		/** testing 1: for the while loop in parseWordData. This means there is only one indices, 31, after the word cat. */
		/** one variable to store the WordData with the fields set to the contents of the string*/
		WordData one = WordData.parseWordData("0 cat 31");
		assertTrue(one.getVisited() == false);
		assertTrue(one.getLineNumber() == 0);
		assertTrue(one.getWord().compareTo("cat") == 0);
		/** creating a linked list to store the indices after the word cat, which is only 31*/
		LinkedList<Integer> num1 = new LinkedList<Integer>();
		num1.add(31);
		assertTrue(one.getLlData().containsAll(num1));
		
		/** testing many: for the while loop in parseWordData. This means there are two indices, 31, 47, after the word cat. */
		WordData two = WordData.parseWordData("0 cat 31 47");
		assertTrue(two.getVisited() == false);
		assertTrue(two.getLineNumber() == 0);
		assertTrue(two.getWord().compareTo("cat") == 0);
		/** creating a linked list to store the indices after the word cat, which is 31 and 47*/
		LinkedList<Integer> num2 = new LinkedList<Integer>();
		num2.add(31);
		num2.add(47);
		assertTrue(two.getLlData().containsAll(num2));
		
	}

}
