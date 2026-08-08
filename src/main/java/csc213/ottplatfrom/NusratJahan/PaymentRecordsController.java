package csc213.ottplatfrom.NusratJahan;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PaymentRecordsController
{
    @javafx.fxml.FXML
    private TableColumn colAmount;
    @javafx.fxml.FXML
    private TableColumn colPaymentId;
    @javafx.fxml.FXML
    private TableView paymentTable;
    @javafx.fxml.FXML
    private TableColumn colSubscriberName;
    @javafx.fxml.FXML
    private TableColumn colDate;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private TableColumn colStatus;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleDelete(ActionEvent actionEvent) {
    }
}