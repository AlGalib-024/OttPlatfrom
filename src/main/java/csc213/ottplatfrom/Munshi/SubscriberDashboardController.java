package csc213.ottplatfrom.Munshi;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class SubscriberDashboardController {

    @FXML
    public void initialize() {

        System.out.println("Subscriber Dashboard Loaded");

    }

    @FXML
    private void buySubscriptionOnClick(ActionEvent event) {

        System.out.println("Buy Subscription Clicked");

    }

    @FXML
    private void renewSubscriptionOnClick(ActionEvent event) {

        System.out.println("Renew Subscription Clicked");

    }

    @FXML
    private void viewCurrentPlanOnClick(ActionEvent event) {

        System.out.println("View Current Plan Clicked");

    }

    @FXML
    private void cancelSubscriptionOnClick(ActionEvent event) {

        System.out.println("Cancel Subscription Clicked");

    }

    @FXML
    private void updateProfileOnClick(ActionEvent event) {

        System.out.println("Update Profile Clicked");

    }

    @FXML
    private void changePasswordOnClick(ActionEvent event) {

        System.out.println("Change Password Clicked");

    }

    @FXML
    private void paymentHistoryOnClick(ActionEvent event) {

        System.out.println("Payment History Clicked");

    }

    @FXML
    private void downloadSubtitleOnClick(ActionEvent event) {

        System.out.println("Download Subtitle Clicked");

    }

}