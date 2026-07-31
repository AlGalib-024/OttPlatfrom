package csc213.ottplatfrom.rajmee;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController
{
    @javafx.fxml.FXML
    private TextField userIdField;
    @javafx.fxml.FXML
    private ComboBox <String>roleComboBox;
    @javafx.fxml.FXML
    private PasswordField passwordField;
    @javafx.fxml.FXML
    private Label errorLabel;

    @javafx.fxml.FXML
    public void initialize() {
        roleComboBox.getItems().addAll("CEO", "Accountant", "Subscriber", "Advertiser",
                "Marketing Manager", "Content Manager",
                "Content Reviewer", "Customer Support Representative");
    }

    @javafx.fxml.FXML
    public void handleClear(ActionEvent actionEvent) {
        userIdField.clear();
        passwordField.clear();
        roleComboBox.setValue(null);
        errorLabel.setText("");
    }

    @javafx.fxml.FXML
    public void handleLogin(ActionEvent actionEvent) {
        String userId = userIdField.getText();
        String password = passwordField.getText();
        String role = roleComboBox.getValue();

        if (userId == null || userId.isBlank() || password == null || password.isBlank() || role == null) {
            errorLabel.setText("User ID/email and password cannot be empty, and a role must be selected.");
            return;
        }

        switch (role) {
            case "Marketing Manager" ->
                    SceneSwitcher.switchScene(actionEvent,"/csc213/ottplatfrom/rajmee/MarketingDashboard.fxml", "Marketing Manager Dashboard");
            case "Content Manager" ->
                    SceneSwitcher.switchScene(actionEvent,"/csc213/ottplatfrom/rajmee/ContentManagerDashboard.fxml", "Content Manager Dashboard");
            default ->
                    errorLabel.setText("Dashboard for '" + role + "' is not wired up yet in this build.");
        }
    }
}