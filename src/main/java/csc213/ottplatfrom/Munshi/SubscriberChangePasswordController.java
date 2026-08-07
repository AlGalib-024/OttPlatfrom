package csc213.ottplatfrom.Munshi;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import csc213.ottplatfrom.model.Subscriber;

public class SubscriberChangePasswordController {

    @FXML
    private PasswordField currentPasswordField;

    @FXML
    private PasswordField newPasswordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private CheckBox showPasswordCheckBox;

    private Subscriber subscriber;

    @FXML
    public void initialize() {

        // Sample Subscriber
        subscriber = new Subscriber(
                "S001",
                "Abdulla",
                "Galib",
                "galib@gmail.com",
                "01700000000",
                "Male",
                "2002-05-20",
                "Bangladesh",
                "Dhaka",
                "123456"
        );

    }

    @FXML
    private void changePasswordOnClick(ActionEvent event) {

        if (currentPasswordField.getText().isEmpty()) {
            showAlert("Enter current password.");
            return;
        }

        if (!currentPasswordField.getText().equals(subscriber.getPassword())) {
            showAlert("Current password is incorrect.");
            return;
        }

        if (newPasswordField.getText().isEmpty()) {
            showAlert("Enter new password.");
            return;
        }

        if (confirmPasswordField.getText().isEmpty()) {
            showAlert("Confirm your new password.");
            return;
        }

        if (!newPasswordField.getText().equals(confirmPasswordField.getText())) {
            showAlert("New password and confirm password do not match.");
            return;
        }

        subscriber.setPassword(newPasswordField.getText());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Password changed successfully.");
        alert.showAndWait();

        clearFields();

    }

    @FXML
    private void clearOnClick(ActionEvent event) {

        clearFields();

    }

    @FXML
    private void backOnClick(ActionEvent event) {

        System.out.println("Back to Subscriber Dashboard");

    }

    private void clearFields() {

        currentPasswordField.clear();
        newPasswordField.clear();
        confirmPasswordField.clear();
        showPasswordCheckBox.setSelected(false);

    }

    private void showAlert(String message) {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();

    }

}