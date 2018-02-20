package exercise15_29;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.Group;

public class Exercise15_29 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Start Car");
        // Create a car
	CarPane pane = new CarPane();

	// Create and register handles
	pane.setOnMousePressed(e -> pane.pause());
	pane.setOnMouseReleased(e -> pane.play());

	pane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
		pane.increaseSpeed();
            }            
            else if (e.getCode() == KeyCode.DOWN) {
		pane.decreaseSpeed();
            }
        });
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        pane.getStylesheets().add("styleSheet.css");

            
            
        Scene scene = new Scene(pane, 800, 125);
        scene.getStylesheets().add("styleSheet.css");
            primaryStage.setTitle("Exercise_15_29"); // Set the stage title
            primaryStage.setScene(scene); // Place the scene in the stage            
            primaryStage.show(); // Display the stage
            pane.requestFocus(); // Request focus
            
    }  
}
