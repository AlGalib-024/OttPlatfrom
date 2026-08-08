package csc213.ottplatfrom.Munshi;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import csc213.ottplatfrom.model.Advertisement;

public class ViewAdvertisementPerformanceController {

    @FXML
    private ComboBox<String> advertisementComboBox;

    @FXML
    private ComboBox<String> statusComboBox;

    @FXML
    private DatePicker fromDatePicker;

    @FXML
    private DatePicker toDatePicker;

    @FXML
    private TableView<Advertisement> performanceTableView;

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

        advertisementComboBox.getItems().addAll(
                "Netflix Premium",
                "Football Live",
                "Movie Festival"
        );

        statusComboBox.getItems().addAll(
                "All",
                "Active",
                "Inactive"
        );

        statusComboBox.setValue("All");

        idColumn.setCellValueFactory(new PropertyValueFactory<>("advertisementId"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("advertisementTitle"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        budgetColumn.setCellValueFactory(new PropertyValueFactory<>("budget"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("advertisementStatus"));

        ObservableList<Advertisement> advertisementList = FXCollections.observableArrayList();

        advertisementList.add(new Advertisement(
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

        advertisementList.add(new Advertisement(
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

        performanceTableView.setItems(advertisementList);
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
        alert.setContentText("Advertisement performance loaded successfully.");
        alert.showAndWait();

    }

    @FXML
    private void clearOnClick(ActionEvent event) {

        advertisementComboBox.setValue(null);
        statusComboBox.setValue("All");
        fromDatePicker.setValue(null);
        toDatePicker.setValue(null);
        performanceTableView.getSelectionModel().clearSelection();

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