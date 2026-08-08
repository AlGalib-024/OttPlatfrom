package csc213.ottplatfrom.NusratJahan;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class CeoDashboardController {

    @FXML
    private Label totalContentLabel;

    @FXML
    private Label totalRevenueLabel;

    @FXML
    private Label totalSubscribersLabel;

    @FXML
    private Label pendingPaymentsLabel;

    @FXML
    private ComboBox<String> periodBox;

    @FXML
    public void initialize() {
        // Load ComboBox values
        periodBox.getItems().addAll(
                "Today",
                "This Week",
                "This Month",
                "This Year"
        );

        // Default selection
        periodBox.setValue("This Month");


        loadDashboardData();


        periodBox.setOnAction(event -> loadDashboardData());
    }

    private void loadDashboardData() {
        String period = periodBox.getValue();

        switch (period) {
            case "Today":
                totalSubscribersLabel.setText("120");
                totalRevenueLabel.setText("৳ 5,000");
                totalContentLabel.setText("45");
                pendingPaymentsLabel.setText("8");
                break;

            case "This Week":
                totalSubscribersLabel.setText("860");
                totalRevenueLabel.setText("৳ 32,000");
                totalContentLabel.setText("48");
                pendingPaymentsLabel.setText("14");
                break;

            case "This Year":
                totalSubscribersLabel.setText("35,000");
                totalRevenueLabel.setText("৳ 12,50,000");
                totalContentLabel.setText("150");
                pendingPaymentsLabel.setText("75");
                break;

            case "This Month":
            default:
                totalSubscribersLabel.setText("4,250");
                totalRevenueLabel.setText("৳ 1,25,000");
                totalContentLabel.setText("52");
                pendingPaymentsLabel.setText("23");
                break;
        }
    }


    @FXML
    public void handleViewDashboard(ActionEvent actionEvent) {
        loadScene("ceo-dashboard.fxml", actionEvent);
    }

    @FXML
    public void goManageUsers(ActionEvent actionEvent) {
        loadScene("ceo-manage-users.fxml", actionEvent);
    }

    @FXML
    public void goContentList(ActionEvent actionEvent) {
        loadScene("ceo-content-list.fxml", actionEvent);
    }

    @FXML
    public void goFeaturedContent(ActionEvent actionEvent) {
        loadScene("ceo-featured-content.fxml", actionEvent);
    }

    @FXML
    public void goSubscriptionPlans(ActionEvent actionEvent) {
        loadScene("ceo-subscription-plans.fxml", actionEvent);
    }

    @FXML
    public void goSubscriberDetails(ActionEvent actionEvent) {
        loadScene("ceo-subscriber-details.fxml", actionEvent);
    }

    @FXML
    public void goAnnouncements(ActionEvent actionEvent) {
        loadScene("ceo-announcements.fxml", actionEvent);
    }

    @FXML
    public void goCustomerFeedback(ActionEvent actionEvent) {
        loadScene("ceo-customer-feedback.fxml", actionEvent);
    }



    private void loadScene(String fxmlFile, ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(fxmlFile)
            );

            Parent root = loader.load();

            Stage stage = (Stage) periodBox.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}