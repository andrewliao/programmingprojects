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

public class SameGame extends Application {
	
	public static int numRows = 12;
	public static int numColumns = 12;
	public static Button[][] buttons = new Button[numRows][numColumns];
	public static int[][] colorsOfButtonIndex = new int[numRows][numColumns];
  	public static final Color[] colors = new Color[] {
			Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.BLACK,
			Color.YELLOW, Color.ORANGE, Color.PINK, Color.RED, Color.BROWN, Color.ALICEBLUE, Color.LIGHTGRAY
	};
	
	
   /**
     * This method returns a random color from a set of 10 possibilities.
     * @param numColors This specifies the number of Colors that the board needs.
     * @return This returns a random color.
     */
    public static int getColorIndex(int numColors) {
	    	return (int)(Math.random() * numColors);
    }
    


    @Override
    public void start(Stage primaryStage) {
    		List<String> arguments = getParameters().getRaw();
    		int numOfColors = 3;
    		
    		if(arguments.size() >= 3) {
    			try {
    				numRows = Integer.parseInt(arguments.get(0));
    				numColumns = Integer.parseInt(arguments.get(1));
    				numOfColors = Integer.parseInt(arguments.get(2));
    				if(numOfColors != 11 && numOfColors > 0) {
    					
	    				SameGame.buttons = new Button[numRows][numColumns];
	    				SameGame.colorsOfButtonIndex = new int[numRows][numColumns];
	
		    	    		GridPane grid = new GridPane();
		    	        for(int i = 0; i < numRows; i++) {
		    	        		for(int j = 0; j < numColumns; j++) {
		    	        			buttons[i][j] = new Button();
		    	        			grid.add(buttons[i][j], j, i);
		    	 
		    	        		}
		    	        }
		    	       
		    	        Circle x;
		    	        int y;
		    	        for(int i = 0; i < numRows; i++) {
		    	        		for(int j = 0; j < numColumns; j++) {
		    	        			y = SameGame.getColorIndex(numOfColors);
		    	        			x = new Circle(10, colors[y]);
		    	        			colorsOfButtonIndex[i][j] = y;
		    	        			buttons[i][j].setGraphic(x);
		    	        		}
		    	        }
		    	        
		    	        for(int i = 0; i < numRows; i++) {
		    	        		for(int j = 0; j < numColumns; j++) {
		    	        			buttons[i][j].setOnAction(new ButtonAction());
		    	        		}
		    	        }
		    	        
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

        		GridPane grid = new GridPane();
            for(int i = 0; i < numRows; i++) {
            		for(int j = 0; j < numColumns; j++) {
            			buttons[i][j] = new Button();
            			grid.add(buttons[i][j], j, i);
     
            		}
            }
           
            Circle x;
            int y;
            for(int i = 0; i < numRows; i++) {
            		for(int j = 0; j < numColumns; j++) {
            			y = SameGame.getColorIndex(numOfColors);
            			x = new Circle(10, colors[y]);
            			colorsOfButtonIndex[i][j] = y;
            			buttons[i][j].setGraphic(x);
            		}
            }
            
            for(int i = 0; i < numRows; i++) {
            		for(int j = 0; j < numColumns; j++) {
            			buttons[i][j].setOnAction(new ButtonAction());
            		}
            }
            
            Scene scene = new Scene(grid);
            primaryStage.setScene(scene);
            primaryStage.show();
            
    		} else {
    			System.out.println("Too few inputs given!");
    		}
    		
 
    }

    public class ButtonAction implements EventHandler<ActionEvent> {
    		@Override
    		public void handle(ActionEvent e) {
    			Button b = (Button)e.getSource();

    			
    			int[] buttonIndex = search(b);
    			int rowNumber = buttonIndex[0];
    			int columnNumber = buttonIndex[1];
    			
    			int numLeft = checkLeft(SameGame.colorsOfButtonIndex, rowNumber, columnNumber);
    			int numRight = checkRight(SameGame.colorsOfButtonIndex, rowNumber, columnNumber);
    			int numTop = checkTop(SameGame.colorsOfButtonIndex, rowNumber, columnNumber);
    			int numBottom = checkBottom(SameGame.colorsOfButtonIndex, rowNumber, columnNumber);
    
    			int[][] leftSide = markLeftToEmpty(numLeft, rowNumber, columnNumber, SameGame.colorsOfButtonIndex);
    			int[][] rightSide = markRightToEmpty(numRight, rowNumber, columnNumber, leftSide);
    			int[][] topSide = markTopToEmpty(numTop, rowNumber, columnNumber, rightSide);
    			int[][] bottomSide = markBottomToEmpty(numBottom, rowNumber, columnNumber, topSide);
    			int[][] downShift = shiftDown(bottomSide);
    			int[][] leftShift = shiftLeftForEmptyColumns(downShift);
    			
    			for(int i = 0; i < SameGame.numRows; i++) {
    				for(int j = 0; j < SameGame.numColumns; j++) {
    					((Circle)(SameGame.buttons[i][j].getGraphic())).setFill(colors[leftShift[i][j]]);
    				}
    				
    			}
    			
    			
    			
    			
    			
    		}
    		
    		public int[][] shiftDown(int[][] colorIndex) {
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
    			return colorIndex;
    		}
    		
    		public int[][] markLeftToEmpty(int left, int rowNumber, int columnNumber, int[][] colorIndex) {
    			if(left > 1) {
    				for(int i = 0; i < left; i++) {
    					colorIndex[rowNumber][columnNumber - i] = 11;
    				}
    			}
    			return colorIndex;
    		}
    		
    		public int[][] markRightToEmpty(int right, int rowNumber, int columnNumber, int[][] colorIndex) {
    			if(right > 1) {
    				for(int i = 0 ; i < right; i++) {
    					colorIndex[rowNumber][columnNumber + i] = 11;
    				}
    			}
    			return colorIndex;
    		}
    		
    		public int[][] markTopToEmpty(int top, int rowNumber, int columnNumber, int[][] colorIndex) {
    			if(top > 1) {
    				for(int i = 0; i < top; i++) {
    					colorIndex[rowNumber - i][columnNumber] = 11;
    				}
    			}
    			return colorIndex;
    		}
    		
    		public int[][] markBottomToEmpty(int bottom, int rowNumber, int columnNumber, int[][] colorIndex) {
    			if (bottom > 1) {
    				for(int i = 0; i < bottom; i++) {
    					colorIndex[rowNumber + i][columnNumber] = 11;
    				}
    			}
    			return colorIndex;
    		}
    		
    		
    		public int[][] shiftLeftForEmptyColumns(int[][] colorIndex) {
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
    			return colorIndex;
    		}
    	
    		public int[] search(Button b) {
    			int[] buttonCoordinates = new int[2];
        		for(int i = 0; i < SameGame.numRows; i++) {
        			for(int j = 0; j < SameGame.numColumns; j++) {
        				if(b == buttons[i][j]) {
        					buttonCoordinates[0] = i;
        					buttonCoordinates[1] = j;
        				}
        			}
        		}	
        		return buttonCoordinates;
        }
    		
    		public int checkLeft(int[][] colorIndex , int rowNumber, int columnNumber) {
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
    		
    		public int checkRight(int[][] colorIndex, int rowNumber, int columnNumber) {
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
    		
    		public int checkTop(int[][] colorIndex, int rowNumber, int columnNumber) {
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
    		
    		public int checkBottom(int[][] colorIndex, int rowNumber, int columnNumber) {
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
    
    public static void main(String[] args) {
    		
    		launch(args);
    }

    
}