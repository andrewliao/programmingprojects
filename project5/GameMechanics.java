package project5;

/**
 * This class will store the methods that handle all the game mechanics of the SameGame.
 * @author Andrew Liao
 *
 */

public class GameMechanics {
  
	/**
     * This method returns a random color from a set of 10 possibilities.
     * @param numColors This specifies the number of Colors that the board needs.
     * @return This returns a random color.
     */
    public static int getColorIndex(int numColors) {
	    	return (int)(Math.random() * numColors);
    }
    
	/**
	 * In this method we will iterate through every column and shift down any colored button if there is a light gray colored button beneath it.
	 * @param colorIndex This is a int[][] that stores the value of index of the colors of the button.
	 */
	public static void shiftDown(int[][] colorIndex) {
		/**
		 * The loop will iterate through all the columns of the colorIndex. The goal is to go through
		 * all the rows in each column and make sure that we shift down a colored element if there is an
		 * empty button(colored light gray) underneath it, with the subgoal of iterating through all the rows. 
		 * The precondition of the loop is that colorIndex has at least one column.
		 */
		for(int i = 0; i < colorIndex[0].length; i++) {
			/**
			 * The loop will iterate from the bottom row and move to the top row on each column. The goal
			 * is to see if there is an empty button(which is colored light gray) and if it is we look to find
			 * another button that is not empty and shift it down. The subgoal is to find a replacement button.
			 * The precondition is that we are not on the top row.
			 */
			for(int j = colorIndex.length - 1; j > -1; j--) {
				if(colorIndex[j][i] == 11) {
					/** the starting index of the search for the button that we would shift down */
					int start = j - 1;
					/** the loop will stop if we found a replacement button */
					boolean foundReplacement = false;
					
					/** 
					 * This loop is to loop through from the empty button to the top of the colorIndex rows
					 * to see if there is a replacement button. The precondition is that we have not found a replacement
					 * and that start is not above the top row. The goal is to either find a replacement button or leave
					 * the button as is, because all the top buttons are also empty.
					 */
					while(!foundReplacement && start > -1) {
						if(colorIndex[start][i] != 11) {
							colorIndex[j][i] = colorIndex[start][i];
							colorIndex[start][i] = 11;
							foundReplacement = true;
						}
						start--;
					}	
				}
			}
		}
	}
	
	/**
	 * This method is marking every contiguous to the left of button with the same color as empty, which is indicated by the number of 11.
	 * @param left This is the number of contiguous elements on the left of the button that have the same color. We include the button in the number, so it starts at 1.
	 * @param rowNumber This indicates the row number of the button.
	 * @param columnNumber This indicates the column number of the button.
	 * @param colorIndex This stores the color index [][] which indicates the index for the color for all the buttons on the grid.
	 */
	public static void markLeftToEmpty(int left, int rowNumber, int columnNumber, int[][] colorIndex) {
		if(left > 1) {
			/** 
			 * This goal of the loop is to mark all the contiguous elements left of the button to be 11, which means that
			 * it is empty. The precondition of the loop is that left is at least 2(the if statement guarantees at least 2).
			 * The subgoal is to iterate one element one at a time away from the button.
			 */
			for(int i = 0; i < left; i++) {
				colorIndex[rowNumber][columnNumber - i] = 11;
			}
		}
	}
	
	/**
	 * This method is marking every contiguous to the right of button with the same color as empty, which is indicated by the number of 11.
	 * @param right This is the number of contiguous elements on the right of the button that have the same color. We include the button in the number, so it starts at 1.
	 * @param rowNumber This indicates the row number of the button.
	 * @param columnNumber This indicates the column number of the button.
	 * @param colorIndex This stores the color index [][] which indicates the index for the color for all the buttons on the grid.
	 */
	public static void markRightToEmpty(int right, int rowNumber, int columnNumber, int[][] colorIndex) {
		if(right > 1) {
			/** 
			 * This goal of the loop is to mark all the contiguous elements right of the button to be 11, which means that
			 * it is empty. The precondition of the loop is that right is at least 2(the if statement guarantees at least 2).
			 * The subgoal is to iterate one element one at a time away from the button.
			 */
			for(int i = 0 ; i < right; i++) {
				colorIndex[rowNumber][columnNumber + i] = 11;
			}
		}
	}
	
	/**
	 * This method is marking every contiguous to the top of button with the same color as empty, which is indicated by the number of 11.
	 * @param top This is the number of contiguous elements on the top of the button that have the same color. We include the button in the number, so it starts at 1.
	 * @param rowNumber This indicates the row number of the button.
	 * @param columnNumber This indicates the column number of the button.
	 * @param colorIndex This stores the color index [][] which indicates the index for the color for all the buttons on the grid.
	 */
	public static void markTopToEmpty(int top, int rowNumber, int columnNumber, int[][] colorIndex) {
		if(top > 1) {
			/** 
			 * This goal of the loop is to mark all the contiguous elements top of the button to be 11, which means that
			 * it is empty. The precondition of the loop is that top is at least 2(the if statement guarantees at least 2).
			 * The subgoal is to iterate one element one at a time away from the button.
			 */
			for(int i = 0; i < top; i++) {
				colorIndex[rowNumber - i][columnNumber] = 11;
			}
		}
	}
	
	/**
	 * This method is marking every contiguous to the bottom of button with the same color as empty, which is indicated by the number of 11.
	 * @param bottom This is the number of contiguous elements on the bottom of the button that have the same color. We include the button in the number, so it starts at 1.
	 * @param rowNumber This indicates the row number of the button.
	 * @param columnNumber This indicates the column number of the button.
	 * @param colorIndex This stores the color index [][] which indicates the index for the color for all the buttons on the grid.
	 */
	public static void markBottomToEmpty(int bottom, int rowNumber, int columnNumber, int[][] colorIndex) {
		if (bottom > 1) {
			/** 
			 * This goal of the loop is to mark all the contiguous elements bottom of the button to be 11, which means that
			 * it is empty. The precondition of the loop is that bottom is at least 2(the if statement guarantees at least 2).
			 * The subgoal is to iterate one element one at a time away from the button.
			 */
			for(int i = 0; i < bottom; i++) {
				colorIndex[rowNumber + i][columnNumber] = 11;
			}
		}
	}
	
	
	/**
	 * This method will shift left a non-empty column into an empty column if one can be found.
	 * @param colorIndex This is a double array that will store the integers of all the colors of the buttons in the grid.
	 */
	public static void shiftLeftForEmptyColumns(int[][] colorIndex) {
		/**
		 * This goal to see is to iterate through all the columns and see if it can find an empty column. The precondition
		 * of this loop is that colorIndex has at least one row and column. The subgoal is that if it can find an empty column
		 * it will iterate through until either the end of all the columns and do nothing or find another row which is not empty and 
		 * swap the contents, thus shifting the non-empty column left. 
		 */
		for(int i = 0; i < colorIndex[0].length; i++) {
			if(colorIndex[colorIndex.length - 1][i] == 11) {
				/** this stores a boolean to indicate if we can find a replacement column */
				boolean foundReplacementColumn = false;
				/** the start index of column is one after the index of the start, which is the empty column we are trying to replace */
				int start = i + 1;
				
				/**
				 * The goal of this loop is to see if it can find a replacement column to shift left into the empty column.
				 * The precondition for the loop is that start is not at the last column and the we have not found a 
				 * replacement column yet. The subgoal is to iterate through each column and check if the next column is empty or not.
				 */
				while(!foundReplacementColumn && start < colorIndex[0].length) {
					if(colorIndex[colorIndex.length - 1][start] != 11) {
						foundReplacementColumn = true;
						/**
						 * The goal is to change all the elements of the replacement column with the empty column. The precondition
						 * is that the replacement columns exists. The subgoal is replacing the empty column with the replacement
						 * column one at a time while making the replacement column empty.
						 */
						for(int k = 0; k < colorIndex.length; k++) {
							colorIndex[k][i] = colorIndex[k][start];
							colorIndex[k][start] = 11;
						}
					} 
					start++;
				}
			}
		}
	}
	
	/**
	 * This method will check how many contiguous buttons to the left are the same color as the button.
	 * @param colorIndex This is the int[][] that stores the index of the colors of all the buttons.
	 * @param rowNumber This stores the row number of the button.
	 * @param columnNumber This stores the column number of the button.
	 * @return This should return the number of contiguous elements with the same color as the button to the left, including the button itself.
	 */
	public static int checkLeft(int[][] colorIndex , int rowNumber, int columnNumber) {
		/** This stores the index of the color of the button. */
		int colorValueOfButton = colorIndex[rowNumber][columnNumber];
		/** This stores the number of buttons in a row to the left of the button with the same color. */
		int numberInARow = 0;
		/** This stores a boolean that states if the button next to it is the same color. */
		boolean contiguousIsSameColor = true;
		
		/**
		 * The precondition of the loop is that the column number of the button is not on the edge of the board
		 * and that the element next to it is the same color. The goal is to count the total number of contiguous elements
		 * that have the same color as the button. The subgoal is to check the column right next to it one at a time.
		 */
		while(contiguousIsSameColor && columnNumber != -1) {
			if(colorIndex[rowNumber][columnNumber] == colorValueOfButton) {
				numberInARow++;
				columnNumber--;
			} else {
				contiguousIsSameColor = false;
			}
		}
		return numberInARow;
	}
	
	/**
	 * This method will check how many contiguous buttons to the right are the same color as the button.
	 * @param colorIndex This is the int[][] that stores the index of the colors of all the buttons.
	 * @param rowNumber This stores the row number of the button.
	 * @param columnNumber This stores the column number of the button.
	 * @return This should return the number of contiguous elements with the same color as the button to the right, including the button itself.
	 */
	public static int checkRight(int[][] colorIndex, int rowNumber, int columnNumber) {
		/** This stores the index of the color of the button. */
		int colorValueOfButton = colorIndex[rowNumber][columnNumber];
		/** This stores the number of buttons in a row to the right of the button with the same color. */
		int numberInARow = 0;
		/** This stores a boolean that states if the button next to it is the same color. */
		boolean contiguousIsSameColor = true;
		
		/**
		 * The precondition of the loop is that the column number of the button is not on the edge of the board
		 * and that the element next to it is the same color. The goal is to count the total number of contiguous elements
		 * that have the same color as the button. The subgoal is to check the column right next to it one at a time.
		 */
		while(contiguousIsSameColor && columnNumber != colorIndex[0].length) {
			if(colorIndex[rowNumber][columnNumber] == colorValueOfButton) {
				numberInARow++;
				columnNumber++;
			} else {
				contiguousIsSameColor = false;
			}
		}
		return numberInARow;
	}
	
	/**
	 * This method will check how many contiguous buttons on top of it has the same color as the button.
	 * @param colorIndex This is the int[][] that stores the index of the colors of all the buttons.
	 * @param rowNumber This stores the row number of the button.
	 * @param columnNumber This stores the column number of the button.
	 * @return This should return the number of contiguous elements with the same color as the button on top of it, including the button itself.
	 */
	public static int checkTop(int[][] colorIndex, int rowNumber, int columnNumber) {
		/** This stores the index of the color of the button. */
		int colorValueOfButton = colorIndex[rowNumber][columnNumber];
		/** This stores the number of buttons in a row on the top of the button with the same color. */
		int numberInARow = 0;
		/** This stores a boolean that states if the button on top of it has the same color. */
		boolean contiguousIsSameColor = true;
		
		/**
		 * The precondition of the loop is that the row number of the button is not on the top of the board
		 * and that the element on top of it is the same color. The goal is to count the total number of contiguous elements
		 * that have the same color as the button. The subgoal is to check the row on top of it one at a time.
		 */
		while(contiguousIsSameColor && rowNumber != -1) {
			if(colorIndex[rowNumber][columnNumber] == colorValueOfButton) {
				numberInARow++;
				rowNumber--;
			} else {
				contiguousIsSameColor = false;
			}
		}
		return numberInARow;
	}
	
	/**
	 * This method will check how many contiguous buttons on the bottom of it has the same color as the button.
	 * @param colorIndex This is the int[][] that stores the index of the colors of all the buttons.
	 * @param rowNumber This stores the row number of the button.
	 * @param columnNumber This stores the column number of the button.
	 * @return This should return the number of contiguous elements with the same color as the button on the bottom of it, including the button itself.
	 */
	public static int checkBottom(int[][] colorIndex, int rowNumber, int columnNumber) {
		/** This stores the index of the color of the button. */
		int colorValueOfButton = colorIndex[rowNumber][columnNumber];
		/** This stores the number of buttons in a row on the bottom of the button with the same color. */
		int numberInARow = 0;
		/** This stores a boolean that states if the button on the bottom of it has the same color. */
		boolean contiguousIsSameColor = true;
		
		/**
		 * The precondition of the loop is that the row number of the button is not on the bottom of the board
		 * and that the element on the bottom of it is the same color. The goal is to count the total number of contiguous elements
		 * that have the same color as the button. The subgoal is to check the row on the bottom of it one at a time.
		 */
		while(contiguousIsSameColor && rowNumber != colorIndex.length) {
			if(colorIndex[rowNumber][columnNumber] == colorValueOfButton) {
				numberInARow++;
				rowNumber++;
			} else {
				contiguousIsSameColor = false;
			}
		}
		return numberInARow;
	}
	
}
