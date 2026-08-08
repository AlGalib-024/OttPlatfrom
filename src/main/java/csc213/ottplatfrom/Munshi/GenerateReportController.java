package csc213.ottplatfrom.Munshi;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import csc213.ottplatfrom.model.Advertisement;

public class GenerateReportController {

    @FXML
    private ComboBox<String> reportTypeComboBox;

    @FXML
    private ComboBox<String> advertisementComboBox;

    @FXML
    private DatePicker fromDatePicker;

    @FXML
    private DatePicker toDatePicker;

    @FXML
    private TableView<Advertisement> reportTableView;

    @FXML
    private TableColumn<Advertisement, String> idColumn;

    @FXML
    private TableColumn<Advertisement, String> titleColumn;

    @FXML
    private TableColumn<Advertisement, String> categoryColumn;

    @FXML
    private TableColumn<Advertisement, Double> budgetColumn;

    @FXML
    private TableColumn<Advertisement, String> statusColumn;

    @FXML
    public void initialize() {

        reportTypeComboBox.getItems().addAll(
                "Performance Report",
                "Budget Report",
                "Advertisement Summary"
        );

        advertisementComboBox.getItems().addAll(
                "Netflix Premium",
                "Football Live",
                "Movie Festival"
        );

        idColumn.setCellValueFactory(new PropertyValueFactory<>("advertisementId"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("advertisementTitle"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        budgetColumn.setCellValueFactory(new PropertyValueFactory<>("budget"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("advertisementStatus"));

        ObservableList<Advertisement> reportList = FXCollections.observableArrayList();

        reportList.add(new Advertisement(
                "AD001",
                "ADV001",
                "Netflix Premium",
                "Entertainment",
                "Adults",
                5000,
                "2026-08-01",
                "2026-09-01",
                "Active"
        ));

        reportList.add(new Advertisement(
                "AD002",
                "ADV001",
                "Football Live",
                "Sports",
                "Everyone",
                3500,
                "2026-08-05",
                "2026-09-05",
                "Active"
        ));

        reportTableView.setItems(reportList);

    }

    @FXML
    private void generateReportOnClick(ActionEvent event) {

        if (reportTypeComboBox.getValue() == null) {
            showAlert("Please select a report type.");
            return;
        }

        if (advertisementComboBox.getValue() == null) {
            showAlert("Please select an advertisement.");
            return;
        }

        if (fromDatePicker.getValue() != null &&
                toDatePicker.getValue() != null &&
                fromDatePicker.getValue().isAfter(toDatePicker.getValue())) {

            showAlert("From Date cannot be after To Date.");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Report generated successfully.");
        alert.showAndWait();

    }

    @FXML
    private void clearOnClick(ActionEvent event) {

        reportTypeComboBox.setValue(null);
        advertisementComboBox.setValue(null);
        fromDatePicker.setValue(null);
        toDatePicker.setValue(null);
        reportTableView.getSelectionModel().clearSelection();

    }

    @FXML
    private void backOnClick(ActionEvent event) {

        System.out.println("Back to Advertiser Dashboard");

    }

    private void showAlert(String message) {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();

    }

}