package project4;
/**
 * This class tests the parseWordData method of WordData.
 * @author Andrew Liao
 */

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

public class WordDataTest {

	@Test
	public void testParseWordData() throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("/Users/andrewliao/code/programmingprojects/project4/SmallWordIndex"));
		String line = scanner.nextLine();
		System.out.println(line);
		WordData x = new WordData();
		WordData y = x.parseWordData(line);
		System.out.println(y.getBoolData());
		System.out.println(y.getIntData());
		System.out.println(y.getStringData());
		System.out.println(y.getLlData());
		
	}

}
