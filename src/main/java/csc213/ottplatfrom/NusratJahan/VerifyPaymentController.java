package csc213.ottplatfrom.NusratJahan;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class VerifyPaymentController
{
    @javafx.fxml.FXML
    private TableView pendingTable;
    @javafx.fxml.FXML
    private TableColumn colAmount;
    @javafx.fxml.FXML
    private TableColumn colPaymentId;
    @javafx.fxml.FXML
    private TableColumn colMethod;
    @javafx.fxml.FXML
    private TableColumn colSubscriberName;
    @javafx.fxml.FXML
    private TableColumn colDate;
    @javafx.fxml.FXML
    private Label statusLabel;



    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleVerify(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleViewDetails(ActionEvent actionEvent) {
    }
    @FXML
    public void initialize() {
        colPaymentId.setCellValueFactory(new PropertyValueFactory<>("paymentId"));
        colSubscriberName.setCellValueFactory(new PropertyValueFactory<>("subscriberName"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amountDisplay"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colMethod.setCellValueFactory(new PropertyValueFactory<>("method"));

        pendingTable.setItems(FXCollections.observableArrayList(DataStore.loadPendingPayments()));
    }
}