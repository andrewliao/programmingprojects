package project4;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * This class stores different types of data.
 * @author Andrew Liao
 *
 */

public class WordData {
	/** stores the integer of the data */
	private int intData;
	/** stores a String of the data */
	private String stringData;
	/** stores a boolean describing the data */
	private boolean boolData;
	/** stores a LinkedList containing Integers of the data */
	private LinkedList<Integer> llData;
	
	/**
	 * The getter method for the intData.
	 * @return This returns the intData field of the WordData class.
	 */
	public int getIntData() {
		return intData;
	}
	
	/**
	 * This is the setter method for intData.
	 * @param intData This is the data which we will set the field intData of WordData to be.
	 */
	public void setIntData(int intData) {
		this.intData = intData;
	}
	
	/**
	 * The getter method for stringData.
	 * @return This returns the stringData field of the WordData class.
	 */
	public String getStringData() {
		return stringData;
	}
	
	/**
	 * The setter method for stringData.
	 * @param stringData This is the data which we set the field of stringData of WordData to be.
	 */
	public void setStringData(String stringData) {
		this.stringData = stringData;
	}
	
	/**
	 * The getter method for boolData.
	 * @return This returns the boolData field of the WordData class.
	 */
	public boolean getBoolData() {
		return boolData;
	}

	/**
	 * The setter method for boolData.
	 * @param boolData This is the data which we set the field of boolData of WordData to be.
	 */
	public void setBoolData(boolean boolData) {
		this.boolData = boolData;
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
	 * This method 
	 * @param input
	 * @return
	 */
	public WordData parseWordData(String input) {
		WordData output = new WordData();
		Scanner scanner = new Scanner(input);
		output.setIntData(scanner.nextInt());
		output.setStringData(scanner.next());
		output.setBoolData(false);
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
