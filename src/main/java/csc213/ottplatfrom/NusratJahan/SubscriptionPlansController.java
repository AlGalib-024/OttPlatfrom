package csc213.ottplatfrom.NusratJahan;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class SubscriptionPlansController
{
    @javafx.fxml.FXML
    private TableColumn colPlanName;
    @javafx.fxml.FXML
    private TableColumn colPlanId;
    @javafx.fxml.FXML
    private TableColumn colPrice;
    @javafx.fxml.FXML
    private TextField newPriceField;
    @javafx.fxml.FXML
    private TableView planTable;
    @javafx.fxml.FXML
    private Label statusLabel;



    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleUpdate(ActionEvent actionEvent) {
    }
    @FXML
    public void initialize() {
        colPlanId.setCellValueFactory(new PropertyValueFactory<>("planId"));
        colPlanName.setCellValueFactory(new PropertyValueFactory<>("planName"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("priceDisplay"));

        planTable.setItems(FXCollections.observableArrayList(DataStore.loadPlans()));
    }
}