package project4;

import java.io.*;
import java.util.LinkedList;

/**
 * 
 * @author Andrew Liao
 *
 */

public class WordPath {
	
	/**
	 * This is a static method which reads the number of lines from a file.
	 * @param reader This input is the file reader that we need to input so we can read the file.
	 * @return This returns the number of lines in that file.
	 */
	public static int numLines(Reader reader) throws IOException {
		/** create a buffered reader to read the lines from your input reader */
		BufferedReader br = new BufferedReader(reader);
		/** variable to store the number of lines */
		int lines = 0;
		/**
		 * This checks if the buffered reader is a line or not. If it not null we increase the line count on our file.
		 */
		while(br.readLine() != null) {
			lines++;
		}
		br.close();
		return lines;
	}
	
	/**
	 * This class returns the WordData from each line of a file.
	 * @param fileName This is the input file name that we are going to read.
	 * @return We will return a WordData[] array that contains a WordData describing each line in the file.
	 * @throws IOException We will throw and IOExcpetion if the file does not exist.
	 */
	public static WordData[] makeWordArray(String fileName) throws IOException {
		/** fileReader object to read our file */
		FileReader x = new FileReader(fileName);
		/** variable to store the number of lines in the file. */
		int numOfLines = WordPath.numLines(x);
		/** creating the size of the WordData array. */
		WordData[] y = new WordData[numOfLines];
		x.close();
		
		/** bufferedReader object to read and create each individual WordData object for the output array. */
		BufferedReader z = new BufferedReader(new FileReader(fileName));
		/** variable to hold each current line */
		String line;
		/** variable to iterate through the array*/
		int i = 0;
		while((line = z.readLine()) != null) {
			y[i++] = WordData.parseWordData(line);
		}
		return y;
	}
		
	/**
	 * This method should return a LinkedList that contains the path from the start to the destination of the mutated word.
	 * 
	 */
	public static LinkedList<Integer> getPath(int start, int destination, WordData[] words) {

		if(start == destination) {
			LinkedList<Integer> output = new LinkedList<Integer>();
			output.add(start);
			return output;
		}
		
		LinkedList<Integer> possibleNumbers = words[start].getLlData();
		for(Integer possibility: possibleNumbers) {
			if (!words[possibility].getFlag()) {
				words[possibility].setFlag(true);
				LinkedList<Integer> path = WordPath.getPath(possibility, destination, words);
				if(path != null) {
					path.addFirst(start);
					return path;
				}
			}
		}
		return null;
		
	}
	
	
	
	

	
}
