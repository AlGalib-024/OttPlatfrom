package csc213.ottplatfrom.NusratJahan;

import csc213.ottplatfrom.SceneSwitcher;
import javafx.event.ActionEvent;

public class AccountantDashboardController
{
    @javafx.fxml.FXML
    public void goRecordPayment(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent, "/csc213/ottplatfrom/NusratJahan/accountant-record-payment.fxml", "Record Subscription Payment");
    }

    @javafx.fxml.FXML
    public void goSearchPayment(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent, "/csc213/ottplatfrom/NusratJahan/accountant-search-payment.fxml", "Search Payment");
    }

    @javafx.fxml.FXML
    public void goRefundRequests(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent, "/csc213/ottplatfrom/NusratJahan/accountant-refund-requests.fxml", "Refund Requests");
    }

    @javafx.fxml.FXML
    public void goRecordOfflinePayment(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent, "/csc213/ottplatfrom/NusratJahan/accountant-record-offline-payment.fxml", "Record Offline Payment");
    }

    @javafx.fxml.FXML
    public void goPaymentRecords(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent, "/csc213/ottplatfrom/NusratJahan/accountant-payment-records.fxml", "Payment Records");
    }

    @javafx.fxml.FXML
    public void goSubscriberPayments(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent, "/csc213/ottplatfrom/NusratJahan/accountant-subscriber-payments.fxml", "Subscriber Payment History");
    }

    @javafx.fxml.FXML
    public void goVerifyPayment(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent, "/csc213/ottplatfrom/NusratJahan/accountant-verify-payment.fxml", "Verify Payment");
    }
}