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
	
   /**
     * This method returns a random color from a set of 10 possibilities.
     * @param numColors This specifies the number of Colors that the board needs.
     * @return This returns a random color.
     */
    public static Color getColors(int numColors) {
	    	/** colors stores an array of 10 possible values of colors */
	    	Color[] colors = new Color[] {
	    			Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.BLACK,
	    			Color.YELLOW, Color.ORANGE, Color.PINK, Color.RED, Color.BROWN
	    	};
	    	
	    	return colors[(int)(Math.random() * numColors)];
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
        for(int i = 0; i < 12; i++) {
        		for(int j = 0; j < 12; j++) {
        			x = new Circle(10, SameGame.getColors(3));
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
    			Color currentColor = (Color)((Circle)b.getGraphic()).getFill();
    			int[] buttonIndex = search(b);
    			int rowNumber = buttonIndex[0];
    			int columnNumber = buttonIndex[1];
    			int numLeft = checkLeft(currentColor, rowNumber, columnNumber);
    			System.out.println(currentColor);
    			System.out.println(numLeft);
    			
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
    		
    		public int checkLeft(Color currentColor, int rowNumber, int columnNumber) {
    			int numberOnLeft = 0;
    			for(int i = 0; i < columnNumber; i++) {
    				if(((Circle) (SameGame.buttons[rowNumber][i].getGraphic())).getFill() == currentColor) {
    					numberOnLeft++;
    				}
    			}
    			return numberOnLeft;
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

