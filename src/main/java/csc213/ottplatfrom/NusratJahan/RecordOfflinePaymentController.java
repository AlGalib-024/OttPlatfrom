package csc213.ottplatfrom.NusratJahan;

import csc213.ottplatfrom.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class RecordOfflinePaymentController {

    @FXML
    private ComboBox<String> methodBox;
    @FXML
    private TextField dateField;
    @FXML
    private Label statusLabel;
    @FXML
    private TextField subscriberIdField;
    @FXML
    private TextField amountField;

    @FXML
    public void initialize() {
        methodBox.getItems().addAll("Cash", "Bank Transfer", "Cheque", "Mobile Banking");
        methodBox.getSelectionModel().selectFirst();
        dateField.setText(LocalDate.now().toString());
    }

    @FXML
    public void handleSave(ActionEvent actionEvent) {
        String subscriberId = subscriberIdField.getText() == null ? "" : subscriberIdField.getText().trim();
        String amountText = amountField.getText() == null ? "" : amountField.getText().trim();
        String date = dateField.getText() == null ? "" : dateField.getText().trim();
        String method = methodBox.getValue();

        if (subscriberId.isEmpty()) {
            statusLabel.setText("Subscriber ID cannot be empty.");
            return;
        }
        double amount;
        try {
            amount = Double.parseDouble(amountText);
            if (amount <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            statusLabel.setText("Amount must be a valid number greater than zero.");
            return;
        }

        SubscriberProfile subscriber = DataStore.findSubscriberById(subscriberId);
        String subscriberName = subscriber != null ? subscriber.getName() : "Unknown";

        String newId = DataStore.generateNextPaymentId();
        PaymentRecord record = new PaymentRecord(newId, subscriberId, subscriberName, amount, date, "Verified", method);
        DataStore.savePayment(record);

        statusLabel.setText("Offline payment recorded successfully (ID: " + newId + ")");
        handleClear(actionEvent);
    }

    @FXML
    public void handleClear(ActionEvent actionEvent) {
        subscriberIdField.clear();
        amountField.clear();
        dateField.setText(LocalDate.now().toString());
        methodBox.getSelectionModel().selectFirst();
    }

    @FXML
    public void handleBack(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent, "/csc213/ottplatfrom/NusratJahan/accountant-dashboard.fxml", "Accountant Dashboard");
    }
}