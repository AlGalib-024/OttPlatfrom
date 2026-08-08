package csc213.ottplatfrom.Munshi;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import csc213.ottplatfrom.model.Subscription;

public class SubscriberCancelSubscriptionController {

    @FXML
    private ComboBox<String> cancellationReasonComboBox;

    @FXML
    private DatePicker cancellationDatePicker;

    @FXML
    private CheckBox confirmCancellationCheckBox;

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

        cancellationReasonComboBox.getItems().addAll(
                "Too Expensive",
                "Not Using the Service",
                "Found a Better Service",
                "Other"
        );

        planIdColumn.setCellValueFactory(new PropertyValueFactory<>("planId"));
        planNameColumn.setCellValueFactory(new PropertyValueFactory<>("planName"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
        qualityColumn.setCellValueFactory(new PropertyValueFactory<>("quality"));

        ObservableList<Subscription> subscriptionList = FXCollections.observableArrayList();

        subscriptionList.add(new Subscription(
                "P002",
                "Standard",
                499,
                "1 Month",
                "Full HD",
                "Standard Plan",
                "Active"
        ));

        subscriptionTableView.setItems(subscriptionList);

    }

    @FXML
    private void cancelSubscriptionOnClick(ActionEvent event) {

        if (subscriptionTableView.getSelectionModel().getSelectedItem() == null) {
            showAlert("Please select a subscription.");
            return;
        }

        if (cancellationReasonComboBox.getValue() == null) {
            showAlert("Please select a cancellation reason.");
            return;
        }

        if (cancellationDatePicker.getValue() == null) {
            showAlert("Please select a cancellation date.");
            return;
        }

        if (!confirmCancellationCheckBox.isSelected()) {
            showAlert("Please confirm the cancellation.");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Subscription cancelled successfully.");
        alert.showAndWait();

    }

    @FXML
    private void clearOnClick(ActionEvent event) {

        cancellationReasonComboBox.setValue(null);
        cancellationDatePicker.setValue(null);
        confirmCancellationCheckBox.setSelected(false);
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