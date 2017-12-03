package project5;

import java.awt.Color;
import javafx.application.Application;
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
	
   /**
     * This method returns a random color from a set of 10 possibilities.
     * @param numColors This specifies the number of Colors that the board needs.
     * @return This returns a random color.
     */
    public static Color getColors(int numColors) {
	    	/** colors stores an array of 10 possible values of colors */
	    	Color[] colors = new Color[] {
	    			Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.BLACK,
	    			Color.YELLOW, Color.ORANGE, Color.PINK, Color.RED, Color.DARK_GRAY
	    	};
	    	
	    	return colors[(int)Math.random() * numColors];
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        int numRows = 12;
        int numColumns = 12;
        
        Button[][] buttons = new Button[numRows][numColumns];
        for(int i = 0; i < 12; i++) {
        		for(int j = 0; j < 12; j++) {
        			buttons[i][j] = new Button(Integer.toString(i) + Integer.toString(j));
        			grid.add(buttons[i][j], j, i);
 
        		}
        }
        Circle x = new Circle();
        x.setFill(Color.BLACK);
        
        
   
        
        Scene scene = new Scene(grid, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

