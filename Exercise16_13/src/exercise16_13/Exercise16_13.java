package exercise16_13;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
/**
 *
 * @author Jixer
 */
public class Exercise16_13 extends Application {

	protected TextField tfLoanAmount = new TextField();
	protected TextField tfNumberOfYears = new TextField();
	protected TextArea textArea = new TextArea();

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		tfNumberOfYears.setPrefColumnCount(2);
		tfLoanAmount.setPrefColumnCount(7);
		textArea.setPrefColumnCount(30);

		// Create a button
		Button btShowTable = new Button("Show Table");

		// Create a hbox
		HBox paneForControls = new HBox(10);
		paneForControls.setAlignment(Pos.CENTER);
		paneForControls.getChildren().addAll(new Label("Loan Amount"), tfLoanAmount,
			new Label("Number of Years"), tfNumberOfYears, btShowTable);

		// Create a scrollPane
		ScrollPane scrollPane = new ScrollPane(textArea);

		// Create a pane
		BorderPane pane = new BorderPane();
		pane.setTop(paneForControls);
		pane.setCenter(textArea);

		// Create and register handler
		btShowTable.setOnAction(e -> {
			print();
		});

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise_16_13"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	private void print() {
		// Create a output string
		String output = "";
		double monthlyInterestRate; // Monthly interest rate
		double monthlyPayment;	// Monthly payment
		
		// Add table header
		output += "Interest Rate       Monthly Payment          Total Payment\n";
		
		// Calculate and add table with interest rates to output
		for (double i = 5.0; i <= 8; i += 0.125) {
			monthlyInterestRate = i / 1200;
			monthlyPayment = Double.parseDouble(tfLoanAmount.getText()) * 
				monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate,
				Double.parseDouble(tfNumberOfYears.getText()) * 12));

			output += String.format("%-24.3f%-34.2f%-8.2f\n", i, 
				monthlyPayment, (monthlyPayment * 12) * 
				Double.parseDouble(tfNumberOfYears.getText()));
		}

		textArea.setText(output);
	}
}



