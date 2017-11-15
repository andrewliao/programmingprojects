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
	private boolean flag;
	/** stores a LinkedList containing Integers of the data */
	private LinkedList<Integer> llData;
	
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
	public boolean getFlag() {
		return flag;
	}

	/**
	 * The setter method for flag.
	 * @param flagThis is the data which we set the field of flag of WordData to be.
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	/**
	 * The getter method for llData.
	 * @return This returns the llData field of the WordData class.
	 */
	public LinkedList<Integer> getLlData() {
		return llData;
	}
	
	/**
	 * The setter method for llData.
	 * @param llData This is the data which we set the field of llData of WordData to be.
	 */
	public void setLlData(LinkedList<Integer> llData) {
		this.llData = llData;
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
		output.setFlag(false);
		/** This variable will store the numbers that follow the word */
		LinkedList<Integer> inputNum = new LinkedList<Integer>();
		/**
		 * adding the numbers that follow the word
		 */
		while(scanner.hasNext()) {
			inputNum.add(scanner.nextInt());
		}
		scanner.close();
		output.setLlData(inputNum);
		return output;
	}
	

	
	
	
}
