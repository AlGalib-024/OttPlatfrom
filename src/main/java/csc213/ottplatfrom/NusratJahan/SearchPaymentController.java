package csc213.ottplatfrom.NusratJahan;

import csc213.ottplatfrom.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SearchPaymentController {

    @FXML
    private TextField paymentIdField;

    @FXML
    private Label nameLabel;

    @FXML
    private Label amountLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private Label statusValueLabel;

    @FXML
    private Label methodLabel;

    @FXML
    private Label messageLabel;

    @FXML
    public void initialize() {
        clearFields();
        messageLabel.setText("");
    }

    @FXML
    public void handleSearch(ActionEvent actionEvent) {

        String id = paymentIdField.getText() == null
                ? ""
                : paymentIdField.getText().trim();

        // Validate input
        if (id.isEmpty()) {
            messageLabel.setStyle("-fx-text-fill: red;");
            messageLabel.setText("Please enter a Payment ID.");
            clearFields();
            return;
        }

        // Search payment from DataStore
        PaymentRecord payment = DataStore.findPaymentById(id);

        if (payment == null) {
            messageLabel.setStyle("-fx-text-fill: red;");
            messageLabel.setText("No payment found with ID: " + id);
            clearFields();
            return;
        }

        // Display payment information
        messageLabel.setStyle("-fx-text-fill: green;");
        messageLabel.setText("Payment record found.");

        nameLabel.setText(payment.getSubscriberName());
        amountLabel.setText(payment.getAmountDisplay());
        dateLabel.setText(payment.getDate());
        statusValueLabel.setText(payment.getStatus());
        methodLabel.setText(payment.getMethod());
    }

    private void clearFields() {
        nameLabel.setText("-");
        amountLabel.setText("-");
        dateLabel.setText("-");
        statusValueLabel.setText("-");
        methodLabel.setText("-");
    }

    @FXML
    public void handleClear(ActionEvent actionEvent) {
        paymentIdField.clear();
        messageLabel.setText("");
        clearFields();
    }

    @FXML
    public void handleBack(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(
                actionEvent,
                "/csc213/ottplatfrom/NusratJahan/accountant-dashboard.fxml",
                "Accountant Dashboard"
        );
    }
}