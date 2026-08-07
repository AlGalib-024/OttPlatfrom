package csc213.ottplatfrom.NusratJahan;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) {
    }
}