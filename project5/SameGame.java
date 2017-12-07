 package project5;

import javafx.scene.paint.Color;

import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * This SameGame class is where we will start the application by creating the board and running the game.
 * @author Andrew Liao
 *
 */
public class SameGame extends Application {
	
	/** this stores the default number of rows in the board */
	public static int numRows = 12;
	/** this stores the default number of columns in the board */
	public static int numColumns = 12;
	/** this is the button array game board */
	public static Button[][] buttons = new Button[numRows][numColumns];
	/** this is stores the color indexes of each of the buttons on the board */
	public static int[][] colorsOfButtonIndex = new int[numRows][numColumns];
	/** this array stores all the possible colors for the board */
  	public static final Color[] colors = new Color[] {
			Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.BLACK,
			Color.YELLOW, Color.ORANGE, Color.PINK, Color.RED, Color.BROWN, Color.ALICEBLUE, Color.LIGHTGRAY
	};

    /** 
     * This start method will start the application and run the SameGame. 
     * @param primaryStage This is the stage of the application which will hold the board for the game.
     */
    @Override
    public void start(Stage primaryStage) {
    		/** arguments will store all the arguments the user gives during command line */
    		List<String> arguments = getParameters().getRaw();
    		/** this will store the number of colors on the board */
    		int numOfColors = 3;
    		
    		if(arguments.size() >= 3) {
    			try {
    				numRows = Integer.parseInt(arguments.get(0));
    				numColumns = Integer.parseInt(arguments.get(1));
    				numOfColors = Integer.parseInt(arguments.get(2));
    				
    				if(numOfColors != 11 && numOfColors > 0) {
    					/** this will create a new button[][] according to the size indicated by the command line */
	    				SameGame.buttons = new Button[numRows][numColumns];
	    				/** this will store a new int[][] which has the index of the colors of the buttons on the board */
	    				SameGame.colorsOfButtonIndex = new int[numRows][numColumns];
	    				
	    				/** this will be the grid which will store all the buttons in the board */
		    	    		GridPane grid = new GridPane();
		    	    		
		    	    		/**
		    	    		 * The loop will iterate all the rows in the board. The precondition is that there is at least one row.
		    	    		 * The goal of this loop is to check all the columns in each row. The subgoal is to
		    	    		 * check all the columns for one row and create a button and add it to the grid.
		    	    		 */
		    	        for(int i = 0; i < numRows; i++) {
		    	        		/**
		    	        		 * The precondition of this loops is that there is at least one column. The goal is to 
		    	        		 * create a button[][] for the SameGame board. The subgoal is that each column will have buttons
		    	        		 * that will be added to the grid.
		    	        		 */
		    	        		for(int j = 0; j < numColumns; j++) {
		    	        			buttons[i][j] = new Button();
		    	        			grid.add(buttons[i][j], j, i);
		    	 
		    	        		}
		    	        }
		    	       
		    	        /** This will store the circle object which will represent the graphic on the button */
		    	        Circle x;
		    	        /** This stores the index of the colors for each of the buttons */
		    	        int colorNumber;
		    	        
		    	        /**
	    	    		     * The loop will iterate all the rows in the board. The precondition is that there is at least one row.
	    	    	      	 * The goal of this loop is to check all the columns in each row. The subgoal is to
	    	    		     * check all the columns for one row and add a graphic with a color on the button.
	    	    		     */
		    	        for(int i = 0; i < numRows; i++) {
		    	        		/**
		    	        		 * The precondition of this loops is that there is at least one column. The goal is to 
		    	        		 * create an int[][] that stores the color indexes for the board and fill the graphic for all the buttons.
		    	        		 *  The subgoal is that each column will have buttons that have a circle graphic with a color. 
		    	        		 */
		    	        		for(int j = 0; j < numColumns; j++) {
		    	        			colorNumber = GameMechanics.getColorIndex(numOfColors);
		    	        			x = new Circle(10, colors[colorNumber]);
		    	        			colorsOfButtonIndex[i][j] = colorNumber;
		    	        			buttons[i][j].setGraphic(x);
		    	        		}
		    	        }
		    	        
		    	        /**
		    	         * The loop will iterate all the rows in the board. The precondition is that there is at least one row.
    	    	      	 	* The goal of this loop is to check all the columns in each row. The subgoal is to
    	    	      	 	* check all the columns for one row and make sure that the buttons handles a user event.
    	    	      	 	*/
		    	        for(int i = 0; i < numRows; i++) {
		    	        		/**
		    	        		 * The precondition of this loops is that there is at least one column. The goal is to 
		    	        		 * create an int[][] that stores the color indexes for the board and fill the graphic for all the buttons.
		    	        		 *  The subgoal is that each column will have buttons that have a circle graphic with a color. 
		    	        		 */
		    	        		for(int j = 0; j < numColumns; j++) {
		    	        			buttons[i][j].setOnAction(new ButtonAction());
		    	        		}
		    	        }
		    	        
		    	        /** This will store the elements for the stage, which means adding the gridpane. */
		    	        Scene scene = new Scene(grid);
		    	        primaryStage.setScene(scene);
		    	        primaryStage.show();
		    	        
    				} else {
    					System.out.println("Must be between index of 1 and 10!");
    				}
    	        
    			} catch(java.lang.NegativeArraySizeException e) {
    				System.out.println("You cannot input a negative number as a row or column size!");
    			} catch(java.lang.ArrayIndexOutOfBoundsException e) {
    				System.out.println("You must input a color number between 1 and 10!");
    			} catch(java.lang.NumberFormatException e) {
    				System.out.println("Your input is not all numbers!");
    			}
    		} else if (arguments.size() == 0){

			/** this will be the grid which will store all the buttons in the board */
	    		GridPane grid = new GridPane();
	    		
	    		/**
	    		 * The loop will iterate all the rows in the board. The precondition is that there is at least one row.
	    		 * The goal of this loop is to check all the columns in each row. The subgoal is to
	    		 * check all the columns for one row and create a button and add it to the grid.
	    		 */
	        for(int i = 0; i < numRows; i++) {
	        		/**
	        		 * The precondition of this loops is that there is at least one column. The goal is to 
	        		 * create a button[][] for the SameGame board. The subgoal is that each column will have buttons
	        		 * that will be added to the grid.
	        		 */
	        		for(int j = 0; j < numColumns; j++) {
	        			buttons[i][j] = new Button();
	        			grid.add(buttons[i][j], j, i);
	 
	        		}
	        }
	       
	        /** This will store the circle object which will represent the graphic on the button */
	        Circle x;
	        /** This stores the index of the colors for each of the buttons */
	        int colorNumber;
	        
	        /**
    		     * The loop will iterate all the rows in the board. The precondition is that there is at least one row.
    	      	 * The goal of this loop is to check all the columns in each row. The subgoal is to
    		     * check all the columns for one row and add a graphic with a color on the button.
    		     */
	        for(int i = 0; i < numRows; i++) {
	        		/**
	        		 * The precondition of this loops is that there is at least one column. The goal is to 
	        		 * create an int[][] that stores the color indexes for the board and fill the graphic for all the buttons.
	        		 *  The subgoal is that each column will have buttons that have a circle graphic with a color. 
	        		 */
	        		for(int j = 0; j < numColumns; j++) {
	        			colorNumber = GameMechanics.getColorIndex(numOfColors);
	        			x = new Circle(10, colors[colorNumber]);
	        			colorsOfButtonIndex[i][j] = colorNumber;
	        			buttons[i][j].setGraphic(x);
	        		}
	        }
	        
	        /**
	         * The loop will iterate all the rows in the board. The precondition is that there is at least one row.
	      	 	* The goal of this loop is to check all the columns in each row. The subgoal is to
	      	 	* check all the columns for one row and make sure that the buttons handles a user event.
	      	 	*/
	        for(int i = 0; i < numRows; i++) {
	        		/**
	        		 * The precondition of this loops is that there is at least one column. The goal is to 
	        		 * create an int[][] that stores the color indexes for the board and fill the graphic for all the buttons.
	        		 *  The subgoal is that each column will have buttons that have a circle graphic with a color. 
	        		 */
	        		for(int j = 0; j < numColumns; j++) {
	        			buttons[i][j].setOnAction(new ButtonAction());
	        		}
	        }
	        
	        /** This will store the elements for the stage, which means adding the gridpane. */
	        Scene scene = new Scene(grid);
	        primaryStage.setScene(scene);
	        primaryStage.show();
            
    		} else {
    			System.out.println("Too few inputs given!");
    		}
    		
 
    }
    
    /**
     * This method will search the entire board array until we find the button.
     * @param b This is the button which we will examine and find the coordinates of. 
     * @return We should return an int[] which will hold the row and column numbers.
     */
    public int[] search(Button b) {
    		/** this will store an int[] with the first index storing the row and the second index storing the column value */
		int[] buttonCoordinates = new int[2];
		
		/** 
		 * This loops iterates through the rows in the SameGame board. The prerequisite for the loop
    		 * is that there is at least 1 row in the SameGame board we create. The subgoal of each iteration is 
    		 * to go through the columns in each row of the the board with the next for loop. 
    		 * The goal of this loop is to iterate through  all the rows in the board.
		 */
		for(int i = 0; i < SameGame.numRows; i++) {
			/**
			 * This loops iterates through the columns in the SameGame board. The prerequisite for the loop is
			 * that there is at least 1 column in each row of the board. The subgoal of the board is to go through
			 * each element in the column at a row. The goal is to obtain the coordinate of the button.
			 */
			for(int j = 0; j < SameGame.numColumns; j++) {
				if(b == buttons[i][j]) {
					buttonCoordinates[0] = i;
					buttonCoordinates[1] = j;
				}
			}
		}	
		
		return buttonCoordinates;
    }

    /** 
     * This is a nested class that will create an EventHandler for the buttons.
     * We will need to override the handle method, which will tell us what to do when we press a button.
     */
    public class ButtonAction implements EventHandler<ActionEvent> {
    		
    		/**
    		 * This method will handle a button whenever someone clicks on it. This method must be 
    		 * overridden when we implement an EventHandler.
    		 * @param e This is what comes from the button when we click on it.
    		 */
    		@Override
    		public void handle(ActionEvent e) {
    			/** This will store the button that is pressed. */
    			Button b = (Button)e.getSource();

    			/** This will store an index array that stores the row number and column number of the button */
    			int[] buttonIndex = search(b);
    			/** rowNumber will store the row number of the button */
    			int rowNumber = buttonIndex[0];
    			/** columnNumber will store the columnNumber of the button */
    			int columnNumber = buttonIndex[1];
    			
    			/** numLeft will store the number of buttons to the left of the button clicked that could be cleared. */
    			int numLeft = GameMechanics.checkLeft(SameGame.colorsOfButtonIndex, rowNumber, columnNumber);
    			/** numRight will store the number of buttons to the right of the button clicked that could be cleared. */
    			int numRight = GameMechanics.checkRight(SameGame.colorsOfButtonIndex, rowNumber, columnNumber);
    			/** numTop will store the number of buttons to the top of the button clicked that could be cleared. */
    			int numTop = GameMechanics.checkTop(SameGame.colorsOfButtonIndex, rowNumber, columnNumber);
    			/** numBottom will store the number of buttons to the bottom of the button clicked that could be cleared. */
    			int numBottom = GameMechanics.checkBottom(SameGame.colorsOfButtonIndex, rowNumber, columnNumber);
    
    		    GameMechanics.markLeftToEmpty(numLeft, rowNumber, columnNumber, SameGame.colorsOfButtonIndex);
    		    GameMechanics.markRightToEmpty(numRight, rowNumber, columnNumber, SameGame.colorsOfButtonIndex);
    			GameMechanics.markTopToEmpty(numTop, rowNumber, columnNumber, SameGame.colorsOfButtonIndex);
    			GameMechanics.markBottomToEmpty(numBottom, rowNumber, columnNumber, SameGame.colorsOfButtonIndex);
    			GameMechanics.shiftDown(SameGame.colorsOfButtonIndex);
    			GameMechanics.shiftLeftForEmptyColumns(SameGame.colorsOfButtonIndex);
    			
    			/**
    			 * This loops iterates through the rows in the SameGame board. The prerequisite for the loop
    			 * is that there is at least 1 row in the SameGame board we create. The subgoal of each iteration is 
    			 * to go through the columns in each row of the the board. The goal of this loop is to iterate through
    			 * all the rows in the board.
    			 */
    			for(int i = 0; i < SameGame.numRows; i++) {
    				/**
    				 * This loops iterates through the columns in the SameGame board. The prerequisite for the loop is
    				 * that there is at least 1 column in each row of the board. The subgoal of the board is to make each
    				 * element at the specific row indicated by i and the specific row indicated by j the correct color. The goal
    				 * is to make the entire board have the correct color for the button which we will get the values from the
    				 * colorsOfButton[][] index which will tell us what color in the colors[] field.
    				 */
    				for(int j = 0; j < SameGame.numColumns; j++) {
    					((Circle)(SameGame.buttons[i][j].getGraphic())).setFill(colors[SameGame.colorsOfButtonIndex[i][j]]);
    				} 				
    			}   
    			
    		}
    		
    }
    
    /**
     * The main method is what is run to start the game application.
     * @param args This stores the arguments that specifies the size of the board and the number of colors of the buttons.
     */
    public static void main(String[] args) {   		
    		launch(args);
    }

    
}