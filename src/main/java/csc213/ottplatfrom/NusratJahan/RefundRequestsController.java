package csc213.ottplatfrom.NusratJahan;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class RefundRequestsController
{
    @javafx.fxml.FXML
    private TableColumn colReason;
    @javafx.fxml.FXML
    private TableColumn colAmount;
    @javafx.fxml.FXML
    private TableView refundTable;
    @javafx.fxml.FXML
    private TableColumn colSubscriberName;
    @javafx.fxml.FXML
    private TableColumn colRequestId;
    @javafx.fxml.FXML
    private TableColumn colStatus;


    @FXML
    public void initialize() {
        colRequestId.setCellValueFactory(new PropertyValueFactory<>("requestId"));
        colSubscriberName.setCellValueFactory(new PropertyValueFactory<>("subscriberName"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amountDisplay"));
        colReason.setCellValueFactory(new PropertyValueFactory<>("reason"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        refundTable.setItems(FXCollections.observableArrayList(DataStore.loadRefundRequests()));
    }
}