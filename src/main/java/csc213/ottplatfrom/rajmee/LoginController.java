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
    }

    @javafx.fxml.FXML
    public void handleLogin(ActionEvent actionEvent) {
    }
}