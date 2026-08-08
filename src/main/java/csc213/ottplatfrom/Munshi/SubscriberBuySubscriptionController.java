package csc213.ottplatfrom.Munshi;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import csc213.ottplatfrom.model.Subscription;

public class SubscriberBuySubscriptionController {

    @FXML
    private ComboBox<String> paymentMethodComboBox;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private CheckBox autoRenewCheckBox;

    @FXML
    private TableView<Subscription> planTableView;

    @FXML
    private TableColumn<Subscription, String> planIdColumn;

    @FXML
    private TableColumn<Subscription, String> planNameColumn;

    @FXML
    private TableColumn<Subscription, Double> priceColumn;

    @FXML
    private TableColumn<Subscription, String> durationColumn;

    @FXML
    private TableColumn<Subscription, String> qualityColumn;

    @FXML
    public void initialize() {

        paymentMethodComboBox.getItems().addAll(
                "Bkash",
                "Nagad",
                "Visa Card",
                "Master Card"
        );

        planIdColumn.setCellValueFactory(new PropertyValueFactory<>("planId"));
        planNameColumn.setCellValueFactory(new PropertyValueFactory<>("planName"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
        qualityColumn.setCellValueFactory(new PropertyValueFactory<>("quality"));

        ObservableList<Subscription> subscriptionList = FXCollections.observableArrayList();

        subscriptionList.add(
                new Subscription("P001", "Basic", 299,
                        "1 Month", "HD",
                        "Basic Plan", "Available")
        );

        subscriptionList.add(
                new Subscription("P002", "Standard", 499,
                        "1 Month", "Full HD",
                        "Standard Plan", "Available")
        );

        subscriptionList.add(
                new Subscription("P003", "Premium", 799,
                        "1 Month", "4K",
                        "Premium Plan", "Available")
        );

        planTableView.setItems(subscriptionList);
    }

    @FXML
    private void subscribeOnClick(ActionEvent event) {

        if (paymentMethodComboBox.getValue() == null) {
            showAlert("Please select a payment method.");
            return;
        }

        if (startDatePicker.getValue() == null) {
            showAlert("Please select a start date.");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Subscription purchased successfully.");
        alert.showAndWait();
    }

    @FXML
    private void clearOnClick(ActionEvent event) {

        paymentMethodComboBox.setValue(null);
        startDatePicker.setValue(null);
        autoRenewCheckBox.setSelected(false);
        planTableView.getSelectionModel().clearSelection();

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
}