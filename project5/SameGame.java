package project5;

import javafx.scene.paint.Color;
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
			Color.YELLOW, Color.ORANGE, Color.PINK, Color.RED, Color.BROWN, Color.LIGHTGRAY
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
        GridPane grid = new GridPane();
        for(int i = 0; i < 12; i++) {
        		for(int j = 0; j < 12; j++) {
        			buttons[i][j] = new Button();
        			grid.add(buttons[i][j], j, i);
 
        		}
        }
       
        Circle x;
        int y;
        for(int i = 0; i < 12; i++) {
        		for(int j = 0; j < 12; j++) {
        			y = SameGame.getColorIndex(3);
        			x = new Circle(10, colors[y]);
        			colorsOfButtonIndex[i][j] = y;
        			buttons[i][j].setGraphic(x);
        		}
        }
        
        for(int i = 0; i < 12; i++) {
        		for(int j = 0; j < 12; j++) {
        			buttons[i][j].setOnAction(new ButtonAction());
        		}
        }
        
        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    public class ButtonAction implements EventHandler<ActionEvent> {
    		@Override
    		public void handle(ActionEvent e) {
    			Button b = (Button)e.getSource();
    			int currentColorIndex = 0;
    			for(int i = 0; i < 10; i++) {
    				if(colors[i] == ((Circle)b.getGraphic()).getFill()) {
    					currentColorIndex = i;
    				}
    			}
    			
    			int[] buttonIndex = search(b);
    			int rowNumber = buttonIndex[0];
    			int columnNumber = buttonIndex[1];
    			
    			int numLeft = checkLeft(SameGame.colorsOfButtonIndex, rowNumber, columnNumber);
    			int numRight = checkRight(SameGame.colorsOfButtonIndex, rowNumber, columnNumber);
    			int numTop = checkTop(SameGame.colorsOfButtonIndex, rowNumber, columnNumber);
    			int numBottom = checkBottom(SameGame.colorsOfButtonIndex, rowNumber, columnNumber);
    
    			int[][] leftSide = changeLeftToEmpty(numLeft, rowNumber, columnNumber, SameGame.colorsOfButtonIndex);
    			int[][] rightSide = changeRightToEmpty(numRight, rowNumber, columnNumber, leftSide);
    			int[][] vertical = changeVerticalToEmpty(numLeft, numRight, numTop, numBottom, rowNumber, columnNumber, rightSide);
    			
    			
    			//for(int i = 0; i < bottomSide.length; i++) {
    			//	for(int j = 0; j < bottomSide[i].length; j++) {
    			//		System.out.print(bottomSide[i][j] + " ");
    			//	}
    			//	System.out.println();
    			//}
    			
    			for(int i = 0; i < vertical.length; i++) {
    				for(int j = 0; j < vertical[i].length; j++) {
    					System.out.print(vertical[i][j] + " ");
    				}
    				System.out.println();
    			}
    			System.out.println();
    			System.out.println();
    			
    			
    			
    			
    			
    		}
    		
    		public int[][] changeLeftToEmpty(int left, int rowNumber, int columnNumber, int[][] colorIndex) {
    			if(left > 1) {
    				for(int i = 1; i < left; i++) {
    					for(int j = rowNumber; j > -1; j--) {
    						if(j == 0) {
    							colorIndex[j][columnNumber - i] = 11;
    						} else {
    							colorIndex[j][columnNumber - i] = colorIndex[j - 1][columnNumber - i];
    						}
    					}
    				}
    			}
    			return colorIndex;
    		}
    		
    		
    		public int[][] changeRightToEmpty(int right, int rowNumber, int columnNumber, int[][] colorIndex) {
    			if(right > 1) {
    				for(int i = 1; i < right; i++) {	
    					for(int j = rowNumber; j > -1 ; j--) {
    						if(j == 0) {
    							colorIndex[j][columnNumber + i] = 11;
    						} else {
    							colorIndex[j][columnNumber + i] = colorIndex[j - 1][columnNumber + i];
    						}
    					}
    				}
    			}
    			
    			return colorIndex;
    			
    		}
    		
    		public int[][] changeVerticalToEmpty(int left, int right, int top, int bottom, int rowNumber, int columnNumber, int[][] colorIndex) {
    			int totalToChange = top + bottom - 2;
    			int bottomIndex = rowNumber + bottom - 1;
    			int topIndex = rowNumber - top;
    			
    			if(totalToChange == 0 && left == 0 && right == 0) {
    				return colorIndex;
    			} else if(totalToChange == 0) {
    				for(int i = rowNumber; i > -1; i--) {
    					if(i == 0) {
    						colorIndex[i][columnNumber] = 11;
    					} else {
    						colorIndex[i][columnNumber] = colorIndex[i - 1][columnNumber];
    					}
    				}
    				return colorIndex;
    			} else {
    				//to change the buttons from bottom to top
    				for(int i = 0; i < totalToChange; i++) {
    					if(topIndex - i > -1) {
    						colorIndex[bottomIndex - i][columnNumber] = colorIndex[topIndex - i][columnNumber];
    					} else {
    						colorIndex[bottomIndex - i][columnNumber] = 11;
    					}
    				}
    				
    				for(int i = topIndex; i > -1; i--) {
    					colorIndex[i][columnNumber] = 11;
    				}
    			}
    			
    			return colorIndex;
    			
    		}
    		
    		
    		
    		public void changeButtonColors(int left, int right, int top, int bottom, int rowNumber, int columnNumber) {
    			if(left > 1) {
    				for(int i = 0; i < left; i++) {
    					((Circle)(SameGame.buttons[rowNumber][columnNumber - i].getGraphic())).setFill(Color.LIGHTGRAY);
    				}
    			}
    			
    			if(right > 1) {
    				for(int i = 0; i < right; i++) {
    					((Circle)(SameGame.buttons[rowNumber][columnNumber + i].getGraphic())).setFill(Color.LIGHTGRAY);
    				}
    			}
    			
    			if(top > 1) {
    				for(int i = 0; i < top; i++) {
    					((Circle)(SameGame.buttons[rowNumber - i][columnNumber].getGraphic())).setFill(Color.LIGHTGRAY);;
    				}
    			}
    			
    			if(bottom > 1) {
    				for(int i = 0; i < bottom; i++) {
    					((Circle)(SameGame.buttons[rowNumber + i][columnNumber].getGraphic())).setFill(Color.LIGHTGRAY);;
    				}
    			}
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
    			while(contiguousIsSameColor && columnNumber != 12) {
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
    			while(contiguousIsSameColor && rowNumber != 12) {
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
    
    
    
   
    
    /**
    public boolean checkRight() {
    	
    }
    
    public boolean checkTop() {
    	
    }
    
    public boolean checkBottom() {
    	
    }
    */
    
    public static void main(String[] args) {
        launch(args);
    }

    
}

