package project4;

import static org.junit.Assert.*;
import java.io.*;
import java.util.*;

import org.junit.Test;

public class WordPathTest {

	@Test
	public void test() throws IOException {
		WordPath x = new WordPath();
		WordData[] y = x.makeWordArray("/Users/andrewliao/code/programmingprojects/project4/SmallWordIndex");
		for(WordData object: y) {
			System.out.println(object.getBoolData());
			System.out.println(object.getIntData());
			System.out.println(object.getStringData());
			System.out.println(object.getLlData());
		}
	}

}
