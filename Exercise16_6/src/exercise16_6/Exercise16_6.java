package exercise16_6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author Jixer
 */
public class Exercise16_6 extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane pane = new GridPane();

        // Row 0
        TextField tfTextField = new TextField("JavaFX");
        Label lblTextField = new Label("Text Field:", tfTextField);
        lblTextField.setContentDisplay(ContentDisplay.RIGHT);

        HBox hBoxTop = new HBox(lblTextField);
        hBoxTop.setPadding(new Insets(2));

        hBoxTop.setAlignment(Pos.CENTER);
        pane.add(hBoxTop, 0, 0);

        // Row 1
        ToggleGroup group = new ToggleGroup();

        RadioButton rbLeft = new RadioButton();
        Label lblLeft = new Label("Left", rbLeft);
        rbLeft.setToggleGroup(group);
        rbLeft.setOnAction(e -> tfTextField.setAlignment(Pos.CENTER_LEFT));
        rbLeft.setSelected(true);

        RadioButton rbRight = new RadioButton();
        Label lblRight = new Label("Right", rbRight);

        rbRight.setOnAction(e-> tfTextField.setAlignment(Pos.CENTER_RIGHT));
        rbRight.setToggleGroup(group);

        RadioButton rbCenter = new RadioButton();
        Label lblCenter = new Label("Center", rbCenter);

        rbCenter.setOnAction(e-> tfTextField.setAlignment(Pos.CENTER));
        rbCenter.setToggleGroup(group);

        TextField tfColumnSize = new TextField();
        tfColumnSize.setPrefColumnCount(3);
        tfColumnSize.setText("12");

        tfColumnSize.setOnAction(e->
                tfTextField.setPrefColumnCount(Integer.parseInt(tfColumnSize.getText())));
        Label lblColumnSize = new Label("Column Size", tfColumnSize);
        lblColumnSize.setContentDisplay(ContentDisplay.RIGHT);

        HBox hBox = new HBox(lblLeft, lblCenter, lblRight, lblColumnSize);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(10, 10, 10, 10));
        pane.add(hBox, 0, 1);

        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("TextField");
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
