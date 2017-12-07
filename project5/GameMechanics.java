package project5;

/**
 * This class will store the methods that handle all the game mechanics of the SameGame.
 * @author Andrew Liao
 *
 */

public class GameMechanics {
	public static void shiftDown(int[][] colorIndex) {
		//check every column
		for(int i = 0; i < colorIndex[0].length; i++) {
			//check through every row
			for(int j = colorIndex.length - 1; j > -1; j--) {
				if(colorIndex[j][i] == 11) {
					int start = j - 1;
					boolean foundReplacement = false;
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
	
	public static void markLeftToEmpty(int left, int rowNumber, int columnNumber, int[][] colorIndex) {
		if(left > 1) {
			for(int i = 0; i < left; i++) {
				colorIndex[rowNumber][columnNumber - i] = 11;
			}
		}
	}
	
	public static void markRightToEmpty(int right, int rowNumber, int columnNumber, int[][] colorIndex) {
		if(right > 1) {
			for(int i = 0 ; i < right; i++) {
				colorIndex[rowNumber][columnNumber + i] = 11;
			}
		}
	}
	
	public static void markTopToEmpty(int top, int rowNumber, int columnNumber, int[][] colorIndex) {
		if(top > 1) {
			for(int i = 0; i < top; i++) {
				colorIndex[rowNumber - i][columnNumber] = 11;
			}
		}
	}
	
	public static void markBottomToEmpty(int bottom, int rowNumber, int columnNumber, int[][] colorIndex) {
		if (bottom > 1) {
			for(int i = 0; i < bottom; i++) {
				colorIndex[rowNumber + i][columnNumber] = 11;
			}
		}
	}
	
	
	public static void shiftLeftForEmptyColumns(int[][] colorIndex) {
		//this loop goes through all the columns of the colorIndex
		for(int i = 0; i < colorIndex[0].length; i++) {
			//checking if the bottom button is equal to gray
			if(colorIndex[colorIndex.length - 1][i] == 11) {
				boolean foundReplacementColumn = false;
				//start index at replacement + 1
				int start = i + 1;
				while(!foundReplacementColumn && start < colorIndex[0].length) {
					if(colorIndex[colorIndex.length - 1][start] != 11) {
						foundReplacementColumn = true;
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
	
	public static int checkLeft(int[][] colorIndex , int rowNumber, int columnNumber) {
		int colorValueOfButton = colorIndex[rowNumber][columnNumber];
		int numberInARow = 0;
		boolean contiguousIsSameColor = true;
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
	
	public static int checkRight(int[][] colorIndex, int rowNumber, int columnNumber) {
		int colorValueOfButton = colorIndex[rowNumber][columnNumber];
		int numberInARow = 0;
		boolean contiguousIsSameColor = true;
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
	
	public static int checkTop(int[][] colorIndex, int rowNumber, int columnNumber) {
		int colorValueOfButton = colorIndex[rowNumber][columnNumber];
		int numberInARow = 0;
		boolean contiguousIsSameColor = true;
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
	
	public static int checkBottom(int[][] colorIndex, int rowNumber, int columnNumber) {
		int colorValueOfButton = colorIndex[rowNumber][columnNumber];
		int numberInARow = 0;
		boolean contiguousIsSameColor = true;
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
