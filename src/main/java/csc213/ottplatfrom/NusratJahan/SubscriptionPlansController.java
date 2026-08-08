package csc213.ottplatfrom.NusratJahan;

import csc213.ottplatfrom.SceneSwitcher;
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
    @FXML
    private TableColumn colPlanName;
    @FXML
    private TableColumn colPlanId;
    @FXML
    private TableColumn colPrice;
    @FXML
    private TextField newPriceField;
    @FXML
    private TableView planTable;
    @FXML
    private Label statusLabel;

    @FXML
    public void initialize() {
        colPlanId.setCellValueFactory(new PropertyValueFactory<>("planId"));
        colPlanName.setCellValueFactory(new PropertyValueFactory<>("planName"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("priceDisplay"));

        planTable.setItems(FXCollections.observableArrayList(DataStore.loadPlans()));
    }

    @FXML
    public void handleUpdate(ActionEvent actionEvent) {
        SubscriptionPlan selected = (SubscriptionPlan) planTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            statusLabel.setText("Please select a plan first.");
            return;
        }

        String priceText = newPriceField.getText().trim();
        if (priceText.isEmpty()) {
            statusLabel.setText("Please enter a new price.");
            return;
        }

        double newPrice;
        try {
            newPrice = Double.parseDouble(priceText);
        } catch (NumberFormatException e) {
            statusLabel.setText("Price must be a valid number.");
            return;
        }

        if (newPrice <= 0) {
            statusLabel.setText("Price must be greater than zero.");
            return;
        }

        DataStore.updatePlanPrice(selected.getPlanId(), newPrice);
        selected.setPrice(newPrice);
        planTable.refresh();
        newPriceField.clear();
        statusLabel.setText("Subscription plan updated successfully.");
    }

    @FXML
    public void handleBack(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent, "/csc213/ottplatfrom/NusratJahan/ceo-dashboard.fxml", "CEO Dashboard");
    }
}