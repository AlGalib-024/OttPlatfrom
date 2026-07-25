package csc213.ottplatfrom.NusratJahan;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * One controller for every Accountant (User-2) goal from the CRA report:
 * payment records, verifying payments, recording offline/subscription
 * payments, refund requests, payment search, subscriber payment history and
 * deleting payment records.
 */
public class AccountantDashboardController {

    @FXML
    private Label welcomeLabel;

    // Goal 1 - payment records
    @FXML
    private TableView<PaymentRecord> paymentsTable;
    @FXML
    private TableColumn<PaymentRecord, String> colPayId;
    @FXML
    private TableColumn<PaymentRecord, String> colPaySubscriber;
    @FXML
    private TableColumn<PaymentRecord, Double> colPayAmount;
    @FXML
    private TableColumn<PaymentRecord, String> colPayDate;
    @FXML
    private TableColumn<PaymentRecord, String> colPayStatus;

    // Goal 2 - verify payment
    @FXML
    private TableView<PaymentRecord> pendingPaymentsTable;
    @FXML
    private TableColumn<PaymentRecord, String> colPendId;
    @FXML
    private TableColumn<PaymentRecord, String> colPendSubscriber;
    @FXML
    private TableColumn<PaymentRecord, Double> colPendAmount;
    @FXML
    private TableColumn<PaymentRecord, String> colPendDate;
    @FXML
    private Label verifyStatusLabel;

    // Goal 3 - record offline payment
    @FXML
    private TextField offlineSubIdField;
    @FXML
    private TextField offlineAmountField;
    @FXML
    private TextField offlineDateField;
    @FXML
    private ComboBox<String> offlineMethodCombo;
    @FXML
    private Label offlineStatusLabel;

    // Goal 4 - refund requests
    @FXML
    private TableView<RefundRequest> refundsTable;
    @FXML
    private TableColumn<RefundRequest, String> colRefId;
    @FXML
    private TableColumn<RefundRequest, String> colRefSubscriber;
    @FXML
    private TableColumn<RefundRequest, Double> colRefAmount;
    @FXML
    private TableColumn<RefundRequest, String> colRefReason;
    @FXML
    private TableColumn<RefundRequest, String> colRefStatus;

    // Goal 5 - search payment
    @FXML
    private TextField searchPayIdField;
    @FXML
    private Label searchPayMessageLabel;
    @FXML
    private Label searchResSubscriber;
    @FXML
    private Label searchResAmount;
    @FXML
    private Label searchResDate;
    @FXML
    private Label searchResMethod;
    @FXML
    private Label searchResStatus;

    // Goal 6 - record subscription payment
    @FXML
    private TextField subPaySubIdField;
    @FXML
    private TextField subPayAmountField;
    @FXML
    private ComboBox<String> subPayMethodCombo;
    @FXML
    private Label subPayStatusLabel;

    // Goal 7 - subscriber payment history
    @FXML
    private TextField historySubIdField;
    @FXML
    private Label historyStatusLabel;
    @FXML
    private TableView<PaymentRecord> historyTable;
    @FXML
    private TableColumn<PaymentRecord, String> colHistId;
    @FXML
    private TableColumn<PaymentRecord, String> colHistDate;
    @FXML
    private TableColumn<PaymentRecord, Double> colHistAmount;
    @FXML
    private TableColumn<PaymentRecord, String> colHistMethod;
    @FXML
    private TableColumn<PaymentRecord, String> colHistStatus;

    // Goal 8 - delete payment record
    @FXML
    private TableView<PaymentRecord> deleteTable;
    @FXML
    private TableColumn<PaymentRecord, String> colDelId;
    @FXML
    private TableColumn<PaymentRecord, String> colDelSubscriber;
    @FXML
    private TableColumn<PaymentRecord, Double> colDelAmount;
    @FXML
    private TableColumn<PaymentRecord, String> colDelDate;
    @FXML
    private TableColumn<PaymentRecord, String> colDelStatus;
    @FXML
    private Label deleteStatusLabel;

    private ObservableList<PaymentRecord> allPayments;
    private ObservableList<PaymentRecord> pendingPayments;

    @FXML
    private void initialize() {
        welcomeLabel.setText("Welcome");

        colPayId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colPaySubscriber.setCellValueFactory(new PropertyValueFactory<>("subscriberName"));
        colPayAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colPayDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colPayStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        colPendId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colPendSubscriber.setCellValueFactory(new PropertyValueFactory<>("subscriberName"));
        colPendAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colPendDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        colRefId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colRefSubscriber.setCellValueFactory(new PropertyValueFactory<>("subscriberName"));
        colRefAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colRefReason.setCellValueFactory(new PropertyValueFactory<>("reason"));
        colRefStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        colHistId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colHistDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colHistAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colHistMethod.setCellValueFactory(new PropertyValueFactory<>("method"));
        colHistStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        colDelId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colDelSubscriber.setCellValueFactory(new PropertyValueFactory<>("subscriberName"));
        colDelAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colDelDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colDelStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        offlineMethodCombo.getItems().addAll("Cash", "Bank Transfer", "Cheque", "Mobile Banking");
        subPayMethodCombo.getItems().addAll("Card", "Bank Transfer", "Mobile Banking");

        loadAllData();
    }

    private void loadAllData() {
        allPayments = FXCollections.observableArrayList(DataStore.loadPayments());
        paymentsTable.setItems(allPayments);
        deleteTable.setItems(allPayments);

        List<PaymentRecord> pending = new ArrayList<>();
        for (PaymentRecord p : allPayments) {
            if (p.getStatus().equals("Pending")) {
                pending.add(p);
            }
        }
        pendingPayments = FXCollections.observableArrayList(pending);
        pendingPaymentsTable.setItems(pendingPayments);

        refundsTable.setItems(FXCollections.observableArrayList(DataStore.loadRefunds()));
    }

    @FXML
    private void handleSignOut(ActionEvent event) throws IOException {
        DataStore.setCurrentUser(null);
        csc213.ottplatfrom.SceneSwitcher.switchTo(event, "login.fxml", "OTT Platform - Sign In");
    }

    // ---------- Goal 2: Verify payment ----------

    @FXML
    private void handleVerifyPayment() {
        PaymentRecord selected = pendingPaymentsTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            verifyStatusLabel.setText("Select a pending payment first.");
            return;
        }
        selected.setStatus("Verified");
        DataStore.savePayments(allPayments);
        pendingPayments.remove(selected);
        paymentsTable.refresh();
        deleteTable.refresh();
        verifyStatusLabel.setText("Payment verified successfully.");
    }

    // ---------- Goal 3: Record offline payment ----------

    @FXML
    private void handleRecordOfflinePayment() {
        String subId = offlineSubIdField.getText().trim();
        if (subId.isEmpty()) {
            offlineStatusLabel.setText("Subscriber ID is required.");
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(offlineAmountField.getText());
        } catch (NumberFormatException e) {
            offlineStatusLabel.setText("Enter a valid amount.");
            return;
        }
        if (amount <= 0) {
            offlineStatusLabel.setText("Enter a valid amount.");
            return;
        }

        String date = offlineDateField.getText().trim();
        if (date.isEmpty()) {
            offlineStatusLabel.setText("Enter a payment date.");
            return;
        }

        if (offlineMethodCombo.getValue() == null) {
            offlineStatusLabel.setText("Select a payment method.");
            return;
        }

        String subscriberName = lookUpSubscriberName(subId);
        if (subscriberName == null) subscriberName = subId;

        String id = "PAY" + (allPayments.size() + 1);
        PaymentRecord record = new PaymentRecord(id, subId, subscriberName, amount, date, offlineMethodCombo.getValue(), "Recorded");
        allPayments.add(record);
        DataStore.savePayments(allPayments);
        deleteTable.refresh();

        handleClearOfflinePayment();
        offlineStatusLabel.setText("Offline payment recorded successfully.");
    }

    @FXML
    private void handleClearOfflinePayment() {
        offlineSubIdField.clear();
        offlineAmountField.clear();
        offlineDateField.clear();
        offlineMethodCombo.setValue(null);
    }

    // ---------- Goal 5: Search payment record ----------

    @FXML
    private void handleSearchPayment() {
        String id = searchPayIdField.getText().trim();
        if (id.isEmpty()) {
            searchPayMessageLabel.setText("Enter a Payment ID.");
            return;
        }

        PaymentRecord found = null;
        for (PaymentRecord p : allPayments) {
            if (p.getId().equalsIgnoreCase(id)) {
                found = p;
                break;
            }
        }

        if (found == null) {
            searchPayMessageLabel.setText("Payment not found.");
            clearPaymentDetails();
            return;
        }

        searchPayMessageLabel.setText("");
        searchResSubscriber.setText("Subscriber: " + found.getSubscriberName());
        searchResAmount.setText("Amount: $" + found.getAmount());
        searchResDate.setText("Date: " + found.getDate());
        searchResMethod.setText("Method: " + found.getMethod());
        searchResStatus.setText("Status: " + found.getStatus());
    }

    @FXML
    private void handleClearPaymentSearch() {
        searchPayIdField.clear();
        searchPayMessageLabel.setText("");
        clearPaymentDetails();
    }

    private void clearPaymentDetails() {
        searchResSubscriber.setText("");
        searchResAmount.setText("");
        searchResDate.setText("");
        searchResMethod.setText("");
        searchResStatus.setText("");
    }

    // ---------- Goal 6: Record subscription payment ----------

    @FXML
    private void handleRecordSubscriptionPayment() {
        String subId = subPaySubIdField.getText().trim();
        if (subId.isEmpty()) {
            subPayStatusLabel.setText("Subscriber ID is required.");
            return;
        }

        String subscriberName = lookUpSubscriberName(subId);
        if (subscriberName == null) {
            subPayStatusLabel.setText("Subscriber not found.");
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(subPayAmountField.getText());
        } catch (NumberFormatException e) {
            subPayStatusLabel.setText("Enter a valid amount.");
            return;
        }
        if (amount <= 0) {
            subPayStatusLabel.setText("Enter a valid amount.");
            return;
        }

        if (subPayMethodCombo.getValue() == null) {
            subPayStatusLabel.setText("Select a payment method.");
            return;
        }

        String id = "PAY" + (allPayments.size() + 1);
        PaymentRecord record = new PaymentRecord(id, subId, subscriberName, amount,
                java.time.LocalDate.now().toString(), subPayMethodCombo.getValue(), "Verified");
        allPayments.add(record);
        DataStore.savePayments(allPayments);
        deleteTable.refresh();

        handleClearSubscriptionPayment();
        subPayStatusLabel.setText("Subscription payment recorded successfully.");
    }

    @FXML
    private void handleClearSubscriptionPayment() {
        subPaySubIdField.clear();
        subPayAmountField.clear();
        subPayMethodCombo.setValue(null);
    }

    // ---------- Goal 7: View subscriber payment history ----------

    @FXML
    private void handleSearchHistory() {
        String subId = historySubIdField.getText().trim();
        if (subId.isEmpty()) {
            historyStatusLabel.setText("Enter a Subscriber ID.");
            historyTable.setItems(FXCollections.observableArrayList());
            return;
        }

        String subscriberName = lookUpSubscriberName(subId);
        if (subscriberName == null) {
            historyStatusLabel.setText("Subscriber not found.");
            historyTable.setItems(FXCollections.observableArrayList());
            return;
        }

        List<PaymentRecord> history = new ArrayList<>();
        for (PaymentRecord p : allPayments) {
            if (p.getSubscriberId().equalsIgnoreCase(subId)) {
                history.add(p);
            }
        }
        historyTable.setItems(FXCollections.observableArrayList(history));
        historyStatusLabel.setText(history.size() + " payment(s) found for " + subscriberName + ".");
    }

    // ---------- Goal 8: Delete payment record ----------

    @FXML
    private void handleDeletePayment() {
        PaymentRecord selected = deleteTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            deleteStatusLabel.setText("Select a payment record to delete.");
            return;
        }

        allPayments.remove(selected);
        pendingPayments.remove(selected);
        DataStore.savePayments(allPayments);
        deleteStatusLabel.setText("Payment record deleted successfully.");
    }

    // ---------- helper ----------

    /** Returns the subscriber's name, or null if no subscriber has that ID. */
    private String lookUpSubscriberName(String subscriberId) {
        for (Subscriber s : DataStore.loadSubscribers()) {
            if (s.getId().equalsIgnoreCase(subscriberId)) {
                return s.getName();
            }
        }
        return null;
    }
}
