package csc213.ottplatfrom.Munshi;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import csc213.ottplatfrom.model.Advertisement;

public class ManageBudgetController {

    @FXML
    private ComboBox<String> advertisementComboBox;

    @FXML
    private TextField currentBudgetTextField;

    @FXML
    private TextField newBudgetTextField;

    @FXML
    private CheckBox confirmBudgetCheckBox;

    @FXML
    private TableView<Advertisement> budgetTableView;

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

        budgetTableView.setItems(advertisementList);
    }

    @FXML
    private void updateBudgetOnClick(ActionEvent event) {

        if (advertisementComboBox.getValue() == null) {
            showAlert("Please select an advertisement.");
            return;
        }

        if (newBudgetTextField.getText().isEmpty()) {
            showAlert("Please enter a new budget.");
            return;
        }

        if (!confirmBudgetCheckBox.isSelected()) {
            showAlert("Please confirm the budget update.");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Budget updated successfully.");
        alert.showAndWait();
    }

    @FXML
    private void clearOnClick(ActionEvent event) {

        advertisementComboBox.setValue(null);
        currentBudgetTextField.clear();
        newBudgetTextField.clear();
        confirmBudgetCheckBox.setSelected(false);
        budgetTableView.getSelectionModel().clearSelection();

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