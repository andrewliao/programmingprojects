package project4;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * This class stores different types of data.
 * @author Andrew Liao
 *
 */

public class WordData {
	/** stores the integer of the line Number of the data */
	private int lineNumber;
	/** stores a String of the data */
	private String word;
	/** stores a boolean describing if the data is marked*/
	private boolean visited;
	/** stores a LinkedList containing the index of the words which are just one character different */
	private LinkedList<Integer> mutatedIndices;
	
	/**
	 * The getter method for the intData.
	 * @return This returns the intData field of the WordData class.
	 */
	public int getLineNumber() {
		return lineNumber;
	}
	
	/**
	 * This is the setter method for intData.
	 * @param intData This is the data which we will set the field intData of WordData to be.
	 */
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	/**
	 * The getter method for stringData.
	 * @return This returns the stringData field of the WordData class.
	 */
	public String getWord() {
		return word;
	}
	
	/**
	 * The setter method for word.
	 * @param word This is the data which we set the field of word of WordData to be.
	 */
	public void setWord(String word) {
		this.word = word;
	}
	
	/**
	 * The getter method for boolData.
	 * @return This returns the boolData field of the WordData class.
	 */
	public boolean getVisited() {
		return visited;
	}

	/**
	 * The setter method for visited.
	 * @param flagThis is the data which we set the field of visited of WordData to be.
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	/**
	 * The getter method for llData.
	 * @return This returns the llData field of the WordData class.
	 */
	public LinkedList<Integer> getMutatedIndices() {
		return mutatedIndices;
	}
	
	/**
	 * The setter method for llData.
	 * @param llData This is the data which we set the field of llData of WordData to be.
	 */
	public void setLlData(LinkedList<Integer> llData) {
		this.mutatedIndices = llData;
	}
	
	/**
	 * This method creates another WordData object based on the String input it receives from a file.
	 * @param input This input represents the String line it receives from a file.
	 * @return It returns a WordData with its fields set to the information provided by the String input.
	 */
	public static WordData parseWordData(String input) {
		/** the output WordData object */
		WordData output = new WordData();
		/** scanner object to read the String input line*/
		Scanner scanner = new Scanner(input);
		output.setLineNumber(scanner.nextInt());
		output.setWord(scanner.next());
		output.setVisited(false);
		/** This variable will store the numbers that follow the word */
		LinkedList<Integer> inputNum = new LinkedList<Integer>();
		/**
		 * The goal of the loop is to add the integers of the string, which refer to the numLine of other WordData, to the linkedlist.
		 * The subgoal is adding an integer to the linkedlist. 
		 * The precondition of the loop is that the scanner has a string with numbers following the word in the string.
		 */
		while(scanner.hasNext()) {
			inputNum.add(scanner.nextInt());
		}
		scanner.close();
		output.setLlData(inputNum);
		return output;
	}
	

	
	
	
}
