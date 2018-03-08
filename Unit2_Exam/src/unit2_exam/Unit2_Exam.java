package unit2_exam;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
/**
 *
 * @author Jixer
 */
public class Unit2_Exam extends Application {
    
    // create text fields
    TextField TextFieldUSD = new TextField();
    TextField TextFieldCD = new TextField();
    
    @Override
    public void start(Stage primaryStage) {
        
        //create convert button
        Button ConvertButton = new Button("Convert");
        
        // create hbox for text fields
        HBox HBoxUSD = new HBox();
        HBoxUSD.getChildren().addAll(new Label("US Dollars:                "), TextFieldUSD);
        HBox hBoxCanD = new HBox();
        hBoxCanD.getChildren().addAll(new Label("Canadian Dollars:     "), TextFieldCD);
        
        //create vbox and pane
        VBox contentPane = new VBox(5);
        contentPane.setPadding(new Insets (5, 5, 5, 5));
        contentPane.getChildren().addAll(HBoxUSD, hBoxCanD, ConvertButton);
        Pane displayPane = new Pane();
        displayPane.getChildren().add(contentPane);
        
        //event handler for button
        ConvertButton.setOnAction(e -> {
            setText(TextFieldCD);
        });
        
        Scene scene = new Scene(displayPane);
	primaryStage.setTitle("Unit 2 Exam");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    private void setText(TextField TextFieldCD) {
    
        Double converted = Double.parseDouble(TextFieldUSD.getText()) * 1.5;
        String output = converted.toString();
        TextFieldCD.setText(output);
    }
}





