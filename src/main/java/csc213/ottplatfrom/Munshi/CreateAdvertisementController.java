package csc213.ottplatfrom.Munshi;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import csc213.ottplatfrom.model.Advertisement;

public class CreateAdvertisementController {

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

        advertisementTableView.setItems(advertisementList);
    }

    @FXML
    private void createOnClick(ActionEvent event) {

        if (advertisementIdTextField.getText().isEmpty()) {
            showAlert("Advertisement ID is required.");
            return;
        }

        if (advertisementTitleTextField.getText().isEmpty()) {
            showAlert("Advertisement Title is required.");
            return;
        }

        if (categoryComboBox.getValue() == null) {
            showAlert("Select a category.");
            return;
        }

        if (targetAudienceComboBox.getValue() == null) {
            showAlert("Select a target audience.");
            return;
        }

        if (budgetTextField.getText().isEmpty()) {
            showAlert("Enter the budget.");
            return;
        }

        if (startDatePicker.getValue() == null) {
            showAlert("Select the start date.");
            return;
        }

        if (endDatePicker.getValue() == null) {
            showAlert("Select the end date.");
            return;
        }

        Advertisement advertisement = new Advertisement(
                advertisementIdTextField.getText(),
                "ADV001",
                advertisementTitleTextField.getText(),
                categoryComboBox.getValue(),
                targetAudienceComboBox.getValue(),
                Double.parseDouble(budgetTextField.getText()),
                startDatePicker.getValue().toString(),
                endDatePicker.getValue().toString(),
                activeCheckBox.isSelected() ? "Active" : "Inactive"
        );

        advertisementTableView.getItems().add(advertisement);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Advertisement created successfully.");
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