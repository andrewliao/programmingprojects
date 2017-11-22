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
		 * The goal is to find the number of lines of the reader/file. The precondition is that
		 * the buffered reader contains a reader that has multiple lines. 
		 * The subgoal checks if the buffered reader is a line or not. If it not null we increase the line count on our file.
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
	 * @param start, destination, words. Start stores the index of the WordData at the start of the search. 
	 * Destination is the index of the destination WordData. Words stores all the WordData of the file.
	 * @return  We will return a LinkedList<Integer> that stores that contains the integers of the WordData objects in the path.
	 */
	public static LinkedList<Integer> getPath(int start, int destination, WordData[] words) {

		if(start == destination) {
			/** creating an output linkedlist that stores the integer of start */
			LinkedList<Integer> output = new LinkedList<Integer>();
			output.add(start);
			return output;
		}
		
		try {
			/** this linkedlist stores the linkedlist field of the WordData at the index start of the words WordData array*/
			LinkedList<Integer> possibleNumbers = words[start].getLlData();
			
			/** This for loop goal is to iterate and add the numbers that contribute from the path of the word
			 * from the WordData at index of start to the WordData at index of destination. The precondition of 
			 * the loop is that there are possible integers of the start index that could contain a possible path.
			 * The subgoal goal is to see if the WordData at index of the integers possibility had been visited yet
			 * and if it wasn't we set the boolean of visited to be true, meanwhile if a path is found we return it right away.
			 *  */
			for(Integer possibility: possibleNumbers) {
				if (!words[possibility].getVisited()) {
					words[possibility].setVisited(true);
					/** This path variable stores the linkedlist of the integers containing the path after we do a recursively check for a solution. */
					LinkedList<Integer> path = WordPath.getPath(possibility, destination, words);
					if(path != null) {
						path.addFirst(start);
						return path;
					}
				}
			}
		} catch(NullPointerException exc) { //if words is null
			System.out.println("There is no possible path for this word!");
		}
		
		return null;
		
	}
	
	/**
	 * This method returns the 
	 * @param file This is the variable that stores the name of the file.
	 * @throws IOException Occurs when there is no such file.
	 */
	public void getWordPath(String file) throws IOException {
		/** This variable stores the boolean quit that when true quits this method. */
		boolean quit = false;
		while(!quit) {
			/** This words variable stores the WordData array of the entire file */
			WordData[] words = WordPath.makeWordArray(file);
			/** This stores the start word that the user must specify. */
			String word1 = JOptionPane.showInputDialog("Input word1:");
			/** This stores the destination word that the user must specify. */
			String word2 = JOptionPane.showInputDialog("Input word2:");
			
			/** This variable stores the boolean if we have found the WordData[] of the first word */
			boolean found1 = false;
			/
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
			
			/** */
			LinkedList<Integer> test = new LinkedList<Integer>();
			test = WordPath.getPath(lineOfWord1, lineOfWord2, words);
			for(Integer index: test) {
				System.out.println(words[index].getWord());
			}
			
			
			for(int i = 0; i < words.length; i++) {
				words[i].setVisited(false);
			}
			
			/** */
			String loop = JOptionPane.showInputDialog("Type quit if you want to stop, Otherwise anything else we will continue!");
			if(loop.compareTo("quit") == 0) {
				quit = true;
			}
		}
		
	}
		
	public static void main(String[] args) {
			try {
				/** */
				WordPath x = new WordPath();
				x.getWordPath(args[0]);
			} catch(IOException exc) {
				System.out.println("File not found!");
			}
	}
	
	
	

	
}
