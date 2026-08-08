package csc213.ottplatfrom.Munshi;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import csc213.ottplatfrom.model.Payment;

public class SubscriberPaymentHistoryController {

    @FXML
    private DatePicker fromDatePicker;

    @FXML
    private DatePicker toDatePicker;

    @FXML
    private ComboBox<String> paymentMethodComboBox;

    @FXML
    private TableView<Payment> paymentHistoryTableView;

    @FXML
    private TableColumn<Payment, String> paymentIdColumn;

    @FXML
    private TableColumn<Payment, String> dateColumn;

    @FXML
    private TableColumn<Payment, String> planColumn;

    @FXML
    private TableColumn<Payment, String> methodColumn;

    @FXML
    private TableColumn<Payment, Double> amountColumn;

    @FXML
    private TableColumn<Payment, String> statusColumn;

    @FXML
    public void initialize() {

        paymentMethodComboBox.getItems().addAll(
                "All",
                "Bkash",
                "Nagad",
                "Visa Card",
                "Master Card"
        );

        paymentMethodComboBox.setValue("All");

        paymentIdColumn.setCellValueFactory(new PropertyValueFactory<>("paymentId"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
        planColumn.setCellValueFactory(new PropertyValueFactory<>("planName"));
        methodColumn.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("paymentStatus"));

        ObservableList<Payment> paymentList = FXCollections.observableArrayList();

        paymentList.add(new Payment(
                "PAY001",
                "S001",
                "Premium",
                "Bkash",
                799,
                "2026-08-01",
                "Paid"
        ));

        paymentList.add(new Payment(
                "PAY002",
                "S001",
                "Premium",
                "Visa Card",
                799,
                "2026-07-01",
                "Paid"
        ));

        paymentHistoryTableView.setItems(paymentList);

    }

    @FXML
    private void searchOnClick(ActionEvent event) {

        if (fromDatePicker.getValue() != null &&
                toDatePicker.getValue() != null &&
                fromDatePicker.getValue().isAfter(toDatePicker.getValue())) {

            showAlert("From Date cannot be after To Date.");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Payment history loaded successfully.");
        alert.showAndWait();

    }

    @FXML
    private void clearOnClick(ActionEvent event) {

        fromDatePicker.setValue(null);
        toDatePicker.setValue(null);
        paymentMethodComboBox.setValue("All");
        paymentHistoryTableView.getSelectionModel().clearSelection();

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