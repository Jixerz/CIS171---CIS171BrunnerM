package exercise15_32;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
/// Very clean code
/**
 *
 * @author Jixer
 */
public class Exercise15_32 extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        ClockPane clockPane = new ClockPane();
        clockPane.start();

        Button btStart = new Button("Start");
        btStart.setOnAction(e -> clockPane.start());
        Button btStop = new Button("Stop");
        btStop.setOnAction(e -> clockPane.stop());

        HBox hBox = new HBox(btStart, btStop);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setAlignment(Pos.CENTER);
        BorderPane borderPane = new BorderPane(clockPane, null, null, hBox, null);

        primaryStage.setScene(new Scene(borderPane));
        primaryStage.setTitle("Clock");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
