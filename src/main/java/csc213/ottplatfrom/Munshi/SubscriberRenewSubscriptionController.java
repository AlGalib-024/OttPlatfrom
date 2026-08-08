package csc213.ottplatfrom.Munshi;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import csc213.ottplatfrom.model.Subscription;

public class SubscriberRenewSubscriptionController {

    @FXML
    private ComboBox<String> renewalMethodComboBox;

    @FXML
    private DatePicker renewalDatePicker;

    @FXML
    private CheckBox autoRenewCheckBox;

    @FXML
    private TableView<Subscription> subscriptionTableView;

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

        renewalMethodComboBox.getItems().addAll(
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

        subscriptionList.add(new Subscription(
                "P001",
                "Basic",
                299,
                "1 Month",
                "HD",
                "Basic Plan",
                "Available"
        ));

        subscriptionList.add(new Subscription(
                "P002",
                "Standard",
                499,
                "1 Month",
                "Full HD",
                "Standard Plan",
                "Available"
        ));

        subscriptionList.add(new Subscription(
                "P003",
                "Premium",
                799,
                "1 Month",
                "4K",
                "Premium Plan",
                "Available"
        ));

        subscriptionTableView.setItems(subscriptionList);
    }

    @FXML
    private void renewOnClick(ActionEvent event) {

        if (renewalMethodComboBox.getValue() == null) {
            showAlert("Please select a payment method.");
            return;
        }

        if (renewalDatePicker.getValue() == null) {
            showAlert("Please select a renewal date.");
            return;
        }

        if (subscriptionTableView.getSelectionModel().getSelectedItem() == null) {
            showAlert("Please select a subscription plan.");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Subscription renewed successfully.");
        alert.showAndWait();
    }

    @FXML
    private void clearOnClick(ActionEvent event) {

        renewalMethodComboBox.setValue(null);
        renewalDatePicker.setValue(null);
        autoRenewCheckBox.setSelected(false);
        subscriptionTableView.getSelectionModel().clearSelection();

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