package csc213.ottplatfrom.NusratJahan;

import csc213.ottplatfrom.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SubscriberDetailsController {

    @FXML
    private Label expiryLabel;

    @FXML
    private Label phoneLabel;

    @FXML
    private Label countryLabel;

    @FXML
    private Label planLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label statusLabel;

    @FXML
    private TextField subscriberIdField;

    @FXML
    private Label nameLabel;

    @FXML
    public void initialize() {
        clearLabels();
        statusLabel.setText("");
    }

    @FXML
    public void handleSearch(ActionEvent actionEvent) {

        String id = subscriberIdField.getText().trim();

        if (id.isEmpty()) {
            statusLabel.setText("Please enter a Subscriber ID.");
            clearLabels();
            return;
        }

        if (id.equalsIgnoreCase("S001")) {
            nameLabel.setText("Rahim Ahmed");
            emailLabel.setText("rahim@gmail.com");
            phoneLabel.setText("+8801712345678");
            countryLabel.setText("Bangladesh");
            planLabel.setText("Premium Plan");
            expiryLabel.setText("31 Dec 2026");
            statusLabel.setText("Subscriber found successfully.");

        } else if (id.equalsIgnoreCase("S002")) {
            nameLabel.setText("Nusrat Jahan");
            emailLabel.setText("nusrat@gmail.com");
            phoneLabel.setText("+8801811122233");
            countryLabel.setText("Bangladesh");
            planLabel.setText("Basic Plan");
            expiryLabel.setText("15 Nov 2026");
            statusLabel.setText("Subscriber found successfully.");

        } else {
            clearLabels();
            statusLabel.setText("No subscriber found with ID: " + id);
        }
    }

    @FXML
    public void handleClear(ActionEvent actionEvent) {
        subscriberIdField.clear();
        statusLabel.setText("");
        clearLabels();
    }

    @FXML
    public void handleBack(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(
                actionEvent,
                "/csc213/ottplatfrom/NusratJahan/CeoDashboard.fxml",
                "CEO Dashboard"
        );
    }

    private void clearLabels() {
        nameLabel.setText("-");
        emailLabel.setText("-");
        phoneLabel.setText("-");
        countryLabel.setText("-");
        planLabel.setText("-");
        expiryLabel.setText("-");
    }
}