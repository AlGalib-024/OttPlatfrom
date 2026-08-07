package csc213.ottplatfrom.NusratJahan;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleUpdate(ActionEvent actionEvent) {
    }
}