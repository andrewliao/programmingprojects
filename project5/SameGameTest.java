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
	
	
	

}
