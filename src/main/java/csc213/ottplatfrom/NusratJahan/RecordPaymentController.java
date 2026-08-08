package csc213.ottplatfrom.NusratJahan;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RecordPaymentController {

    @FXML
    private ComboBox<String> methodBox;

    @FXML
    private Label statusLabel;

    @FXML
    private TextField subscriberIdField;

    @FXML
    private TextField amountField;

    @FXML
    public void initialize() {
        // Load payment methods
        methodBox.getItems().addAll(
                "Card",
                "Mobile Banking",
                "Bank Transfer"
        );


        methodBox.getSelectionModel().selectFirst();

        statusLabel.setText("");
    }

    @FXML
    public void handleSave(ActionEvent actionEvent) {
        String subscriberId = subscriberIdField.getText().trim();
        String amountText = amountField.getText().trim();
        String method = methodBox.getValue();

        // Validation
        if (subscriberId.isEmpty() || amountText.isEmpty()) {
            statusLabel.setStyle("-fx-text-fill: red;");
            statusLabel.setText("Please fill in all fields.");
            return;
        }

        try {
            double amount = Double.parseDouble(amountText);

            if (amount <= 0) {
                statusLabel.setStyle("-fx-text-fill: red;");
                statusLabel.setText("Amount must be greater than 0.");
                return;
            }

            // Simulate saving payment
            statusLabel.setStyle("-fx-text-fill: green;");
            statusLabel.setText(
                    "Payment of ৳ " + amount +
                            " recorded successfully via " + method + "."
            );

            // Optional: clear fields after save
            subscriberIdField.clear();
            amountField.clear();
            methodBox.getSelectionModel().selectFirst();

        } catch (NumberFormatException e) {
            statusLabel.setStyle("-fx-text-fill: red;");
            statusLabel.setText("Invalid amount. Enter a numeric value.");
        }
    }

    @FXML
    public void handleClear(ActionEvent actionEvent) {
        subscriberIdField.clear();
        amountField.clear();
        methodBox.getSelectionModel().selectFirst();
        statusLabel.setText("");
    }

    @FXML
    public void handleBack(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("CeoDashboard.fxml")
            );

            Stage stage = (Stage) subscriberIdField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("CEO Dashboard");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            statusLabel.setStyle("-fx-text-fill: red;");
            statusLabel.setText("Unable to return to dashboard.");
        }
    }
}