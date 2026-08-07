package csc213.ottplatfrom.Munshi;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import csc213.ottplatfrom.model.Advertisement;

public class DeleteAdvertisementController {

    @FXML
    private TextField advertisementIdTextField;

    @FXML
    private CheckBox confirmDeleteCheckBox;

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

        advertisementTableView.setItems(advertisementList);

    }

    @FXML
    private void deleteOnClick(ActionEvent event) {

        Advertisement selectedAdvertisement =
                advertisementTableView.getSelectionModel().getSelectedItem();

        if (selectedAdvertisement == null) {
            showAlert("Please select an advertisement.");
            return;
        }

        if (!confirmDeleteCheckBox.isSelected()) {
            showAlert("Please confirm deletion.");
            return;
        }

        advertisementTableView.getItems().remove(selectedAdvertisement);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Advertisement deleted successfully.");
        alert.showAndWait();

    }

    @FXML
    private void clearOnClick(ActionEvent event) {

        advertisementIdTextField.clear();
        confirmDeleteCheckBox.setSelected(false);
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