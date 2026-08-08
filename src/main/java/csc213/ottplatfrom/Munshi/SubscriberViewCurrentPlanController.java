package csc213.ottplatfrom.Munshi;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import csc213.ottplatfrom.model.Subscription;

public class SubscriberViewCurrentPlanController {

    @FXML
    private TableView<Subscription> currentPlanTableView;

    @FXML
    private TableColumn<Subscription, String> planIdColumn;

    @FXML
    private TableColumn<Subscription, String> planNameColumn;

    @FXML
    private TableColumn<Subscription, Double> priceColumn;

    @FXML
    private TableColumn<Subscription, String> durationColumn;

    @FXML
    private TableColumn<Subscription, String> qualityColumn;

    @FXML
    public void initialize() {

        planIdColumn.setCellValueFactory(new PropertyValueFactory<>("planId"));
        planNameColumn.setCellValueFactory(new PropertyValueFactory<>("planName"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
        qualityColumn.setCellValueFactory(new PropertyValueFactory<>("quality"));

        ObservableList<Subscription> currentPlanList = FXCollections.observableArrayList();

        currentPlanList.add(new Subscription(
                "P002",
                "Standard",
                499,
                "1 Month",
                "Full HD",
                "Standard Plan",
                "Active"
        ));

        currentPlanTableView.setItems(currentPlanList);

    }

    @FXML
    private void refreshOnClick(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Current plan refreshed successfully.");
        alert.showAndWait();

    }

    @FXML
    private void backOnClick(ActionEvent event) {

        System.out.println("Back to Subscriber Dashboard");

    }

}