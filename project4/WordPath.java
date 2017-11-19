package project4;

import java.io.*;
import java.util.LinkedList;

import javax.swing.JOptionPane;

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
	
	/**
	 * This method 
	 * @throws IOException 
	 */
	public void getWordPath(String file) throws IOException {
		boolean quit = false;
		while(!quit) {
			WordData[] words = WordPath.makeWordArray(file);
			String word1 = JOptionPane.showInputDialog("Input word1:");
			String word2 = JOptionPane.showInputDialog("Input word2:");
			
			boolean found1 = false;
			int lineOfWord1 = 0;
			for(int i = 0; i < words.length; i++) {
				if(word1.compareTo(words[i].getWord()) == 0) {
					found1 = true;
					lineOfWord1 = words[i].getLineNumber();
				}
			}
			
			boolean found2 = false;
			int lineOfWord2 = 0;
			for(int i = 0; i < words.length; i++) {
				if(word2.compareTo(words[i].getWord()) == 0) {
					found2 = true;
					lineOfWord2 = words[i].getLineNumber();
				}
			}
			
			System.out.println(lineOfWord1);
			System.out.println(lineOfWord2);
			
			LinkedList<Integer> test = new LinkedList<Integer>();
			test = WordPath.getPath(lineOfWord1, lineOfWord2, words);
			for(Integer index: test) {
				System.out.println(words[index].getWord());
			}
			
			
			for(int i = 0; i < words.length; i++) {
				words[i].setFlag(false);
			}
			
			String loop = JOptionPane.showInputDialog("Type quit if you want to stop, Otherwise anything else we will continue!");
			if(loop.compareTo("quit") == 0) {
				quit = true;
			}
		}
		
	}
		
	public static void main(String[] args) {
			try {
				WordPath x = new WordPath();
				x.getWordPath(args[0]);
			} catch(IOException exc) {
				System.out.println("File not found!");
			}
	}
	
	
	

	
}
