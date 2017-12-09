package project5;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

/**
 * This class will have all the JUnit test for the game mechanic helper methods for the SameGame board.
 * @author Andrew Liao
 *
 */
public class SameGameTest {

	
	@Test
	public void testGetColorIndex() {
		/** this stores the number we obtained after we input that we should have 10 possibilities */
		int number = GameMechanics.getColorIndex(10);
		/** this checks to make sure our number must be between 0 and 9 which is 10 possibilities */
		assertTrue(number < 10 && number >= 0);
	}
	
	@Test
	public void testShiftDownTestZeroRows() {
		/** creating an int[][] with zero rows */
		int[][] index = new int[0][5];
		
		/** we should try to shift down, but this will throw an error as we can iterate through zero rows */
		try {
			GameMechanics.shiftDown(index);
		} catch(Exception e) {
			/** this checks to make sure we throw an ArrayIndexOutOfBoundsExcpetion */
			assertTrue(e instanceof java.lang.ArrayIndexOutOfBoundsException);
		}
	}
	
	@Test
	public void testShiftDownTestZeroColumns() {
		/** creating an int[][] with zero columns */
		int[][] index = new int[5][0];
		
		/** we should try to shift down, but this will throw an error as we can iterate through zero rows */
		try {
			GameMechanics.shiftDown(index);
		} catch(Exception e) {
			/** this checks to make sure we throw an ArrayIndexOutOfBoundsExcpetion */
			assertTrue(e instanceof java.lang.ArrayIndexOutOfBoundsException);
		}
	}
	
	@Test
	public void testShiftDownTestOneForOneRow() {
		/** creating an int[][] with one row */
		int[][] index = new int[1][2];
		index[0][0] = 5;
		index[0][1] = 11;
		
		GameMechanics.shiftDown(index);
		/** this checks to make sure that we don't have to change anything as the number is already at the top */
		assertTrue(index[0][1] == 11);
	}
	
	@Test
	public void testShiftDownTestOneForOneColumn() {
		/** creating an int[][] with one column */
		int[][] index = new int[2][1];
		index[0][0] = 5;
		index[1][0] = 11;
		
		GameMechanics.shiftDown(index);
		/** this checks to make sure that we moved the empty 11 index up */
		assertTrue(index[0][0] == 11);
		/** this checks to make sure that we moved the colored index(anything except 11) and switched it with the 11*/
		assertTrue(index[1][0] == 5);
	}
	
	@Test
	public void testShiftDownTestMany() {
		/** creating an int[][] with 3 by 3 dimensions */
		int[][] index = new int[3][3];
		index[0][0] = 5;
		index[0][1] = 11;
		index[0][2] = 9;
		index[1][0] = 11;
		index[1][1] = 4;
		index[1][2] = 5;
		index[2][0] = 7;
		index[2][1] = 8;
		index[2][2] = 5;
		
		GameMechanics.shiftDown(index);
		/** this checks to make sure that we moved the empty number 11 up */
		assertTrue(index[0][0] == 11);
		/** this checks to make sure that the empty 11 stayed at top */
		assertTrue(index[0][1] == 11);
		/** this checks to make sure that we don't change anything as nothing is empty underneath */
		assertTrue(index[0][2] == 9);
		/** this checks to make sure that the colored 5 is switched with its original empty button */
		assertTrue(index[1][0] == 5);
		/** this checks to make sure that we don't change anything as nothing is empty underneath */
		assertTrue(index[1][1] == 4);
		/** this checks to make sure that we don't change anything as nothing is empty underneath */
		assertTrue(index[1][2] == 5);
		/** this checks to make sure that we don't change anything as nothing is empty underneath */
		assertTrue(index[2][0] == 7);
		/** this checks to make sure that we don't change anything as nothing is empty underneath */
		assertTrue(index[2][1] == 8);
		/** this checks to make sure that we don't change anything as nothing is empty underneath */
		assertTrue(index[2][2] == 5);
	}
	
	@Test
	public void testShiftDownFirstRow() {
		/** creating a two by two int[][] */
		int[][] index = new int[2][2];
		index[0][0] = 11;
		index[0][1] = 5;
		index[1][0] = 5;
		index[1][1] = 5;
		
		GameMechanics.shiftDown(index);
		
		/** this tests to make sure we do not change if the empty button index is in the first row */
		assertTrue(index[0][0] == 11);
		/** this test to make sure nothing changes at all */
		assertTrue(index[0][1] == 5);
		/** this test to make sure nothing changes at all */
		assertTrue(index[1][0] == 5);
		/** this test to make sure nothing changes at all */
		assertTrue(index[1][1] == 5);
		
	}
	
	@Test
	public void testShiftDownFirstColumn() {
		/** creating a two by two int[][] */
		int[][] index = new int[2][2];
		index[0][0] = 5;
		index[0][1] = 5;
		index[1][0] = 11;
		index[1][1] = 5;
		
		GameMechanics.shiftDown(index);
		
		/** this tests to make sure that the empty button index of 11 is on the top at the first column */
		assertTrue(index[0][0] == 11);
		/** this test to make sure nothing changes at all */
		assertTrue(index[0][1] == 5);
		/** this test that we shifted down the non empty index (non-11 number) */
		assertTrue(index[1][0] == 5);
		/** this test to make sure nothing changes at all */
		assertTrue(index[1][1] == 5);
	}
	
	@Test
	public void testShiftDownMiddle() {
		/** creating an int[][] with 3 by 3 dimensions */
		int[][] index = new int[3][3];
		index[0][0] = 5;
		index[0][1] = 11;
		index[0][2] = 9;
		index[1][0] = 11;
		index[1][1] = 4;
		index[1][2] = 5;
		index[2][0] = 7;
		index[2][1] = 8;
		index[2][2] = 5;
		
		GameMechanics.shiftDown(index);
		/** this checks to make sure that we moved the empty number 11 up */
		assertTrue(index[0][0] == 11);
		/** this checks to make sure that the empty 11 stayed at top */
		assertTrue(index[0][1] == 11);
		/** this checks to make sure that we don't change anything as nothing is empty underneath */
		assertTrue(index[0][2] == 9);
		/** this checks to make sure that the colored 5 is switched with its original empty button */
		assertTrue(index[1][0] == 5);
		/** this checks to make sure that we don't change anything as nothing is empty underneath */
		assertTrue(index[1][1] == 4);
		/** this checks to make sure that we don't change anything as nothing is empty underneath */
		assertTrue(index[1][2] == 5);
		/** this checks to make sure that we don't change anything as nothing is empty underneath */
		assertTrue(index[2][0] == 7);
		/** this checks to make sure that we don't change anything as nothing is empty underneath */
		assertTrue(index[2][1] == 8);
		/** this checks to make sure that we don't change anything as nothing is empty underneath */
		assertTrue(index[2][2] == 5);
	}
	
	@Test
	public void testShiftDownLastRow() {
		/** creating a two by two int[][] */
		int[][] index = new int[2][2];
		index[0][0] = 5;
		index[0][1] = 5;
		index[1][0] = 11;
		index[1][1] = 11;
		
		GameMechanics.shiftDown(index);
		
		/** this test makes sure that since the empty button is on the last row, we must shift it to the top row */
		assertTrue(index[0][0] == 11);
		/** this test makes sure that since the empty button is on the last row, we must shift it to the top row */
		assertTrue(index[0][1] == 11);
		/** this test makes sure that since the empty button is on the last row, the bottom contains the non-empty color index */
		assertTrue(index[1][0] == 5);
		/** this test makes sure that since the empty button is on the last row, the bottom contains the non-empty color index */
		assertTrue(index[1][1] == 5);
	}
	
	@Test
	public void testShiftDownLastColumn() {
		/** creating a two by two int[][] */
		int[][] index = new int[2][2];
		index[0][0] = 5;
		index[0][1] = 5;
		index[1][0] = 5;
		index[1][1] = 11;
		
		GameMechanics.shiftDown(index);
		
		/** this test to make sure nothing changes at all */
		assertTrue(index[0][0] == 5);
		/** this test that we shifted down the non empty index (non-11 number) */
		assertTrue(index[0][1] == 11);
		/** this test to make sure nothing changes at all */
		assertTrue(index[1][0] == 5);
		/** this tests to make sure that the empty button index of 11 is on the top at the first column */
		assertTrue(index[1][1] == 5);
	}
	
	@Test
	public void testMarkLeftToEmptyTestZero() {
		/** creating a two by two int[][]*/
		int[][] index = new int[2][2];
		index[0][0] = 4;
		index[0][1] = 1;
		index[1][0] = 7;
		index[1][1] = 8;
		
		GameMechanics.markLeftToEmpty(0, 0, 1, index);
		/** this should check that the element is the same as we said there is no element the same as the button, indicated by 0 for left input */
		assertTrue(index[0][0] == 4);
		/** this should check that the element is the same as we said there is no element the same as the button, indicated by 0 for left input */
		assertTrue(index[0][1] == 1);
		/** this should check that the element is the same as we said there is no element the same as the button, indicated by 0 for left input */
		assertTrue(index[1][0] == 7);
		/** this should check that the element is the same as we said there is no element the same as the button, indicated by 0 for left input */
		assertTrue(index[1][1] == 8);
	}
	
	@Test
	public void testMarkLeftToEmptyTestOne() {
		/** creating a two by two int[][]*/
		int[][] index = new int[2][2];
		index[0][0] = 4;
		index[0][1] = 1;
		index[1][0] = 7;
		index[1][1] = 8;
		
		GameMechanics.markLeftToEmpty(1, 0, 1, index);
		/** this should check that the element is the same as we said there is no element the same as the button, indicated by 1 for left input */
		assertTrue(index[0][0] == 4);
		/** this should check that the element is the same as we said there is no element the same as the button, indicated by 1 for left input */
		assertTrue(index[0][1] == 1);
		/** this should check that the element is the same as we said there is no element the same as the button, indicated by 1 for left input */
		assertTrue(index[1][0] == 7);
		/** this should check that the element is the same as we said there is no element the same as the button, indicated by 1 for left input */
		assertTrue(index[1][1] == 8);
	}
	
	@Test
	public void testMarkLeftToEmptyTestMany() {
		/** creating a two by two int[][]*/
		int[][] index = new int[2][2];
		index[0][0] = 4;
		index[0][1] = 8;
		index[1][0] = 8;
		index[1][1] = 8;
		
		GameMechanics.markLeftToEmpty(2, 1, 1, index);
		/** this should remain the same as this row is not the row of the button */
		assertTrue(index[0][0] == 4);
		/** this should remain the same as this row is not the row of the button */
		assertTrue(index[0][1] == 8);
		/** this should become empty as this is the left element that becomes empty as it is contiguous to the button */
		assertTrue(index[1][0] == 11);
		/** the button element should also turn empty */
		assertTrue(index[1][1] == 11);
	}
	
	@Test
	public void testMarkLeftToEmptyTestFirst() {
		/** creating a two by two int[][]*/
		int[][] index = new int[2][2];
		index[0][0] = 8;
		index[0][1] = 5;
		index[1][0] = 11;
		index[1][1] = 6;
		
		GameMechanics.markLeftToEmpty(0, 0, 0, index);
		/** this should test that nothing changes because no elements to the left of the button */
		assertTrue(index[0][0] == 8);
		/** this should remain the same as this row is not the row of the button */
		assertTrue(index[0][1] == 5);
		/** this should become empty as this is the left element that becomes empty as it is contiguous to the button */
		assertTrue(index[1][0] == 11);
		/** the button element should also turn empty */
		assertTrue(index[1][1] == 6);
	}
	
	@Test
	public void testMarkLeftToEmptyTestMiddle() {
		/** creating a two by two int[][]*/
		int[][] index = new int[2][2];
		index[0][0] = 4;
		index[0][1] = 8;
		index[1][0] = 8;
		index[1][1] = 8;
		
		GameMechanics.markLeftToEmpty(2, 1, 1, index);
		/** this should remain the same as this row is not the row of the button */
		assertTrue(index[0][0] == 4);
		/** this should remain the same as this row is not the row of the button */
		assertTrue(index[0][1] == 8);
		/** this should become empty as this is the left element that becomes empty as it is contiguous to the button */
		assertTrue(index[1][0] == 11);
		/** the button element should also turn empty */
		assertTrue(index[1][1] == 11);
	}
	
	@Test
	public void testMarkLeftToEmptyTestLast() {
		/** creating a two by two int[][]*/
		int[][] index = new int[2][2];
		index[0][0] = 4;
		index[0][1] = 8;
		index[1][0] = 8;
		index[1][1] = 8;
		
		GameMechanics.markLeftToEmpty(2, 1, 1, index);
		/** this should remain the same as this row is not the row of the button */
		assertTrue(index[0][0] == 4);
		/** this should remain the same as this row is not the row of the button */
		assertTrue(index[0][1] == 8);
		/** this should become empty as this is the left element that becomes empty as it is contiguous to the button */
		assertTrue(index[1][0] == 11);
		/** the button element should also turn empty */
		assertTrue(index[1][1] == 11);
	}
	
	@Test
	public void testMarkRightToEmptyTestZero() {
		/** creating a two by two int[][]*/
		int[][] index = new int[2][2];
		index[0][0] = 4;
		index[0][1] = 1;
		index[1][0] = 7;
		index[1][1] = 8;
		
		GameMechanics.markRightToEmpty(0, 0, 1, index);
		/** this should check that the element is the same as we said there is no element the same as the button, indicated by 0 for right input */
		assertTrue(index[0][0] == 4);
		/** this should check that the element is the same as we said there is no element the same as the button, indicated by 0 for right input */
		assertTrue(index[0][1] == 1);
		/** this should check that the element is the same as we said there is no element the same as the button, indicated by 0 for right input */
		assertTrue(index[1][0] == 7);
		/** this should check that the element is the same as we said there is no element the same as the button, indicated by 0 for right input */
		assertTrue(index[1][1] == 8);
	}
	
	@Test
	public void testMarkRightToEmptyTestOne() {
		/** creating a two by two int[][]*/
		int[][] index = new int[2][2];
		index[0][0] = 4;
		index[0][1] = 1;
		index[1][0] = 7;
		index[1][1] = 8;
		
		GameMechanics.markRightToEmpty(1, 0, 1, index);
		/** this should check that the element is the same as we said there is no element the same as the button, indicated by 1 for right input */
		assertTrue(index[0][0] == 4);
		/** this should check that the element is the same as we said there is no element the same as the button, indicated by 1 for right input */
		assertTrue(index[0][1] == 1);
		/** this should check that the element is the same as we said there is no element the same as the button, indicated by 1 for right input */
		assertTrue(index[1][0] == 7);
		/** this should check that the element is the same as we said there is no element the same as the button, indicated by 1 for right input */
		assertTrue(index[1][1] == 8);
	}
	
	@Test
	public void testMarkRightToEmptyTestMany() {
		/** creating a two by two int[][]*/
		int[][] index = new int[2][2];
		index[0][0] = 4;
		index[0][1] = 8;
		index[1][0] = 8;
		index[1][1] = 8;
		
		GameMechanics.markRightToEmpty(2, 1, 0, index);
		/** this should remain the same as this row is not the row of the button */
		assertTrue(index[0][0] == 4);
		/** this should remain the same as this row is not the row of the button */
		assertTrue(index[0][1] == 8);
		/** this should become empty as this is the right element that becomes empty as it is contiguous to the button */
		assertTrue(index[1][0] == 11);
		/** the button element should also turn empty */
		assertTrue(index[1][1] == 11);
	}
	
	@Test
	public void testMarkRightToEmptyTestFirst() {
		/** creating a two by two int[][]*/
		int[][] index = new int[2][2];
		index[0][0] = 8;
		index[0][1] = 8;
		index[1][0] = 11;
		index[1][1] = 6;
		
		GameMechanics.markRightToEmpty(2, 0, 0, index);
		/** this should change the button and the button to the right to be 11  */
		assertTrue(index[0][0] == 11);
		/** this should change the button and the button to the right to be 11  */
		assertTrue(index[0][1] == 11);
		/** this should remain the same as this button is not affected */
		assertTrue(index[1][0] == 11);
		/** this should remain the same as this button is not affected */
		assertTrue(index[1][1] == 6);
	}
	
	@Test
	public void testMarkRightToEmptyTestMiddle() {
		/** creating a two by two int[][]*/
		int[][] index = new int[2][2];
		index[0][0] = 4;
		index[0][1] = 8;
		index[1][0] = 8;
		index[1][1] = 8;
		
		GameMechanics.markRightToEmpty(2, 1, 0, index);
		/** this should remain the same as this row is not the row of the button */
		assertTrue(index[0][0] == 4);
		/** this should remain the same as this row is not the row of the button */
		assertTrue(index[0][1] == 8);
		/** the button element should also turn empty */
		assertTrue(index[1][0] == 11);
		/** this should become empty as this is the right element that becomes empty as it is contiguous to the button */
		assertTrue(index[1][1] == 11);
	}
	
	@Test
	public void testMarkRightToEmptyTestLast() {
		/** creating a two by two int[][]*/
		int[][] index = new int[2][2];
		index[0][0] = 4;
		index[0][1] = 8;
		index[1][0] = 8;
		index[1][1] = 8;
		
		GameMechanics.markRightToEmpty(0, 1, 1, index);
		/** this should remain the same as this row is not the row of the button */
		assertTrue(index[0][0] == 4);
		/** this should remain the same as this row is not the row of the button */
		assertTrue(index[0][1] == 8);
		/** this should remain the same as this it is the element to the left of the button */
		assertTrue(index[1][0] == 8);
		/** this should remain the same as nothing can go off the board */
		assertTrue(index[1][1] == 8);
	}
	
	@Test
	public void testMarkTopToEmptyTestZero() {
		/** creating a two by two int[][]*/
		int[][] index = new int[2][2];
		index[0][0] = 4;
		index[0][1] = 1;
		index[1][0] = 7;
		index[1][1] = 8;
		
		GameMechanics.markTopToEmpty(0, 0, 1, index);
		/** this should check that the element is the same as we said there is no element the same as the button, indicated by 0 for top input */
		assertTrue(index[0][0] == 4);
		/** this should check that the element is the same as we said there is no element the same as the button, indicated by 0 for top input */
		assertTrue(index[0][1] == 1);
		/** this should check that the element is the same as we said there is no element the same as the button, indicated by 0 for top input */
		assertTrue(index[1][0] == 7);
		/** this should check that the element is the same as we said there is no element the same as the button, indicated by 0 for top input */
		assertTrue(index[1][1] == 8);
	}
	
	@Test
	public void testMarkTopToEmptyTestOne() {
		/** creating a two by two int[][]*/
		int[][] index = new int[2][2];
		index[0][0] = 4;
		index[0][1] = 1;
		index[1][0] = 7;
		index[1][1] = 8;
		
		GameMechanics.markTopToEmpty(0, 0, 1, index);
		/** this should check that the element is the same as we said there is no element the same as the button, indicated by 0 for top input */
		assertTrue(index[0][0] == 4);
		/** this should check that the element is the same as we said there is no element the same as the button, indicated by 0 for top input */
		assertTrue(index[0][1] == 1);
		/** this should check that the element is the same as we said there is no element the same as the button, indicated by 0 for top input */
		assertTrue(index[1][0] == 7);
		/** this should check that the element is the same as we said there is no element the same as the button, indicated by 0 for top input */
		assertTrue(index[1][1] == 8);
	}
	
	@Test
	public void testMarkTopToEmptyTestMany() {
		/** creating a two by two int[][]*/
		int[][] index = new int[2][2];
		index[0][0] = 4;
		index[0][1] = 8;
		index[1][0] = 8;
		index[1][1] = 8;
		
		GameMechanics.markTopToEmpty(2, 1, 1, index);
		/** this should remain the same as this row is not the column of the button */
		assertTrue(index[0][0] == 4);
		/** this should as this column is the same as the one as the button and is the one that is contiguous with the same index */
		assertTrue(index[0][1] == 11);
		/** this should remain the same as this row is not the column of the button */
		assertTrue(index[1][0] == 8);
		/** this should as this column is the same as the one as the button */
		assertTrue(index[1][1] == 11);
	}
	
	@Test
	public void testMarkTopToEmptyTestFirst() {
		/** creating a two by two int[][]*/
		int[][] index = new int[2][2];
		index[0][0] = 8;
		index[0][1] = 8;
		index[1][0] = 11;
		index[1][1] = 6;
		
		GameMechanics.markTopToEmpty(0, 0, 0, index);
		/** this should check that nothing changed as the button is on the top  */
		assertTrue(index[0][0] == 8);
		/** this should check that nothing changed as the button is on the top  */
		assertTrue(index[0][1] == 8);
		/** this should check that nothing changed as the button is on the top  */
		assertTrue(index[1][0] == 11);
		/** this should check that nothing changed as the button is on the top  */
		assertTrue(index[1][1] == 6);
	}
	
	@Test
	public void testMarkTopToEmptyTestMiddle() {
		/** creating a two by two int[][]*/
		int[][] index = new int[2][2];
		index[0][0] = 4;
		index[0][1] = 8;
		index[1][0] = 8;
		index[1][1] = 8;
		
		GameMechanics.markTopToEmpty(2, 1, 1, index);
		/** this should remain the same as this row is not the column of the button */
		assertTrue(index[0][0] == 4);
		/** this should change  as this column is the same as the one as the button and is the one that is contiguous with the same index */
		assertTrue(index[0][1] == 11);
		/** this should remain the same as this row is not the column of the button */
		assertTrue(index[1][0] == 8);
		/** this should change as this column is the same as the one as the button */
		assertTrue(index[1][1] == 11);
	}
	
	@Test
	public void testMarkTopToEmptyTestLast() {
		/** creating a two by two int[][]*/
		int[][] index = new int[2][2];
		index[0][0] = 4;
		index[0][1] = 8;
		index[1][0] = 8;
		index[1][1] = 8;
		
		GameMechanics.markTopToEmpty(2, 1, 1, index);
		/** this should remain the same as this row is not the row of the button */
		assertTrue(index[0][0] == 4);
		/** this should remain the same as this row is not the row of the button */
		assertTrue(index[0][1] == 11);
		/** this should remain the same as this it is the element to the left of the button */
		assertTrue(index[1][0] == 8);
		/** this should remain the same as nothing can go off the board */
		assertTrue(index[1][1] == 11);
	}
	
	@Test
	public void testMarkBottomToEmptyTestZero() {
		/** creating a two by two int[][]*/
		int[][] index = new int[2][2];
		index[0][0] = 4;
		index[0][1] = 1;
		index[1][0] = 7;
		index[1][1] = 8;
		
		GameMechanics.markBottomToEmpty(0, 0, 1, index);
		/** this should check that the element is the same as we said there is no element the same as the button, indicated by 0 for bottom input */
		assertTrue(index[0][0] == 4);
		/** this should check that the element is the same as we said there is no element the same as the button, indicated by 0 for bottom input */
		assertTrue(index[0][1] == 1);
		/** this should check that the element is the same as we said there is no element the same as the button, indicated by 0 for bottom input */
		assertTrue(index[1][0] == 7);
		/** this should check that the element is the same as we said there is no element the same as the button, indicated by 0 for bottom input */
		assertTrue(index[1][1] == 8);
	}
	
	@Test
	public void testMarkBottomToEmptyTestOne() {
		/** creating a two by two int[][]*/
		int[][] index = new int[2][2];
		index[0][0] = 4;
		index[0][1] = 1;
		index[1][0] = 7;
		index[1][1] = 8;
		
		GameMechanics.markBottomToEmpty(0, 0, 1, index);
		/** this should check that the element is the same as we said there is no element the same as the button, indicated by 0 for bottom input */
		assertTrue(index[0][0] == 4);
		/** this should check that the element is the same as we said there is no element the same as the button, indicated by 0 for bottom input */
		assertTrue(index[0][1] == 1);
		/** this should check that the element is the same as we said there is no element the same as the button, indicated by 0 for bottom input */
		assertTrue(index[1][0] == 7);
		/** this should check that the element is the same as we said there is no element the same as the button, indicated by 0 for bottom input */
		assertTrue(index[1][1] == 8);
	}
	
	@Test
	public void testMarkBottomToEmptyTestMany() {
		/** creating a two by two int[][]*/
		int[][] index = new int[2][2];
		index[0][0] = 4;
		index[0][1] = 8;
		index[1][0] = 8;
		index[1][1] = 8;
		
		GameMechanics.markBottomToEmpty(2, 0, 1, index);
		/** this should remain the same as this row is not the column of the button */
		assertTrue(index[0][0] == 4);
		/** this should change as this column is the same as the one as the button and is the one that is contiguous with the same index */
		assertTrue(index[0][1] == 11);
		/** this should remain the same as this row is not the column of the button */
		assertTrue(index[1][0] == 8);
		/** this should change  as this column is the same as the one as the button */
		assertTrue(index[1][1] == 11);
	}
	
	@Test
	public void testMarkBottomToEmptyTestFirst() {
		/** creating a two by two int[][]*/
		int[][] index = new int[2][2];
		index[0][0] = 8;
		index[0][1] = 9;
		index[1][0] = 8;
		index[1][1] = 6;
		
		GameMechanics.markBottomToEmpty(2, 0, 0, index);
		/** this should change because the top element is the button with a contiguous element   */
		assertTrue(index[0][0] == 11);
		/** this should check that nothing changed as it is not contiguous with the button */
		assertTrue(index[0][1] == 9);
		/** this should change as it represents the button that is contiguous with the button */
		assertTrue(index[1][0] == 11);
		/** this should check that nothing changed as it is not contiguous with the button */
		assertTrue(index[1][1] == 6);
	}
	
	@Test
	public void testMarkBottomToEmptyTestMiddle() {
		/** creating a two by two int[][]*/
		int[][] index = new int[2][2];
		index[0][0] = 4;
		index[0][1] = 8;
		index[1][0] = 8;
		index[1][1] = 8;
		
		GameMechanics.markBottomToEmpty(2, 0, 1, index);
		/** this should remain the same as this row is not the column of the button */
		assertTrue(index[0][0] == 4);
		/** this should change as this column is the same as the one as the button and is the one that is contiguous with the same index */
		assertTrue(index[0][1] == 11);
		/** this should remain the same as this row is not the column of the button */
		assertTrue(index[1][0] == 8);
		/** this should change  as this column is the same as the one as the button */
		assertTrue(index[1][1] == 11);
	}
	
	@Test
	public void testMarkBottomToEmptyTestLast() {
		/** creating a two by two int[][]*/
		int[][] index = new int[2][2];
		index[0][0] = 4;
		index[0][1] = 8;
		index[1][0] = 8;
		index[1][1] = 8;
		
		GameMechanics.markBottomToEmpty(0, 1, 1, index);
		/** this should remain the same as there is no button underneath it */
		assertTrue(index[0][0] == 4);
		/** this should remain the same as there is no button underneath it */
		assertTrue(index[0][1] == 8);
		/** this should remain the same as there is no button underneath it */
		assertTrue(index[1][0] == 8);
		/** this should remain the same as there is no button underneath it */
		assertTrue(index[1][1] == 8);
	}
	
	
	@Test
	public void testShiftLeftTestZeroRows() {
		/** creating an int[][] with zero rows */
		int[][] index = new int[0][5];
		
		/** we should try to shift left, but this will throw an error as we can iterate through zero rows */
		try {
			GameMechanics.shiftLeftForEmptyColumns(index);
		} catch(Exception e) {
			/** this checks to make sure we throw an ArrayIndexOutOfBoundsExcpetion */
			assertTrue(e instanceof java.lang.ArrayIndexOutOfBoundsException);
		}
	}
	
	@Test
	public void testShiftLeftTestZeroColumns() {
		/** creating an int[][] with zero columns */
		int[][] index = new int[5][0];
		
		/** we should try to shift left, but this will throw an error as we can iterate through zero rows */
		try {
			GameMechanics.shiftLeftForEmptyColumns(index);
		} catch(Exception e) {
			/** this checks to make sure we throw an ArrayIndexOutOfBoundsExcpetion */
			assertTrue(e instanceof java.lang.ArrayIndexOutOfBoundsException);
		}
	}
	
	@Test
	public void testShiftLeftTestOneForOneRow() {
		/** creating an int[][] with one row */
		int[][] index = new int[1][2];
		index[0][0] = 11;
		index[0][1] = 5;
		
		GameMechanics.shiftLeftForEmptyColumns(index);
		
		/** this makes sure that we shift left 5 because the first column is empty */
		assertTrue(index[0][0] == 5);
		/** this makes sure that shifted the empty column the the left */
		assertTrue(index[0][1] == 11);
	}
	
	@Test
	public void testShiftLeftTestOneForOneColumn() {
		/** creating an int[][] with one column */
		int[][] index = new int[2][1];
		index[0][0] = 5;
		index[1][0] = 11;
		
		GameMechanics.shiftLeftForEmptyColumns(index);
		/** this makes sure nothing changes as there is no other column to shift left */
		assertTrue(index[0][0] == 5);
		/** this makes sure nothing changes as there is no other column to shift left */
		assertTrue(index[1][0] == 11);
	}
	
	@Test
	public void testShiftLeftTestMany() {
		/** creating an int[][] with 3 by 3 dimensions */
		int[][] index = new int[3][3];
		index[0][0] = 5;
		index[0][1] = 11;
		index[0][2] = 9;
		index[1][0] = 11;
		index[1][1] = 11;
		index[1][2] = 11;
		index[2][0] = 7;
		index[2][1] = 11;
		index[2][2] = 5;
		
		GameMechanics.shiftLeftForEmptyColumns(index);
		/** this column should remained unchanged as no empty column before it */
		assertTrue(index[0][0] == 5);
		/** this column should remained unchanged as no empty column before it */
		assertTrue(index[1][0] == 11);
		/** this column should remained unchanged as no empty column before it */
		assertTrue(index[2][0] == 7);
		/** this checks we moved the third column into the second as the second was empty and the third wasn't */
		assertTrue(index[0][1] == 9);
		/** this checks we moved the third column into the second as the second was empty and the third wasn't */
		assertTrue(index[1][1] == 11);
		/** this checks we moved the third column into the second as the second was empty and the third wasn't */
		assertTrue(index[2][1] == 5);
		/** this checks we moved the empty column into the rightmost column */
		assertTrue(index[0][2] == 11);
		/** this checks we moved the empty column into the rightmost column */
		assertTrue(index[1][2] == 11);
		/** this checks we moved the empty column into the rightmost column */
		assertTrue(index[2][2] == 11);
	}
	
	@Test
	public void testShiftLeftFirst() {
		/** creating a 2 by 2 int[][] index */
		int[][] index = new int[2][2];
		index[0][0] = 11;
		index[0][1] = 5;
		index[1][0] = 11;
		index[1][1] = 7;
		
		GameMechanics.shiftLeftForEmptyColumns(index);
		/** this checks if the first column switched its contents with the second column */
		assertTrue(index[0][0] == 5);
		/** this checks if the second column switched its contents with the first column */
		assertTrue(index[0][1] == 11);
		/** this checks if the first column switched its contents with the second column */
		assertTrue(index[1][0] == 7);
		/** this checks if the second column switched its contents with the first column */
		assertTrue(index[1][1] == 11);
	}
	
	@Test
	public void testShiftLeftMiddle() {
		/** creating an int[][] with 3 by 3 dimensions */
		int[][] index = new int[3][3];
		index[0][0] = 5;
		index[0][1] = 11;
		index[0][2] = 9;
		index[1][0] = 11;
		index[1][1] = 11;
		index[1][2] = 11;
		index[2][0] = 7;
		index[2][1] = 11;
		index[2][2] = 5;
		
		GameMechanics.shiftLeftForEmptyColumns(index);
		/** this column should remained unchanged as no empty column before it */
		assertTrue(index[0][0] == 5);
		/** this column should remained unchanged as no empty column before it */
		assertTrue(index[1][0] == 11);
		/** this column should remained unchanged as no empty column before it */
		assertTrue(index[2][0] == 7);
		/** this checks we moved the third column into the second as the second was empty and the third wasn't */
		assertTrue(index[0][1] == 9);
		/** this checks we moved the third column into the second as the second was empty and the third wasn't */
		assertTrue(index[1][1] == 11);
		/** this checks we moved the third column into the second as the second was empty and the third wasn't */
		assertTrue(index[2][1] == 5);
		/** this checks we moved the empty column into the rightmost column */
		assertTrue(index[0][2] == 11);
		/** this checks we moved the empty column into the rightmost column */
		assertTrue(index[1][2] == 11);
		/** this checks we moved the empty column into the rightmost column */
		assertTrue(index[2][2] == 11);
	}
	
	@Test
	public void testShiftLeftLast() {
		/** creating a 2 by 2 int[][] index */
		int[][] index = new int[2][2];
		index[0][0] = 5;
		index[0][1] = 11;
		index[1][0] = 7;
		index[1][1] = 11;
		
		GameMechanics.shiftLeftForEmptyColumns(index);
		/** this checks if nothing changed because the empty column is already the rightmost column */
		assertTrue(index[0][0] == 5);
		/** this checks if nothing changed because the empty column is already the rightmost column */
		assertTrue(index[0][1] == 11);
		/** this checks if nothing changed because the empty column is already the rightmost column */
		assertTrue(index[1][0] == 7);
		/** this checks if nothing changed because the empty column is already the rightmost column */
		assertTrue(index[1][1] == 11);
	}
	
	@Test
	public void testCheckLeftTestZero() {
		/** creating a 1 by 3 array int[][] array */
		int[][] index = new int[1][3];
		index[0][0] = 5;
		index[0][1] = 11;
		index[0][2] = 9;
		
		
		int numberInARow = GameMechanics.checkLeft(index, 0, 2);
		/** when no numbers to the left are contiguous, we should check that it equals 1 */
		assertTrue(numberInARow == 1);
	}
	
	@Test
	public void testCheckLeftTestOne() {
		/** creating a 1 by 3 array int[][] array */
		int[][] index = new int[1][3];
		index[0][0] = 5;
		index[0][1] = 9;
		index[0][2] = 9;
		
		
		int numberInARow = GameMechanics.checkLeft(index, 0, 2);
		/** when one numbers to the left are contiguous, we should check that it equals 2 */
		assertTrue(numberInARow == 2);
	}
	
	@Test 
	public void testCheckLeftTestMany() {
		/** creating a 1 by 3 array int[][] array */
		int[][] index = new int[1][3];
		index[0][0] = 9;
		index[0][1] = 9;
		index[0][2] = 9;
		
		
		int numberInARow = GameMechanics.checkLeft(index, 0, 2);
		/** when the numbers to the left are contiguous, we should check that it equals 3 */
		assertTrue(numberInARow == 3);
	}
	
	@Test
	public void testCheckRightTestZero() {
		/** creating a 1 by 3 array int[][] array */
		int[][] index = new int[1][3];
		index[0][0] = 5;
		index[0][1] = 11;
		index[0][2] = 9;
		
		
		int numberInARow = GameMechanics.checkRight(index, 0, 1);
		/** when no numbers to the right are contiguous, we should check that it equals 1 */
		assertTrue(numberInARow == 1);
	}
	
	@Test
	public void testCheckRightTestOne() {
		/** creating a 1 by 3 array int[][] array */
		int[][] index = new int[1][3];
		index[0][0] = 5;
		index[0][1] = 9;
		index[0][2] = 9;
		
		
		int numberInARow = GameMechanics.checkRight(index, 0, 1);
		/** when one numbers to the right are contiguous, we should check that it equals 2 */
		assertTrue(numberInARow == 2);
	}
	
	@Test 
	public void testCheckRightTestMany() {
		/** creating a 1 by 3 array int[][] array */
		int[][] index = new int[1][3];
		index[0][0] = 9;
		index[0][1] = 9;
		index[0][2] = 9;
		
		
		int numberInARow = GameMechanics.checkRight(index, 0, 0);
		/** when the numbers to the right are contiguous, we should check that it equals 3 */
		assertTrue(numberInARow == 3);
	}
	
	@Test
	public void testCheckTopTestZero() {
		/** creating a 3 by 1 array int[][] array */
		int[][] index = new int[3][1];
		index[0][0] = 5;
		index[1][0] = 11;
		index[2][0] = 9;
		
		
		int numberInARow = GameMechanics.checkTop(index, 2, 0);
		/** when no numbers to the top are contiguous, we should check that it equals 1 */
		assertTrue(numberInARow == 1);
	}
	
	@Test
	public void testCheckTopTestOne() {
		/** creating a 3 by 1 array int[][] array */
		int[][] index = new int[3][1];
		index[0][0] = 5;
		index[1][0] = 9;
		index[2][0] = 9;
		
		
		int numberInARow = GameMechanics.checkTop(index, 2, 0);
		/** when one numbers to the top are contiguous, we should check that it equals 2 */
		assertTrue(numberInARow == 2);
	}
	
	@Test 
	public void testCheckTopTestMany() {
		/** creating a 3 by 1 array int[][] array */
		int[][] index = new int[3][1];
		index[0][0] = 9;
		index[1][0] = 9;
		index[2][0] = 9;
		
		
		int numberInARow = GameMechanics.checkTop(index, 2, 0);
		/** when the numbers to the top are contiguous, we should check that it equals 3 */
		assertTrue(numberInARow == 3);
	}
	
	@Test
	public void testCheckBottomTestZero() {
		/** creating a 3 by 1 array int[][] array */
		int[][] index = new int[3][1];
		index[0][0] = 5;
		index[1][0] = 11;
		index[2][0] = 9;
		
		
		int numberInARow = GameMechanics.checkBottom(index, 0, 0);
		/** when no numbers to the bottom are contiguous, we should check that it equals 1 */
		assertTrue(numberInARow == 1);
	}
	
	@Test
	public void testCheckBottomTestOne() {
		/** creating a 3 by 1 array int[][] array */
		int[][] index = new int[3][1];
		index[0][0] = 9;
		index[1][0] = 9;
		index[2][0] = 5;
		
		
		int numberInARow = GameMechanics.checkBottom(index, 0, 0);
		/** when one numbers to the bottom are contiguous, we should check that it equals 2 */
		assertTrue(numberInARow == 2);
	}
	
	@Test 
	public void testCheckBottomTestMany() {
		/** creating a 3 by 1 array int[][] array */
		int[][] index = new int[3][1];
		index[0][0] = 9;
		index[1][0] = 9;
		index[2][0] = 9;
		
		
		int numberInARow = GameMechanics.checkBottom(index, 0, 0);
		/** when the numbers to the bottom are contiguous, we should check that it equals 3 */
		assertTrue(numberInARow == 3);
	}
}
