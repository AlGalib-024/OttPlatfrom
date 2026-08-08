package csc213.ottplatfrom.Rajmee;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SendNotificationController  {

    @FXML private TextField titleField;
    @FXML private TextArea messageField;
    @FXML private ComboBox<String> typeComboBox;
    @FXML private ComboBox<String> audienceComboBox;
    @FXML private Label resultLabel;


    public void initialize() {
        typeComboBox.getItems().addAll("Promotional", "Announcement", "Reminder");
        audienceComboBox.getItems().addAll(
                "All Subscribers", "Premium Subscribers", "Basic Subscribers", "New Users", "Inactive Users"
        );
    }

    @FXML
    private void handlePreview(ActionEvent event) {
        if (!validate()) return;
        resultLabel.setStyle("-fx-text-fill: #333;");
        resultLabel.setText("Preview -> [" + typeComboBox.getValue() + "] " + titleField.getText()
                + " to " + audienceComboBox.getValue() + ": " + messageField.getText());
    }

    @FXML
    private void handleSend(ActionEvent event) {
        if (!validate()) return;

        resultLabel.setStyle("-fx-text-fill: green;");
        resultLabel.setText("Notification sent successfully to: " + audienceComboBox.getValue());

        titleField.clear();
        messageField.clear();
        typeComboBox.setValue(null);
        audienceComboBox.setValue(null);
    }

    private boolean validate() {
        if (titleField.getText() == null || titleField.getText().isBlank()
                || messageField.getText() == null || messageField.getText().isBlank()
                || typeComboBox.getValue() == null || audienceComboBox.getValue() == null) {
            resultLabel.setStyle("-fx-text-fill: red;");
            resultLabel.setText("All fields are required: title, message, type, and target audience.");
            return false;
        }
        return true;
    }

    @FXML
    private void handleBack(ActionEvent event) {
        SceneSwitcher.switchScene(
               event,
                "/csc213/ottplatfrom/rajmee/MarketingDashboard.fxml",

                "Marketing Dashboard"
        );
    }
}