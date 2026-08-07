package csc213.ottplatfrom.Munshi;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import csc213.ottplatfrom.model.Advertisement;

public class EditAdvertisementController {

    @FXML
    private TextField advertisementIdTextField;

    @FXML
    private TextField advertisementTitleTextField;

    @FXML
    private ComboBox<String> categoryComboBox;

    @FXML
    private ComboBox<String> targetAudienceComboBox;

    @FXML
    private TextField budgetTextField;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private DatePicker endDatePicker;

    @FXML
    private CheckBox activeCheckBox;

    @FXML
    private TableView<Advertisement> advertisementTableView;

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

        categoryComboBox.getItems().addAll(
                "Movie",
                "Series",
                "Sports",
                "Entertainment"
        );

        targetAudienceComboBox.getItems().addAll(
                "Children",
                "Teenagers",
                "Adults",
                "Everyone"
        );

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

        advertisementTableView.setItems(advertisementList);
    }

    @FXML
    private void updateOnClick(ActionEvent event) {

        if (advertisementTableView.getSelectionModel().getSelectedItem() == null) {
            showAlert("Please select an advertisement from the table.");
            return;
        }

        if (advertisementTitleTextField.getText().isEmpty()) {
            showAlert("Advertisement title is required.");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Advertisement updated successfully.");
        alert.showAndWait();

    }

    @FXML
    private void clearOnClick(ActionEvent event) {

        advertisementIdTextField.clear();
        advertisementTitleTextField.clear();
        categoryComboBox.setValue(null);
        targetAudienceComboBox.setValue(null);
        budgetTextField.clear();
        startDatePicker.setValue(null);
        endDatePicker.setValue(null);
        activeCheckBox.setSelected(false);
        advertisementTableView.getSelectionModel().clearSelection();

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