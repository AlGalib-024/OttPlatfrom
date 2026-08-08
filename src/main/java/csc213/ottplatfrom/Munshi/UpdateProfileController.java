package csc213.ottplatfrom.Munshi;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import csc213.ottplatfrom.model.Subscriber;

public class SubscriberUpdateProfileController {

    @FXML
    private TextField subscriberIdTextField;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField phoneTextField;

    @FXML
    private ComboBox<String> genderComboBox;

    @FXML
    private DatePicker dateOfBirthDatePicker;

    @FXML
    private ComboBox<String> countryComboBox;

    @FXML
    private TextField addressTextField;

    @FXML
    public void initialize() {

        genderComboBox.getItems().addAll(
                "Male",
                "Female",
                "Other"
        );

        countryComboBox.getItems().addAll(
                "Bangladesh",
                "India",
                "Pakistan",
                "Nepal",
                "Bhutan"
        );

        // Sample Subscriber Data
        Subscriber subscriber = new Subscriber(
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

        subscriberIdTextField.setText(subscriber.getSubscriberId());
        firstNameTextField.setText(subscriber.getFirstName());
        lastNameTextField.setText(subscriber.getLastName());
        emailTextField.setText(subscriber.getEmail());
        phoneTextField.setText(subscriber.getPhone());
        genderComboBox.setValue(subscriber.getGender());
        countryComboBox.setValue(subscriber.getCountry());
        addressTextField.setText(subscriber.getAddress());

    }

    @FXML
    private void updateProfileOnClick(ActionEvent event) {

        if (subscriberIdTextField.getText().isEmpty()) {
            showAlert("Subscriber ID is required.");
            return;
        }

        if (firstNameTextField.getText().isEmpty()) {
            showAlert("First Name is required.");
            return;
        }

        if (lastNameTextField.getText().isEmpty()) {
            showAlert("Last Name is required.");
            return;
        }

        if (emailTextField.getText().isEmpty()) {
            showAlert("Email is required.");
            return;
        }

        if (phoneTextField.getText().isEmpty()) {
            showAlert("Phone Number is required.");
            return;
        }

        if (genderComboBox.getValue() == null) {
            showAlert("Please select a gender.");
            return;
        }

        if (dateOfBirthDatePicker.getValue() == null) {
            showAlert("Please select your date of birth.");
            return;
        }

        if (countryComboBox.getValue() == null) {
            showAlert("Please select your country.");
            return;
        }

        if (addressTextField.getText().isEmpty()) {
            showAlert("Address is required.");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Profile updated successfully.");
        alert.showAndWait();

    }

    @FXML
    private void clearOnClick(ActionEvent event) {

        subscriberIdTextField.clear();
        firstNameTextField.clear();
        lastNameTextField.clear();
        emailTextField.clear();
        phoneTextField.clear();
        genderComboBox.setValue(null);
        dateOfBirthDatePicker.setValue(null);
        countryComboBox.setValue(null);
        addressTextField.clear();

    }

    @FXML
    private void backOnClick(ActionEvent event) {

        System.out.println("Back to Subscriber Dashboard");

    }

    private void showAlert(String message) {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();

    }

}}