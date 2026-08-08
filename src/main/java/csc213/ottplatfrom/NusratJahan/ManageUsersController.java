package csc213.ottplatfrom.NusratJahan;

import csc213.ottplatfrom.SceneSwitcher;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ManageUsersController
{
    @javafx.fxml.FXML
    private TableColumn colName;
    @javafx.fxml.FXML
    private TableView userTable;
    @javafx.fxml.FXML
    private TableColumn colUserId;
    @javafx.fxml.FXML
    private TableColumn colEmail;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private TableColumn colStatus;

    @javafx.fxml.FXML
    public void initialize() {
        colUserId.setCellValueFactory(new PropertyValueFactory<>("userId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        userTable.setItems(FXCollections.observableArrayList(DataStore.loadAllUsers()));
    }

    @javafx.fxml.FXML
    public void handleActivate(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleDeactivate(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent, "/csc213/ottplatfrom/NusratJahan/ceo-dashboard.fxml", "CEO Dashboard");
    }
}